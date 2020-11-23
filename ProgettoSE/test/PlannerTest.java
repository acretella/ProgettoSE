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
import progettose.EwoActivity;
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
        
        Activity activity = new PlannedActivity(0,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
                "lllllll");
        
        assertTrue(p.createActivity(activity) == true);
    }
    
   @Test
    public void testNegCreateActivity(){
        List <String> l = new ArrayList<>();
        
        Activity activity = new EwoActivity(1,
                "branch office",
                "departement",
                "electrical",
                "aaaaaaaa",
                100,
                1,
                l,
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
                "lllllll");
        
        
        
        assertTrue(p.createActivity(activity2) == false);
    }

        
    

    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
