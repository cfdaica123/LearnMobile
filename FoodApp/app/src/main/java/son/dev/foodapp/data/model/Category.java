package son.dev.foodapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")
public class Category {
    @PrimaryKey
    public int Id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "thumbnail")
    public String thumbnail;
}
