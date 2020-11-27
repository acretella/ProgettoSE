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
    private File smp;
    private List<String> competencies;

    public Procedure(File smp, List<String> competencies) {
        this.smp = smp;
        this.competencies = competencies;
    }

    public File getSmp() {
        return smp;
    }

    public List<String> getCompetencies() {
        return competencies;
    }
        
}
