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
import progettose.Site;
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
    public void testNegModifyCompetence(){
        String skill = "skilltest15";//skill non presente nel DB
        assertFalse(admin.modifyCompetence(skill, skill));
    }
    
    @Test
    public void testPosCreateSite(){
        assertTrue(admin.createSite(new Site("aaa","bbb")));
        admin.deleteSite(new Site("aaa","bbb")); //per poter rilanciare il test senza cancellare dal db
    }
    
    @Test
    public void testPos2CreateSite(){
        assertTrue(admin.createSite(new Site("ccc","ddd")));
        assertTrue(admin.createSite(new Site("ccc","fff"))); //Due Site con stesso factorySite
        admin.deleteSite(new Site("ccc","ddd")); //per poter rilanciare il test senza cancellare dal db
        admin.deleteSite(new Site("ccc","fff")); //per poter rilanciare il test senza cancellare dal db
    }

    @Test
    public void testPos3CreateSite(){
        assertTrue(admin.createSite(new Site("cca","ww")));
        assertTrue(admin.createSite(new Site("ccb","ww"))); //Due Site con stessa Area
        admin.deleteSite(new Site("cca","ww")); //per poter rilanciare il test senza cancellare dal db
        admin.deleteSite(new Site("ccb","ww")); //per poter rilanciare il test senza cancellare dal db
    }
    
    @Test
    public void testNegCreateSite(){
        assertTrue(admin.createSite(new Site("aa","bb")));
        assertFalse(admin.createSite(new Site("aa","bb")));
        admin.deleteSite(new Site("aa","bb")); //per poter rilanciare il test senza cancellare dal db
    }
  
    @Test
    public void testPosModifySite(){
        admin.createSite(new Site("aax","bbx"));
        assertTrue(admin.modifySite(new Site("aax","bbx"), new Site("vcd","pgb")));
        admin.deleteSite(new Site("vcd","pgb")); //per poter rilanciare il test senza cancellare dal db
    }

    @Test
    public void testNegModifySite(){
        assertFalse(admin.modifySite(new Site("44","55"), new Site("66","77")));
    }
    
        
}
