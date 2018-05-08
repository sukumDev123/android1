package app.ssru.sukhum.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private EditText username , password;
    private String userNameAndPass[] = {"kungo000" , "1234" };
    private TextView callBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findIdElement();
        callBack.setText("");
        btnLogin.setOnClickListener(this);
    }

    private void findIdElement() {
        btnLogin = findViewById(R.id.btnLogin);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        callBack = findViewById(R.id.callBack);
    }

    @Override
    public void onClick(View v) {
        if(v == btnLogin){
            boolean checkEmpty = checkEmpty();
            if(checkEmpty){
                boolean loginCheck = loginCheckFun();
                if(loginCheck){
                    Intent intent = new Intent(LoginActivity.this,ProfileActivity.class);
                    startActivity(intent);
                }else{
                    callBack.setText("username or password not pass");
                    callBack.setTextColor(Color.rgb(255,0,0));
                }
            }else{
                callBack.setText("username or password empty");
                callBack.setTextColor(Color.rgb(255,0,0));
            }
        }
    }

    private boolean loginCheckFun() {
        if( (username.getText().toString().equals(userNameAndPass[0]) ) && (password.getText().toString().equals(userNameAndPass[1]) )  ){
            return true;
        }
        return false;
    }

    private boolean checkEmpty() {
        if( (username.getText() != null && !username.getText().toString().isEmpty() ) && (password.getText() != null && !password.getText().toString().isEmpty() )  ){
            return  true;
        }
        return false;
    }
}
