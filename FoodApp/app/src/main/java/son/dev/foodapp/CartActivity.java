package son.dev.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import son.dev.foodapp.adapter.CartAdapter;
import son.dev.foodapp.constract.CartConstract;
import son.dev.foodapp.constract.CartPresenter;
import son.dev.foodapp.data.model.OrderItem;

public class CartActivity extends AppCompatActivity implements CartConstract.IView {

    private RecyclerView mRvCart;
    private CartConstract.IPresenter mPresenter;
    private TextView tvTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initGUI();
    }

    private void initGUI(){
        mRvCart = findViewById(R.id.rv_cart);
        mRvCart.setLayoutManager(new LinearLayoutManager(this));
        tvTotal = findViewById(R.id.tv_total);

        mPresenter = new CartPresenter(this, this);
        mPresenter.getOrderItemList();
    }

    @Override
    public void updateOrderItemListUI(List<OrderItem> orderItemList) {
        CartAdapter adapter = new CartAdapter(this, orderItemList);
        mRvCart.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void updateTotalUI(double total) {
        tvTotal.setText(total + "$");
    }
}