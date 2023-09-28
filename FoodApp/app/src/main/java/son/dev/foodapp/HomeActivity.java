package son.dev.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import son.dev.foodapp.constract.HomeConstract;
import son.dev.foodapp.data.model.Product;

public class HomeActivity extends AppCompatActivity implements HomeConstract.IView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    private void init(){

    }

    @Override
    public void updateProductListToView(List<Product> productList) {
        Log.d("size", productList.size() + "");
    }
}