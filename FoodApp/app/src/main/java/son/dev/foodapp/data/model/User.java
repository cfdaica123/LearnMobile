package son.dev.foodapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    public int Id;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "password")
    public String password;
}
