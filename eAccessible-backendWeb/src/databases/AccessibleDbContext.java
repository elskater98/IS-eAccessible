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

import bean.Accessibility;
import bean.Characteristic;
import bean.CharacteristicLocalType;
import bean.Local;
import bean.Level;
import bean.LocalType;

public class AccessibleDbContext {

    private static Dao<Accessibility, Integer> accessibilityDao;
    private static final String eAccessibleJNDI = "java:jboss/PostgreSQL/eAccessible";
    private static Dao<Characteristic, Integer> characteristicDao;
    private static Dao<CharacteristicLocalType, Integer> characteristicLocalTypeDao;
    private static Dao<Level, Integer> levelDao;
    private static Dao<Local, Integer> localDao;
    private static Dao<LocalType, Integer> localTypeDao;

    public static Dao<Accessibility, Integer> getAccessibilityDao() {
        if (accessibilityDao != null) {
            return accessibilityDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            accessibilityDao = DaoManager.createDao(dataSourceConnectionSource, Accessibility.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getAccessibilityDao();
    }

    public static Dao<Characteristic, Integer> getCharacteristicDao() {
        if (characteristicDao != null) {
            return characteristicDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            characteristicDao = DaoManager.createDao(dataSourceConnectionSource, Characteristic.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getCharacteristicDao();
    }

    public static Dao<CharacteristicLocalType, Integer> getCharacteristicLocalTypeDao() {
        if (characteristicLocalTypeDao != null) {
            return characteristicLocalTypeDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            characteristicLocalTypeDao = DaoManager.createDao(dataSourceConnectionSource, CharacteristicLocalType.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getCharacteristicLocalTypeDao();
    }

    public static Dao<Level, Integer> getLevelDao() {
        if (levelDao != null) {
            return levelDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            levelDao = DaoManager.createDao(dataSourceConnectionSource, Level.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getLevelDao();
    }

    public static Dao<Local, Integer> getLocalDao() {
        if (localDao != null) {
            return localDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            localDao = DaoManager.createDao(dataSourceConnectionSource, Local.class);
            return localDao;
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getLocalDao();
    }

    public static Dao<LocalType, Integer> getLocalTypeDao() {
        if (localTypeDao != null) {
            return localTypeDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            localTypeDao = DaoManager.createDao(dataSourceConnectionSource, LocalType.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getLocalTypeDao();
    }

    private static DataSource getDataSource() throws NamingException {
        final InitialContext cxt = new InitialContext();
        return (DataSource) cxt.lookup(eAccessibleJNDI);
    }

    private static DataSourceConnectionSource getConnectionSource() throws NamingException, SQLException {
        return new DataSourceConnectionSource(getDataSource(), new PostgresDatabaseType());
    }

}