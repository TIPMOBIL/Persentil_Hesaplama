package com.ctepe.persentil_hesaplama;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;


public class weight_erkek extends ActionBarActivity {

    TextView yas, agirlik, boy, bas_cevresi;
    TextView yas_text, agirlik_text, boy_text, bas_cevre_text;

    Double w2,h2,a2, b2, vucut_alan, boy_gore_agirlik, boy_agirlik_dummy;

    LinearLayout dis_layout;

    public static String weight_ideal_sonuc, weight_persentil_sonuc, height_ideal_sonuc, height_persentil_sonuc, bas_cevre_ideal_sonuc, bas_cevre_persentil_sonuc, vucut_alan_sonuc, boya_gore_agirlik_sonuc;

    ViewPager pager;
    persentil_adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persentil_deger);

        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new persentil_adapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        dis_layout = (LinearLayout) findViewById(R.id.dis_layout);
        dis_layout.setBackgroundColor(Color.parseColor("#5ac6fff4"));

        yas_text = (TextView) findViewById(R.id.textView1);
        agirlik_text = (TextView) findViewById(R.id.textView2);
        boy_text = (TextView) findViewById(R.id.textView3);
        bas_cevre_text = (TextView) findViewById(R.id.textView4);

        yas_text.setBackgroundResource(R.drawable.cell_shape_erkek);
        agirlik_text.setBackgroundResource(R.drawable.cell_shape_erkek);
        boy_text.setBackgroundResource(R.drawable.cell_shape_erkek);
        bas_cevre_text.setBackgroundResource(R.drawable.cell_shape_erkek);


        yas = (TextView) findViewById(R.id.text_yas);
        agirlik = (TextView) findViewById(R.id.text_agirlik);
        boy = (TextView) findViewById(R.id.text_boy);
        bas_cevresi = (TextView) findViewById(R.id.text_bas_cev);


        yas.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
        agirlik.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
        boy.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
        bas_cevresi.setBackgroundResource(R.drawable.cell_shape_ic_erkek);


        Intent weight_erkek_intent = getIntent();

        String w = weight_erkek_intent.getStringExtra("weight");
        String h = weight_erkek_intent.getStringExtra("height");
        String a = weight_erkek_intent.getStringExtra("age");
        String b = weight_erkek_intent.getStringExtra("bas_cevresi");

        w2 = Double.parseDouble(w);
        h2 = Double.parseDouble(h);
        a2 = Double.parseDouble(a);
        b2 = Double.parseDouble(b);

        if (a2 * 0.25  <= 1.5) {
            a2 = a2 * 0.25;
        } else {
            a2 = ((a2 - 7) * 0.5 + 2);
        }

        yas.setText("" + a2);
        agirlik.setText("" + w2);
        boy.setText("" + h2);
        bas_cevresi.setText("" + b2);


        double[ ][ ] agirlik={
                {0,2.6,2.9,3.1,3.4,3.8,4.1,4.6},
                {0.25,4.1,4.7,5.3,5.9,6.4,6.9,7.5},
                {0.5,5.6,6.5,7.1,7.8,8.5,9.1,9.7},
                {0.75,6.5,7.5,8.2,9,9.8,10.6,11.3},
                {1,7.4,8.4,9,10,10.8,11.7,12.5},
                {1.25,8.1,9.1,9.9,10.8,11.7,12.5,13.5},
                {1.5,8.7,9.7,10.5,11.5,12.5,13.3,13.7},
                {2,9.1,10.2,11,12.1,13.2,14.1,15},
                {2.5,10.3,11.5,12.5,13.6,14.8,15.9,17},
                {3,11.1,12.3,13.3,14.6,15.8,17.1,18.3},
                {3.5,11.7,12.9,14.2,15.6,17,18.2,19.6},
                {4,12.3,13.6,15.1,16.7,18.4,19.5,21.1},
                {4.5,12.7,14.3,16.1,17.7,19.5,20.8,22.6},
                {5,13.4,15,17,18.7,20.7,22.5,24},
                {5.5,14.1,16,17.9,19.7,22,23.6,25.5},
                {6,14.8,17,18.8,20.8,23,24.9,26.8},
                {6.5,15.6,18,19.7,22,24.3,26.3,28.4},
                {7,16.4,19.1,20.8,23.2,25.6,27.8,30.1},
                {7.5,17.3,20.2,21.8,24.7,27.2,29.3,31.9},
                {8,18.1,21.2,23.1,26.1,28.7,31,33.8},
                {8.5,19,22.4,24.5,27.5,30.4,33,36.1},
                {9,19.9,23.5,25.9,29.5,32.2,35.3,38.6},
                {9.5,21,24.6,27.6,31.6,34.8,38.1,41.8},
                {10,22,25.9,29.5,33.7,37.4,42,45.7},
                {10.5,22.9,27.2,31.1,36.1,40,45.2,49.5},
                {11,24.1,28.5,32.9,38.5,43,48.3,52.8},
                {11.5,25.4,30.9,35,40.8,45.6,51.5,56.6},
                {12,26.7,31.6,36.9,43.1,48.5,54.5,60.1},
                {12.5,28.3,33.3,39,45.6,51.2,57.8,64},
                {13,30,35.4,41,48,54,60.7,67.5},
                {13.5,37,37.6,43.3,50.4,56.8,63.6,70.4},
                {14,34.2,40,45.6,52.8,59.8,66.4,72.8},
                {14.5,36.8,42.7,48.3,55.6,62.5,69.3,75.5},
                {15,39.5,45.3,51,58.3,65,71.6,77.6},
                {15.5,42.1,47.8,53.5,60.9,67.5,73.6,79.5},
                {16,44.9,50.5,56,63.3,69.8,75.3,80.8},
                {16.5,47.4,52.8,58.1,65,71.5,76.6,82},
                {17,49.4,54.7,59.9,68.2,72.7,77.5,82.7},
                {17.5,49.4,54.7,59.9,68.2,72.7,77.5,82.7},
                {18,49.4,54.7,59.9,68.2,72.7,77.5,82.7},

        };

        int i=0;
        while (agirlik [i][0]!=a2) {

            i++;
        }

        weight_ideal_sonuc = ("" + agirlik [i][4]);


        int[] persentil = {0,3,10,25,50,75,90,97};

        int j=1;


        if (agirlik [i][7]<w2){
            weight_persentil_sonuc = (">" + persentil[7] + "p");

        }
        else if (agirlik [i][1]>w2){
            weight_persentil_sonuc = ("<" + persentil[1] + "p");

        }
        else {
            while (agirlik[i][j] < w2) {
                j++;

            }

            if (agirlik[i][j]==w2) {
                weight_persentil_sonuc = ("" + persentil[j] + "p");
            }
            else {
                weight_persentil_sonuc = ("" + persentil[j - 1] + "-" + persentil[j] + "p");

            }
        }




        double[][] boy = {
                {0,46.3,48.1,49.3,50.6,52,53.3,54.6},
                {0.25,54.5,56,58,60,61.5,63,66},
                {0.5,59.5,61.5,64,66.5,67.5,69,72.5},
                {0.75,64,66,68.5,71,72.5,74.3,77.5},
                {1,68,70.4,72.5,74.7,76.5,78.5,82.5},
                {1.25,71.5,73.7,76,78,80.5,82.5,86.5},
                {1.5,75,77,79.5,81.5,84,86.5,89.5},
                {2,77,80,82,84,86.5,88.7,92.5},
                {2.5,83.5,86.2,89,91,94,96.4,100},
                {3,86.7,90,92.5,95.3,98.5,100.5,105},
                {3.5,89.7,93.5,96.5,99,102,105,109.5},
                {4,92.5,96.5,99.5,102.5,106,109,114},
                {4.5,95.5,99.5,103,106.4,110,112.5,118},
                {5,98,102.5,106,109.5,113,116,121.5},
                {5.5,101.3,105.6,109,113,116.5,119,125},
                {6,104,108.5,112,116,119,122.5,127.5},
                {6.5,106.7,111.7,115,119,122,125,130.5},
                {7,109.5,114.7,118,121.5,125,128,133.5},
                {7.5,112.3,117.5,121,124,128,131,136.5},
                {8,115,120.3,123.8,127,131,134,139.5},
                {8.5,117.5,122.5,126,129.5,133.5,137,142.5},
                {9,120,125.3,128.5,132,136.5,140,145.5},
                {9.5,122.5,127.8,131,135,139,143,148},
                {10,125,130,133.5,137.5,142,146,151.5},
                {10.5,127.5,132.5,136,140.6,144.5,149,155},
                {11,130,135.3,139,143.5,147.5,152,158},
                {11.5,132.5,138,142,146.5,151,155.5,161.5},
                {12,135,140.5,145,150,154.5,159,165},
                {12.5,137.5,143.5,147.5,153,157.5,162.5,168.5},
                {13,140.5,146,150,156,161,166,171.5},
                {13.5,143,149,153,159,164.5,169.5,175},
                {14,146.5,152,156,162,167.5,172.5,178.5},
                {14.5,149,155,159,165,170,175.5,181},
                {15,152.5,157.5,162,168,172.5,178,182.5},
                {15.5,155.5,160,165,170.5,175,179.5,184},
                {16,158,162.5,167,172.5,176.5,181,185},
                {16.5,160,164,169,173.5,177.5,181.5,185},
                {17,162,166,169.5,173.5,178,182.5,185.5},
                {17.5,162,166,169.5,173.5,178,182.5,185.5},
                {18,162,166,169.5,173.5,178,182.5,185.5},

        };

        int x=0;
        while (boy [x][0]!=a2) {

            x++;
        }

        height_ideal_sonuc = ("" + boy [x][4]);


        int y=1;


        if (boy [x][7]<h2){
            height_persentil_sonuc = (">" + persentil[7] + "p");
        }
        else if (boy [x][1]>h2){
            height_persentil_sonuc = ("<" + persentil[1] + "p");

        }
        else {
            while (boy[x][y] < h2) {
                y++;

            }
            if (boy[x][y]==h2) {
                height_persentil_sonuc = ("" + persentil[y] + "p");

            }
            else {
                height_persentil_sonuc = ("" + persentil[y - 1] + "-" + persentil[y] + "p");


            }

        }




        DecimalFormat vucut_alan_digit = new DecimalFormat("0.000");
        vucut_alan = (w2*4+7)/(w2+90);

        vucut_alan_sonuc = vucut_alan_digit.format(vucut_alan);




        int m = 0;


        while((h2 > boy[m][4]) && (m<40)){
            m++;
        }

        if (m!=0) {
            m--;
        }


        boy_agirlik_dummy = (boy [m][4] + boy [m+1] [4]) / 2 ;

        if (h2 > boy_agirlik_dummy){
            m++;
        }

        boy_gore_agirlik = 100* w2 / agirlik[m][4];

        boya_gore_agirlik_sonuc = vucut_alan_digit.format(boy_gore_agirlik);



        double[][] bas_cevresi = {
                {0, 33, 33.5, 34.4, 35.3, 36.2, 37, 37.5},
                {0.25, 38.7, 39.2, 40, 40.9, 41.5, 42.1, 43.2},
                {0.5, 42.1, 42.7, 43.3, 43.9, 44.8, 45, 45},
                {0.75, 43.8, 44.5, 45.1, 46, 46.5, 47.1, 47.8},
                {1, 44.9, 45.5, 46.5, 47.3, 47.8, 48.4, 48.9},
                {1.25, 45.6, 46.3, 47.1, 48, 48.5, 49.2, 49.9},
                {1.5, 46.2, 47, 47.7, 48.7, 49.2, 49.9, 50.6},
                {2, 47, 48, 48.2, 49.7, 50.2, 51, 51.7},
                {2.5, 47.5, 48.5, 49.2, 50.2, 50.9, 51.6, 52.3},
                {3, 47.9, 48.9, 49.6, 50.4, 51.3, 51.9, 52.7},

        };

        int k=0;



        if (a2<=3) {
            while (bas_cevresi[k][0] != a2) {

                k++;
            }


            bas_cevre_ideal_sonuc = ("" + bas_cevresi[x][4]);

            int l = 1;



            if (bas_cevresi[k][7] < b2) {
                bas_cevre_persentil_sonuc = (">" + persentil[7] + "p");
            } else if (bas_cevresi[k][1] > b2) {
                bas_cevre_persentil_sonuc = ("<" + persentil[1] + "p");
            } else {
                while (bas_cevresi[k][l] < b2) {
                    l++;

                }
                if (bas_cevresi[k][l] == b2) {
                    bas_cevre_persentil_sonuc = ("" + persentil[l] + "p");
                } else {
                    bas_cevre_persentil_sonuc = ("" + persentil[l - 1] + "-" + persentil[l] + "p");

                }

            }
        }
        else {

            bas_cevre_ideal_sonuc = ("-");
            bas_cevre_persentil_sonuc = ("-");

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weight_erkek, menu);
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
