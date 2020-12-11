/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Rossella
 */
public class Maintainer {
    private String name;
    private List<String> competencies;
    private Map<Integer, int[][]> availability;

    public Maintainer(String name, List<String> competencies, Map<Integer, int[][]> availability) {
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

    public Map<Integer, int[][]> getAvailability() {
        return availability;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Maintainer other = (Maintainer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
        
}
