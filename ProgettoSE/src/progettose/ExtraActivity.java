/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.util.List;

/**
 *
 * @author Altro
 */
public class ExtraActivity extends UnPlannedActivity{

    public ExtraActivity(int id, String factorySite, String area, String typology, String activityDescription, 
            int estimatedTime, int week, List<String> materials,boolean interruptable, String workSpaceNote, Procedure procedure) {
        super(id, factorySite, area, typology, activityDescription, estimatedTime, week, materials,interruptable, workSpaceNote, procedure);
        super.setType(2);

    }
    
}
