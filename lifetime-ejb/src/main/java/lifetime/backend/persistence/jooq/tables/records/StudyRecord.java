/**
 * This class is generated by jOOQ
 */
package lifetime.backend.persistence.jooq.tables.records;


import javax.annotation.Generated;

import lifetime.backend.persistence.jooq.tables.Study;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class StudyRecord extends UpdatableRecordImpl<StudyRecord> implements Record3<Integer, String, Integer> {

    private static final long serialVersionUID = 2033007943;

    /**
     * Setter for <code>lifetime.study.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>lifetime.study.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>lifetime.study.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>lifetime.study.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>lifetime.study.lifetime_event_id</code>.
     */
    public void setLifetimeEventId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>lifetime.study.lifetime_event_id</code>.
     */
    public Integer getLifetimeEventId() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Study.STUDY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Study.STUDY.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Study.STUDY.LIFETIME_EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getLifetimeEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudyRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudyRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudyRecord value3(Integer value) {
        setLifetimeEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudyRecord values(Integer value1, String value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StudyRecord
     */
    public StudyRecord() {
        super(Study.STUDY);
    }

    /**
     * Create a detached, initialised StudyRecord
     */
    public StudyRecord(Integer id, String name, Integer lifetimeEventId) {
        super(Study.STUDY);

        set(0, id);
        set(1, name);
        set(2, lifetimeEventId);
    }
}