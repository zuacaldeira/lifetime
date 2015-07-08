/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Comparator;
import lifetime.business.persistence.Achievement;

/**
 *
 * @author azc
 */
public class DescendantComparator implements Comparator<Achievement> {

    public DescendantComparator() {
    }

    @Override
    public int compare(Achievement o1, Achievement o2) {
        return aux(o1, o2);
    }
    
    public int aux(Achievement o1, Achievement o2) {
        if ((o1.getStart() == null)
                && (o1.getEnd() == null)
                && (o2.getStart() == null)
                && (o2.getEnd() == null)) {
            return 0;
        } else if ((o1.getStart() != null)
                && (o1.getEnd() == null)
                && (o2.getStart() == null)
                && (o2.getEnd() == null)) {
            return 1;
        } else if ((o1.getStart() == null)
                && (o1.getEnd() != null)
                && (o2.getStart() == null)
                && (o2.getEnd() == null)) {
            return 1;
        } else if ((o1.getStart() == null)
                && (o1.getEnd() == null)
                && (o2.getStart() != null)
                && (o2.getEnd() == null)) {
            return -1;
        } else if ((o1.getStart() == null)
                && (o1.getEnd() == null)
                && (o2.getStart() == null)
                && (o2.getEnd() != null)) {
            return -1;
        } else if ((o1.getStart() != null)
                && (o1.getEnd() != null)
                && (o2.getStart() == null)
                && (o2.getEnd() == null)) {
            return 1;
        } else if ((o1.getStart() != null)
                && (o1.getEnd() == null)
                && (o2.getStart() != null)
                && (o2.getEnd() == null)) {
            return - o1.getStart().compareTo(o2.getStart());
        } else if ((o1.getStart() != null)
                && (o1.getEnd() == null)
                && (o2.getStart() == null)
                && (o2.getEnd() != null)) {
            return - o1.getStart().compareTo(o2.getEnd());
        } else if ((o1.getStart() == null)
                && (o1.getEnd() != null)
                && (o2.getStart() != null)
                && (o2.getEnd() == null)) {
            return - o1.getEnd().compareTo(o2.getStart());
        } else if ((o1.getStart() == null)
                && (o1.getEnd() != null)
                && (o2.getStart() == null)
                && (o2.getEnd() != null)) {
            return - o1.getEnd().compareTo(o2.getEnd());
        } else if ((o1.getStart() == null)
                && (o1.getEnd() == null)
                && (o2.getStart() != null)
                && (o2.getEnd() != null)) {
            return -1;
        } else if ((o1.getStart() != null)
                && (o1.getEnd() != null)
                && (o2.getStart() != null)
                && (o2.getEnd() == null)) {
            return - o1.getStart().compareTo(o2.getStart());
        } else if ((o1.getStart() != null)
                && (o1.getEnd() != null)
                && (o2.getStart() == null)
                && (o2.getEnd() != null)) {
            return - o1.getEnd().compareTo(o2.getEnd());
        } else if ((o1.getStart() != null)
                && (o1.getEnd() == null)
                && (o2.getStart() != null)
                && (o2.getEnd() != null)) {
            return - o1.getStart().compareTo(o2.getStart());
        } else if ((o1.getStart() == null)
                && (o1.getEnd() != null)
                && (o2.getStart() != null)
                && (o2.getEnd() != null)) {
            return - o1.getEnd().compareTo(o2.getStart());
        } else {
            return - o1.getEnd().compareTo(o2.getEnd());                    
        }
    }
}
