package jp.techacademy.yasuhiro.tsukada.calcapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);




    }

    

    @Override
    public void onClick(View v) {

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        editText1.setInputType
                ( InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editText2.setInputType
                (InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        String string1 = editText1.getText().toString();
        System.out.println(string1);
        if (string1.equals("")) {
        return;
        }
            double stringToValue1 = Double.parseDouble(string1);
        String string2 = editText2.getText().toString();
        System.out.println(string2);
        if (string2.equals("")) {
            return;
        }
        double stringToValue2 = Double.parseDouble(string2);

        double result = 0.0;

        BigDecimal a = new BigDecimal(string1);
        BigDecimal b = new BigDecimal(string2);


        //if文の中で変数を宣言してしまえばいいのだ！
        //System.out.printInなんて忘れろ！


        if (v.getId() == R.id.button1) {
//            result = stringToValue1 + stringToValue2;
            result = a.add(b).doubleValue();
        } else if (v.getId() == R.id.button2) {
//            result = stringToValue1 - stringToValue2;
            result = a.subtract(b).doubleValue();
        } else if (v.getId() == R.id.button3) {
//            result = stringToValue1 * stringToValue2;
            result = a.multiply(b).doubleValue();
        } else if (v.getId() == R.id.button4) {
           result = stringToValue1 / stringToValue2;
        }
        System.out.println(stringToValue1);
        System.out.println(stringToValue2);
        System.out.println(result);
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("Result", result );


        startActivity(intent);
    }
}
