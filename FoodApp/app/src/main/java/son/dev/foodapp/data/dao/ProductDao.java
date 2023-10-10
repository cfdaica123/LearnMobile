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

    @Query("SELECT * FROM products WHERE Id=:productId LIMIT 1")
    Product find(int productId);

    @Query("SELECT * FROM products WHERE category_id=:categoryId")
    List<Product> findByCategory(int categoryId);

}
