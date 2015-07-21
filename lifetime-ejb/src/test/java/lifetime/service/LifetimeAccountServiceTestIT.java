/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.Date;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

/**
 *
 * @author zua
 */
@Test
@RunAsClient
public class LifetimeAccountServiceTestIT extends Arquillian {

    private static final String TEST_APP_NAME = "test.war";

    @EJB(name = "java:global/lifetime-ui/LifetimeAccountService!lifetime.service.LifetimeAccountBusiness")
    private LifetimeAccountBusiness accountService;

    private final Logger logger = Logger.getLogger(LifetimeAccountServiceTestIT.class);

    @Deployment(testable = true)
    public static Archive createDeployment() {
        // pick up a deployment
        return Deployments.getDeploymentLifetimeAccountService();
    }

    /**
     * Test of register method, of class LifetimeAccountService.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param language
     * @param password
     * @param birthDate
     * @param birthPlace Candidate's birth place
     */
    @Test(dataProvider = "registerData")
    public void testRegister(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        logger.info("::Entering:: testResgister:" + firstName + ":" + lastName + ":" + email);
        Assert.assertNotNull(accountService, "Service not initialized");
        if (!accountService.existsAccount(email)) {
            Assert.assertTrue(accountService.register(firstName, lastName, email, password, language, birthDate, birthPlace));
        }
    }

    @Test(dataProvider = "registerData", dependsOnMethods = "testRegister")
    public void testDeleteAccount(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        logger.info("::Entering:: testResgister:" + email);
        Assert.assertNotNull(accountService, "Service not initialized");
        if (accountService.existsAccount(email)) {
            Assert.assertTrue(accountService.deleteAccount(email));
        }
    }

    @Test(dataProvider = "registerNegativeData")
    public void testBadRegistration(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        logger.info("::Entering:: testBadRegistration:" + email);
        Assert.assertNotNull(accountService, "Service not initialized");
        if(!accountService.existsAccount(email)) {
            Assert.assertFalse(accountService.register(firstName, lastName, email, password, language, birthDate, birthPlace));
        } else {
            Assert.assertTrue(false);
        }
    }

    @DataProvider(name = "registerData")
    public static Object[][] getData() {
        Object[][] dataArray = {
            {"Alexandre 1", "Zua Caldeira 1", "zuacaldeira1@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 2", "Zua Caldeira 2", "zuacaldeira2@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 3", "Zua Caldeira 3", "zuacaldeira3@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"}
        };
        return dataArray;
    }

    @DataProvider(name = "registerNegativeData")
    public static Object[][] getNegativeData() {
        Object[][] dataArray = {
            {null, "Zua Caldeira 1", "zuacaldeira1@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 2", null, "zuacaldeira2@gmail.com", "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 3", "Zua Caldeira 3", null, "unicidade", new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 3", "Zua Caldeira 3", "zuacaldeira4@gmail.com", null, new Date(), "pt", "Lisbon, Portugal"},
            {"Alexandre 3", "Zua Caldeira 3", "zuacaldeira5@gmail.com", "unicidade", null, "pt", "Lisbon, Portugal"},
            {"Alexandre 3", "Zua Caldeira 3", "zuacaldeira6@gmail.com", "unicidade", new Date(), null, "Lisbon, Portugal"},
            {"Alexandre 3", "Zua Caldeira 3", "zuacaldeira7@gmail.com", "unicidade", new Date(), "pt", null}
        };
        return dataArray;
    }

    private static class Deployments {

        public static Archive getDeploymentLifetimeAccountService() {
            WebArchive result = ShrinkWrap.create(WebArchive.class, TEST_APP_NAME)
                    //.addAsLibraries(files)
                    .addPackage(LifetimeAccountBusiness.class.getPackage())
                    /*.addPackage(LifetimeSecurityException.class.getPackage())
                    .addPackage(Users.class.getPackage())
                    .addPackage(SecurityRole.class.getPackage())
                    .addClass(org.slf4j.Logger.class)
                    .addAsResource(new File("src/main/resources/META-INF/persistence.xml"),
                            "META-INF/persistence.xml")*/
                    .addAsResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
            return result;
        }
    }

}
