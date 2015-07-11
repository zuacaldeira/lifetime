/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.logic;

import lifetime.service.LifetimeAccountService;
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
import org.testng.annotations.Test;

/**
 *
 * @author zua
 */
@Test
public class LifetimeAccountServiceArquillianTest extends Arquillian {

    @EJB(name = "java:global/test/LifetimeAccountService!lifetime.business.logic.LifetimeAccountService")
    private LifetimeAccountService accountService;

    @Deployment
    public static Archive createDeployment() {
        // get all maven dependecies
        WebArchive result = ShrinkWrap.create(WebArchive.class, "test.war")
                //.addAsLibraries(files)
                .addPackage(LifetimeAccountService.class.getPackage().getName())
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
     * @throws javax.naming.NamingException If lookup fails while looking for a
     * {@link LifetimeAccountService}
     */
    @Test
    public void testRegister() throws NamingException {
        System.out.println("register");
        String firstname = "Alexandre2";
        String lastname = "Caldeira2";
        String email = "zuacaldeira@lifetime.com";
        String password = "unicidade";
        String language = "unicidade";
        Date birthdate = new Date();
        Assert.assertNotNull(accountService, "Service not initialized");
        accountService.register(firstname, lastname, email, password, language, birthdate);
        Assert.assertTrue(accountService.existsUser(email));
        accountService.delete(email);
    }

}
