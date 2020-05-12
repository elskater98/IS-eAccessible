package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "eaccessible.caracteristicatipolocal")
public class CharacteristicLocalType {

    @DatabaseField(id = true, columnName = "codicaracteristicatipolocal")
    public int id;

    @DatabaseField(columnName = "codicaracteristica", foreign = true)
    public Characteristic characteristic;

    @DatabaseField(columnName = "coditipolocal", foreign = true)
    public LocalType localType;

}
