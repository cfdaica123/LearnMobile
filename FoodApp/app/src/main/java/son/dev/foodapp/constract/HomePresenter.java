package son.dev.foodapp.constract;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import son.dev.foodapp.data.AppDatabase;
import son.dev.foodapp.data.dao.ProductDao;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.util.Constants;

public class HomePresenter implements HomeConstract.IPresenter{
    private HomeConstract.IView mView;
    private Context mContext;

    public HomePresenter(Context context, HomeConstract.IView view){
        mContext = context;
        mView = view;
    }
    @Override
    public void getProductList() {
        AppDatabase db = Room.databaseBuilder(mContext,
                AppDatabase.class, Constants.DB_NAME).build();
        ProductDao productDao = db.productDao();
        List<Product> productList = productDao.getAll();

        mView.updateProductListToView(productList);
    }
}
