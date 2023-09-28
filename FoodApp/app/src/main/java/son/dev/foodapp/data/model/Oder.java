package son.dev.foodapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "oders")
public class Oder {
    @PrimaryKey
    public int Id;
    @ColumnInfo(name = "code")
    public String code;
    @ColumnInfo(name = "status")
    public String status;
    @ColumnInfo(name = "userId")
    public int userId;
}
