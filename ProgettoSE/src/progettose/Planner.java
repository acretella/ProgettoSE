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
import java.util.List;
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
        
        String url = "jdbc:postgresql://localhost/ProgettoSE" ;
                
        connection = DriverManager.getConnection(url,this.username,this.password);
      
    }
    
    public boolean createActivity(Activity a) {
        try {
            Statement stm = connection.createStatement();
            
            String query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType)"
                    + " values("+a.getId()+",'"+a.getFactorySite()+"','"+a.getArea()+"','"+a.getTypology()+"','"
                    +a.getActivityDescription()+"',"+a.getEstimatedTime()+","+a.getWeek()+","+a.isInterruptable()+",'"+a.getWorkSpaceNote()
                    +"',"+a.getType()+");";
            stm.executeUpdate(query);
            
            if (! a.getMaterials().isEmpty()){
                
                for (String material : a.getMaterials()){
                    query = "insert into Material_for_Activity(activity,material) values("
                        + a.getId() + ",'" + material + "');";
                    
                    stm.executeUpdate(query);
                }
                
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
        
    }

    public List<String> getAllMaterials(){
        try {
            Statement stm = connection.createStatement();
            
            String query = "Select * from Material";
            
            ResultSet rst = stm.executeQuery(query);
            
            List<String> l = new ArrayList<>();
            
            while (rst.next()){
                l.add(rst.getString("materialName"));
            }
            
            return l;
            
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
        
    }
    

    public List<Activity> getAllActivities(){
           try {
            Statement stm = connection.createStatement();
            
            String query = "Select * from Activity orider by week";
            
            ResultSet rst = stm.executeQuery(query);
            
            List<Activity> l = new ArrayList<>();
            
            while (rst.next()){
                List<String> materials = new ArrayList<>(); //creo la lista di materiali dell'attività
                int id = rst.getInt("id_");
                query = "Select * from Material_for_Activity where activity = "+ id;
                Statement stm2 = connection.createStatement();
                ResultSet rst2 = stm2.executeQuery(query);
                while(rst2.next()){
                    materials.add(rst2.getString("material"));
                }
                l.add(this.createActivity(rst, materials,id));
                
            }
            return l;
                        
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
     
    }
    protected Procedure createProcedure(int id){
        try {
            Statement stm = connection.createStatement();
            String query = "select * from procedura where id_ =" + id;
            
            ResultSet rst = stm.executeQuery(query);
            rst.next();
            String path = rst.getString("smp_path");
            
            query = "select * from competence_for_procedure where procedura = "+ id; 
            rst = stm.executeQuery(query);
            List<String> competences = new ArrayList<>();
            while(rst.next()){
                competences.add(rst.getString("competence"));
            }
            return new Procedure(new File(path), competences);
            
        } catch (SQLException ex) {
            return null;
        }
        
    }
    
    protected Activity createActivity(ResultSet rst, List<String> materials,int id) throws SQLException{
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
    
    
    public boolean deleteActivity(int id){
        try {
            Statement stm = connection.createStatement();
            String query = "delete from Activity where id_ =" + id;
            return stm.executeUpdate(query) != 0;
        } catch (SQLException ex) {
            return false;
        }      
    }
    
    public Activity getActivity(int id){
        try {
            Statement stm = connection.createStatement();
            String query = "Select * from Activity where id_ = "+id;
            ResultSet rst = stm.executeQuery(query);
            
            query = "Select * from Material_for_Activity where activity = "+ id;
            Statement stm2 = connection.createStatement();
            ResultSet rst2 = stm2.executeQuery(query);
            
            List <String> materials = new ArrayList<>(); 
            while(rst2.next()){
                materials.add(rst2.getString("material"));
            }
            rst.next();
            return createActivity(rst, materials, id);
            
        } catch (SQLException ex) {
            return null;
        }
    }
        
    public boolean modifyActivity(Activity a) {
        if(this.deleteActivity(a.getId()))
            return this.createActivity(a);
        else
            return false;  
    }
}
