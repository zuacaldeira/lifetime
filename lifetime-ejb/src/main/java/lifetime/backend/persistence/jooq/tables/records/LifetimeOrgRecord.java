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
public class LifetimeOrgRecord extends org.jooq.impl.UpdatableRecordImpl<lifetime.backend.persistence.jooq.tables.records.LifetimeOrgRecord> implements org.jooq.Record5<java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer> {

	private static final long serialVersionUID = 1315303725;

	/**
	 * Setter for <code>lifetime.lifetime_org.id</code>.
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>lifetime.lifetime_org.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>lifetime.lifetime_org.name</code>.
	 */
	public void setName(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>lifetime.lifetime_org.name</code>.
	 */
	public java.lang.String getName() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>lifetime.lifetime_org.account_id</code>.
	 */
	public void setAccountId(java.lang.Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>lifetime.lifetime_org.account_id</code>.
	 */
	public java.lang.Integer getAccountId() {
		return (java.lang.Integer) getValue(2);
	}

	/**
	 * Setter for <code>lifetime.lifetime_org.address_id</code>.
	 */
	public void setAddressId(java.lang.Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>lifetime.lifetime_org.address_id</code>.
	 */
	public java.lang.Integer getAddressId() {
		return (java.lang.Integer) getValue(3);
	}

	/**
	 * Setter for <code>lifetime.lifetime_org.photo_id</code>.
	 */
	public void setPhotoId(java.lang.Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>lifetime.lifetime_org.photo_id</code>.
	 */
	public java.lang.Integer getPhotoId() {
		return (java.lang.Integer) getValue(4);
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
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer> valuesRow() {
		return (org.jooq.Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return lifetime.backend.persistence.jooq.tables.LifetimeOrg.LIFETIME_ORG.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return lifetime.backend.persistence.jooq.tables.LifetimeOrg.LIFETIME_ORG.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field3() {
		return lifetime.backend.persistence.jooq.tables.LifetimeOrg.LIFETIME_ORG.ACCOUNT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field4() {
		return lifetime.backend.persistence.jooq.tables.LifetimeOrg.LIFETIME_ORG.ADDRESS_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field5() {
		return lifetime.backend.persistence.jooq.tables.LifetimeOrg.LIFETIME_ORG.PHOTO_ID;
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
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value3() {
		return getAccountId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value4() {
		return getAddressId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value5() {
		return getPhotoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LifetimeOrgRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LifetimeOrgRecord value2(java.lang.String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LifetimeOrgRecord value3(java.lang.Integer value) {
		setAccountId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LifetimeOrgRecord value4(java.lang.Integer value) {
		setAddressId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LifetimeOrgRecord value5(java.lang.Integer value) {
		setPhotoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LifetimeOrgRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.Integer value3, java.lang.Integer value4, java.lang.Integer value5) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached LifetimeOrgRecord
	 */
	public LifetimeOrgRecord() {
		super(lifetime.backend.persistence.jooq.tables.LifetimeOrg.LIFETIME_ORG);
	}

	/**
	 * Create a detached, initialised LifetimeOrgRecord
	 */
	public LifetimeOrgRecord(java.lang.Integer id, java.lang.String name, java.lang.Integer accountId, java.lang.Integer addressId, java.lang.Integer photoId) {
		super(lifetime.backend.persistence.jooq.tables.LifetimeOrg.LIFETIME_ORG);

		setValue(0, id);
		setValue(1, name);
		setValue(2, accountId);
		setValue(3, addressId);
		setValue(4, photoId);
	}
}
