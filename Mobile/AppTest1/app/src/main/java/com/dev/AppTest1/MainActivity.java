package com.dev.AppTest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_Username;
    private EditText et_Password;
    private Button btn_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
    }

    private   void init(){
        et_Username = findViewById(R.id.et_username);
        et_Password = findViewById(R.id.et_password);
        et_Password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        btn_Login = findViewById(R.id.btn_login);

        btn_Login.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                String username = et_Username.getText().toString();
                String password = et_Password.getText().toString();
                if(username.equals("admin") && password.equals("123")){
                    Intent intent = new Intent(MainActivity.this, home.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }
                                     }
        );


    }
}