package son.dev.foodapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import son.dev.foodapp.data.model.Order;
@Dao
public interface OrderDao {
    @Query("SELECT * FROM orders")
    List<Order> getAll();

    @Insert
    void insertAll(Order order);

    @Delete
    void delete(Order order);
}
