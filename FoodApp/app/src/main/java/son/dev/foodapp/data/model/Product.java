package son.dev.foodapp.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {
    @PrimaryKey
    public int Id;

    @ColumnInfo(name = "name")
    @NonNull
    public String name;

    @ColumnInfo(name = "description")
    @NonNull
    public String description;

    @ColumnInfo(name = "thumbnail")
    @NonNull
    public String thumbnail;

    @ColumnInfo(name = "price")
    @NonNull
    public double price;

    @ColumnInfo(name = "quantity")
    @NonNull
    public int quantity;

    @ColumnInfo(name = "category_id")
    @NonNull
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
