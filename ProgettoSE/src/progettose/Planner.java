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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Altro
 */
public class Planner extends User{


    public Planner(String username, String password) throws SQLException {
        
        super(username,password);

    }

    public void createActivity(Activity a) throws Exception {
        try {
            Statement stm = super.getConnection().createStatement();
            String query;
            if (a.getProcedure() == null) {
                if (a.getType() == 1) //se è una EWO activity allora devo aggiungere il giorno 
                {
                    query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura,giorno)"
                            + " values(" + a.getId() + ",'" + a.getFactorySite() + "','" + a.getArea() + "','" + a.getTypology() + "','"
                            + a.getActivityDescription() + "'," + a.getEstimatedTime() + "," + a.getWeek() + "," + a.isInterruptable() + ",'" + a.getWorkSpaceNote()
                            + "'," + a.getType() + ",null" + "," + a.getDay() + ");";
                } else {
                    query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura)"
                            + " values(" + a.getId() + ",'" + a.getFactorySite() + "','" + a.getArea() + "','" + a.getTypology() + "','"
                            + a.getActivityDescription() + "'," + a.getEstimatedTime() + "," + a.getWeek() + "," + a.isInterruptable() + ",'" + a.getWorkSpaceNote()
                            + "'," + a.getType() + ",null" + ");";
                }
            } else { // se all'attività è associata una procedura
                query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura)"
                        + " values(" + a.getId() + ",'" + a.getFactorySite() + "','" + a.getArea() + "','" + a.getTypology() + "','"
                        + a.getActivityDescription() + "'," + a.getEstimatedTime() + "," + a.getWeek() + "," + a.isInterruptable() + ",'" + a.getWorkSpaceNote()
                        + "'," + a.getType() + "," + a.getProcedure().getId() + ");";
            }
            stm.executeUpdate(query);

            updateMaterials(a);

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


    public List<Activity> getAllActivities() {
        try {
            Statement stm = super.getConnection().createStatement();

            String query = "Select * from Activity order by week";

            ResultSet rst = stm.executeQuery(query);

            List<Activity> l = new ArrayList<>();

            while (rst.next()) {
                List<String> materials = new ArrayList<>(); //creo la lista di materiali dell'attività
                int id = rst.getInt("id_");
                query = "Select * from Material_for_Activity where activity = " + id;
                Statement stm2 = super.getConnection().createStatement();
                ResultSet rst2 = stm2.executeQuery(query);
                while (rst2.next()) {
                    materials.add(rst2.getString("material"));
                }
                l.add(this.createActivity(rst, materials, id));
            }
            return l;

        } catch (SQLException ex) {
            return new ArrayList<>();
        }

    }

    protected Procedure createProcedure(int id) {
        try {
            Statement stm = super.getConnection().createStatement();
            String query = "select * from procedura where id_ = " + id;
            ResultSet rst = stm.executeQuery(query);
            rst.next();
            String path = rst.getString("smp_path");
            query = "select * from competence_for_procedure where procedura = " + id;
            rst = stm.executeQuery(query);
            List<String> competences = new ArrayList<>();
            while (rst.next()) {
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
        switch (rst.getInt("activityType")) {
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

    public boolean deleteActivity(int id) {
        try {
            Statement stm = super.getConnection().createStatement();
            String query = "delete from Activity where id_ =" + id;
            Activity a = this.getActivity(id);
            if (a == null) //Se l'attività da cancellare non esiste
            {
                return false;
            }
            this.rebuildAvailability(a, false, null);//ripristino le disponibilità dei manutentori collegati all'attività
            if (stm.executeUpdate(query) == 0) {
                return false;
            }

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public Activity getActivity(int id) {
        try {
            Statement stm = super.getConnection().createStatement();
            String query = "Select * from Activity where id_ = " + id;
            ResultSet rst = stm.executeQuery(query);

            query = "Select * from Material_for_Activity where activity = " + id;
            Statement stm2 = super.getConnection().createStatement();
            ResultSet rst2 = stm2.executeQuery(query);

            List<String> materials = new ArrayList<>();
            while (rst2.next()) {
                materials.add(rst2.getString("material"));
            }
            rst.next();
            return createActivity(rst, materials, id);

        } catch (SQLException ex) {
            return null;
        }
    }

    public void modifyActivity(Activity a) throws Exception {
        try {
            Statement stm = super.getConnection().createStatement();
            String idproc;
            if (a.getProcedure() != null) {
                idproc = String.valueOf(a.getProcedure().getId());
            } else {
                idproc = null;
            }
            String query = "";
            if (a.getDay() == -1) {
                query = "update Activity set factorySite='" + a.getFactorySite()
                        + "',area='" + a.getArea() + "',typology='" + a.getTypology() + "',description='" + a.getActivityDescription()
                        + "',estimatedTime=" + a.getEstimatedTime() + ",week=" + a.getWeek() + ",interruptable=" + a.isInterruptable()
                        + ",workSpaceNotes='" + a.getWorkSpaceNote() + "',activityType=" + a.getType()
                        + ",procedura=" + idproc + ",giorno= null" + " where id_=" + a.getId() + ";";
            } else {
                query = "update Activity set factorySite='" + a.getFactorySite()
                        + "',area='" + a.getArea() + "',typology='" + a.getTypology() + "',description='" + a.getActivityDescription()
                        + "',estimatedTime=" + a.getEstimatedTime() + ",week=" + a.getWeek() + ",interruptable=" + a.isInterruptable()
                        + ",workSpaceNotes='" + a.getWorkSpaceNote() + "',activityType=" + a.getType()
                        + ",procedura=" + idproc + ",giorno=" + a.getDay() + " where id_=" + a.getId() + ";";
            }

            if (stm.executeUpdate(query) == 0) {
                throw new Exception("Nessuna modifica effettuata");
            }

            query = "delete from Material_for_Activity where activity= " + a.getId();
            stm.executeUpdate(query);

            updateMaterials(a);
        } catch (SQLException ex) {
            if (ex.getMessage().contains("check_week")) {
                throw new Exception("La settimana deve essere compresa fra 1 e 52");
            } else {
                throw new Exception("L'attività non può essere modificata");
            }
        }
    }
    
    private void updateMaterials(Activity a) throws SQLException{
        String query=  " ";
        Statement stm = super.getConnection().createStatement();
        if (!a.getMaterials().isEmpty()) {
            for (String material : a.getMaterials()) {

                query = "insert into Material_for_Activity(activity,material) values("
                        + a.getId() + ",'" + material + "');";

                stm.executeUpdate(query);
            }
        }
    }

    public List<Maintainer> getAllMaintainers() {
        List<Maintainer> l = new ArrayList<>();
        int id;
        try {
            Statement stm = super.getConnection().createStatement();
            Statement stm2 = super.getConnection().createStatement();
            String query = "select * from Maintainer";
            ResultSet rst = stm.executeQuery(query);
            while (rst.next()) {
                Map<Integer, int[][]> avaibilities = new HashMap<>();
                List<String> competencies = new ArrayList<>();
                String name = rst.getString("nome");
                id = rst.getInt("ID_MAN");
                ResultSet rst2 = stm2.executeQuery("select * from Competence_for_Maintainer where id_man = " + id);
                while (rst2.next()) //Aggiungo le competenze al Maintainer
                {
                    competencies.add(rst2.getString("NOMECOMPETENZA"));
                }
                query = "select * from DISPONIBILITA_MANUTENTORE as dm,Availability as a where dm.ID_DISPONIBILITA = a.ID_DISPONIBILITA and dm.ID_MAN = " + id + " order by Settimana";
                rst2 = stm2.executeQuery(query);
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
    
    public void assignedActivityToMaintainer(Maintainer m, Activity a, int giorno, int ore[]) throws Exception{
        super.getConnection().setAutoCommit(false);
        super.getConnection().setSavepoint();
        if(a.getType() == 1){ //Se l'attività è una EWO devo verificare se il planner vuole assegnarla al posto di un'altra interrompibile
            this.checkInterruptable(m, a, giorno, ore);
            for (Maintainer man : this.getAllMaintainers()) {
                if (man.getName().equals(m.getName())) {
                    m = man;
                    break;
                }
            }
        }

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
                            Statement stm2 = super.getConnection().createStatement();
                            String query = "update Availability set minuti = " + avaibility[j][k] +
                                            " where ID_DISPONIBILITA in (select ID_DISPONIBILITA"+   
                                                " from DISPONIBILITA_MANUTENTORE where ID_MAN = " + id + ")"+
                                                      "and (settimana = " + a.getWeek()+ ")" +
                                                      "and (giorno = " + j + ")"+
                                                      "and (ora = " + k + ")";
                            stm2.executeUpdate(query);
                        }
                    }
                    Statement stm3 = super.getConnection().createStatement();
                    String query = "insert into Maintainer_for_Activity(maintainer,activity,day_of_week,hour_of_day,minutes_first_cell) values("+id+","+a.getId()+","+giorno+","+ore[0]+","+minutiprimacella+");";
                    stm3.executeUpdate(query);
                    super.getConnection().setAutoCommit(true);
                    return;
                } catch (SQLException ex) {
                    if (!super.getConnection().getAutoCommit()) {
                        super.getConnection().rollback();
                        super.getConnection().setAutoCommit(true);
                    }
                    if (ex.getMessage().contains("maintainer_for_activity_pkey")) {
                        throw new Exception("L'attività è gia stata assegnata a " + m.getName());
                    } else {
                        throw new Exception("L'attività non può essere assegnata");
                    }
                }
            }
        }
        if(!super.getConnection().getAutoCommit()){
            super.getConnection().rollback();
            super.getConnection().setAutoCommit(true);
        }
        throw new Exception("Non c'è disponibilità per il manutentore nell'arco di tempo selezionato");
    }

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

    private void rebuildAvailability(Activity a, boolean onemaintainer, Maintainer ma) throws SQLException {
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

        for (int i = 0; i < starts.size(); i++) { //Aggiornare le disponibilità
            Maintainer man = m.get(i);
            int[] availability = man.getAvailability().get(a.getWeek())[days.get(i)];
            int k = starts.get(i);
            int temp = a.getEstimatedTime();

            if (minutes.get(i) < 60) {
                availability[k] += minutes.get(i);
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
    }
    

    private void checkInterruptable(Maintainer m, Activity a, int giorno, int ore[]) throws SQLException {
        //Acquisisco id del maintainer dal db
        Statement stm = super.getConnection().createStatement();
        ResultSet rst = stm.executeQuery("Select * from Maintainer where nome = '" + m.getName()+"'");
        int id=0;
        while(rst.next())
            id = rst.getInt("id_man");
        

        String query = "Select * from Maintainer_for_Activity,Activity where activity=id_ and  maintainer = " + id + " and day_of_week = " + giorno;
        ResultSet rst2 = stm.executeQuery(query);
        while (rst2.next()) {
            int et = rst2.getInt("estimatedTime");
            int start = rst2.getInt("hour_of_day"); //inizio attività
            int end; //fine attività
            if (et % 60 == 0) {
                end = ((et / 60) + start) - 1;
            } else {
                end = (et / 60) + start;
            }
            if ((end >= ore[0] && start <= ore[ore.length - 1]) || (start <= ore[ore.length - 1] && end >= ore[0])) {
                if (rst2.getBoolean("interruptable")) {
                    this.rebuildAvailability(this.getActivity(rst2.getInt("id_")), true, m);
                    super.getConnection().createStatement().executeUpdate("delete from Maintainer_for_Activity where maintainer = " + id +" and activity = "+ a.getId());
                }
            }
        }

    }
   
    public String[] busyMaintainer(Maintainer m,int week,int dayofweek){
        try {
            String busy[] = new String[]{" "," "," "," "," "," "," "};
            ResultSet rst = super.getConnection().createStatement().executeQuery("Select * from Maintainer where nome = '" + m.getName()+"'");
            int id=0;
            while(rst.next())
                id = rst.getInt("id_man");
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
            System.out.println(ex);
            return null;
        }

    }
    
    public boolean getEwoState(int id){
        try {
            String query = "select * from Maintainer_for_Activity where activity = " + id;
            //Se la tabella è vuota allora l'attività non è stata assegnata quindi ritorna false. Ritorna vero altrimenti.
            return getConnection().createStatement().executeQuery(query).next(); 
        } catch (SQLException ex) {
            return false;
        }
    }
}
