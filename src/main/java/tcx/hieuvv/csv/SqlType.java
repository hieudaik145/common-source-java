package tcx.hieuvv.csv;

import lombok.Getter;

/**
 * A enum sql type
 * 
 * @author hieuvv
 * @since 1.0
 * @created 21/05/2020 13:50:02
 */
@Getter
public enum SqlType {

    TEXT("Text", "\"abc\""), VARCHARSTRING("VarcharString", "\"abc\""), INT("Int", "123"), FLOAT("Float", "123.45"),
    DOUBLE("Double", "123.45"), BOOLEAN("Boolean", "true"), DATE("Date", "(new Date(\"1981-10-25\"))"),
    TIME("Time", ""), DATETIME("DateTime", "(new Date(\"1981-10-25T00:00\"))");

    private String text;

    private String value;

    private SqlType(String text, String value) {
        this.text = text;
        this.value = value;
    }

}
