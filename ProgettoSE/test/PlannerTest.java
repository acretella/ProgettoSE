/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import progettose.Activity;
import progettose.PlannedActivity;
import progettose.Planner;

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
        
        Activity activity = new Activity(0,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll");
        
        assertTrue(p.createActivity(activity) == true);
        p.deleteActivity(activity.getId());
    }
    
   @Test
    public void testNegCreateActivity(){
        List <String> l = new ArrayList<>();
        
        Activity activity = new Activity(1,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll");
        
        p.createActivity(activity);
        
        Activity activity2 = new Activity(1,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll");
        
        
        
        assertTrue(p.createActivity(activity2) == false);
    }

    @Test
    public void testPosDeleteActivity(){
        List <String> l = new ArrayList<>();
           
        Activity activity = new Activity(55,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll");
        
        p.createActivity(activity);
                
        assertTrue(p.deleteActivity(55)== true);
    }
    
    public void testGetAllActivities(){
        Activity a = new PlannedActivity(18,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                new ArrayList<>(),
                true,
                "lllllll");
        p.createActivity(a);
        
        List<Activity> list = p.getAllActivities();
        assertTrue(! list.isEmpty());
        String str = "";
        for (Activity act : list)
            str += act.getId() + " ";
        System.out.println(str);
    }
     
    @Test 
    public void testNegDeleteActivity(){

        assertTrue(p.deleteActivity(200)== false);
    }
    
    @Test
    public void testPosGetActivity(){
        Activity a = new PlannedActivity(12,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                new ArrayList<>(),
                true,
                "lllllll");
        p.createActivity(a);
        assertEquals(p.getActivity(a.getId()).getId() , a.getId());
        p.deleteActivity(a.getId());
    }
    
    @Test
    public void testNegGetActivity(){
        assertEquals(p.getActivity(300), null);
    }
    
    @Test
    public void testPosModifyActivity(){
        List <String> l = new ArrayList<>();
        
        Activity a = new Activity(2,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll");
        
        p.createActivity(a);
        a.setType(2);
        assertTrue(p.modifyActivity(a) == true);
        p.deleteActivity(a.getId());
    }
    
    @Test
    public void TestNegModifyActivity(){
        //modifico attività non presente nel DB
        List <String> l = new ArrayList<>();
        
        Activity activity = new Activity(5,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                true,
                "lllllll");
        assertTrue(p.modifyActivity(activity) == false);
    }
}
