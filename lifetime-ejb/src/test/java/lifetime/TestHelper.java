/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime;

import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
public class TestHelper {

    /**
     * Configuration file property name.
     */
    public static final String CONFIGURATION_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";

    /**
     * Configuration file property value.
     */
    public static final String CONFIGURATION_FILE = "/Applications/NetBeans/glassfish-4.1/glassfish/domains/domain1/config/domain.xml";

    private final static int NUMBER_OF_USER_TABLES = 18; 
    public static final int NUMBER_OF_TABLES = NUMBER_OF_USER_TABLES + 1;

    /**
     * Returns a random integer.
     *
     * @return A random integer value
     */
    public static Integer getRandomId() {
        return new Random().nextInt();
    }

    /**
     * Returns a new random byte array.
     *
     * @return A byte array.
     */
    public static byte[] getRandomByteArray() {
        byte[] result = new byte[1024];
        new Random().nextBytes(result);
        return result;
    }

    /**
     * Returns a random string.
     *
     * @return A random string.
     */
    public static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(20);
    }

}
