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
public class UnPlannedActivity extends Activity{

    public UnPlannedActivity(int id, String factorySite, String area, String typology, String activityDescription, int estimatedTime, int week, List<String> materials, String workSpaceNote) {
        super(id, factorySite, area, typology, activityDescription, estimatedTime, week, materials, workSpaceNote);
    }
    
}
