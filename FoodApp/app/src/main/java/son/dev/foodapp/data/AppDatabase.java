package son.dev.foodapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import son.dev.foodapp.data.dao.CategoryDao;
import son.dev.foodapp.data.dao.OrderDao;
import son.dev.foodapp.data.dao.OrderItemDao;
import son.dev.foodapp.data.dao.ProductDao;
import son.dev.foodapp.data.dao.UserDao;
import son.dev.foodapp.data.model.Category;
import son.dev.foodapp.data.model.Order;
import son.dev.foodapp.data.model.OrderItem;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.data.model.User;

@Database(entities = { Category.class, Order.class, OrderItem.class,Product.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract OrderDao oderDao();
    public abstract OrderItemDao oderItemDao();
    public abstract ProductDao productDao();
    public abstract CategoryDao categoryDao();
}
