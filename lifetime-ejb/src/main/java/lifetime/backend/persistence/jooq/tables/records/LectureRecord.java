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
public class LectureRecord extends org.jooq.impl.UpdatableRecordImpl<lifetime.backend.persistence.jooq.tables.records.LectureRecord> implements org.jooq.Record3<java.lang.Integer, java.lang.String, java.lang.Integer> {

	private static final long serialVersionUID = -79535152;

	/**
	 * Setter for <code>lifetime.lecture.id</code>.
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>lifetime.lecture.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>lifetime.lecture.title</code>.
	 */
	public void setTitle(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>lifetime.lecture.title</code>.
	 */
	public java.lang.String getTitle() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>lifetime.lecture.course_id</code>.
	 */
	public void setCourseId(java.lang.Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>lifetime.lecture.course_id</code>.
	 */
	public java.lang.Integer getCourseId() {
		return (java.lang.Integer) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.String, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.String, java.lang.Integer> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return lifetime.backend.persistence.jooq.tables.Lecture.LECTURE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return lifetime.backend.persistence.jooq.tables.Lecture.LECTURE.TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field3() {
		return lifetime.backend.persistence.jooq.tables.Lecture.LECTURE.COURSE_ID;
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
		return getTitle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value3() {
		return getCourseId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LectureRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LectureRecord value2(java.lang.String value) {
		setTitle(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LectureRecord value3(java.lang.Integer value) {
		setCourseId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LectureRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.Integer value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached LectureRecord
	 */
	public LectureRecord() {
		super(lifetime.backend.persistence.jooq.tables.Lecture.LECTURE);
	}

	/**
	 * Create a detached, initialised LectureRecord
	 */
	public LectureRecord(java.lang.Integer id, java.lang.String title, java.lang.Integer courseId) {
		super(lifetime.backend.persistence.jooq.tables.Lecture.LECTURE);

		setValue(0, id);
		setValue(1, title);
		setValue(2, courseId);
	}
}
