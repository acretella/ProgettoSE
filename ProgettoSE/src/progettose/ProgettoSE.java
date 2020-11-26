/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
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
    public static void main(String[] args) throws IOException {
//        Planner p = null;
//        try {
//            p = new Planner("alessio","12345");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//        
//        List<Activity> list = p.getAllActivities();
//        String str = "";
//        for (Activity a : list)
//            str += a.getId() + " ";
//        System.out.println(str);

        File file = new File("C:\\Users\\lenovo\\Desktop\\PM SRS Part I - Planner.pdf");
        Desktop.getDesktop().open(file);
    }
    
}
