/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose.Admin;
/**
 *
 * @author Rossella
 */
public class AdminTest {    
    Admin admin = null;
    
    @Before
    public void setUp() throws SQLException {
        admin = new Admin("alessio","12345");
    }
    
    @Test
    public void testPosCreateCompetence(){
        String skill = "skilltest5";
        assertTrue(admin.createCompetence(skill));
        admin.deleteCompetence(skill);
    }
    
    @Test 
    public void testNegCreateCompetence(){
        String skill = "skilltest1";//skill già presente nel DB
        assertFalse(admin.createCompetence(skill));
    }
    @Test
    public void testPosDeleteCompetence(){
        String skill= "skilltest6";
        admin.createCompetence(skill);
        assertTrue(admin.deleteCompetence(skill));
    }
    
    @Test
    public void testNegDeleteCompetence(){
        String skill= "skilltest14"; //skill non presente nel DB
        assertFalse(admin.deleteCompetence(skill));
    }
    
    @Test
    public void testPosModifyCompetence(){
        String oldSkill = "skill7";
        String newSkill = "skilltest7";
        admin.createCompetence(oldSkill);
        assertTrue(admin.modifyCompetence(oldSkill, newSkill));
        admin.deleteCompetence(newSkill);
    }
    
    @Test
    public void testNegModify(){
        String skill = "skilltest15";//skill non presente nel DB
        assertFalse(admin.modifyCompetence(skill, skill));
    }
    
    @Test
    public void testPosDelete(){
        Site s = new Site("")
    }
        
}
