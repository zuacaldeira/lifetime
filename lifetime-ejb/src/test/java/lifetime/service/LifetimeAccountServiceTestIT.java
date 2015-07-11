/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.io.File;
import java.util.Date;
import javax.ejb.EJB;
import javax.naming.NamingException;
import lifetime.persistence.UserAccount;
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

/**
 *
 * @author zua
 */
@Test
public class LifetimeAccountServiceTestIT extends Arquillian {

    @EJB(name = "java:global/test/LifetimeAccountService!lifetime.service.LifetimeAccountBusiness")
    private LifetimeAccountBusiness accountService;

    @Deployment
    public static Archive createDeployment() {
        // get all maven dependecies
        WebArchive result = ShrinkWrap.create(WebArchive.class, "test.war")
                //.addAsLibraries(files)
                .addPackage(LifetimeAccountBusiness.class.getPackage().getName())
                .addPackage(UserAccount.class.getPackage().getName())
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"),
                        "META-INF/persistence.xml")
                .addAsResource(EmptyAsset.INSTANCE,
                        ArchivePaths.create("beans.xml"));
        return result;
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
     *
     * @throws javax.naming.NamingException If lookup fails while looking for a
     * {@link LifetimeAccountService}
     */
    @Test(dataProvider = "registerData")
    public void testRegister(String firstName, String lastName, String email, String password, Date birthDate, String language) throws NamingException, LifetimeSecurityException {
        System.out.println("IT_IT_IT_IT_IT_IT_IT_IT_IT_IT_IT_IT_IT register");
        Assert.assertNotNull(accountService, "Service not initialized");
        
        if (!accountService.existsUser(email)) {
            accountService.register(firstName, lastName, email, password, language, birthDate);
            Assert.assertTrue(accountService.existsUser(email));
        }
        if (accountService.existsUser(email)) {
            accountService.delete(email);
            Assert.assertFalse(accountService.existsUser(email));
        }
    }

    @DataProvider(name = "registerData")
    public static Object[][] getData() {
        Object[][] dataArray = {
            {"Alexandre 1", "Zua Caldeira 1", "zuacaldeira1@gmail.com", "unicidade", new Date(), "pt"},
            {"Alexandre 2", "Zua Caldeira 2", "zuacaldeira2@gmail.com", "unicidade", new Date(), "pt"},
            {"Alexandre 3", "Zua Caldeira 3", "zuacaldeira3@gmail.com", "unicidade", new Date(), "pt"}
        };
        return dataArray;
    }
}
