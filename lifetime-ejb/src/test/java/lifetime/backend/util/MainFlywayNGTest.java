/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.util;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.flywaydb.core.Flyway;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zuacaldeira
 */
public class MainFlywayNGTest {

    private final int NUMBER_OF_USER_TABLES = 18; 
    private final int NUMBER_OF_TABLES = NUMBER_OF_USER_TABLES + 1;

    public MainFlywayNGTest() {
    }

    /**
     * Test of migrate method, of class MainFlyway. Exceptions cause make the
     * test to fail.
     */
    @Test
    public void testMigrate() {
        System.out.println("migrate");
        MainFlyway.migrate();
    }

    /* EXISTENCE TESTS */
    @Test(dataProvider = "existenceProvider")
    public void testTableExistence(String tablename) throws SQLException {
        // Get an instance of the flyway migration tool
        Flyway flyway = MainFlyway.getFlywayInstance();
        Assert.assertNotNull(flyway, "Main retrun Null Flyway instance.");
        // Get the database metadata from the stored connection
        DatabaseMetaData metadata = flyway.getDataSource().getConnection().getMetaData();
        // Get information about a table named table name
        ResultSet resultSet = metadata.getTables("lifetime", "lifetime", tablename, null);        
        // Assert there is a next result, meaning the search is no null
        Assert.assertTrue(resultSet.next(), "Couldn't find table " + tablename);
        // Assert about the number of expected tables in the database
        
    }

    @DataProvider(name = "existenceProvider")
    private Object[][] getExistenceData() {
        Object[][] result = new Object[NUMBER_OF_TABLES][1];
        int i = 0;
        result[0][0] = "lifetime_user";
        result[1][0] = "lifetime_org";
        result[2][0] = "account";
        result[3][0] = "address";
        result[4][0] = "photo";
        result[5][0] = "lifetime_event";
        result[6][0] = "study";
        result[7][0] = "course";
        result[8][0] = "lecture";
        result[9][0] = "knowledge_unit";
        result[10][0] = "work";
        result[11][0] = "project";
        result[12][0] = "task";
        result[13][0] = "work_unit";
        result[14][0] = "know_how_unit";
        result[15][0] = "sport";
        result[16][0] = "training";
        result[17][0] = "competition";
        result[18][0] = "schema_version";
        return result;
    }

    /* EXISTENCE TESTS */
    @Test
    public void testNumberOfTables() throws SQLException {
        // Get an instance of the flyway migration tool
        Flyway flyway = MainFlyway.getFlywayInstance();
        Assert.assertNotNull(flyway, "Main retrun Null Flyway instance.");
        // Get the database metadata from the stored connection
        DatabaseMetaData metadata = flyway.getDataSource().getConnection().getMetaData();
        // Get information about a table named table name
        ResultSet resultSet = metadata.getTables("lifetime", "lifetime", "%", null);        
        // Assert there is a next result, meaning the search is no null
        int i = 0;
        while(resultSet.next()) {
                System.out.println(resultSet.getString(3));
                i++;
        } 
        //resultSet.close();
        Assert.assertEquals(i, NUMBER_OF_TABLES);
        // Assert about the number of expected tables in the database
        
    }
}
