/**
 * This class is generated by jOOQ
 */
package lifetime.backend.persistence.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TrainingRecord extends org.jooq.impl.UpdatableRecordImpl<lifetime.backend.persistence.jooq.tables.records.TrainingRecord> implements org.jooq.Record4<java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer> {

	private static final long serialVersionUID = 2136830157;

	/**
	 * Setter for <code>lifetime.training.id</code>.
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>lifetime.training.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>lifetime.training.type</code>.
	 */
	public void setType(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>lifetime.training.type</code>.
	 */
	public java.lang.String getType() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>lifetime.training.sport_id</code>.
	 */
	public void setSportId(java.lang.Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>lifetime.training.sport_id</code>.
	 */
	public java.lang.Integer getSportId() {
		return (java.lang.Integer) getValue(2);
	}

	/**
	 * Setter for <code>lifetime.training.sport_lifetime_event_id</code>.
	 */
	public void setSportLifetimeEventId(java.lang.Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>lifetime.training.sport_lifetime_event_id</code>.
	 */
	public java.lang.Integer getSportLifetimeEventId() {
		return (java.lang.Integer) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer> valuesRow() {
		return (org.jooq.Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return lifetime.backend.persistence.jooq.tables.Training.TRAINING.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return lifetime.backend.persistence.jooq.tables.Training.TRAINING.TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field3() {
		return lifetime.backend.persistence.jooq.tables.Training.TRAINING.SPORT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field4() {
		return lifetime.backend.persistence.jooq.tables.Training.TRAINING.SPORT_LIFETIME_EVENT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value3() {
		return getSportId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value4() {
		return getSportLifetimeEventId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TrainingRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TrainingRecord value2(java.lang.String value) {
		setType(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TrainingRecord value3(java.lang.Integer value) {
		setSportId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TrainingRecord value4(java.lang.Integer value) {
		setSportLifetimeEventId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TrainingRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.Integer value3, java.lang.Integer value4) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TrainingRecord
	 */
	public TrainingRecord() {
		super(lifetime.backend.persistence.jooq.tables.Training.TRAINING);
	}

	/**
	 * Create a detached, initialised TrainingRecord
	 */
	public TrainingRecord(java.lang.Integer id, java.lang.String type, java.lang.Integer sportId, java.lang.Integer sportLifetimeEventId) {
		super(lifetime.backend.persistence.jooq.tables.Training.TRAINING);

		setValue(0, id);
		setValue(1, type);
		setValue(2, sportId);
		setValue(3, sportLifetimeEventId);
	}
}
