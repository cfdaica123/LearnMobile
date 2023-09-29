package son.dev.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import son.dev.foodapp.constract.HomeConstract;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.fragment.FavouriteFragment;
import son.dev.foodapp.fragment.HomeFragment;
import son.dev.foodapp.fragment.LibraryFragment;
import son.dev.foodapp.fragment.SettingFragment;

public class HomeActivity extends AppCompatActivity implements HomeConstract.IView {
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(true);

        Fragment homeFragment = new HomeFragment();
        Fragment favouriteFragment = new FavouriteFragment();
        Fragment libraryFragment = new LibraryFragment();
        Fragment settingFragment = new SettingFragment();

        setCurrentFragment(homeFragment);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_home){
                    setCurrentFragment(homeFragment);
                }
                if(item.getItemId() == R.id.menu_favourite){
                    setCurrentFragment(favouriteFragment);
                }
                if(item.getItemId() == R.id.menu_library){
                    setCurrentFragment(libraryFragment);
                }
                if(item.getItemId() == R.id.menu_setting){
                    setCurrentFragment(settingFragment);
                }
                return false;
            }
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private void init(){

    }

    @Override
    public void updateProductListToView(List<Product> productList) {
        Log.d("size", productList.size() + "");
    }
}