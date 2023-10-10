package son.dev.foodapp.constract;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import son.dev.foodapp.data.AppDatabase;
import son.dev.foodapp.data.dao.ProductDao;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.util.Constants;

public class CategoryPresenter implements CategoryConstract.IPresenter{
    private CategoryConstract.IView mView;
    private Context mContext;

    public CategoryPresenter(Context context, CategoryConstract.IView view){
        mContext = context;
        mView = view;
    }

    @Override
    public void getProducts(int categoryId) {
        AppDatabase db = Room.databaseBuilder(mContext,
                        AppDatabase.class, Constants.DB_NAME)
                .allowMainThreadQueries()
                .createFromAsset(Constants.DB_NAME)
                .build();

        ProductDao productDao = db.productDao();
        List<Product> productList = productDao.findByCategory(categoryId);
        mView.updateProductsUI(productList);
    }
}
