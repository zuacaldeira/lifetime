/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.util;

import lifetime.TestHelper;
import lifetime.backend.persistence.jooq.Lifetime;
import lifetime.backend.persistence.jooq.tables.Account;
import lifetime.backend.persistence.jooq.tables.Address;
import lifetime.backend.persistence.jooq.tables.Competition;
import lifetime.backend.persistence.jooq.tables.Course;
import lifetime.backend.persistence.jooq.tables.KnowHowUnit;
import lifetime.backend.persistence.jooq.tables.KnowledgeUnit;
import lifetime.backend.persistence.jooq.tables.Lecture;
import lifetime.backend.persistence.jooq.tables.LifetimeEvent;
import lifetime.backend.persistence.jooq.tables.LifetimeOrg;
import lifetime.backend.persistence.jooq.tables.LifetimeUser;
import lifetime.backend.persistence.jooq.tables.Photo;
import lifetime.backend.persistence.jooq.tables.Project;
import lifetime.backend.persistence.jooq.tables.SchemaVersion;
import lifetime.backend.persistence.jooq.tables.Sport;
import lifetime.backend.persistence.jooq.tables.Study;
import lifetime.backend.persistence.jooq.tables.Task;
import lifetime.backend.persistence.jooq.tables.Training;
import lifetime.backend.persistence.jooq.tables.Work;
import lifetime.backend.persistence.jooq.tables.WorkUnit;
import org.testng.Assert;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author zuacaldeira
 */
public class MainJooqNGTest {

    private static Object[][] tablesClasses;

    static {
        tablesClasses = new Object[TestHelper.NUMBER_OF_TABLES][1];
        tablesClasses[0][0] = LifetimeUser.class;
        tablesClasses[1][0] = LifetimeOrg.class;
        tablesClasses[2][0] = Account.class;
        tablesClasses[3][0] = Address.class;
        tablesClasses[4][0] = Photo.class;
        tablesClasses[5][0] = LifetimeEvent.class;
        tablesClasses[6][0] = Study.class;
        tablesClasses[7][0] = Course.class;
        tablesClasses[8][0] = Lecture.class;
        tablesClasses[9][0] = KnowledgeUnit.class;
        tablesClasses[10][0] = Work.class;
        tablesClasses[11][0] = Project.class;
        tablesClasses[12][0] = Task.class;
        tablesClasses[13][0] = WorkUnit.class;
        tablesClasses[14][0] = KnowHowUnit.class;
        tablesClasses[15][0] = Sport.class;
        tablesClasses[16][0] = Training.class;
        tablesClasses[17][0] = Competition.class;
        tablesClasses[18][0] = SchemaVersion.class;
    }

    public MainJooqNGTest() {
    }

    /**
     * Test of generate method, of class MainJooq.
     */
    @Test
    public void testGenerate() throws Exception {
        System.out.println("generate");
        MainJooq.generate();
    }

    /**
     * Test for the existence of expected classes.
     *
     * @param aClass
     */
    @Test(dataProvider = "existenceProvider")
    public void testExistenceOf(Class tableClass) {
        assertNotNull(tableClass);
    }

    @DataProvider(name = "existenceProvider")
    public Object[][] getExistenceData() {
        return tablesClasses;
    }

    /**
     * Test for the existence of expected classes.
     */
    @Test
    public void testNumberOfTables() {
        Assert.assertEquals(tablesClasses.length, Lifetime.LIFETIME.getTables().size());
        Assert.assertEquals(tablesClasses.length, TestHelper.NUMBER_OF_TABLES);
    }
}
