package son.dev.foodapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import son.dev.foodapp.data.model.Product;
@Dao
public interface ProductDao {
    @Query("SELECT * FROM products")
    List<Product> getAll();

    @Insert
    void insertAll(Product product);

    @Delete
    void delete(Product product);
}
