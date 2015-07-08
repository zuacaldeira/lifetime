/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.logic;

/**
 *
 * @author lifetime
 */
public enum GradeSystem {

    GERMAN("german", 5, 1), IMPERIAL("imperial", 'F', 'A'), 
    PORTUGUESE("portuguese", 0, 20), PERCENTAGE("%", 0, 100);

    private String system;
    private int min;
    private int max;

    private GradeSystem(String system, int min, int max) {
        this.system = system;
        this.min = min;
        this.max = max;
    }

}
