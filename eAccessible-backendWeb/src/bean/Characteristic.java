package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "eaccessible.caracteristica")
public class Characteristic {

    @DatabaseField(id = true, columnName = "codicaracteristica")
    public int id;

    @DatabaseField(columnName = "nomcaracteristicaca")
    public String nameCA;

    @DatabaseField(columnName = "nomcaracteristicaes")
    public String nameES;

    @DatabaseField(columnName = "nomcaracteristicaen")
    public String nameEN;

    @DatabaseField(columnName = "tipo")
    public int type;

    @DatabaseField(columnName = "codinivell", foreign = true, foreignAutoRefresh = true)
    public Level level;

}
