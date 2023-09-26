package son.dev.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import son.dev.recyclerviewapp.adapter.CartAdapter;
import son.dev.recyclerviewapp.model.Product;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRvCart;
    private List<Product> mProductList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGUI();
    }

    private void initGUI(){
        for (int i=0; i < 10; i++){
            Product p = new Product(
                    "https://static.vecteezy.com/system/resources/previews/011/459/666/original/people-avatar-icon-png.png",
                    "Product " + i,
                    i,
                    i
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