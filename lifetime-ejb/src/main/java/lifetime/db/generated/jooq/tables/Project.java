/**
 * This class is generated by jOOQ
 */
package lifetime.db.generated.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import lifetime.db.generated.jooq.Keys;
import lifetime.db.generated.jooq.Lifetime;
import lifetime.db.generated.jooq.tables.records.ProjectRecord;

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
public class Project extends TableImpl<ProjectRecord> {

    private static final long serialVersionUID = -33899618;

    /**
     * The reference instance of <code>lifetime.project</code>
     */
    public static final Project PROJECT = new Project();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProjectRecord> getRecordType() {
        return ProjectRecord.class;
    }

    /**
     * The column <code>lifetime.project.id</code>.
     */
    public final TableField<ProjectRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>lifetime.project.title</code>.
     */
    public final TableField<ProjectRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    /**
     * The column <code>lifetime.project.summary</code>.
     */
    public final TableField<ProjectRecord, String> SUMMARY = createField("summary", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>lifetime.project.work_id</code>.
     */
    public final TableField<ProjectRecord, Integer> WORK_ID = createField("work_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>lifetime.project</code> table reference
     */
    public Project() {
        this("project", null);
    }

    /**
     * Create an aliased <code>lifetime.project</code> table reference
     */
    public Project(String alias) {
        this(alias, PROJECT);
    }

    private Project(String alias, Table<ProjectRecord> aliased) {
        this(alias, aliased, null);
    }

    private Project(String alias, Table<ProjectRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ProjectRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PROJECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProjectRecord> getPrimaryKey() {
        return Keys.KEY_PROJECT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProjectRecord>> getKeys() {
        return Arrays.<UniqueKey<ProjectRecord>>asList(Keys.KEY_PROJECT_PRIMARY, Keys.KEY_PROJECT_ID_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ProjectRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ProjectRecord, ?>>asList(Keys.FK_PROJECT_WORK1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project as(String alias) {
        return new Project(alias, this);
    }

    /**
     * Rename this table
     */
    public Project rename(String name) {
        return new Project(name, null);
    }
}
