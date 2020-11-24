/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
            int type;
            if (a instanceof PlannedActivity)
                type = 0;
            else if (a instanceof EwoActivity)
                type =1;           
            else
                type = 2;
            
            String query = "insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,workSpaceNotes,activityType)"
                    + " values("+a.getId()+",'"+a.getFactorySite()+"','"+a.getArea()+"','"+a.getTypology()+"','"
                    +a.getActivityDescription()+"',"+a.getEstimatedTime()+","+a.getWeek()+",'"+a.getWorkSpaceNote()
                    +"',"+type+");";
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            return false;
        }
        
    }

    
    
}
