package son.dev.foodapp.fragment.constract;

import java.util.List;

import son.dev.foodapp.data.model.Category;
import son.dev.foodapp.data.model.Product;

public interface HomeConstract {
    interface IView{
        void updatePopularProductsUI(List<Product> productList);
        void updateCategoriesUI(List<Category> categoryList);
    }
    interface IPresenter{
        void loadPopularProducts();
        void loadCategories();
    }
}
