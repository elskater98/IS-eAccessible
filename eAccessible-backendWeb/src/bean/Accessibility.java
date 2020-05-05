package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "eaccessible.accessibilitat")
public class Accessibility {

    @DatabaseField(id = true, columnName = "codiaccessibilitat")
    public int id;

    @DatabaseField(columnName = "codilocal", foreign = true, foreignAutoRefresh = true)
    public Local local;

    @DatabaseField(columnName = "codicaracteristica", foreign = true, foreignAutoRefresh = true)
    public Characteristic characteristic;

    @DatabaseField(columnName = "valor")
    public int value;

    @DatabaseField(columnName = "verificat", defaultValue = "0")
    public char verified;

}
