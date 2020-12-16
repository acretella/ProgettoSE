/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rossella
 */
public class User {
    private String username;
    private String password;
    private Connection connection = null;

    public User(String username, String password) throws SQLException {
        this.username = username;
        this.password = password;
        String url = "jdbc:postgresql://localhost/ProgettoSE";
        this.connection = DriverManager.getConnection(url, this.username, this.password);
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * Inserisce il materiale passato come parametro nel DB 
     * @param material nome del materiale da inserire
     * @return true quando il materiale viene inserito correttamente,
     *         false quando nel DB esiste un materiale con lo stesso nome o se ci sono delle SQLException
     */
    public boolean createMaterial(String material){
        try{
            String query = "insert into Material(materialName) values ('" + material +"');";
            connection.createStatement().executeUpdate(query);
            return true;
        } catch(SQLException ex){
            return false;
        }
    }
    
    /**
     * Cancella il materiale passato come parametro dal DB
     * @param material nome del materiale da cancellare
     * @return true quando il materiale è stato cancellato correttamente,
     *         false quando il materiale non è presente nel DB o se ci sono delle SQLException
     */
    public boolean deleteMaterial(String material){
        try{
            String query = "delete from Material where materialName= '" + material + "';";
            return connection.createStatement().executeUpdate(query) == 1; //controllo il valore restituito per stabilire se la execute ha effettuato la delete
        } catch (SQLException ex){
            return false;
        }
    }
    
    /**
     * Effettua una update sulla tabella material
     * @param oldMaterial nome del materiale da modificare
     * @param newMaterial nuovo nome del materiale
     * @return true quando la modifica viene effettuata correttamente,
     *         false quando il materiale da modificare non è presente nel DB o ci sono delle SQLException
     */
    public boolean modifyMaterial(String oldMaterial, String newMaterial){
        try{
            String query = "update Material set materialName = '" + newMaterial + "' where materialName = '" + oldMaterial +"';";
            return connection.createStatement().executeUpdate(query) == 1;//controllo il valore restituito per statbiilire se la exectue ha effettuato la update
        } catch(SQLException ex){
            return false;
        }
    }
    
    /**
     * Prende dal DB i materiali presenti nella relavita tabella
     * @return ArrayList di stringhe contenente i nomi dei materiali
     */
    public List<String> getAllMaterials(){
        try{
            ResultSet rst = connection.createStatement().executeQuery("select * from Material;");
            List<String> materials = new ArrayList<>();
            while (rst.next()){
                materials.add(rst.getString("materialName"));
            }
            return materials;    
        } catch(SQLException ex){
            return new ArrayList<>();
        }
    }
    
    /**
     * Prende dal DB le skill presenti nella tabella Competence
     * @return ArrayList di Stringhe contenenti i nomi delle skill
     */
    public List<String> getAllSkills(){
        try{
            ResultSet rst = connection.createStatement().executeQuery("select * from Competence");
            List<String> skills = new ArrayList<>();
            while(rst.next()){
                skills.add(rst.getString("skill"));
            }
            return skills;
        } catch(SQLException ex){
            return new ArrayList<>();
        }
    }
    
    /**
     * Prende dal DB i siti presenti nella tabella Site
     * @return ArrayList di Site 
     */
    public List<Site> getAllSites() {
        try {
            ResultSet rst = connection.createStatement().executeQuery("select * from Site");
            List<Site> sites = new ArrayList<>();
            while (rst.next()) {
                Site s = new Site(rst.getString("factory_site"), rst.getString("area"));
                sites.add(s);
            }
            return sites;
        } catch (SQLException ex) {
            return new ArrayList<>();
        }
    }
                      
}
