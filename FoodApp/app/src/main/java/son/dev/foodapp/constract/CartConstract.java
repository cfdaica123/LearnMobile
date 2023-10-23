package son.dev.foodapp.constract;

import java.util.List;

import son.dev.foodapp.data.model.OrderItem;

public interface CartConstract {
    interface IView{
        void updateOrderItemListUI(List<OrderItem> orderItemList);
        void updateTotalUI(double total);
    }
    interface IPresenter{
        void getOrderItemList();
    }
}
