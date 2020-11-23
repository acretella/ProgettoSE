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
public class Activity {
    private int id;
    private String factorySite;
    private String area;
    private String typology;
    private String activityDescription;
    private int estimatedTime;
    private int week;
    private List<String> materials;
    private String workSpaceNote;


    public Activity(int id, String factorySite, String area, String typology, String activityDescription, int estimatedTime, int week, List<String> materials, String workSpaceNote) {
        this.id = id;
        this.factorySite = factorySite;
        this.area = area;
        this.typology = typology;
        this.activityDescription = activityDescription;
        this.estimatedTime = estimatedTime;
        this.week = week;
        this.materials = materials;
        this.workSpaceNote = workSpaceNote;
    }

    public int getId() {
        return id;
    }

    public String getFactorySite() {
        return factorySite;
    }

    public String getArea() {
        return area;
    }

    public String getTypology() {
        return typology;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public int getWeek() {
        return week;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public String getWorkSpaceNote() {
        return workSpaceNote;
    }
    
    
}
