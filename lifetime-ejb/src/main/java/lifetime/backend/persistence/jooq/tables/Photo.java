/**
 * This class is generated by jOOQ
 */
package lifetime.backend.persistence.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Photo extends org.jooq.impl.TableImpl<lifetime.backend.persistence.jooq.tables.records.PhotoRecord> {

	private static final long serialVersionUID = 1962741495;

	/**
	 * The singleton instance of <code>lifetime.photo</code>
	 */
	public static final lifetime.backend.persistence.jooq.tables.Photo PHOTO = new lifetime.backend.persistence.jooq.tables.Photo();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<lifetime.backend.persistence.jooq.tables.records.PhotoRecord> getRecordType() {
		return lifetime.backend.persistence.jooq.tables.records.PhotoRecord.class;
	}

	/**
	 * The column <code>lifetime.photo.id</code>.
	 */
	public final org.jooq.TableField<lifetime.backend.persistence.jooq.tables.records.PhotoRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>lifetime.photo.data</code>.
	 */
	public final org.jooq.TableField<lifetime.backend.persistence.jooq.tables.records.PhotoRecord, byte[]> DATA = createField("data", org.jooq.impl.SQLDataType.BLOB, this, "");

	/**
	 * Create a <code>lifetime.photo</code> table reference
	 */
	public Photo() {
		this("photo", null);
	}

	/**
	 * Create an aliased <code>lifetime.photo</code> table reference
	 */
	public Photo(java.lang.String alias) {
		this(alias, lifetime.backend.persistence.jooq.tables.Photo.PHOTO);
	}

	private Photo(java.lang.String alias, org.jooq.Table<lifetime.backend.persistence.jooq.tables.records.PhotoRecord> aliased) {
		this(alias, aliased, null);
	}

	private Photo(java.lang.String alias, org.jooq.Table<lifetime.backend.persistence.jooq.tables.records.PhotoRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, lifetime.backend.persistence.jooq.Lifetime.LIFETIME, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<lifetime.backend.persistence.jooq.tables.records.PhotoRecord, java.lang.Integer> getIdentity() {
		return lifetime.backend.persistence.jooq.Keys.IDENTITY_PHOTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<lifetime.backend.persistence.jooq.tables.records.PhotoRecord> getPrimaryKey() {
		return lifetime.backend.persistence.jooq.Keys.KEY_PHOTO_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<lifetime.backend.persistence.jooq.tables.records.PhotoRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<lifetime.backend.persistence.jooq.tables.records.PhotoRecord>>asList(lifetime.backend.persistence.jooq.Keys.KEY_PHOTO_PRIMARY, lifetime.backend.persistence.jooq.Keys.KEY_PHOTO_ID_UNIQUE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public lifetime.backend.persistence.jooq.tables.Photo as(java.lang.String alias) {
		return new lifetime.backend.persistence.jooq.tables.Photo(alias, this);
	}

	/**
	 * Rename this table
	 */
	public lifetime.backend.persistence.jooq.tables.Photo rename(java.lang.String name) {
		return new lifetime.backend.persistence.jooq.tables.Photo(name, null);
	}
}
