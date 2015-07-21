package lifetime.util;

/*
 * Copyright 2015 zua.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.io.File;
import javax.ejb.EJB;
import lifetime.service.LifetimeAccountBusiness;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

/**
 *
 * @author zua
 */
@Test
//@RunAsClient
public class ServiceLocatorNGTestIT extends Arquillian {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @EJB(name = "java:app/lifetime-ui/LifetimeAccountService!lifetime.service.LifetimeAccountBusiness")
    //@EJB(beanName = "LifetimeAccountService")
    private LifetimeAccountBusiness accountBusiness;

    public ServiceLocatorNGTestIT() {
    }

    /**
     * Factory of deployments or scenarios for this test case.
     *
     * @return A web archive with the test application
     */
    @Deployment(testable = true)
    public static Archive createDeployment() {
        // pick up a deployment
        return Deployments.getDeploymentWelcomeView();
    }

    private static class Deployments {

        public static Archive getDeploymentWelcomeView() {
            WebArchive result = ShrinkWrap.create(WebArchive.class, "test.war")
                    //.addAsLibraries(files)
                    .addClass(LifetimeAccountBusiness.class)
                    .addAsResource(new File("src/main/resources/META-INF/persistence.xml"),
                            "META-INF/persistence.xml")
                    .addAsResource(EmptyAsset.INSTANCE,
                            ArchivePaths.create("beans.xml"));
            return result;
        }
    }

    /**
     * Test of findLifetimeAccountService method, of class ServiceLocator.
     */
    @Test
    public void testFindLifetimeAccountService() {
        LOGGER.info("Looking up LifetimeAccountBusiness()");
        assertNotNull(accountBusiness, "Lookup failed");
    }

}
