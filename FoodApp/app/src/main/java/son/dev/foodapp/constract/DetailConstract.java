package son.dev.foodapp.constract;

import son.dev.foodapp.data.model.OrderItem;
import son.dev.foodapp.data.model.Product;

public interface DetailConstract {
    interface IView{
        void updateProductUI(Product product);
    }
    interface IPresenter{
        void getProduct(int productId);
        void order(OrderItem od);
    }
}
