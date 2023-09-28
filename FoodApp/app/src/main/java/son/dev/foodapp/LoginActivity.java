package son.dev.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import son.dev.foodapp.constract.LoginConstract;
import son.dev.foodapp.constract.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginConstract.IView {
    private LoginConstract.IPresenter mPresenter;
    private EditText etEmail;
    private EditText etPassword;
    private TextView tvError;
    private TextView tvSignUp;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init(){
        mPresenter = new LoginPresenter(this);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        tvSignUp = findViewById(R.id.tv_signup);
        tvError = findViewById(R.id.tv_error);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                mPresenter.doLogin(email, password);
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void loginFailed() {
        tvError.setVisibility(View.VISIBLE);
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
}