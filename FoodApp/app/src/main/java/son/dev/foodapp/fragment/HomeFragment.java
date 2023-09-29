package son.dev.foodapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import son.dev.foodapp.R;
import son.dev.foodapp.data.model.Category;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.fragment.constract.HomeConstract;
import son.dev.foodapp.fragment.constract.HomePresenter;

public class HomeFragment extends Fragment implements HomeConstract.IView {
    private HomeConstract.IPresenter mPresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new HomePresenter(getContext(), this);
        mPresenter.loadCategories();
        mPresenter.loadPopularProducts();
    }

    @Override
    public void updatePopularProductsUI(List<Product> productList) {

    }

    @Override
    public void updateCategoriesUI(List<Category> categoryList) {

    }
}
