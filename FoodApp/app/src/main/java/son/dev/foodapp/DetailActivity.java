package son.dev.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import son.dev.foodapp.constract.DetailConstract;
import son.dev.foodapp.constract.DetailPresenter;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.util.Constants;

public class DetailActivity extends AppCompatActivity implements DetailConstract.IView {
    private TextView tvName;
    private TextView tvPrice;
    private ImageView ivThumbnail;

    private ImageButton ibMinus;
    private ImageButton ibPlus;
    private TextView tvQuantity;
    private TextView tvDescription;

    private DetailConstract.IPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initGUI();

        int productId = getIntent().getIntExtra(Constants.PRODUCT_ID, 1);
        mPresenter = new DetailPresenter(this, this);
        mPresenter.getProduct(productId);
    }

    private void initGUI(){
        tvName = findViewById(R.id.tv_name);
        tvPrice = findViewById(R.id.tv_price);
        ivThumbnail = findViewById(R.id.iv_product_thumbnail);

        ibMinus = findViewById(R.id.ib_minus);
        tvQuantity = findViewById(R.id.tv_quantity);
        ibPlus = findViewById(R.id.ib_plus);

        tvDescription = findViewById(R.id.tv_product_description);

        ibMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(tvQuantity.getText().toString().trim());
                quantity--;
                if(quantity < 1) quantity = 1;
                tvQuantity.setText(quantity + "");
            }
        });

        ibPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(tvQuantity.getText().toString().trim());
                quantity++;
                tvQuantity.setText(quantity + "");
            }
        });
    }

    @Override
    public void updateProductUI(Product product) {
        tvName.setText(product.name);
        tvPrice.setText(product.price + "");
        Glide.with(this)
                .load(product.thumbnail)
                .circleCrop()
                .into(ivThumbnail);
        tvDescription.setText(product.description);
    }
}