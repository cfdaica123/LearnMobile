package son.dev.foodapp.constract;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import son.dev.foodapp.data.AppDatabase;
import son.dev.foodapp.data.dao.ProductDao;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.util.Constants;

public class DetailPresenter implements DetailConstract.IPresenter{
    private DetailConstract.IView mView;
    private Context mContext;

    public DetailPresenter(Context context, DetailConstract.IView view){
        mContext = context;
        mView = view;
    }

    @Override
    public void getProduct(int productId) {
        AppDatabase db = Room.databaseBuilder(mContext,
                        AppDatabase.class, Constants.DB_NAME)
                .allowMainThreadQueries()
                .createFromAsset(Constants.DB_NAME)
                .build();

        ProductDao productDao = db.productDao();
        Product product = productDao.find(productId);

        mView.updateProductUI(product);
    }
}
