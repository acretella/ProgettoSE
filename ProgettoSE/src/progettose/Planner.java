/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Altro
 */
public class Planner extends User{


    public Planner(String username, String password) throws SQLException {        
        super(username,password);
    }

    /**
     * Aggiunge un'attività nel database
     * @param a  Attività da aggiungere
     * @throws Exception Se esiste già un'attività con lo stesso id oppure l'input sulla settimana non è corretto. 
     */
    public void createActivity(Activity a) throws Exception {
        try {
            String query;
            if (a.getType() == 1) //se è una EWO activity allora devo aggiungere il giorno 
                query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura,giorno)"
                        + " values(" + a.getId() + ",'" + a.getSite().getFactorySite() + "','" + a.getSite().getArea() + "','" + a.getTypology() + "','"
                        + a.getActivityDescription() + "'," + a.getEstimatedTime() + "," + a.getWeek() + "," + a.isInterruptable() + ",'" + a.getWorkSpaceNote()
                        + "'," + a.getType() + ",null" + "," + a.getDay() + ");";
            else 
                query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura)"
                        + " values(" + a.getId() + ",'" + a.getSite().getFactorySite() + "','" + a.getSite().getArea() + "','" + a.getTypology() + "','"
                        + a.getActivityDescription() + "'," + a.getEstimatedTime() + "," + a.getWeek() + "," + a.isInterruptable() + ",'" + a.getWorkSpaceNote()
                        + "'," + a.getType() + ",null" + ");";
            
