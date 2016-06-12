/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence.jooq;

import java.util.ArrayList;
import java.util.List;
import lifetime.backend.persistence.jooq.tables.Account;
import lifetime.backend.persistence.jooq.tables.Address;
import lifetime.backend.persistence.jooq.tables.Competition;
import lifetime.backend.persistence.jooq.tables.Course;
import lifetime.backend.persistence.jooq.tables.Lecture;
import lifetime.backend.persistence.jooq.tables.LifetimeEvent;
import lifetime.backend.persistence.jooq.tables.LifetimeOrg;
import lifetime.backend.persistence.jooq.tables.LifetimeUser;
import lifetime.backend.persistence.jooq.tables.Project;
import lifetime.backend.persistence.jooq.tables.SchemaVersion;
import lifetime.backend.persistence.jooq.tables.Sport;
import lifetime.backend.persistence.jooq.tables.Study;
import lifetime.backend.persistence.jooq.tables.Task;
import lifetime.backend.persistence.jooq.tables.Training;
import lifetime.backend.persistence.jooq.tables.Work;
import lifetime.TestHelper;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author zuacaldeira
 */
public class LifetimeNGTest {
    
    /**
     * Test of getCatalog method, of class Lifetime.
     */
    @Test
    public void testGetCatalog() {
        System.out.println("getCatalog");
        Lifetime instance = Lifetime.LIFETIME;
        assertNotNull(instance.getCatalog());
    }

    /**
     * Test of getTables method, of class Lifetime.
     */
    @Test
    public void testGetTables() {
        System.out.println("getTables");
        Lifetime instance = Lifetime.LIFETIME;
        List expResult = instance.getTables();
        assertTrue(expResult.contains(Account.ACCOUNT));
        assertTrue(expResult.contains(Address.ADDRESS));
        assertTrue(expResult.contains(LifetimeUser.LIFETIME_USER));
        assertTrue(expResult.contains(LifetimeOrg.LIFETIME_ORG));
        assertTrue(expResult.contains(LifetimeEvent.LIFETIME_EVENT));
        assertTrue(expResult.contains(Study.STUDY));
        assertTrue(expResult.contains(Course.COURSE));
        assertTrue(expResult.contains(Lecture.LECTURE));
        assertTrue(expResult.contains(Work.WORK));
        assertTrue(expResult.contains(Project.PROJECT));
        assertTrue(expResult.contains(Task.TASK));
        assertTrue(expResult.contains(Sport.SPORT));
        assertTrue(expResult.contains(Training.TRAINING));
        assertTrue(expResult.contains(Competition.COMPETITION));
        if (expResult.contains(SchemaVersion.SCHEMA_VERSION)) {
            assertEquals(expResult.size(), TestHelper.NUMBER_OF_TABLES);
        } else {
            assertEquals(expResult.size()-1, TestHelper.NUMBER_OF_TABLES);
        }
    }

    private List getTablesData() {
        List tables = new ArrayList<>();

        return tables;
    }

}
