package son.dev.foodapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import son.dev.foodapp.data.dao.CategoryDao;
import son.dev.foodapp.data.dao.OderDao;
import son.dev.foodapp.data.dao.OderItemDao;
import son.dev.foodapp.data.dao.ProductDao;
import son.dev.foodapp.data.dao.UserDao;
import son.dev.foodapp.data.model.Category;
import son.dev.foodapp.data.model.Oder;
import son.dev.foodapp.data.model.OderItem;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.data.model.User;

@Database(entities = { Category.class, Oder.class, OderItem.class,Product.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract OderDao oderDao();
    public abstract OderItemDao oderItemDao();
    public abstract ProductDao productDao();
    public abstract CategoryDao categoryDao();
}
