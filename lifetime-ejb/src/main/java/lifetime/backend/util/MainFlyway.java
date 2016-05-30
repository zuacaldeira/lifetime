/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.util;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;

/**
 *
 * @author zuacaldeira
 */
public class MainFlyway {

    private static final String USER = "zua";
    private static final String PASSWORD = "unicidade";
    private static final String URL = "jdbc:mysql://localhost:3306/lifetime?zeroDateTimeBehavior=convertToNull";
    private static final String MIGRATION_DIR = "src/main/resources/db/migration/";

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Run db migrations");
            migrate();  // Migrate
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void migrate() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(URL, USER, PASSWORD);
        //flyway.setLocations("filesystem:" + MIGRATION_DIR);
        flyway.migrate();
    }

}
