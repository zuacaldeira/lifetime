/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.label;

import lifetime.business.persistence.Organization;

/**
 *
 * @author lifetime
 */
public class OrganizationLabel extends LifetimeLabel {

    public OrganizationLabel(Organization organization, String language) {
        super(organization.getFullname(), language);
        setStyleName("organization");
    }
    
}
