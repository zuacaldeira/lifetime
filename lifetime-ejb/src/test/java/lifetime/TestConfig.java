/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import lifetime.backend.util.TestHelper;
import org.testng.annotations.AfterSuite;

/**
 *
 * @author zua
 */
public class TestConfig {

    private static EJBContainer container;

    public static EJBContainer getContainer() {
        if (container == null) {
            System.out.println("Starting the container".toUpperCase());
            Map<String, Object> p = new HashMap<String, Object>();
            p.put(TestHelper.getEmbeddedGlassFishDomainPropertyName,
                    TestHelper.getEmbeddedGlassFishDomainPropertyValue
            );
            container = EJBContainer.createEJBContainer(p);
        }
        return container;
    }

    @AfterSuite
    public void tearDown() {
        if (container != null) {
            container.close();
            System.out.println("Stoping the container".toUpperCase());
        }
    }

}
