/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.io.File;
import java.util.List;

/**
 *
 * @author Altro
 */
public class EwoActivity extends UnPlannedActivity{
    private int day;

    public EwoActivity(int id, String factorySite, String area, String typology, String activityDescription, int estimatedTime, int week, List<String> materials,boolean interruptable, String workSpaceNote,int day,Procedure procedura) {
        super(id, factorySite, area, typology, activityDescription, estimatedTime, week, materials,interruptable, workSpaceNote, procedura);
        super.setType(1);
        this.day = day;
    }

    @Override
    public int getDay() {
        return day;
    }
    
    public void setSkills(List<String> skills){
        if (this.procedure == null)
            this.procedure = new Procedure(0,new File(""),skills);
        else 
            this.procedure.setCompetencies(skills);
    }
    
    
    
}
