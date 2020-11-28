/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rossella
 */
public class Maintainer {
    private String name;
    private List<String> competencies;
    private Map<Integer, Integer[][]> availability;

    public Maintainer(String name, List<String> competencies, Map<Integer, Integer[][]> availability) {
        this.name = name;
        this.competencies = competencies;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public List<String> getCompetencies() {
        return competencies;
    }

    public Map<Integer, Integer[][]> getAvailability() {
        return availability;
    }
    
        
}
