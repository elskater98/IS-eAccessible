package backendServlet;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.j256.ormlite.stmt.QueryBuilder;

import bean.*;
import databases.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService()
public class SoapWebService {

    @WebMethod()
    public List<LocalType> getAllLocalTypes() {
        try {
            return AccessibleDbContext.getLocalTypeDao().queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @WebMethod()
    public List<Local> getLocalsByLocalTypeAndName(final LocalType localType, final String name) {
        try {
            QueryBuilder<Local, Integer> qb = AccessibleDbContext.getLocalDao().queryBuilder();
        	qb.where().eq("coditipolocal", localType).and().eq("nomlocal", name);
        	return qb.query();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<Characteristic> getCharacteristics(final LocalType localType) {
        try {
            final List<Characteristic> result = new ArrayList<>();
            for (CharacteristicLocalType characteristicLocalType : AccessibleDbContext.getCharacteristicLocalTypeDao().queryForEq("coditipolocal", localType)) {
                result.add(AccessibleDbContext.getCharacteristicDao().queryForId(characteristicLocalType.characteristic.id));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public Local addLocal(final Local local) {
        addIncidence(IncidenciesDbContext.addLocalIncidenceType);
        try {
            local.id = (int) (AccessibleDbContext.getLocalDao().countOf() + 1);
            AccessibleDbContext.getLocalDao().create(local);
            return local;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<Accessibility> addAccessibility(final List<Accessibility> accessibilityList) {
        try {
            final List<Accessibility> result = new ArrayList<>();
            for (final Accessibility accessibility : accessibilityList) {
            	accessibility.id = (int) (AccessibleDbContext.getAccessibilityDao().countOf() + 1);
                //accessibility.id = (int) Date.from(Instant.now()).getTime();
                AccessibleDbContext.getAccessibilityDao().create(accessibility);
                result.add(accessibility);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addIncidence(final IncidenceType incidenceType) {
        try {
            final Incidence incidence = new Incidence();
            incidence.id = (int) IncidenciesDbContext.getIncidenceDao().countOf() + 1;
            incidence.date = Date.from(Instant.now());
            incidence.timestamp = Timestamp.from(Instant.now());
            incidence.incidenceType = incidenceType;
            IncidenciesDbContext.getIncidenceDao().create(incidence);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @WebMethod()
    public List<Local> getAllLocals() {
        addIncidence(IncidenciesDbContext.getAllLocalsIncidenceType);
        try {
            return AccessibleDbContext.getLocalDao().queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public Local getLocal(final int id) {
        addIncidence(IncidenciesDbContext.getLocalIncidenceType);
        try {
            return AccessibleDbContext.getLocalDao().queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<Accessibility> getAccesibilityByLocal(final Local local) {
        try {
            return AccessibleDbContext.getAccessibilityDao().queryForEq("codilocal", local.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public void deleteLocalById(final int id) {
        addIncidence(IncidenciesDbContext.deleteLocalIncidenceType);
        try {
            for (final Accessibility accessibility : AccessibleDbContext.getAccessibilityDao().queryForEq("codilocal", id)) {
                AccessibleDbContext.getAccessibilityDao().delete(accessibility);
            }
            AccessibleDbContext.getLocalDao().deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public void validateLocal(final Local local) {
        addIncidence(IncidenciesDbContext.validateLocalIncidenceType);
        try {
            local.verified = '1';
            AccessibleDbContext.getLocalDao().update(local);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<Local> getLocalsByName(final String name) {
        addIncidence(IncidenciesDbContext.getLocalIncidenceType);
        try {
            return AccessibleDbContext.getLocalDao().queryForEq("nomlocal", name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<Incidence> getIncidencesByIncidenceType(final IncidenceType incidenceType) {
        try {
            return IncidenciesDbContext.getIncidenceDao().queryForEq("codiTipusIncidencia", incidenceType.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @WebMethod()
    public List<Incidence> getIncidencesByDate(final String startDate, final String endDate) {
        try {
        	Timestamp sDate = Timestamp.valueOf(startDate);
        	Timestamp eDate = Timestamp.valueOf(endDate);
        	QueryBuilder<Incidence, Integer> qb = IncidenciesDbContext.getIncidenceDao().queryBuilder();
        	qb.where().between("dataHora", sDate, eDate);
        	List<Incidence> incidenceList = qb.query();
        	return incidenceList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<IncidenceType> getAllIncidenceTypes() {
        try {
            return IncidenciesDbContext.getIncidenceTypeDao().queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public LocalType getLocalType(int id) {
        try {
            return AccessibleDbContext.getLocalTypeDao().queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public IncidenceType getIncidenceType(int id) {
        try {
            return IncidenciesDbContext.getIncidenceTypeDao().queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}