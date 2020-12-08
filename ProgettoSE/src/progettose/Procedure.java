/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.io.*;
import java.util.*;
/**
 *
 * @author Rossella
 */
public class Procedure {
    private int id;
    private File smp;
    private List<String> competencies;

    public Procedure(int id, File smp, List<String> competencies) {
        this.id = id;
        this.smp = smp;
        this.competencies = competencies;
    }

    public int getId() {
        return id;
    }

    public File getSmp() {
        return smp;
    }

    public List<String> getCompetencies() {
        return competencies;
    }
    
    
}
