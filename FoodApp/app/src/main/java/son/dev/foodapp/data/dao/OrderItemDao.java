package son.dev.foodapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import son.dev.foodapp.data.model.OrderItem;

@Dao
public interface OrderItemDao {
    @Query("SELECT * FROM order_items")
    List<OrderItem> getAll();

    @Insert
    void insert(OrderItem orderItem);

    @Delete
    void delete(OrderItem orderItem);
}

