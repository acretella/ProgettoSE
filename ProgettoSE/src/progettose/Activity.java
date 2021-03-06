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
public abstract class Activity {
    private int id;
    private Site site;
    private String typology;
    private String activityDescription;
    private int estimatedTime;
    private int week;
    private List<String> materials;
    private boolean interruptable;
    private String workSpaceNote;
    Procedure procedure;
    private int type;


    public Activity(int id, String factorySite, String area, String typology, String activityDescription, int estimatedTime, 
            int week, List<String> materials,boolean interruptable, String workSpaceNote, Procedure procedure) {
        this.id = id;
        this.site = new Site(factorySite,area);
        this.typology = typology;
        this.activityDescription = activityDescription;
        this.estimatedTime = estimatedTime;
        this.week = week;
        this.materials = materials;
        this.interruptable = interruptable;
        this.workSpaceNote = workSpaceNote;
        this.procedure = procedure;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getId() {
        return id;
    }

    public Site getSite() {
        return site;
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

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public String getWorkSpaceNote() {
        return workSpaceNote;
    }

    public int getType() {
        return type;
    }

    public boolean isInterruptable() {
        return interruptable;
    }   

    public void setType(int trype) {
        this.type = trype;
    }

    public Procedure getProcedure() {
        return procedure;
    }
    
    public abstract int getDay();

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    
}
