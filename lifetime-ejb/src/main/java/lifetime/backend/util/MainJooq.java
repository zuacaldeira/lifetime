/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.util;

import java.io.File;
import javax.xml.bind.JAXB;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.util.jdbc.DriverDataSource;
import org.jooq.util.jaxb.Configuration;
import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.Jdbc;

/**
 *
 * @author zuacaldeira
 */
public class MainJooq {

    private static final String USER = "zua";
    private static final String PASSWORD = "unicidade";
    private static final String URL = "jdbc:mysql://localhost:3306/lifetime?zeroDateTimeBehavior=convertToNull";
    private static final String GENERATOR_DIR = "src/main/setup/";

    public static void generate() throws Exception {
        Configuration configuration = JAXB.unmarshal(new File(GENERATOR_DIR + "lifetime.xml"), Configuration.class);
        Jdbc jdbc = configuration.getJdbc()
                .withUser(USER)
                .withPassword(PASSWORD)
                .withUrl(URL);

        GenerationTool.generate(configuration);
        //GenerationTool.generate(configuration);
    }
}
