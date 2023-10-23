package son.dev.foodapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import son.dev.foodapp.data.model.Category;
import son.dev.foodapp.data.model.Order;
@Dao
public interface CategoryDao {
    @Query("SELECT * FROM categories")
    List<Category> getAll();

    @Insert
    void insertAll(Category category);

    @Delete
    void delete(Category category);
}
