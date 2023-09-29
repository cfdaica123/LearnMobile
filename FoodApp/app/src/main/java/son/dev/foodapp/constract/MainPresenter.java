package son.dev.foodapp.constract;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import son.dev.foodapp.data.AppDatabase;
import son.dev.foodapp.data.dao.ProductDao;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.util.Constants;

public class MainPresenter implements MainConstract.IPresenter{
    private MainConstract.IView mView;
    private Context mContext;

    public MainPresenter(Context context, MainConstract.IView view){
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
