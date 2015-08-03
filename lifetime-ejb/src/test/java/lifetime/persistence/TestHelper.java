/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author zua
 */
public class TestHelper {
    public static String getEmbeddedGlassFishDomainPropertyName = "org.glassfish.ejb.embedded.glassfish.configuration.file";
    public static String getEmbeddedGlassFishDomainPropertyValue = "/Applications/NetBeans/glassfish-4.1/glassfish/domains/domain1/config/domain.xml";

    public static Integer getRandomId() {
        Integer result = new Random().nextInt();
        return result;
    }

    public static byte[] getRandomByteArray() {
        byte[] result = new byte[1024];
        new Random().nextBytes(result);
        return result;
    }

    public static String getRandomString() {
        String result = RandomStringUtils.randomAlphanumeric(20);
        return result;
    }

}
