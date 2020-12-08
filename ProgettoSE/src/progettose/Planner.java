/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class Planner {

    private String username;
    private String password;
    private Connection connection = null;

    public Planner(String username, String password) throws SQLException {
        this.username = username;
        this.password = password;

        String url = "jdbc:postgresql://localhost/ProgettoSE";

        connection = DriverManager.getConnection(url, this.username, this.password);

    }

    public void createActivity(Activity a) throws Exception {
        try {
            Statement stm = connection.createStatement();
            String query;
            if (a.getProcedure() == null) {
                if(a.getType() == 1) //se è una EWO activity allora devo aggiungere il giorno 
                    query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura,giorno)"
                        + " values(" + a.getId() + ",'" + a.getFactorySite() + "','" + a.getArea() + "','" + a.getTypology() + "','"
                        + a.getActivityDescription() + "'," + a.getEstimatedTime() + "," + a.getWeek() + "," + a.isInterruptable() + ",'" + a.getWorkSpaceNote()
                        + "'," + a.getType() + ",null" +","+ a.getDay()+");";
                query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura)"
                        + " values(" + a.getId() + ",'" + a.getFactorySite() + "','" + a.getArea() + "','" + a.getTypology() + "','"
                        + a.getActivityDescription() + "'," + a.getEstimatedTime() + "," + a.getWeek() + "," + a.isInterruptable() + ",'" + a.getWorkSpaceNote()
                        + "'," + a.getType() + ",null" + ");";
            } else{ // se all'attività è associata una procedura
                query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura)"
                        + " values(" + a.getId() + ",'" + a.getFactorySite() + "','" + a.getArea() + "','" + a.getTypology() + "','"
                        + a.getActivityDescription() + "'," + a.getEstimatedTime() + "," + a.getWeek() + "," + a.isInterruptable() + ",'" + a.getWorkSpaceNote()
                        + "'," + a.getType() + "," + a.getProcedure().getId() + ");";
            }
            stm.executeUpdate(query);

            updateMaterials(a);
            
        } catch (SQLException ex) {
            if(ex.getMessage().contains("check_id"))
                throw new Exception("Esiste già un attività con id = "+a.getId());
            else if (ex.getMessage().contains("check_week"))
                throw new Exception("La settimana deve essere compresa fra 1 e 52");
            else
                throw new Exception("L'attività non può essere creata");
        }

    }

    public List<String> getAllMaterials() {
        try {
            Statement stm = connection.createStatement();

            String query = "Select * from Material";

            ResultSet rst = stm.executeQuery(query);

            List<String> l = new ArrayList<>();

            while (rst.next()) {
                l.add(rst.getString("materialName"));
            }

            return l;

        } catch (SQLException ex) {
            return new ArrayList<>();
        }

    }

    public List<Activity> getAllActivities() {
        try {
            Statement stm = connection.createStatement();

            String query = "Select * from Activity order by week";

            ResultSet rst = stm.executeQuery(query);

            List<Activity> l = new ArrayList<>();

            while (rst.next()) {
                List<String> materials = new ArrayList<>(); //creo la lista di materiali dell'attività
                int id = rst.getInt("id_");
                query = "Select * from Material_for_Activity where activity = " + id;
                Statement stm2 = connection.createStatement();
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
            Statement stm = connection.createStatement();
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
            return new Procedure(id, new File(path), competences);

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
            Statement stm = connection.createStatement();
            String query = "delete from Activity where id_ =" + id;
            return stm.executeUpdate(query) != 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    public Activity getActivity(int id) {
        try {
            Statement stm = connection.createStatement();
            String query = "Select * from Activity where id_ = " + id;
            ResultSet rst = stm.executeQuery(query);

            query = "Select * from Material_for_Activity where activity = " + id;
            Statement stm2 = connection.createStatement();
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
            Statement stm = connection.createStatement();
            String idproc;
            if(a.getProcedure() != null)
                idproc = String.valueOf(a.getProcedure().getId());
            else
                idproc=null;
            String query="";
            if(a.getDay() == -1){
                query ="update Activity set factorySite='"+a.getFactorySite()+
                        "',area='"+a.getArea()+"',typology='"+a.getTypology()+"',description='"+a.getActivityDescription()+
                        "',estimatedTime="+a.getEstimatedTime()+",week="+a.getWeek()+",interruptable="+a.isInterruptable()+
                        ",workSpaceNotes='"+a.getWorkSpaceNote()+"',activityType="+a.getType()+
                    ",procedura="+idproc+",giorno= null"+" where id_="+a.getId()+";";
            }
            else{
                query = "update Activity set factorySite='"+a.getFactorySite()+
                        "',area='"+a.getArea()+"',typology='"+a.getTypology()+"',description='"+a.getActivityDescription()+
                        "',estimatedTime="+a.getEstimatedTime()+",week="+a.getWeek()+",interruptable="+a.isInterruptable()+
                        ",workSpaceNotes='"+a.getWorkSpaceNote()+"',activityType="+a.getType()+
                    ",procedura="+idproc+",giorno="+a.getDay()+" where id_="+a.getId()+";";
            }
             
                    if(stm.executeUpdate(query) == 0)
                        throw new Exception("Nessuna modifica effettuata");
                    
                    query = "delete from Material_for_Activity where activity= "+ a.getId();
                    stm.executeUpdate(query);
                    
                    updateMaterials(a);
        } catch (SQLException ex) {
            if(ex.getMessage().contains("check_week"))
                throw new Exception("La settimana deve essere compresa fra 1 e 52");
            else
                throw new Exception("L'attività non può essere modificata");
        }
    }
    
    private void updateMaterials(Activity a) throws SQLException{
        String query=  " ";
        Statement stm = connection.createStatement();
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
            Statement stm = connection.createStatement();
            Statement stm2 = connection.createStatement();
            String query = "select * from Maintainer";
            ResultSet rst = stm.executeQuery(query);
            while(rst.next()){
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
            System.out.println(ex.getMessage());
            return null;
        }

    }
    
    public void assignedActivityToMaintainer(Maintainer m, Activity a, int giorno, int ore[]) throws Exception{
        int avaibility[][] = m.getAvailability().get(a.getWeek()); 
        int daily [] = avaibility[giorno];
        int timeLeft = a.getEstimatedTime();
        for (int i=0; i<ore.length; i++){
            if (daily[ore[i]] < timeLeft){
                timeLeft -= daily[ore[i]];
                daily[ore[i]] = 0;
            }
            else{ 
                daily[ore[i]] -= timeLeft;
                //Aggiorno il db
                int id = 0;
                
                Statement stm = connection.createStatement();
                ResultSet rst = stm.executeQuery("select * from Maintainer where nome = '" + m.getName()+"'");
                rst.next();
                id= rst.getInt("ID_MAN");
                
                try{
                    for (int j=0; j<=6; j++){
                        for (int k=0; k<=6; k++){
                            Statement stm2 = connection.createStatement();
                            String query = "update Availability set minuti = " + avaibility[j][k] +
                                            " where ID_DISPONIBILITA in (select ID_DISPONIBILITA"+   
                                                " from DISPONIBILITA_MANUTENTORE where ID_MAN = " + id + ")"+
                                                      "and (settimana = " + a.getWeek()+ ")" +
                                                      "and (giorno = " + j + ")"+
                                                      "and (ora = " + k + ")";
                            stm2.executeUpdate(query);
                        }
                    }
                    Statement stm3 = connection.createStatement();
                    String query = "insert into Maintainer_for_Activity(maintainer,activity) values("+id+","+a.getId()+");";
                    stm3.executeUpdate(query);
                    return;
                    } catch (SQLException ex) {
                        if(ex.getMessage().contains("maintainer_for_activity_pkey"))
                            throw new Exception("L'attività è gia stata assegnata a "+ m.getName());
                        else
                            throw new Exception("L'attività non può essere assegnata");
                    }
            }           
        }
        throw new Exception("Non c'è disponibilità per il manutentore nell'arco di tempo selezionato");
    }
       
    /**
     * This method returns a list that contains all the skills in the DB
     * @return a list of strings or a list empty
     */
    public List<String> getAllSkills(){
        try {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("select * from Competence");
            List<String> skills = new ArrayList<>();
            while(rst.next())
                skills.add(rst.getString("skill"));
            return skills;
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
    }
    
    public boolean setEwoActivity(EwoActivity a){
        try {
            Statement stm = connection.createStatement();
            String query = "";
            int id = 0;
            if(a.getProcedure().getId() == 0) // se l'attività non ha procedure associate nel db
                for (String skill:a.getProcedure().getCompetencies()){
                    query = "select max(id_) from Procedura";
                    ResultSet rst = stm.executeQuery(query);
                    rst.next();
                    id = rst.getInt("max");
                    if(rst.wasNull()) //Se non ci sono procedure nel database
                        id = 0; 
                    else
                        id += 1;
                    
                    //Creo una procedura e mi assicuro che l'id sia univoco
                    query = "insert into Procedura(id_,smp_path) values ("+id+",null);";
                    stm.executeUpdate(query);
                }
            else{
                id = a.getProcedure().getId();
                query = "delete from Competence_for_Procedure where procedura = " + id;
                stm.executeUpdate(query);
            }
            //Associo la procedura all'attività nel database ed aggiorno la descrizione ed il tempo stimato
            query = "update Activity set description = '" + a.getActivityDescription() + 
                    "',estimatedTime = "+a.getEstimatedTime()+",procedura= "+ id +" where id_ =" + a.getId();
            stm.executeUpdate(query);
            //Associo le competenze alla procedura appena creata 
            for (String c : a.getProcedure().getCompetencies()){
                query = "insert into Competence_for_Procedure (procedura,competence) values ("+id+",'"+c+"');";
                stm.executeUpdate(query);
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
  
}
