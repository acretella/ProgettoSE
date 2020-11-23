/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Altro
 */
public class ProgettoSE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Planner p = null;
        try {
            p = new Planner("alessio","12345");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        List <String> l = new ArrayList<>();
        
        Activity activity = new Activity(0,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                "lllllll");
        
        boolean createActivity = p.createActivity(activity);
    }
    
}
