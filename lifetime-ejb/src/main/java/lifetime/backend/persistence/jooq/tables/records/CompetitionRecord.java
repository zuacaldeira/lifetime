/**
 * This class is generated by jOOQ
 */
package lifetime.backend.persistence.jooq.tables.records;


import javax.annotation.Generated;

import lifetime.backend.persistence.jooq.tables.Competition;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


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
public class CompetitionRecord extends UpdatableRecordImpl<CompetitionRecord> implements Record5<Integer, String, UInteger, Integer, Integer> {

    private static final long serialVersionUID = -229378041;

    /**
     * Setter for <code>lifetime.competition.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>lifetime.competition.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>lifetime.competition.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>lifetime.competition.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>lifetime.competition.performance</code>.
     */
    public void setPerformance(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>lifetime.competition.performance</code>.
     */
    public UInteger getPerformance() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>lifetime.competition.sport_id</code>.
     */
    public void setSportId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>lifetime.competition.sport_id</code>.
     */
    public Integer getSportId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>lifetime.competition.sport_lifetime_event_id</code>.
     */
    public void setSportLifetimeEventId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>lifetime.competition.sport_lifetime_event_id</code>.
     */
    public Integer getSportLifetimeEventId() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, UInteger, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, UInteger, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Competition.COMPETITION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Competition.COMPETITION.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field3() {
        return Competition.COMPETITION.PERFORMANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Competition.COMPETITION.SPORT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Competition.COMPETITION.SPORT_LIFETIME_EVENT_ID;
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
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value3() {
        return getPerformance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getSportId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getSportLifetimeEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompetitionRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompetitionRecord value2(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompetitionRecord value3(UInteger value) {
        setPerformance(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompetitionRecord value4(Integer value) {
        setSportId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompetitionRecord value5(Integer value) {
        setSportLifetimeEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompetitionRecord values(Integer value1, String value2, UInteger value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CompetitionRecord
     */
    public CompetitionRecord() {
        super(Competition.COMPETITION);
    }

    /**
     * Create a detached, initialised CompetitionRecord
     */
    public CompetitionRecord(Integer id, String title, UInteger performance, Integer sportId, Integer sportLifetimeEventId) {
        super(Competition.COMPETITION);

        set(0, id);
        set(1, title);
        set(2, performance);
        set(3, sportId);
        set(4, sportLifetimeEventId);
    }
}
