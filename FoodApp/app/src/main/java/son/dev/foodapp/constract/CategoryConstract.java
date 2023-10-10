package son.dev.foodapp.constract;

import java.util.List;

import son.dev.foodapp.data.model.Product;

public interface CategoryConstract {
    interface IView{
        void updateProductsUI(List<Product> productList);
    }
    interface IPresenter{
        void getProducts(int categoryId);
    }
}
