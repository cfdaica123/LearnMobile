package son.dev.foodapp.fragment.constract;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import son.dev.foodapp.constract.LoginConstract;
import son.dev.foodapp.data.AppDatabase;
import son.dev.foodapp.data.dao.CategoryDao;
import son.dev.foodapp.data.dao.ProductDao;
import son.dev.foodapp.data.model.Category;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.util.Constants;

public class HomePresenter implements HomeConstract.IPresenter{
    private Context mContext;
    private HomeConstract.IView mView;
    private AppDatabase db;
    public HomePresenter(Context context, HomeConstract.IView view){
        mContext = context;
        mView = view;
        db = Room.databaseBuilder(mContext,
                        AppDatabase.class, Constants.DB_NAME)
                .allowMainThreadQueries()
                .createFromAsset(Constants.DB_NAME)
                .build();
    }
    @Override
    public void loadPopularProducts() {
        ProductDao productDao = db.productDao();
        List<Product> productList = productDao.getAll();

        mView.updatePopularProductsUI(productList);
    }

    @Override
    public void loadCategories() {
        CategoryDao categoryDao = db.categoryDao();
        List<Category> categoryList = categoryDao.getAll();
        mView.updateCategoriesUI(categoryList);
    }
}
