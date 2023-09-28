package son.dev.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import son.dev.foodapp.adapter.CartAdapter;
import son.dev.foodapp.data.model.Product;

public class CartActivity extends AppCompatActivity {

    private RecyclerView mRvCart;
    private List<Product> mProductList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initGUI();
    }

    private void initGUI(){
        for (int i=0; i < 10; i++){
            Product p = new Product(
                    1 + i,
                    "Product " + i,
                    "Product Description" + i,
                    "Thumbnail URL" + i,
                    10.0 + i,
                    2 + i,
                    1 + i

            );
            mProductList.add(p);
        }
        mRvCart = findViewById(R.id.rv_cart);
        mRvCart.setLayoutManager(new LinearLayoutManager(this));

        CartAdapter adapter = new CartAdapter(this, mProductList);
        mRvCart.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

}