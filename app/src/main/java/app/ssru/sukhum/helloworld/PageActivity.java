package app.ssru.sukhum.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button hellopage;
    private Button btnmain;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        hellopage = findViewById(R.id.hellopage);
        btnmain = findViewById(R.id.btnmain);
        hellopage.setOnClickListener(this);
        btnmain.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == hellopage) {
            Intent intent = new Intent(PageActivity.this,HelloWorldActivity.class);
            startActivity(intent);
        }else if(view == btnmain){
            Intent intent2 = new Intent(PageActivity.this,MainActivity.class);
            startActivity(intent2);

        }
    }
}