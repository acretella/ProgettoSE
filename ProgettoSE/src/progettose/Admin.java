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
            System.out.println(ex);
            return false;
        }
    }
    public boolean createSite(Site s){
        try {
            //this.createFactorySiteandArea(s); //Se la factorySite o l'area non esistono allora devo crearle
            String query = "insert into Site(factory_site,area) values('" + s.getFactorySite() +"','"+s.getArea()+"');";
            getConnection().createStatement().executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean modifySite(Site old,Site nw){
        try {
            //this.createFactorySiteandArea(nw); //Se la factorySite o l'area non esistono allora devo crearle
            String query = "update Site set factory_site = '" +nw.getFactorySite() +"',"
                    +" area='"+nw.getArea()+ "' where factory_site = '" + old.getFactorySite() +"' and area = '" + old.getArea() + "'";
            return getConnection().createStatement().executeUpdate(query) != 0; //Se il valore di ritorno è uguale a 0 allora non è stata fatta nessuna modifica
        } catch (SQLException ex) {
            return false;
        }
    }
    
    private void createFactorySiteandArea(Site s) throws SQLException{
        if (!getConnection().createStatement().executeQuery("select * from FactorySite where factory_site = '" + s.getFactorySite() + "'").next()) 
            getConnection().createStatement().executeUpdate("insert into FactorySite values('" + s.getFactorySite() + "');");   
        if (!getConnection().createStatement().executeQuery("select * from Area where area = '" + s.getArea() + "'").next())
            getConnection().createStatement().executeUpdate("insert into Area values('" + s.getArea() + "')");          
    } 
}
