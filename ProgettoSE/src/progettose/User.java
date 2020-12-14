/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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

    public boolean createMaterial(String material){
        try{
            Statement stm = connection.createStatement();
            String query = "insert into Material(materialName) values ('" + material +"');";
            stm.executeUpdate(query);
            return true;
        } catch(SQLException ex){
            return false;
        }
    }
    
    public boolean deleteMaterial(String material){
        try{
            Statement stm = connection.createStatement();
            String query = "delete from Material where materialName= '" + material + "';";
            return stm.executeUpdate(query) == 1; //controllo il valore restituito per stabilire se la execute ha effettuato la delete
        } catch (SQLException ex){
            return false;
        }
    }
    
    public boolean modifyMaterial(String oldMaterial, String newMaterial){
        try{
            Statement stm = connection.createStatement();
            String query = "update Material set materialName = '" + newMaterial + "' where materialName = '" + oldMaterial +"';";
            return stm.executeUpdate(query) == 1;//controllo il valore restituito per statbiilire se la exectue ha effettuato la update
        } catch(SQLException ex){
            return false;
        }
    }
    
    public List<String> getAllMaterials(){
        try{
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("select * from Material;");
            List<String> materials = new ArrayList<>();
            while (rst.next()){
                materials.add(rst.getString("materialName"));
            }
            return materials;    
        } catch(SQLException ex){
            return new ArrayList<>();
        }
    }
    
    public List<String> getAllSkills(){
        try{
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("select * from Competence");
            List<String> skills = new ArrayList<>();
            while(rst.next()){
                skills.add(rst.getString("skill"));
            }
            return skills;
        } catch(SQLException ex){
            return new ArrayList<>();
        }
    }
                      
}
