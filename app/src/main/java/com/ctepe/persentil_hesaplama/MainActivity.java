package com.ctepe.persentil_hesaplama;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    NumberPicker age;
    EditText height = null, weight = null, bas_cevresi;

    Button btn_erkek, btn_kiz;

    String h,w,a,b;

    int a2;

    public static String flag = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        age = (NumberPicker) findViewById(R.id.numpick_yas);

        weight = (EditText) findViewById(R.id.edit_agirlik);
        height = (EditText) findViewById(R.id.edit_boy);
        bas_cevresi = (EditText) findViewById(R.id.edit_bas_cevresi);

        btn_erkek = (Button) findViewById(R.id.btn_erkek);
        btn_kiz = (Button) findViewById(R.id.btn_kiz);

        age.setMaxValue(40);
        age.setMinValue(0);
        age.setValue(2);
        age.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        age.setWrapSelectorWheel(true);

        age.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {

                if (value * 0.25 <= 1.5) {
                    return Double.toString(value * 0.25);
                } else {
                    return Double.toString((value - 7) * 0.5 + 2);
                }

            }
        });


        btn_erkek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (weight.getText().toString().trim().length() == 0)  {
                    Toast.makeText(getApplicationContext(), "Agirlik ve Boy Degerini Giriniz", Toast.LENGTH_SHORT).show();
                }
                else if (height.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "Agirlik ve Boy Degerini Giriniz", Toast.LENGTH_SHORT).show();
                }
                else {

                    w = weight.getText().toString();
                    h = height.getText().toString();
                    b = bas_cevresi.getText().toString();

                    a2 = age.getValue();
                    a = String.valueOf(a2);

                    flag = "erkek";


                    Intent weight_erkek_intent = new Intent(getApplicationContext(), weight_erkek.class);

                    weight_erkek_intent.putExtra("weight", w);
                    weight_erkek_intent.putExtra("height", h);
                    weight_erkek_intent.putExtra("age", a);
                    weight_erkek_intent.putExtra("bas_cevresi", b);

                    startActivity(weight_erkek_intent);
                }






            }
        });


        btn_kiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (weight.getText().toString().trim().length() == 0)  {
                    Toast.makeText(getApplicationContext(), "Agirlik ve Boy Degerini Giriniz", Toast.LENGTH_SHORT).show();
                }
                else if (height.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "Agirlik ve Boy Degerini Giriniz", Toast.LENGTH_SHORT).show();
                }
                else {


                    w = weight.getText().toString();
                    h = height.getText().toString();
                    b = bas_cevresi.getText().toString();

                    a2 = age.getValue();
                    a = String.valueOf(a2);

                    flag = "kiz";


                    Intent weight_kiz_intent = new Intent(getApplicationContext(), weight_kiz.class);

                    weight_kiz_intent.putExtra("weight", w);
                    weight_kiz_intent.putExtra("height", h);
                    weight_kiz_intent.putExtra("age", a);
                    weight_kiz_intent.putExtra("bas_cevresi", b);

                    startActivity(weight_kiz_intent);
                }
            }
        });


    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