            super.getConnection().createStatement().executeUpdate(query); //Creo l'attività nel DB
            updateMaterials(a); //Inserisco i materiali necessari all'attività nel DB

        } catch (SQLException ex) {
            if (ex.getMessage().contains("check_id")) {
                throw new Exception("Esiste già un attività con id = " + a.getId());
            } else if (ex.getMessage().contains("check_week")) {
                throw new Exception("La settimana deve essere compresa fra 1 e 52");
            } else {
                throw new Exception("L'attività non può essere creata");
            }
        }

    }

    /**
     *
     * @return Una lista di tutte le attività contenute nel database
     */
    public List<Activity> getAllActivities() {
        try {
            String query = "Select * from Activity order by week";
            ResultSet rst = super.getConnection().createStatement().executeQuery(query); 
           
            List<Activity> l = new ArrayList<>();

            while (rst.next()) {
                List<String> materials = new ArrayList<>(); //creo la lista di materiali di ogni attività
                int id = rst.getInt("id_"); //id dell'attività
                query = "Select * from Material_for_Activity where activity = " + id;
                ResultSet rst2 = super.getConnection().createStatement().executeQuery(query);
                while (rst2.next()) {
                    materials.add(rst2.getString("material"));
                }
                l.add(this.createActivity(rst, materials, id)); //Dopo aver ottenuto i materiali dell'attività creo l'oggetto attività e lo aggiungo alla lista di attività
            }
            return l;

        } catch (SQLException ex) {
            return new ArrayList<>();
        }

    }

    /**
     * Crea la procedura associata ad un'attività
     * @param id Identificativo della procedura
     * @return Procedura associata all'attività
     */
    protected Procedure createProcedure(int id) {
        try {
            String query = "select * from procedura where id_ = " + id;
            ResultSet rst = super.getConnection().createStatement().executeQuery(query);
            rst.next();
            String path = rst.getString("smp_path");
            query = "select * from competence_for_procedure where procedura = " + id;
            rst = super.getConnection().createStatement().executeQuery(query);
            List<String> competences = new ArrayList<>();
            while (rst.next()) { //Aggiungo le competenze alla procedura
                competences.add(rst.getString("competence"));
            }
            if (path != null) {
                return new Procedure(id, new File(path), competences);
            } else {
                return new Procedure(id, null, competences);
            }

        } catch (SQLException ex) {
            return null;
        }

    }

    protected Activity createActivity(ResultSet rst, List<String> materials, int id) throws SQLException {
        Activity a = null;
        Procedure p = null;
        switch (rst.getInt("activityType")) { //Crea un'attività a seconda del tipo
            case 0:
                a = new PlannedActivity(id,
                        rst.getString("factorySite"),
                        rst.getString("area"),
                        rst.getString("typology"),
                        rst.getString("description"),
                        rst.getInt("estimatedTime"),
                        rst.getInt("week"),
                        materials,
                        rst.getBoolean("interruptable"),
                        rst.getString("workSpaceNotes"),
                        p = createProcedure(rst.getInt("procedura"))
                );
                break;
            case 1:
                a = new EwoActivity(id,
                        rst.getString("factorySite"),
                        rst.getString("area"),
                        rst.getString("typology"),
                        rst.getString("description"),
                        rst.getInt("estimatedTime"),
                        rst.getInt("week"),
                        materials,
                        rst.getBoolean("interruptable"),
                        rst.getString("workSpaceNotes"),
                        rst.getInt("giorno"),
                        p = createProcedure(rst.getInt("procedura"))
                );
                break;
            case 2:
                a = new ExtraActivity(id,
                        rst.getString("factorySite"),
                        rst.getString("area"),
                        rst.getString("typology"),
                        rst.getString("description"),
                        rst.getInt("estimatedTime"),
                        rst.getInt("week"),
                        materials,
                        rst.getBoolean("interruptable"),
                        rst.getString("workSpaceNotes"),
                        p = createProcedure(rst.getInt("procedura"))
                );
                break;
        }
        return a;
    }

    /**
     * Cancella un'attività dal database
     * @param id Identificativo dell'attività da cancellare
     * @return True se l'attività è stata cancellata, False altrimenti
     */
    public boolean deleteActivity(int id) {
        try {
            Statement stm = super.getConnection().createStatement();
            Activity a = this.getActivity(id);
            if (a == null) //Se l'attività da cancellare non esiste        
                return false;
            
            this.rebuildAvailability(a, false, null);//ripristino le disponibilità dei manutentori collegati all'attività
            return stm.executeUpdate("delete from Activity where id_ =" + id) != 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     *
     * @param id Identificativo dell'attività
     * @return L'attività presente nel Database con l'identificativo dato come parametro
     */
    public Activity getActivity(int id) {
        try {
            String query = "Select * from Activity where id_ = " + id;
            ResultSet rst = super.getConnection().createStatement().executeQuery(query);

            query = "Select * from Material_for_Activity where activity = " + id;
            ResultSet rst2 = super.getConnection().createStatement().executeQuery(query);

            List<String> materials = new ArrayList<>();
            while (rst2.next()) { //Aggiungo la lista di materiali all'attività
                materials.add(rst2.getString("material")); //Dopo aver ottenuto i materiali dell'attività creo l'oggetto attività e lo aggiungo alla lista di attività
            }
            rst.next();
            return createActivity(rst, materials, id);

        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Modifica un'attività presente nel database
     * @param a Attività da modificare
     * @throws Exception Se non è stato possibile effettuare la modifica, la causa è contenuta nel messaggio dell'eccezione
     */
    public void modifyActivity(Activity a) throws Exception {
        try {            
            String query = "";
            if (a.getType() != 1) 
                query = "update Activity set factorySite='" + a.getSite().getFactorySite()
                        + "',area='" + a.getSite().getArea() + "',typology='" + a.getTypology() + "',description='" + a.getActivityDescription()
                        + "',estimatedTime=" + a.getEstimatedTime() + ",week=" + a.getWeek() + ",interruptable=" + a.isInterruptable()
                        + ",workSpaceNotes='" + a.getWorkSpaceNote() + "',activityType=" + a.getType()
                        + ",giorno= null" + " where id_=" + a.getId() + ";";
            else 
                query = "update Activity set factorySite='" + a.getSite().getFactorySite()
                        + "',area='" + a.getSite().getArea() + "',typology='" + a.getTypology() + "',description='" + a.getActivityDescription()
                        + "',estimatedTime=" + a.getEstimatedTime() + ",week=" + a.getWeek() + ",interruptable=" + a.isInterruptable()
                        + ",workSpaceNotes='" + a.getWorkSpaceNote() + "',activityType=" + a.getType()
                        + ",giorno=" + a.getDay() + " where id_=" + a.getId() + ";";
            

            if (super.getConnection().createStatement().executeUpdate(query) == 0) 
                throw new Exception("Nessuna modifica effettuata");

            query = "delete from Material_for_Activity where activity= " + a.getId();
            super.getConnection().createStatement().executeUpdate(query);

            updateMaterials(a);
        } catch (SQLException ex) {
            if (ex.getMessage().contains("check_week")) 
                throw new Exception("La settimana deve essere compresa fra 1 e 52");
            else 
                throw new Exception("L'attività non può essere modificata");
            
        }
    }
    
    private void updateMaterials(Activity a) throws SQLException{
        if (!a.getMaterials().isEmpty()) {
            for (String material : a.getMaterials()) {
                String query = "insert into Material_for_Activity(activity,material) values("
                        + a.getId() + ",'" + material + "');";
                super.getConnection().createStatement().executeUpdate(query);
            }
        }
    }

    /**
     * 
     * @return Una lista di tutti i Maintainer presenti nel DB
     */
    public List<Maintainer> getAllMaintainers() {
        List<Maintainer> l = new ArrayList<>();
        int id;
        try {
            String query = "select * from Maintainer";
            ResultSet rst = super.getConnection().createStatement().executeQuery(query);
            while (rst.next()) {
                Map<Integer, int[][]> avaibilities = new HashMap<>();
                List<String> competencies = new ArrayList<>();
                String name = rst.getString("nome");
                id = rst.getInt("ID_MAN");
                ResultSet rst2 = super.getConnection().createStatement().executeQuery("select * from Competence_for_Maintainer where id_man = " + id);
                while (rst2.next()) //Aggiungo le competenze al Maintainer              
                    competencies.add(rst2.getString("NOMECOMPETENZA"));
                
                query = "select * from DISPONIBILITA_MANUTENTORE as dm,Availability as a where dm.ID_DISPONIBILITA = a.ID_DISPONIBILITA and dm.ID_MAN = " + id + " order by Settimana";
                rst2 = super.getConnection().createStatement().executeQuery(query);
                Integer key;
                int value[][] = new int[7][7]; //matrice valore della entry
                boolean flag = true;
                int temp = 0;
                while (rst2.next()) { //Aggiungo le disponibilità al Maintainer
                    key = rst2.getInt("Settimana");
                    if (flag) { //utilizzo la flag poiché non posso utilizzare due volte un resultset sulla stessa colonna
                        temp = key;
                        flag = false;
                    }
                    if (temp != key) { //quando cambia la settimana
                        avaibilities.put(temp, value); //inserisco nella map
                        temp = key;
                        value = new int[7][7];
                    }
                    value[rst2.getInt("Giorno")][rst2.getInt("Ora")] = rst2.getInt("Minuti");  //riempio la matrice                
                }
                avaibilities.put(temp, value); //per non perdere l'ultima settimana di disponibilità
                l.add(new Maintainer(name, competencies, avaibilities));
            }
            return l;
        } catch (SQLException ex) {
            return null;
        }

    }
    
    /**
     * Assegna l'attvitià ad un manutentore
     * @param m Manutentore a cui vogliamo assegnare l'attività
     * @param a Attività da assegnare
     * @param giorno Giorno in cui assegnare l'attività
     * @param ore Ore delle settimana selezionate per svolgere l'attività
     * @throws Exception L'attività non può essere assegnata. è possibile vedere la causa nel messaggio dell'eccezione.
     */
    public void assignedActivityToMaintainer(Maintainer m, Activity a, int giorno, int ore[]) throws Exception{
        super.getConnection().setAutoCommit(false);
        super.getConnection().setSavepoint();
        if(a.getType() == 1) //Se l'attività è una EWO devo verificare se il planner vuole assegnarla al posto di un'altra interrompibile
            m = this.checkInterruptable(m, a, giorno, ore); //Controllo se il manutentore sta svolgendo un'attività da interrompere

        int avaibility[][] = m.getAvailability().get(a.getWeek());
        int daily[] = avaibility[giorno];
        int timeLeft = a.getEstimatedTime();
        int minutiprimacella = daily[ore[0]];
        for (int i = 0; i < ore.length; i++) {
            if (daily[ore[i]] < timeLeft) {
                timeLeft -= daily[ore[i]];
                daily[ore[i]] = 0;
            } else {
                daily[ore[i]] -= timeLeft;
                //Aggiorno il db
                int id = 0;
                Statement stm = super.getConnection().createStatement();
                ResultSet rst = stm.executeQuery("select * from Maintainer where nome = '" + m.getName()+"'");
                rst.next();
                id= rst.getInt("ID_MAN");
                try{
                    for (int j=0; j<=6; j++){
                        for (int k=0; k<=6; k++){
                            String query = "update Availability set minuti = " + avaibility[j][k] +
                                            " where ID_DISPONIBILITA in (select ID_DISPONIBILITA"+   
                                                " from DISPONIBILITA_MANUTENTORE where ID_MAN = " + id + ")"+
                                                      "and (settimana = " + a.getWeek()+ ")" +
                                                      "and (giorno = " + j + ")"+
                                                      "and (ora = " + k + ")";
                            super.getConnection().createStatement().executeUpdate(query);
                        }
                    }
                    String query = "insert into Maintainer_for_Activity(maintainer,activity,day_of_week,hour_of_day,minutes_first_cell) values("+id+","+a.getId()+","+giorno+","+ore[0]+","+minutiprimacella+");";
                    super.getConnection().createStatement().executeUpdate(query);
                    super.getConnection().setAutoCommit(true);
                    return;
                } catch (SQLException ex) {
                    this.roollback();
                    if (ex.getMessage().contains("maintainer_for_activity_pkey")) {
                        throw new Exception("L'attività è gia stata assegnata a " + m.getName());
                    } else {
                        throw new Exception("L'attività non può essere assegnata");
                    }
                }
            }
        }
        this.roollback();
        throw new Exception("Non c'è disponibilità per il manutentore nell'arco di tempo selezionato");
    }
    
    private void roollback() throws SQLException{
        if (!super.getConnection().getAutoCommit()) {
            super.getConnection().rollback();
            super.getConnection().setAutoCommit(true);
        }
    }
    
    /**
     * Permette di aggiungere informazioni aggiuntive ad un' attività EWO
     * @param a Attività EWO
     * @return True se sono state fatte modifiche, False se c'è stato un errore
     */
    public boolean setEwoActivity(EwoActivity a) {
        try {
            Statement stm = super.getConnection().createStatement();
            String query = "";
            int id = 0;
            if (a.getProcedure().getId() == 0) { // se l'attività non ha procedure associate nel db
                query = "select max(id_) from Procedura";
                ResultSet rst = stm.executeQuery(query);
                rst.next();
                id = rst.getInt("max");
                if (rst.wasNull()) //Se non ci sono procedure nel database
                {
                    id = 0;
                } else {
                    id += 1;
                }

                //Creo una procedura e mi assicuro che l'id sia univoco
                query = "insert into Procedura(id_,smp_path) values (" + id + ",null);";
                stm.executeUpdate(query);
            } else {
                id = a.getProcedure().getId();
                query = "delete from Competence_for_Procedure where procedura = " + id;
                stm.executeUpdate(query);
            }
            //Associo la procedura all'attività nel database ed aggiorno la descrizione ed il tempo stimato
            query = "update Activity set description = '" + a.getActivityDescription()
                    + "',estimatedTime = " + a.getEstimatedTime() + ",procedura= " + id + " where id_ =" + a.getId();
            stm.executeUpdate(query);
            //Associo le competenze alla procedura appena creata 
            for (String c : a.getProcedure().getCompetencies()) {
                query = "insert into Competence_for_Procedure (procedura,competence) values (" + id + ",'" + c + "');";
                stm.executeUpdate(query);
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    //Metodo di utilità per ripristinare la disponibilità dei manutentori quando un'attività viene cancellata o
    //quando un'attività viene annullata per un manutentore a causa di una attività EWO
    private Maintainer rebuildAvailability(Activity a, boolean onemaintainer, Maintainer ma) throws SQLException {
        List<Maintainer> m = this.getAllMaintainers();
        List<Maintainer> maintainers = this.getAllMaintainers();
        List<String> idm = new ArrayList<>();
        List<Integer> starts = new ArrayList<>(); //Per ogni manutentore segno l'ora di inizio dell'attività
        List<Integer> days = new ArrayList<>(); //Per ogni manutentore segno il giorno della settimana in cui svolgo l'attività
        List<Integer> minutes = new ArrayList<>();
        
        Statement stm = super.getConnection().createStatement();
        String query= "";
        if(onemaintainer)
            query=  "select * from Maintainer_for_Activity,Maintainer where Maintainer.id_man = Maintainer_for_Activity.maintainer and nome = '"+ma.getName()+"'"+" and activity = " + a.getId();
        else
            query = "select * from Maintainer_for_Activity,Maintainer where Maintainer.id_man = Maintainer_for_Activity.maintainer and  activity = " + a.getId();
        
        ResultSet rst = stm.executeQuery(query);
        while (rst.next()) {
            idm.add(rst.getString("Nome"));
            days.add(rst.getInt("day_of_week"));
            starts.add(rst.getInt("hour_of_day"));
            minutes.add(rst.getInt("minutes_first_cell"));
        }

        for (Maintainer man : maintainers) {
            if (!idm.contains(man.getName())) {
                m.remove(man);
            }
        }
        Maintainer man = null;
        for (int i = 0; i < starts.size(); i++) { //Aggiornare le disponibilità
            man = m.get(i);
            int[] availability = man.getAvailability().get(a.getWeek())[days.get(i)];
            int k = starts.get(i);
            int temp = a.getEstimatedTime();

            if (minutes.get(i) < 60) {
                availability[k] = minutes.get(i);
                temp -= minutes.get(i);
                k++;
            }
            while (temp != 0) {
                if (temp < 60) {
                    availability[k] += temp;
                    temp = 0;
                } else {
                    availability[k] = 60;
                    temp -= 60;
                }
                k++;
            }

            for (int j = 0; j <= 6; j++) {
                for (k = 0; k <= 6; k++) {
                    Statement stm2 = super.getConnection().createStatement();
                    query = "update Availability set minuti = " + man.getAvailability().get(a.getWeek())[j][k]
                            + " where ID_DISPONIBILITA in (select ID_DISPONIBILITA"
                            + " from DISPONIBILITA_MANUTENTORE,Maintainer where DISPONIBILITA_MANUTENTORE.ID_MAN = Maintainer.ID_MAN and Maintainer.nome = '" + man.getName() + "')"
                            + "and (settimana = " + a.getWeek() + ")"
                            + "and (giorno = " + j + ")"
                            + "and (ora = " + k + ")";
                    stm2.executeUpdate(query);
                }
            }
        }
        return man;
    }
    
    //Metodo di utilità per l'assegnazione di un' attività EWO
    //che controlla se ci sono attività interrompibili nell'arco di tempo dato come parametro
    private Maintainer checkInterruptable(Maintainer m, Activity a, int giorno, int ore[]) throws SQLException {
        int id = this.getIdMaintainer(m.getName()); //Acquisisco id del maintainer dal db
        //Controllo se ci sono attività nel giorno e nelle ore del giorno date come parametro
        String query = "Select * from Maintainer_for_Activity,Activity where activity=id_ and  maintainer = " + id + " and day_of_week = " + giorno;
        ResultSet rst2 = super.getConnection().createStatement().executeQuery(query);
        while (rst2.next()) {
            int et = rst2.getInt("estimatedTime");
            int start = rst2.getInt("hour_of_day"); //inizio attività
            int end; //fine attività
            if (et % 60 == 0) {  //Calcolo quante e in quali ore è svolta l'attività
                end = ((et / 60) + start) - 1;
            } else {
                end = (et / 60) + start;
            }
            if ((end >= ore[0] && start <= ore[ore.length - 1]) || (start <= ore[ore.length - 1] && end >= ore[0])) { 
                if (rst2.getBoolean("interruptable")) {
                    int ida =  rst2.getInt("id_");
                    m = this.rebuildAvailability(this.getActivity(ida), true, m); //Ripristinare le disponibilità del manutentore 
                    super.getConnection().createStatement().executeUpdate("delete from Maintainer_for_Activity where maintainer = " + id +" and activity = "+ ida); //Interruzione dell'attività
                }
            }
        }
        return m;
    }
   
    private int getIdMaintainer(String name) throws SQLException{
        ResultSet rst = super.getConnection().createStatement().executeQuery("Select * from Maintainer where nome = '" + name + "'");
        rst.next();
        return rst.getInt("id_man");
    }
    /**
     * Ritorna un'array di stringhe dove l'indice rappresenta l'ora del giorno e l'elemento indica se il Maintainer in
     * quella data ora è impegnato con un'attività
     * @param m Manutentore
     * @param week Settimana da controllare
     * @param dayofweek Giorno da controllare
     * @return Array di stringhe, un elemento dell'array ha l'asterisco se il Maintainer è occupato a svolgere l'attività in quell'ora
     */
    public String[] busyMaintainer(Maintainer m,int week,int dayofweek){
        try {
            String busy[] = new String[]{" "," "," "," "," "," "," "};
            ResultSet rst = super.getConnection().createStatement().executeQuery("Select * from Maintainer where nome = '" + m.getName()+"'");
            int id= this.getIdMaintainer(m.getName());
            String query="Select * from Maintainer_for_Activity,Activity where activity = id_ and maintainer = " + id + " and week = " + week + " and day_of_week = " + dayofweek ;
            ResultSet rst2 = super.getConnection().createStatement().executeQuery(query);
            while(rst2.next()){
                int start = rst2.getInt("hour_of_day");
                int minstart = rst2.getInt("minutes_first_cell");
                int time = rst2.getInt("estimatedTime");
                boolean flag = true;
                while (time > 0) {

                    busy[start] = "*";
                    if (flag) {
                        time -= minstart;
                        flag = false;
                    } else {
                        time -= 60;
                    }
                    start++;
                }
            }
            return busy;
        } catch (SQLException ex) {
            return null;
        }

    }
    
    /**
     * Metodo di utilità per i tickets
     * @param id Identificativo dell'attività
     * @return Ritorna lo stato generale della attività EWO (True=Assegnata,False altrimenti)
     */
    public boolean getEwoState(int id){
        try {
            //Se la tabella è vuota allora l'attività non è stata assegnata quindi ritorna false. Ritorna vero altrimenti.
            return getConnection().createStatement().executeQuery("select * from Maintainer_for_Activity where activity = " + id).next(); 
        } catch (SQLException ex) {
            return false;
        }
    }
}
