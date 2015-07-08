/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import java.util.Date;
import lifetime.business.util.LifetimeAchievement;

/**
 *
 * @author azc
 */
public class SocialEngagement implements LifetimeAchievement {

    private String title;
    private String organization;
    private String description;
    private Date start;
    private Date end;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public SocialEngagement(String title, String organization, String description, Date start, Date end) {
        this.title = title;
        this.organization = organization;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
