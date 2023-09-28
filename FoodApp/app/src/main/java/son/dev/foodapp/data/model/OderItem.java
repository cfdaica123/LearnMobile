package son.dev.foodapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "oderItems")
public class OderItem {
    @PrimaryKey
    public int Id;
    @ColumnInfo(name = "oderId")
    public int oderId;
    @ColumnInfo(name = "productId")
    public int productId;
    @ColumnInfo(name = "quantity")
    public int quantity;
    @ColumnInfo(name = "price")
    public String price;
}
