/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.util;

import org.flywaydb.core.Flyway;

/**
 *
 * @author zuacaldeira
 */
public class MainFlyway {

    private static final String USER = "zua";
    private static final String PASSWORD = "unicidade";
    private static final String URL = "jdbc:mysql://localhost:3306/lifetime?zeroDateTimeBehavior=convertToNull";

    /**
     * Execute lifetime migrations. The migration {@literal sql} files are
     * placed under default location.
     */
    public static void migrate() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(URL, USER, PASSWORD);
        //flyway.baseline();
        flyway.migrate();
    }

}
