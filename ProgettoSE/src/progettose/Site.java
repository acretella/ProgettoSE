/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

/**
 *
 * @author Rossella
 */
public class Site {
    private String factorySite;
    private String area;

    public Site(String factorySite, String area) {
        this.factorySite = factorySite;
        this.area = area;
    }

    public String getFactorySite() {
        return factorySite;
    }

    public String getArea() {
        return area;
    }

    @Override
    public String toString() {
        return factorySite + ", " + area ;
    }
        
}
