/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import lifetime.backend.service.RegistrationService;
import org.glassfish.hk2.api.ServiceLocator;
import org.testng.annotations.AfterSuite;

/**
 *
 * @author zua
 */
public class TestConfig {

    private static EJBContainer container;

    private static EJBContainer getContainer() {
        if (container == null) {
            System.out.println("Starting the container".toUpperCase());
            Map<String, Object> p = new HashMap<String, Object>();
            p.put(TestHelper.CONFIGURATION_FILE_PROPERTY,
                    TestHelper.CONFIGURATION_FILE
            );
            container = EJBContainer.createEJBContainer(p);
        }
        return container;
    }

    public static Object lookupService(String name) {
        try {
            Context context = getContainer().getContext();
            return (RegistrationService) context.lookup(name);
        } catch (Exception ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, "Lookup failed for {0}", name);
            throw new RuntimeException(ex);
        }

    }

    @AfterSuite
    public void tearDown() {
        if (container != null) {
            container.close();
            System.out.println("Stoping the container".toUpperCase());
        }
    }

}
