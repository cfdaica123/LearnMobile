package son.dev.foodapp.constract;

import java.util.List;

import son.dev.foodapp.data.model.Product;

public interface MainConstract {
    interface IView{
        void updateProductListToView(List<Product> productList);
    }
    interface IPresenter{
        void getProductList();
    }
}
