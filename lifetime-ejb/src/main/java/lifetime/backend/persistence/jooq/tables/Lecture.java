/**
 * This class is generated by jOOQ
 */
package lifetime.backend.persistence.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import lifetime.backend.persistence.jooq.Keys;
import lifetime.backend.persistence.jooq.Lifetime;
import lifetime.backend.persistence.jooq.tables.records.LectureRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Lecture extends TableImpl<LectureRecord> {

    private static final long serialVersionUID = -1589293624;

    /**
     * The reference instance of <code>lifetime.lecture</code>
     */
    public static final Lecture LECTURE = new Lecture();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LectureRecord> getRecordType() {
        return LectureRecord.class;
    }

    /**
     * The column <code>lifetime.lecture.id</code>.
     */
    public final TableField<LectureRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>lifetime.lecture.title</code>.
     */
    public final TableField<LectureRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    /**
     * The column <code>lifetime.lecture.course_id</code>.
     */
    public final TableField<LectureRecord, Integer> COURSE_ID = createField("course_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>lifetime.lecture</code> table reference
     */
    public Lecture() {
        this("lecture", null);
    }

    /**
     * Create an aliased <code>lifetime.lecture</code> table reference
     */
    public Lecture(String alias) {
        this(alias, LECTURE);
    }

    private Lecture(String alias, Table<LectureRecord> aliased) {
        this(alias, aliased, null);
    }

    private Lecture(String alias, Table<LectureRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Lifetime.LIFETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LectureRecord, Integer> getIdentity() {
        return Keys.IDENTITY_LECTURE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LectureRecord> getPrimaryKey() {
        return Keys.KEY_LECTURE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LectureRecord>> getKeys() {
        return Arrays.<UniqueKey<LectureRecord>>asList(Keys.KEY_LECTURE_PRIMARY, Keys.KEY_LECTURE_ID_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LectureRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LectureRecord, ?>>asList(Keys.FK_LECTURE_COURSE1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lecture as(String alias) {
        return new Lecture(alias, this);
    }

    /**
     * Rename this table
     */
    public Lecture rename(String name) {
        return new Lecture(name, null);
    }
}
