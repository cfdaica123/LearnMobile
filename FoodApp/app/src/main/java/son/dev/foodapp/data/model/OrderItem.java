package son.dev.foodapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "order_items")
public class OrderItem {
    @PrimaryKey(autoGenerate = true)
    public int Id;
    @ColumnInfo(name = "order_id")
    @NotNull
    public int orderId;
    @ColumnInfo(name = "product_id")
    @NotNull
    public int productId;
    @ColumnInfo(name = "quantity")
    @NotNull
    public int quantity;
    @ColumnInfo(name = "price")
    @NotNull
    public double price;
}
