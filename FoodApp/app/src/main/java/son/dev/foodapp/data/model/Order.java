package son.dev.foodapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "orders")
public class Order {
    @PrimaryKey
    public int Id;
    @ColumnInfo(name = "code")
    public String code;
    @ColumnInfo(name = "status")
    public String status;
}
