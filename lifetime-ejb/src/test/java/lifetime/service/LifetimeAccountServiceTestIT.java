/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.io.File;
import java.util.Date;
import javax.ejb.EJB;
import lifetime.persistence.Account;
import org.jboss.arquillian.container.test.api.Deployment;
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
public class LifetimeAccountServiceTestIT extends Arquillian {

    private static final String TEST_APP_NAME = "test.war";

    @EJB(name = "java:global/lifetime-ui/LifetimeAccountService!lifetime.service.LifetimeAccountBusiness", beanInterface = LifetimeAccountBusiness.class)
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
    @Test(dataProvider = "registerData", priority = 1)
    public void testRegister(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        logger.info(":::testResgister:::" + firstName + ":" + lastName + ":" + email);
        Assert.assertNotNull(accountService, "Service not initialized");
        if (!accountService.hasAccount(email)) {
            Assert.assertTrue(accountService.register(firstName, lastName, email, password, language, birthDate, birthPlace));
        }
        logger.info("::::::done");
    }

    @Test(dataProvider = "registerData", priority = 1)
    public void testDelete(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        logger.info(":::testResgister:::" + firstName + ":" + lastName + ":" + email);
        Assert.assertNotNull(accountService, "Service not initialized");
        if (accountService.hasAccount(email)) {
            Assert.assertTrue(accountService.deleteAccount(email));
        }
        logger.info("::::::done");
    }

    @Test(dataProvider = "registerNegativeData")
    public void testBadRegistration(String firstName, String lastName, String email, String password, Date birthDate, String language, String birthPlace) {
        logger.info(":::testBadregistration:::" + firstName + ":" + lastName + ":" + email);
        Assert.assertNotNull(accountService, "Service not initialized");
        Assert.assertFalse(accountService.register(firstName, lastName, email, password, language, birthDate, birthPlace));
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
                    .addClass(LifetimeAccountBusiness.class)
                    .addClass(Account.class)
                    .addAsResource(new File("src/main/resources/META-INF/persistence.xml"),
                            "META-INF/persistence.xml")
                    .addAsResource(EmptyAsset.INSTANCE,
                            ArchivePaths.create("beans.xml"));
            return result;
        }
    }

}
