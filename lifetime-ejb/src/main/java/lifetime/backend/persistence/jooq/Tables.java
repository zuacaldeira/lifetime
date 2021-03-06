/**
 * This class is generated by jOOQ
 */
package lifetime.backend.persistence.jooq;


import javax.annotation.Generated;

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


/**
 * Convenience access to all tables in lifetime
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>lifetime.account</code>.
     */
    public static final Account ACCOUNT = lifetime.backend.persistence.jooq.tables.Account.ACCOUNT;

    /**
     * The table <code>lifetime.address</code>.
     */
    public static final Address ADDRESS = lifetime.backend.persistence.jooq.tables.Address.ADDRESS;

    /**
     * The table <code>lifetime.competition</code>.
     */
    public static final Competition COMPETITION = lifetime.backend.persistence.jooq.tables.Competition.COMPETITION;

    /**
     * The table <code>lifetime.course</code>.
     */
    public static final Course COURSE = lifetime.backend.persistence.jooq.tables.Course.COURSE;

    /**
     * The table <code>lifetime.lecture</code>.
     */
    public static final Lecture LECTURE = lifetime.backend.persistence.jooq.tables.Lecture.LECTURE;

    /**
     * The table <code>lifetime.lifetime_event</code>.
     */
    public static final LifetimeEvent LIFETIME_EVENT = lifetime.backend.persistence.jooq.tables.LifetimeEvent.LIFETIME_EVENT;

    /**
     * The table <code>lifetime.lifetime_org</code>.
     */
    public static final LifetimeOrg LIFETIME_ORG = lifetime.backend.persistence.jooq.tables.LifetimeOrg.LIFETIME_ORG;

    /**
     * The table <code>lifetime.lifetime_user</code>.
     */
    public static final LifetimeUser LIFETIME_USER = lifetime.backend.persistence.jooq.tables.LifetimeUser.LIFETIME_USER;

    /**
     * The table <code>lifetime.project</code>.
     */
    public static final Project PROJECT = lifetime.backend.persistence.jooq.tables.Project.PROJECT;

    /**
     * The table <code>lifetime.schema_version</code>.
     */
    public static final SchemaVersion SCHEMA_VERSION = lifetime.backend.persistence.jooq.tables.SchemaVersion.SCHEMA_VERSION;

    /**
     * The table <code>lifetime.sport</code>.
     */
    public static final Sport SPORT = lifetime.backend.persistence.jooq.tables.Sport.SPORT;

    /**
     * The table <code>lifetime.study</code>.
     */
    public static final Study STUDY = lifetime.backend.persistence.jooq.tables.Study.STUDY;

    /**
     * The table <code>lifetime.task</code>.
     */
    public static final Task TASK = lifetime.backend.persistence.jooq.tables.Task.TASK;

    /**
     * The table <code>lifetime.training</code>.
     */
    public static final Training TRAINING = lifetime.backend.persistence.jooq.tables.Training.TRAINING;

    /**
     * The table <code>lifetime.work</code>.
     */
    public static final Work WORK = lifetime.backend.persistence.jooq.tables.Work.WORK;
}
