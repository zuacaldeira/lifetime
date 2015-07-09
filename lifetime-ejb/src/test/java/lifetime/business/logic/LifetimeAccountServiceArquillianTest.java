/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.logic;

import java.io.File;
import java.util.Date;
import javax.ejb.EJB;
import javax.naming.NamingException;
import lifetime.business.persistence.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author zua
 */
@RunWith(Arquillian.class)
public class LifetimeAccountServiceArquillianTest {

    @EJB(name = "java:global/test/LifetimeAccountService!lifetime.business.logic.LifetimeAccountService")
    private LifetimeAccountService accountService;

    @Deployment
    public static Archive createDeployment() {
        // get all maven dependecies
        System.err.print("+++++++++++++++ " + Package.getPackage("org.jboss.arquillian.junit"));
        JavaArchive result = ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(LifetimeAccountService.class)
                .addPackage(User.class.getPackage().getName())
                .addPackage("org.jboss.arquillian.junit")
                .addClass("org.jboss.arquillian.container.test.api.Deployment")
                .addClass("org.jboss.arquillian.junit.Arquillian")
                .addClass("org.jboss.shrinkwrap.api.Archive")
                .addClass("org.jboss.shrinkwrap.api.ArchivePaths")
                .addClass("org.jboss.shrinkwrap.api.ShrinkWrap")
                .addClass("org.jboss.shrinkwrap.api.spec.JavaArchive")
                .addClass("org.jboss.shrinkwrap.api.asset.EmptyAsset")
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
        assertNotNull("Service not initialized", accountService);
        accountService.register(firstname, lastname, email, password, language, birthdate);

    }

}
