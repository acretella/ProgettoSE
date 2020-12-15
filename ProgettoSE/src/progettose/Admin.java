/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String query = "insert into Competence(skill) values ('" + competence + "');";
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
            return stm.executeUpdate(query) == 1;
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
    
    public boolean deleteSite(Site site) {
        try {
            Statement stm = super.getConnection().createStatement();
            String query = "delete from Site where (factory_site, area) = ('" + site.getFactorySite() + "', '" + site.getArea() + "')";
            return stm.executeUpdate(query) == 1;
        } catch (SQLException ex) {
            return false;
        }
    }
    public boolean createSite(Site s){
        try {
            //Se la factorySite non esiste devo crearla
            if(!getConnection().createStatement().executeQuery("select * from FactorySite where factory_site = " +s.getFactorySite()).next())
                getConnection().createStatement().executeQuery("insert into FactorySite values('"+s.getFactorySite()+"');");
            //Se la l'area non esiste devo crearla
            if(!getConnection().createStatement().executeQuery("select * from Area where area = " +s.getArea()).next())
                getConnection().createStatement().executeQuery("insert into Area values('"+s.getArea()+"')");
            String query = "insert into Site(factory_site,area) values('" + s.getFactorySite() +"','"+s.getArea()+"');";
            getConnection().createStatement().executeQuery(query);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean modifySite(Site old,Site nw){
        try {
            String query = "update FactorySite set factory_site = '" +nw.getFactorySite() +"' where factory_site = '" + old.getFactorySite() +"'";
            getConnection().createStatement().executeQuery(query);
            query = "update Area set area = '" +nw.getArea() +"' where area = '" + old.getArea() +"'";
            getConnection().createStatement().executeQuery(query);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
}
