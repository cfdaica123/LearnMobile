package son.dev.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import son.dev.foodapp.constract.CategoryConstract;
import son.dev.foodapp.constract.CategoryPresenter;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.fragment.adapter.ProductAdapter;
import son.dev.foodapp.util.Constants;

public class CategoryActivity extends AppCompatActivity implements CategoryConstract.IView {
    private RecyclerView rvProduct;
    private CategoryConstract.IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initGUI();
        int categoryId =getIntent().getIntExtra(Constants.CATEGORY_ID, 1);

        mPresenter = new CategoryPresenter(this, this);
        mPresenter.getProducts(categoryId);
    }

    private void initGUI(){
        rvProduct = findViewById(R.id.rv_products);
        rvProduct.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public void updateProductsUI(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(this, productList);
        rvProduct.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}