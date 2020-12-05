/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import progettose.Activity;
import progettose.Maintainer;
import progettose.PlannedActivity;
import progettose.Planner;
import progettose.Procedure;

/**
 *
 * @author Altro
 */
public class PlannerTest {
    Planner p = null;
    
    @Before
    public void testConnection() {
        try {
            p = new Planner("alessio","12345");
            assertEquals(1,1);
        } catch (SQLException ex) {
            assertEquals(1,2);
        }
    } 
    
    @Test
    public void testPosCreateActivity(){
        List <String> l = new ArrayList<>();
        Procedure proc = null;
        Activity activity = new Activity(0,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                false,
                "lllllll",
                proc);        
        try {
            p.createActivity(activity);
        } catch (Exception ex) {
            assertEquals(true,false);
        }
        p.deleteActivity(activity.getId());
    }
    
   @Test(expected=Exception.class)
    public void testNegCreateActivity() throws Exception{
        List <String> l = new ArrayList<>();
        Procedure proc = null;
        Activity activity = new Activity(2,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll",
                proc);
        
        Activity activity2 = new Activity(2,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll",
                proc);            
        try {
            p.createActivity(activity);        
            p.createActivity(activity2);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().equals("Esiste già un attività con id = "+ activity.getId()));
            throw ex;
        }
        finally{
            p.deleteActivity(activity.getId());
    
        }
    }
    
    @Test(expected=Exception.class)
    public void TestNeg2CreateActivity() throws Exception{
        Activity activity = new Activity(47,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                53,
                new ArrayList<String>(),
                true,
                "lllllll",
                null);
        
        try {
            p.createActivity(activity);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().equals("La settimana deve essere compresa fra 1 e 52"));
            throw ex;
        }
        
    }

    @Test
    public void testPosDeleteActivity() throws Exception{
        List <String> l = new ArrayList<>();
        Procedure proc = null;   
        Activity activity = new Activity(55,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll",
                proc);
        
        
        p.createActivity(activity);

                
        assertTrue(p.deleteActivity(55)== true);
    }
    
    @Test
    public void testGetAllActivities() throws Exception{
        Procedure proc = null;
        Activity a = new PlannedActivity(18,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                new ArrayList<>(),
                true,
                "lllllll",
                proc);
        p.createActivity(a);
        
        List<Activity> list = p.getAllActivities();
        assertTrue(! list.isEmpty());
        String str = "";
        for (Activity act : list)
            str += act.getId() + " ";
        System.out.println(str);
        p.deleteActivity(a.getId());
    }
     
    @Test 
    public void testNegDeleteActivity(){

        assertTrue(p.deleteActivity(200)== false);
    }
    
    @Test
    public void testPosGetActivity() throws Exception{
        Procedure proc = null;
        Activity a = new PlannedActivity(12,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                new ArrayList<>(),
                true,
                "lllllll",
                proc);
        p.createActivity(a);
        assertEquals(p.getActivity(a.getId()).getId() , a.getId());
        p.deleteActivity(a.getId());
    }
    
    @Test
    public void testNegGetActivity(){
        assertEquals(p.getActivity(300), null);
    }
    
    @Test
    public void testPosModifyActivity() throws Exception{
        List <String> l = new ArrayList<>();
        Procedure proc = null;
        Activity a = new Activity(2,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll",
                proc);
        
        p.createActivity(a);
        a.setType(2);
        p.modifyActivity(a);
        p.deleteActivity(a.getId());
    }
    
    @Test(expected=Exception.class)
    public void TestNegModifyActivity() throws Exception {
        //modifico attività non presente nel DB
        List <String> l = new ArrayList<>();
        Procedure proc = null;
        Activity activity = new Activity(5,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll",
                proc);
        
        p.modifyActivity(activity);
    }
    
    @Test(expected=Exception.class)
    public void TestNeg2ModifyActivity() throws Exception{
        try {
            Activity activity = new Activity(42,
                    "branch office",
                    "departement",
                    "electrical",
                    "aaaaaaaa",
                    100,
                    1,
                    new ArrayList<>(),
                    true,
                    "lllllll",
                    null);
            p.createActivity(activity);
            activity.setWeek(53);
            p.modifyActivity(activity);
            p.deleteActivity(activity.getId());
        } catch (Exception ex) {
            assertTrue(ex.getMessage().equals("La settimana deve essere compresa fra 1 e 52"));
            throw new Exception();
        }
    }
    
    @Test
    public void isThereAFile() throws Exception{
        //Questo test può essere eseguito soltanto se il database contiente già una procedura con id=1
        Procedure proc= new Procedure(1,null,null);
        Activity activity = new Activity(46,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                new ArrayList<>(),
                true,
                "lllllll",
                proc);
        p.createActivity(activity);
        activity = p.getActivity(46);
        assertNotNull(activity.getProcedure());  
        //assertNull(activity.getProcedure());
        try {
            Desktop.getDesktop().open(activity.getProcedure().getSmp());
        } catch (Exception ex) {}
        p.deleteActivity(46);
    }
    
    @Test
    public void testPosGetAllMaintainers(){
        //Questo test può essere eseguito soltanto se il database contiente già manutentori
        List<Maintainer> list = p.getAllMaintainers();
        assertNotNull(list);
        //Matrice delle disponibilità manutentore
//        int manutentore = 1;
//        int settimana = 22;
//        int matrice [][] = list.get(manutentore).getAvailability().get(settimana);
//        for (int i=0;i<=6;i++){
//            for (int j=0;j<=6;j++){
//                System.out.println("i="+i+" j="+j+" valore = "+ matrice[i][j]);
//            }
//        }
    }
    
    @Test
    public void testAssignedActivity() throws Exception{
        //Questo test può essere eseguito soltanto se il database contiente già un manutentore con disponibilità
        Maintainer m = p.getAllMaintainers().get(0);
        Activity a = new Activity(99,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                40,
                1,
                new ArrayList<>(),
                true,
                "lllllll",
                null);
        p.createActivity(a);
        int ore[] = new int[2];
        ore[0]=1;ore[1]=2;
        assertEquals(p.assignedActivityToMaintainer(m,a, 1,ore),true);
        p.deleteActivity(a.getId());
    }
}
