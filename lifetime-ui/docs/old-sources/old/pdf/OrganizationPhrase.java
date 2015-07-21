/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import lifetime.business.persistence.Organization;

/**
 *
 * @author azc
 */
public class OrganizationPhrase extends ValuePhrase {

    public OrganizationPhrase(String string) {
        super(string, LifetimeFonts.FONT_ORG);
    }
    
    public OrganizationPhrase(Organization org) {
        super(org.getFullname(), LifetimeFonts.FONT_ORG);
    }
    
}
