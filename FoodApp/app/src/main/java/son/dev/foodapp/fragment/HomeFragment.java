package son.dev.foodapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import son.dev.foodapp.CartActivity;
import son.dev.foodapp.R;
import son.dev.foodapp.data.model.Category;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.fragment.adapter.CategoryAdapter;
import son.dev.foodapp.fragment.adapter.ProductAdapter;
import son.dev.foodapp.fragment.constract.HomeConstract;
import son.dev.foodapp.fragment.constract.HomePresenter;

public class HomeFragment extends Fragment implements HomeConstract.IView {
    private HomeConstract.IPresenter mPresenter;
    private RecyclerView rvCategory;
    private RecyclerView rvPopular;

    private ImageView ivCart;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        rvCategory = rootView.findViewById(R.id.rv_category);
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        rvPopular = rootView.findViewById(R.id.rv_popular);
        rvPopular.setLayoutManager(new GridLayoutManager(getContext(), 2));

        ivCart = rootView.findViewById(R.id.iv_cart);
        ivCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);
            }
        });

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
        ProductAdapter adapter = new ProductAdapter(getContext(), productList);
        rvPopular.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateCategoriesUI(List<Category> categoryList) {
        CategoryAdapter adapter = new CategoryAdapter(getContext(), categoryList);
        rvCategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
