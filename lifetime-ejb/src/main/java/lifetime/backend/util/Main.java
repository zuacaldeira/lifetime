/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.bind.JAXB;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.util.jaxb.Configuration;
import org.jooq.util.GenerationTool;

/**
 *
 * @author zuacaldeira
 */
public class Main {

    private static final String USER = "zua";
    private static final String PASSWORD = "unicidade";
    private static final String URL = "jdbc:mysql://localhost:3306/lifetime?zeroDateTimeBehavior=convertToNull";

    public static void main(String[] args) throws Exception {
        generateClasses();
        //testConnection();
        // Example queryVsResultQuery
        //queryVsResultQuery();
    }

    private static void queryVsResultQuery() {
        System.out.println("Query vs ResultQuery");
        System.out.println("\tDone!");
    }

    private static void generateClasses() {
        System.out.println("Generating classes...");
        try {
            Configuration configuration = JAXB.unmarshal(new File("src/main/java/lifetime/backend/persistence/migration/lifetime.xml"), Configuration.class);
            configuration.getJdbc()
                    .withUser(USER)
                    .withPassword(PASSWORD);

            GenerationTool.generate(configuration);
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("\tClasses generated!");
    }

    private static void testConnection() throws SQLException {
        System.out.println("Testing connection");

        // Create a JDBC connection using the DriveManager, given 
        // 1) the database location; 
        // 2) a database user; 
        // 3) the corresponding password
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            DSLContext context = DSL.using(conn, SQLDialect.MYSQL);
            /*Result<Record> result = context.select().from(AUTHOR).fetch();
            for (Record record: result) {
                Integer id = record.getValue(AUTHOR.ID);
                String firstName = record.getValue(AUTHOR.FIRST_NAME);
                String lastName = record.getValue(AUTHOR.LAST_NAME);   
                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\tConnection tested!");
    }
}
