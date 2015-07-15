/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.lang.reflect.Method;
import java.util.Date;
import javax.ejb.EJB;
import javax.naming.NamingException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
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
    
    

    @Deployment(testable = false)
    public static Archive createDeployment() {
        // pick up a deployment
        return Deployments.getDeploymentLifetimeAccountService();
    }
    private String currentEmail;

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
        currentEmail = email;
        accountService.register(firstName, lastName, email, password, language, birthDate);
        accountService.delete(currentEmail);
        System.out.println("register IT_IT_IT_IT_IT_IT_IT_IT_IT_IT_IT_IT_IT ");
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

    @Override
    public void arquillianAfterTest(Method testMethod) throws Exception {
        super.arquillianAfterTest(testMethod);
    }

}
