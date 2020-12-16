/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.sql.SQLException;
/**
 *
 * @author Rossella
 */
public class Admin extends User {
    
    public Admin(String username, String password) throws SQLException {
        super(username, password);
    }
    
    /**
     * Inserisce la competenza passata come parametro nel DB
     * @param competence nome della competenza da inserire
     * @return true quando l'inserimento viene eseguito correttamente, false quando la competenza è già presente nel DB o ci sono SQLException 
     */
    public boolean createCompetence(String competence){
        try{
            String query = "insert into Competence(skill) values ('" + competence + "');";
            super.getConnection().createStatement().executeUpdate(query);
            return true;
        } catch (SQLException ex){
            return false;
        }
    }
    
    /**
     * Elimina la competenza passata come parametro dal DB
     * @param competence nome della competenza da cancellare
     * @return true quando la cancellazione viene eseguita correttamente, false la competenza da cancellare non è presente nel DB o ci sono SQLException
     */
    public boolean deleteCompetence(String competence){
        try{
            String query = "delete from Competence where skill = '" + competence +"';";
            return super.getConnection().createStatement().executeUpdate(query) == 1;
        } catch(SQLException ex){
            return false;
        }
    }
    
    /**
     * Effettua una update sulla tabella competence
     * @param oldCompetence nome della competenza da modificare
     * @param newCompetence nuovo nome della competenza
     * @return true quando la modifica viene eseguita correttamente, false quando la competenza da modificare non è presente nel DB o ci sono SQLException
     */
    public boolean modifyCompetence(String oldCompetence, String newCompetence){
        try{
            String query = "update Competence set skill = '" + newCompetence + "' where skill = '" + oldCompetence + "';";
            return super.getConnection().createStatement().executeUpdate(query) == 1;
        }catch (SQLException ex){
            return false;
        }
    }
    
    /**
     * Cancella il sito passato come parametro dal DB
     * @param site nome del sito da cancellare
     * @return true quando la cancellazione viene effettuata correttamente, false quando il sito da cancellare non è presente o ci sono SQLException 
     */
    public boolean deleteSite(Site site) {
        try {
            String query = "delete from Site where (factory_site, area) = ('" + site.getFactorySite() + "', '" + site.getArea() + "')";
            return super.getConnection().createStatement().executeUpdate(query) == 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    /**
     * Inserisce il sito passato come parametro nel DB
     * @param s nome del sito da inserire
     * @return true quando l'inserimetno viene eseguito correttamente, false quando il sito è già presente nel DB o ci sono SQLException
     */
    public boolean createSite(Site s){
        try {
            String query = "insert into Site(factory_site,area) values('" + s.getFactorySite() +"','"+s.getArea()+"');";
            getConnection().createStatement().executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    /**
     * Effettua una update sulla tabella Site
     * @param old sito da modificare
     * @param nw sito aggiornato
     * @return true quando la modifica viene effettuata correttamente, false quando nel DB non è presente il sito da modificare o ci sono SQLException
     */
    public boolean modifySite(Site old,Site nw){
        try {
            String query = "update Site set factory_site = '" +nw.getFactorySite() +"',"
                    +" area='"+nw.getArea()+ "' where factory_site = '" + old.getFactorySite() +"' and area = '" + old.getArea() + "'";
            return getConnection().createStatement().executeUpdate(query) != 0; //Se il valore di ritorno è uguale a 0 allora non è stata fatta nessuna modifica
        } catch (SQLException ex) {
            return false;
        }
    }

}
