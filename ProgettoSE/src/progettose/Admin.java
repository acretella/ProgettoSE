/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Rossella
 */
public class Admin extends User {
    
    public Admin(String username, String password) throws SQLException {
        super(username, password);
    }
    
    public boolean createCompetence(String competence){
        try{
            Statement stm = super.getConnection().createStatement();
            String query = "insert into Competence(skill) values = ('" + competence + "');";
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex){
            return false;
        }
    }
    
    public boolean deleteCompetence(String competence){
        try{
            Statement stm = super.getConnection().createStatement();
            String query = "delete from Competence where skill = '" + competence +"';";
            return stm.executeUpdate(query) ==1;
        } catch(SQLException ex){
            return false;
        }
    }
    
    public boolean modifyCompetence(String oldCompetence, String newCompetence){
        try{
            Statement stm = super.getConnection().createStatement();
            String query = "update Competence set skill = '" + newCompetence + "' where skill = '" + oldCompetence + "';";
            return stm.executeUpdate(query) == 1;
        }catch (SQLException ex){
            return false;
        }
    }
    
}
