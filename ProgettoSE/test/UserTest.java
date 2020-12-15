/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose.Site;
import progettose.User;

/**
 *
 * @author Rossella
 */
public class UserTest {
    User user = null;
    
    @Before
    public void setUp() throws SQLException {
        user = new User("alessio","12345");
    }
    
    @Test
    public void testGetAllSkills(){
        //questo testo dà esito positivo solo se esistono delle skill nel DB
        List<String> competences = user.getAllSkills();
        assertTrue(!competences.isEmpty());
//        for(String s: competences)
//            System.out.println(s);
    }
    
    @Test
    public void testGetAllMaterials(){
        //questo test dà esito positivo solo se esistono dei materiali nel DB
        List<String> materials = user.getAllMaterials();
        assertTrue(!materials.isEmpty());
        for(String s: materials)
            System.out.println(s);
    }
    
    @Test
    public void testPosCreateMaterial(){
        String material = "cavi";
        assertTrue(user.createMaterial(material));
        user.deleteMaterial(material);
    }
    
    @Test
    public void testNegCreateMaterial(){
        String material ="materialtest1";
        user.createMaterial(material);
        assertFalse(user.createMaterial(material));//inserisco un material già presente
    }
    
    @Test
    public void testPosDeleteMaterial(){
        String material = "materialtest2";
        user.createMaterial(material);
        assertTrue(user.deleteMaterial(material));
    }
    
    @Test
    public void testNegDeleteMaterial(){
        String material = "materialtest3";//non presente nel DB
        assertFalse(user.deleteMaterial(material));
    }
    
    @Test
    public void testPosModifyMaterial(){
        String material = "material4";
        user.createMaterial(material);
        String newMaterial = "materialtest4";
        assertTrue(user.modifyMaterial(material, newMaterial));
        user.deleteMaterial(newMaterial);
    }
    
    @Test
    public void testNegModifyMaterial(){
        String material = "materialtest5";//materiale non presente nel DB
        assertFalse(user.modifyMaterial(material, material));
    }
    
    @Test
    public void testGetAllSites(){
        List<Site> sites = user.getAllSites();
        assertTrue(!sites.isEmpty());
        for(Site s: sites)
            System.out.println(s);
    }
    
}
