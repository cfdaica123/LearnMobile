package son.dev.foodapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "products")
public class Product {
    @PrimaryKey
    public int Id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "thumbnail")
    public String thumbnail;
    @ColumnInfo(name = "price")
    public int price;
    @ColumnInfo(name = "quantity")
    public double quantity;
    @ColumnInfo(name = "categoryId")
    public int categoryId;
}
