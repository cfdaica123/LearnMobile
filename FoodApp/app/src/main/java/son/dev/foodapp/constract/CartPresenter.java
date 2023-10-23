package son.dev.foodapp.constract;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import son.dev.foodapp.data.AppDatabase;
import son.dev.foodapp.data.dao.OrderItemDao;
import son.dev.foodapp.data.model.OrderItem;
import son.dev.foodapp.util.Constants;

public class CartPresenter implements CartConstract.IPresenter{
    private CartConstract.IView mView;
    private Context mContext;

    public CartPresenter(Context context, CartConstract.IView view){
        mContext = context;
        mView = view;
    }

    @Override
    public void getOrderItemList() {
        AppDatabase db = Room.databaseBuilder(mContext,
                        AppDatabase.class, Constants.DB_NAME)
                .allowMainThreadQueries()
                .createFromAsset(Constants.DB_NAME)
                .build();
        OrderItemDao orderItemDao = db.oderItemDao();
        List<OrderItem> orderItemList = orderItemDao.getAll();
        mView.updateOrderItemListUI(orderItemList);

        double total = 0;
        for(int i = 0; i < orderItemList.size(); i++){
            OrderItem orderItem = orderItemList.get(i);
            total += orderItem.price * orderItem.quantity;
        }
        mView.updateTotalUI(total);
    }
}
