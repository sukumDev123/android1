package app.ssru.sukhum.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editX,
            editY;
    private Button btnCal,
            btnReset;
    private TextView result;
    private RadioGroup radioGroupS;
    private RadioButton radioPlus,
            radioDelete,
            radioMul,
            radioDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        initView();

    }

    private void initView() {
        radioGroupS.check(radioPlus.getId());
        result.setText("0");
        btnReset.setOnClickListener(this);
        btnCal.setOnClickListener(this);
        editX.setText("");
        editY.setText("");

    }



    private void bindView() {
        editX = findViewById(R.id.editX);
        editY = findViewById(R.id.editY);
        btnCal = findViewById(R.id.btnCal);
        btnReset = findViewById(R.id.btnReset);
        radioGroupS = findViewById(R.id.radioGroupS);
        radioPlus = findViewById(R.id.radioPlus);
        radioDelete = findViewById(R.id.radioDelete);
        radioMul = findViewById(R.id.radioMul);
        radioDivide = findViewById(R.id.radioDivide);
        result = findViewById(R.id.result);
    }


    @Override
    public void onClick(View view) {
        if(view == btnReset){
            initView();
        }else if( view == btnCal) {
            cal();
        }
    }

    private void cal() {
        int id = radioGroupS.getCheckedRadioButtonId();
        int result_value = 0;
        int x = getValueX();
        int y = getValueY();
        if(id == radioPlus.getId()){
            result_value = plusFunction(x,y);
        }else if(id == radioDelete.getId()){
            result_value = deleteFunction(x,y);
        }else if(id == radioMul.getId()){
            result_value = mulFunction(x,y);
        }else if(id == radioDivide.getId()){
            result_value = divFunction(x,y);
        }
        result.setText(String.valueOf(result_value));
    }


    private int getValueX() {
        if(editX.getText() != null && !editX.getText().toString().isEmpty()){
            return Integer.parseInt(editX.getText().toString());
        }
        return 0;
    }

    private int getValueY() {
        if(editY.getText() != null && !editY.getText().toString().isEmpty()){
            return Integer.parseInt(editY.getText().toString());
        }
        return 0;
    }

    private int plusFunction (int x , int y) {
        return  x + y;
    }
    private int deleteFunction (int x , int y) {
        return  x - y;
    }
    private int mulFunction (int x , int y) {
        return  x * y;
    }
    private int divFunction (int x , int y) {
        return  x / y;
    }

}
