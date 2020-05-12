package databases;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.PostgresDatabaseType;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;

import bean.Incidence;
import bean.IncidenceType;

public class IncidenciesDbContext {

    public static IncidenceType getAllLocalsIncidenceType = new IncidenceType();
    public static IncidenceType addLocalIncidenceType = new IncidenceType();
    public static IncidenceType deleteLocalIncidenceType = new IncidenceType();
    public static IncidenceType getLocalIncidenceType = new IncidenceType();
    public static IncidenceType validateLocalIncidenceType = new IncidenceType();

    static {
        getAllLocalsIncidenceType.id = 1;
        getAllLocalsIncidenceType.description = "GET_ALL_LOCALS";

        addLocalIncidenceType.id = 2;
        addLocalIncidenceType.description = "ADD_LOCAL";

        deleteLocalIncidenceType.id = 3;
        deleteLocalIncidenceType.description = "DELETE_LOCAL";

        getLocalIncidenceType.id = 4;
        getLocalIncidenceType.description = "GET_LOCAL";

        validateLocalIncidenceType.id = 5;
        validateLocalIncidenceType.description = "VALIDATE_LOCAL";
    }

    private static Dao<IncidenceType, Integer> incidenceTypeDao;
    private static Dao<Incidence, Integer> incidenceDao;

    public static Dao<IncidenceType, Integer> getIncidenceTypeDao() {
        if (incidenceTypeDao != null) {
            return incidenceTypeDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = IncidenciesDbContext.getConnectionSource()) {
            incidenceTypeDao = DaoManager.createDao(dataSourceConnectionSource, IncidenceType.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getIncidenceTypeDao();
    }

    public static Dao<Incidence, Integer> getIncidenceDao() {
        if (incidenceDao != null) {
            return incidenceDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = IncidenciesDbContext.getConnectionSource()) {
            incidenceDao = DaoManager.createDao(dataSourceConnectionSource, Incidence.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getIncidenceDao();
    }
    private static final String incidenciaJNDI = "java:jboss/PostgreSQL/incidencia";

    private static DataSource getDataSource() throws NamingException {
        final InitialContext cxt = new InitialContext();
        return (DataSource) cxt.lookup(incidenciaJNDI);
    }

    private static DataSourceConnectionSource getConnectionSource() throws NamingException, SQLException {
        return new DataSourceConnectionSource(getDataSource(), new PostgresDatabaseType());
    }

}