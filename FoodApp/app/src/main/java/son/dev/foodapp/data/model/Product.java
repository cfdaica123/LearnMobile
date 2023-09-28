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
    public double price;

    @ColumnInfo(name = "quantity")
    public int quantity;

    @ColumnInfo(name = "categoryId")
    public int categoryId;

    public Product() {
    }

    public Product(int id, String name, String description, String thumbnail, double price, int quantity, int categoryId) {
        this.Id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }
}
