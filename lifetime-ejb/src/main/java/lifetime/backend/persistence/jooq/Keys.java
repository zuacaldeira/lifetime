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
import lifetime.backend.persistence.jooq.tables.Photo;
import lifetime.backend.persistence.jooq.tables.Project;
import lifetime.backend.persistence.jooq.tables.SchemaVersion;
import lifetime.backend.persistence.jooq.tables.Sport;
import lifetime.backend.persistence.jooq.tables.Study;
import lifetime.backend.persistence.jooq.tables.Task;
import lifetime.backend.persistence.jooq.tables.Training;
import lifetime.backend.persistence.jooq.tables.Work;
import lifetime.backend.persistence.jooq.tables.records.AccountRecord;
import lifetime.backend.persistence.jooq.tables.records.AddressRecord;
import lifetime.backend.persistence.jooq.tables.records.CompetitionRecord;
import lifetime.backend.persistence.jooq.tables.records.CourseRecord;
import lifetime.backend.persistence.jooq.tables.records.LectureRecord;
import lifetime.backend.persistence.jooq.tables.records.LifetimeEventRecord;
import lifetime.backend.persistence.jooq.tables.records.LifetimeOrgRecord;
import lifetime.backend.persistence.jooq.tables.records.LifetimeUserRecord;
import lifetime.backend.persistence.jooq.tables.records.PhotoRecord;
import lifetime.backend.persistence.jooq.tables.records.ProjectRecord;
import lifetime.backend.persistence.jooq.tables.records.SchemaVersionRecord;
import lifetime.backend.persistence.jooq.tables.records.SportRecord;
import lifetime.backend.persistence.jooq.tables.records.StudyRecord;
import lifetime.backend.persistence.jooq.tables.records.TaskRecord;
import lifetime.backend.persistence.jooq.tables.records.TrainingRecord;
import lifetime.backend.persistence.jooq.tables.records.WorkRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>lifetime</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = Identities0.IDENTITY_ACCOUNT;
    public static final Identity<AddressRecord, Integer> IDENTITY_ADDRESS = Identities0.IDENTITY_ADDRESS;
    public static final Identity<CompetitionRecord, Integer> IDENTITY_COMPETITION = Identities0.IDENTITY_COMPETITION;
    public static final Identity<CourseRecord, Integer> IDENTITY_COURSE = Identities0.IDENTITY_COURSE;
    public static final Identity<LectureRecord, Integer> IDENTITY_LECTURE = Identities0.IDENTITY_LECTURE;
    public static final Identity<LifetimeEventRecord, Integer> IDENTITY_LIFETIME_EVENT = Identities0.IDENTITY_LIFETIME_EVENT;
    public static final Identity<LifetimeOrgRecord, Integer> IDENTITY_LIFETIME_ORG = Identities0.IDENTITY_LIFETIME_ORG;
    public static final Identity<LifetimeUserRecord, Integer> IDENTITY_LIFETIME_USER = Identities0.IDENTITY_LIFETIME_USER;
    public static final Identity<PhotoRecord, Integer> IDENTITY_PHOTO = Identities0.IDENTITY_PHOTO;
    public static final Identity<ProjectRecord, Integer> IDENTITY_PROJECT = Identities0.IDENTITY_PROJECT;
    public static final Identity<SportRecord, Integer> IDENTITY_SPORT = Identities0.IDENTITY_SPORT;
    public static final Identity<StudyRecord, Integer> IDENTITY_STUDY = Identities0.IDENTITY_STUDY;
    public static final Identity<TaskRecord, Integer> IDENTITY_TASK = Identities0.IDENTITY_TASK;
    public static final Identity<WorkRecord, Integer> IDENTITY_WORK = Identities0.IDENTITY_WORK;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = UniqueKeys0.KEY_ACCOUNT_PRIMARY;
    public static final UniqueKey<AddressRecord> KEY_ADDRESS_PRIMARY = UniqueKeys0.KEY_ADDRESS_PRIMARY;
    public static final UniqueKey<AddressRecord> KEY_ADDRESS_ID_UNIQUE = UniqueKeys0.KEY_ADDRESS_ID_UNIQUE;
    public static final UniqueKey<CompetitionRecord> KEY_COMPETITION_PRIMARY = UniqueKeys0.KEY_COMPETITION_PRIMARY;
    public static final UniqueKey<CompetitionRecord> KEY_COMPETITION_ID_UNIQUE = UniqueKeys0.KEY_COMPETITION_ID_UNIQUE;
    public static final UniqueKey<CourseRecord> KEY_COURSE_PRIMARY = UniqueKeys0.KEY_COURSE_PRIMARY;
    public static final UniqueKey<CourseRecord> KEY_COURSE_ID_UNIQUE = UniqueKeys0.KEY_COURSE_ID_UNIQUE;
    public static final UniqueKey<LectureRecord> KEY_LECTURE_PRIMARY = UniqueKeys0.KEY_LECTURE_PRIMARY;
    public static final UniqueKey<LectureRecord> KEY_LECTURE_ID_UNIQUE = UniqueKeys0.KEY_LECTURE_ID_UNIQUE;
    public static final UniqueKey<LifetimeEventRecord> KEY_LIFETIME_EVENT_PRIMARY = UniqueKeys0.KEY_LIFETIME_EVENT_PRIMARY;
    public static final UniqueKey<LifetimeEventRecord> KEY_LIFETIME_EVENT_ID_UNIQUE = UniqueKeys0.KEY_LIFETIME_EVENT_ID_UNIQUE;
    public static final UniqueKey<LifetimeOrgRecord> KEY_LIFETIME_ORG_PRIMARY = UniqueKeys0.KEY_LIFETIME_ORG_PRIMARY;
    public static final UniqueKey<LifetimeOrgRecord> KEY_LIFETIME_ORG_ID_UNIQUE = UniqueKeys0.KEY_LIFETIME_ORG_ID_UNIQUE;
    public static final UniqueKey<LifetimeUserRecord> KEY_LIFETIME_USER_PRIMARY = UniqueKeys0.KEY_LIFETIME_USER_PRIMARY;
    public static final UniqueKey<LifetimeUserRecord> KEY_LIFETIME_USER_ID_UNIQUE = UniqueKeys0.KEY_LIFETIME_USER_ID_UNIQUE;
    public static final UniqueKey<PhotoRecord> KEY_PHOTO_PRIMARY = UniqueKeys0.KEY_PHOTO_PRIMARY;
    public static final UniqueKey<PhotoRecord> KEY_PHOTO_ID_UNIQUE = UniqueKeys0.KEY_PHOTO_ID_UNIQUE;
    public static final UniqueKey<ProjectRecord> KEY_PROJECT_PRIMARY = UniqueKeys0.KEY_PROJECT_PRIMARY;
    public static final UniqueKey<ProjectRecord> KEY_PROJECT_ID_UNIQUE = UniqueKeys0.KEY_PROJECT_ID_UNIQUE;
    public static final UniqueKey<SchemaVersionRecord> KEY_SCHEMA_VERSION_PRIMARY = UniqueKeys0.KEY_SCHEMA_VERSION_PRIMARY;
    public static final UniqueKey<SportRecord> KEY_SPORT_PRIMARY = UniqueKeys0.KEY_SPORT_PRIMARY;
    public static final UniqueKey<SportRecord> KEY_SPORT_ID_UNIQUE = UniqueKeys0.KEY_SPORT_ID_UNIQUE;
    public static final UniqueKey<StudyRecord> KEY_STUDY_PRIMARY = UniqueKeys0.KEY_STUDY_PRIMARY;
    public static final UniqueKey<StudyRecord> KEY_STUDY_ID_UNIQUE = UniqueKeys0.KEY_STUDY_ID_UNIQUE;
    public static final UniqueKey<TaskRecord> KEY_TASK_PRIMARY = UniqueKeys0.KEY_TASK_PRIMARY;
    public static final UniqueKey<TaskRecord> KEY_TASK_ID_UNIQUE = UniqueKeys0.KEY_TASK_ID_UNIQUE;
    public static final UniqueKey<TrainingRecord> KEY_TRAINING_PRIMARY = UniqueKeys0.KEY_TRAINING_PRIMARY;
    public static final UniqueKey<WorkRecord> KEY_WORK_PRIMARY = UniqueKeys0.KEY_WORK_PRIMARY;
    public static final UniqueKey<WorkRecord> KEY_WORK_ID_UNIQUE = UniqueKeys0.KEY_WORK_ID_UNIQUE;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CompetitionRecord, SportRecord> FK_COMPETITION_SPORT1 = ForeignKeys0.FK_COMPETITION_SPORT1;
    public static final ForeignKey<CourseRecord, StudyRecord> FK_COURSE_STUDY1 = ForeignKeys0.FK_COURSE_STUDY1;
    public static final ForeignKey<LectureRecord, CourseRecord> FK_LECTURE_COURSE1 = ForeignKeys0.FK_LECTURE_COURSE1;
    public static final ForeignKey<LifetimeEventRecord, LifetimeUserRecord> FK_LIFETIME_EVENT_LIFETIME_USER1 = ForeignKeys0.FK_LIFETIME_EVENT_LIFETIME_USER1;
    public static final ForeignKey<LifetimeEventRecord, LifetimeOrgRecord> FK_LIFETIME_EVENT_LIFETIME_ORG1 = ForeignKeys0.FK_LIFETIME_EVENT_LIFETIME_ORG1;
    public static final ForeignKey<LifetimeEventRecord, AddressRecord> FK_LIFETIME_EVENT_ADDRESS1 = ForeignKeys0.FK_LIFETIME_EVENT_ADDRESS1;
    public static final ForeignKey<LifetimeOrgRecord, AccountRecord> FK_LIFETIME_ORG_ACCOUNT1 = ForeignKeys0.FK_LIFETIME_ORG_ACCOUNT1;
    public static final ForeignKey<LifetimeOrgRecord, AddressRecord> FK_LIFETIME_ORG_ADDRESS1 = ForeignKeys0.FK_LIFETIME_ORG_ADDRESS1;
    public static final ForeignKey<LifetimeOrgRecord, PhotoRecord> FK_LIFETIME_ORG_PHOTO1 = ForeignKeys0.FK_LIFETIME_ORG_PHOTO1;
    public static final ForeignKey<LifetimeUserRecord, AddressRecord> FK_LIFETIME_USER_ADDRESS1 = ForeignKeys0.FK_LIFETIME_USER_ADDRESS1;
    public static final ForeignKey<LifetimeUserRecord, AccountRecord> FK_LIFETIME_USER_ACCOUNT1 = ForeignKeys0.FK_LIFETIME_USER_ACCOUNT1;
    public static final ForeignKey<LifetimeUserRecord, PhotoRecord> FK_LIFETIME_USER_PHOTO1 = ForeignKeys0.FK_LIFETIME_USER_PHOTO1;
    public static final ForeignKey<ProjectRecord, WorkRecord> FK_PROJECT_WORK1 = ForeignKeys0.FK_PROJECT_WORK1;
    public static final ForeignKey<SportRecord, LifetimeEventRecord> FK_SPORT_LIFETIME_EVENT1 = ForeignKeys0.FK_SPORT_LIFETIME_EVENT1;
    public static final ForeignKey<StudyRecord, LifetimeEventRecord> FK_STUDY_LIFETIME_EVENT1 = ForeignKeys0.FK_STUDY_LIFETIME_EVENT1;
    public static final ForeignKey<TaskRecord, ProjectRecord> FK_TASK_PROJECT1 = ForeignKeys0.FK_TASK_PROJECT1;
    public static final ForeignKey<TrainingRecord, SportRecord> FK_TRAINING_SPORT1 = ForeignKeys0.FK_TRAINING_SPORT1;
    public static final ForeignKey<WorkRecord, LifetimeEventRecord> FK_WORK_LIFETIME_EVENT1 = ForeignKeys0.FK_WORK_LIFETIME_EVENT1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = createIdentity(Account.ACCOUNT, Account.ACCOUNT.ID);
        public static Identity<AddressRecord, Integer> IDENTITY_ADDRESS = createIdentity(Address.ADDRESS, Address.ADDRESS.ID);
        public static Identity<CompetitionRecord, Integer> IDENTITY_COMPETITION = createIdentity(Competition.COMPETITION, Competition.COMPETITION.ID);
        public static Identity<CourseRecord, Integer> IDENTITY_COURSE = createIdentity(Course.COURSE, Course.COURSE.ID);
        public static Identity<LectureRecord, Integer> IDENTITY_LECTURE = createIdentity(Lecture.LECTURE, Lecture.LECTURE.ID);
        public static Identity<LifetimeEventRecord, Integer> IDENTITY_LIFETIME_EVENT = createIdentity(LifetimeEvent.LIFETIME_EVENT, LifetimeEvent.LIFETIME_EVENT.ID);
        public static Identity<LifetimeOrgRecord, Integer> IDENTITY_LIFETIME_ORG = createIdentity(LifetimeOrg.LIFETIME_ORG, LifetimeOrg.LIFETIME_ORG.ID);
        public static Identity<LifetimeUserRecord, Integer> IDENTITY_LIFETIME_USER = createIdentity(LifetimeUser.LIFETIME_USER, LifetimeUser.LIFETIME_USER.ID);
        public static Identity<PhotoRecord, Integer> IDENTITY_PHOTO = createIdentity(Photo.PHOTO, Photo.PHOTO.ID);
        public static Identity<ProjectRecord, Integer> IDENTITY_PROJECT = createIdentity(Project.PROJECT, Project.PROJECT.ID);
        public static Identity<SportRecord, Integer> IDENTITY_SPORT = createIdentity(Sport.SPORT, Sport.SPORT.ID);
        public static Identity<StudyRecord, Integer> IDENTITY_STUDY = createIdentity(Study.STUDY, Study.STUDY.ID);
        public static Identity<TaskRecord, Integer> IDENTITY_TASK = createIdentity(Task.TASK, Task.TASK.ID);
        public static Identity<WorkRecord, Integer> IDENTITY_WORK = createIdentity(Work.WORK, Work.WORK.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = createUniqueKey(Account.ACCOUNT, "KEY_account_PRIMARY", Account.ACCOUNT.ID);
        public static final UniqueKey<AddressRecord> KEY_ADDRESS_PRIMARY = createUniqueKey(Address.ADDRESS, "KEY_address_PRIMARY", Address.ADDRESS.ID);
        public static final UniqueKey<AddressRecord> KEY_ADDRESS_ID_UNIQUE = createUniqueKey(Address.ADDRESS, "KEY_address_id_UNIQUE", Address.ADDRESS.ID);
        public static final UniqueKey<CompetitionRecord> KEY_COMPETITION_PRIMARY = createUniqueKey(Competition.COMPETITION, "KEY_competition_PRIMARY", Competition.COMPETITION.ID);
        public static final UniqueKey<CompetitionRecord> KEY_COMPETITION_ID_UNIQUE = createUniqueKey(Competition.COMPETITION, "KEY_competition_id_UNIQUE", Competition.COMPETITION.ID);
        public static final UniqueKey<CourseRecord> KEY_COURSE_PRIMARY = createUniqueKey(Course.COURSE, "KEY_course_PRIMARY", Course.COURSE.ID);
        public static final UniqueKey<CourseRecord> KEY_COURSE_ID_UNIQUE = createUniqueKey(Course.COURSE, "KEY_course_id_UNIQUE", Course.COURSE.ID);
        public static final UniqueKey<LectureRecord> KEY_LECTURE_PRIMARY = createUniqueKey(Lecture.LECTURE, "KEY_lecture_PRIMARY", Lecture.LECTURE.ID);
        public static final UniqueKey<LectureRecord> KEY_LECTURE_ID_UNIQUE = createUniqueKey(Lecture.LECTURE, "KEY_lecture_id_UNIQUE", Lecture.LECTURE.ID);
        public static final UniqueKey<LifetimeEventRecord> KEY_LIFETIME_EVENT_PRIMARY = createUniqueKey(LifetimeEvent.LIFETIME_EVENT, "KEY_lifetime_event_PRIMARY", LifetimeEvent.LIFETIME_EVENT.ID);
        public static final UniqueKey<LifetimeEventRecord> KEY_LIFETIME_EVENT_ID_UNIQUE = createUniqueKey(LifetimeEvent.LIFETIME_EVENT, "KEY_lifetime_event_id_UNIQUE", LifetimeEvent.LIFETIME_EVENT.ID);
        public static final UniqueKey<LifetimeOrgRecord> KEY_LIFETIME_ORG_PRIMARY = createUniqueKey(LifetimeOrg.LIFETIME_ORG, "KEY_lifetime_org_PRIMARY", LifetimeOrg.LIFETIME_ORG.ID);
        public static final UniqueKey<LifetimeOrgRecord> KEY_LIFETIME_ORG_ID_UNIQUE = createUniqueKey(LifetimeOrg.LIFETIME_ORG, "KEY_lifetime_org_id_UNIQUE", LifetimeOrg.LIFETIME_ORG.ID);
        public static final UniqueKey<LifetimeUserRecord> KEY_LIFETIME_USER_PRIMARY = createUniqueKey(LifetimeUser.LIFETIME_USER, "KEY_lifetime_user_PRIMARY", LifetimeUser.LIFETIME_USER.ID);
        public static final UniqueKey<LifetimeUserRecord> KEY_LIFETIME_USER_ID_UNIQUE = createUniqueKey(LifetimeUser.LIFETIME_USER, "KEY_lifetime_user_id_UNIQUE", LifetimeUser.LIFETIME_USER.ID);
        public static final UniqueKey<PhotoRecord> KEY_PHOTO_PRIMARY = createUniqueKey(Photo.PHOTO, "KEY_photo_PRIMARY", Photo.PHOTO.ID);
        public static final UniqueKey<PhotoRecord> KEY_PHOTO_ID_UNIQUE = createUniqueKey(Photo.PHOTO, "KEY_photo_id_UNIQUE", Photo.PHOTO.ID);
        public static final UniqueKey<ProjectRecord> KEY_PROJECT_PRIMARY = createUniqueKey(Project.PROJECT, "KEY_project_PRIMARY", Project.PROJECT.ID);
        public static final UniqueKey<ProjectRecord> KEY_PROJECT_ID_UNIQUE = createUniqueKey(Project.PROJECT, "KEY_project_id_UNIQUE", Project.PROJECT.ID);
        public static final UniqueKey<SchemaVersionRecord> KEY_SCHEMA_VERSION_PRIMARY = createUniqueKey(SchemaVersion.SCHEMA_VERSION, "KEY_schema_version_PRIMARY", SchemaVersion.SCHEMA_VERSION.INSTALLED_RANK);
        public static final UniqueKey<SportRecord> KEY_SPORT_PRIMARY = createUniqueKey(Sport.SPORT, "KEY_sport_PRIMARY", Sport.SPORT.ID, Sport.SPORT.LIFETIME_EVENT_ID);
        public static final UniqueKey<SportRecord> KEY_SPORT_ID_UNIQUE = createUniqueKey(Sport.SPORT, "KEY_sport_id_UNIQUE", Sport.SPORT.ID);
        public static final UniqueKey<StudyRecord> KEY_STUDY_PRIMARY = createUniqueKey(Study.STUDY, "KEY_study_PRIMARY", Study.STUDY.ID, Study.STUDY.LIFETIME_EVENT_ID);
        public static final UniqueKey<StudyRecord> KEY_STUDY_ID_UNIQUE = createUniqueKey(Study.STUDY, "KEY_study_id_UNIQUE", Study.STUDY.ID);
        public static final UniqueKey<TaskRecord> KEY_TASK_PRIMARY = createUniqueKey(Task.TASK, "KEY_task_PRIMARY", Task.TASK.ID);
        public static final UniqueKey<TaskRecord> KEY_TASK_ID_UNIQUE = createUniqueKey(Task.TASK, "KEY_task_id_UNIQUE", Task.TASK.ID);
        public static final UniqueKey<TrainingRecord> KEY_TRAINING_PRIMARY = createUniqueKey(Training.TRAINING, "KEY_training_PRIMARY", Training.TRAINING.ID);
        public static final UniqueKey<WorkRecord> KEY_WORK_PRIMARY = createUniqueKey(Work.WORK, "KEY_work_PRIMARY", Work.WORK.ID, Work.WORK.LIFETIME_EVENT_ID);
        public static final UniqueKey<WorkRecord> KEY_WORK_ID_UNIQUE = createUniqueKey(Work.WORK, "KEY_work_id_UNIQUE", Work.WORK.ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<CompetitionRecord, SportRecord> FK_COMPETITION_SPORT1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_SPORT_PRIMARY, Competition.COMPETITION, "fk_competition_sport1", Competition.COMPETITION.SPORT_ID, Competition.COMPETITION.SPORT_LIFETIME_EVENT_ID);
        public static final ForeignKey<CourseRecord, StudyRecord> FK_COURSE_STUDY1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_STUDY_PRIMARY, Course.COURSE, "fk_course_study1", Course.COURSE.STUDY_ID);
        public static final ForeignKey<LectureRecord, CourseRecord> FK_LECTURE_COURSE1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_COURSE_PRIMARY, Lecture.LECTURE, "fk_lecture_course1", Lecture.LECTURE.COURSE_ID);
        public static final ForeignKey<LifetimeEventRecord, LifetimeUserRecord> FK_LIFETIME_EVENT_LIFETIME_USER1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_LIFETIME_USER_PRIMARY, LifetimeEvent.LIFETIME_EVENT, "fk_lifetime_event_lifetime_user1", LifetimeEvent.LIFETIME_EVENT.LIFETIME_USER_ID);
        public static final ForeignKey<LifetimeEventRecord, LifetimeOrgRecord> FK_LIFETIME_EVENT_LIFETIME_ORG1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_LIFETIME_ORG_PRIMARY, LifetimeEvent.LIFETIME_EVENT, "fk_lifetime_event_lifetime_org1", LifetimeEvent.LIFETIME_EVENT.LIFETIME_ORG_ID);
        public static final ForeignKey<LifetimeEventRecord, AddressRecord> FK_LIFETIME_EVENT_ADDRESS1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_ADDRESS_PRIMARY, LifetimeEvent.LIFETIME_EVENT, "fk_lifetime_event_address1", LifetimeEvent.LIFETIME_EVENT.ADDRESS_ID);
        public static final ForeignKey<LifetimeOrgRecord, AccountRecord> FK_LIFETIME_ORG_ACCOUNT1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_ACCOUNT_PRIMARY, LifetimeOrg.LIFETIME_ORG, "fk_lifetime_org_account1", LifetimeOrg.LIFETIME_ORG.ACCOUNT_ID);
        public static final ForeignKey<LifetimeOrgRecord, AddressRecord> FK_LIFETIME_ORG_ADDRESS1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_ADDRESS_PRIMARY, LifetimeOrg.LIFETIME_ORG, "fk_lifetime_org_address1", LifetimeOrg.LIFETIME_ORG.ADDRESS_ID);
        public static final ForeignKey<LifetimeOrgRecord, PhotoRecord> FK_LIFETIME_ORG_PHOTO1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_PHOTO_PRIMARY, LifetimeOrg.LIFETIME_ORG, "fk_lifetime_org_photo1", LifetimeOrg.LIFETIME_ORG.PHOTO_ID);
        public static final ForeignKey<LifetimeUserRecord, AddressRecord> FK_LIFETIME_USER_ADDRESS1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_ADDRESS_PRIMARY, LifetimeUser.LIFETIME_USER, "fk_lifetime_user_address1", LifetimeUser.LIFETIME_USER.ADDRESS_ID);
        public static final ForeignKey<LifetimeUserRecord, AccountRecord> FK_LIFETIME_USER_ACCOUNT1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_ACCOUNT_PRIMARY, LifetimeUser.LIFETIME_USER, "fk_lifetime_user_account1", LifetimeUser.LIFETIME_USER.ACCOUNT_ID);
        public static final ForeignKey<LifetimeUserRecord, PhotoRecord> FK_LIFETIME_USER_PHOTO1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_PHOTO_PRIMARY, LifetimeUser.LIFETIME_USER, "fk_lifetime_user_photo1", LifetimeUser.LIFETIME_USER.PHOTO_ID);
        public static final ForeignKey<ProjectRecord, WorkRecord> FK_PROJECT_WORK1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_WORK_PRIMARY, Project.PROJECT, "fk_project_work1", Project.PROJECT.WORK_ID);
        public static final ForeignKey<SportRecord, LifetimeEventRecord> FK_SPORT_LIFETIME_EVENT1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_LIFETIME_EVENT_PRIMARY, Sport.SPORT, "fk_sport_lifetime_event1", Sport.SPORT.LIFETIME_EVENT_ID);
        public static final ForeignKey<StudyRecord, LifetimeEventRecord> FK_STUDY_LIFETIME_EVENT1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_LIFETIME_EVENT_PRIMARY, Study.STUDY, "fk_study_lifetime_event1", Study.STUDY.LIFETIME_EVENT_ID);
        public static final ForeignKey<TaskRecord, ProjectRecord> FK_TASK_PROJECT1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_PROJECT_PRIMARY, Task.TASK, "fk_task_project1", Task.TASK.PROJECT_ID);
        public static final ForeignKey<TrainingRecord, SportRecord> FK_TRAINING_SPORT1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_SPORT_PRIMARY, Training.TRAINING, "fk_training_sport1", Training.TRAINING.SPORT_ID, Training.TRAINING.SPORT_LIFETIME_EVENT_ID);
        public static final ForeignKey<WorkRecord, LifetimeEventRecord> FK_WORK_LIFETIME_EVENT1 = createForeignKey(lifetime.backend.persistence.jooq.Keys.KEY_LIFETIME_EVENT_PRIMARY, Work.WORK, "fk_work_lifetime_event1", Work.WORK.LIFETIME_EVENT_ID);
    }
}
