package com.ctepe.persentil_hesaplama;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;


public class weight_kiz extends ActionBarActivity {

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
        dis_layout.setBackgroundColor(Color.parseColor("#50fcd9ff"));

        yas_text = (TextView) findViewById(R.id.textView1);
        agirlik_text = (TextView) findViewById(R.id.textView2);
        boy_text = (TextView) findViewById(R.id.textView3);
        bas_cevre_text = (TextView) findViewById(R.id.textView4);



        yas_text.setBackgroundResource(R.drawable.cell_shape_kiz);
        agirlik_text.setBackgroundResource(R.drawable.cell_shape_kiz);
        boy_text.setBackgroundResource(R.drawable.cell_shape_kiz);
        bas_cevre_text.setBackgroundResource(R.drawable.cell_shape_kiz);



        yas = (TextView) findViewById(R.id.text_yas);
        agirlik = (TextView) findViewById(R.id.text_agirlik);
        boy = (TextView) findViewById(R.id.text_boy);
        bas_cevresi = (TextView) findViewById(R.id.text_bas_cev);


        yas.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
        agirlik.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
        boy.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
        bas_cevresi.setBackgroundResource(R.drawable.cell_shape_ic_kiz);


        Intent weight_kiz_intent = getIntent();

        String w = weight_kiz_intent.getStringExtra("weight");
        String h = weight_kiz_intent.getStringExtra("height");
        String a = weight_kiz_intent.getStringExtra("age");
        String b = weight_kiz_intent.getStringExtra("bas_cevresi");

        w2 = Double.parseDouble(w);
        h2 = Double.parseDouble(h);
        a2 = Double.parseDouble(a);
        b2 = Double.parseDouble(b);

        if (a2 * 0.25 <= 1.5) {
            a2 = a2 * 0.25;
        } else {
            a2 = ((a2 - 7) * 0.5 + 2);
        }

        yas.setText("" + a2);
        agirlik.setText("" + w2);
        boy.setText("" + h2);
        bas_cevresi.setText("" + b2);


        double[ ][ ] agirlik={
                {0,2.6,2.8,3.1,3.4,3.7,3.9,4.3},
                {0.25,4,4.4,4.8,5.4,6,6.4,7},
                {0.5,5.4,6.1,6.8,7.4,8,8.6,9.2},
                {0.75,6.4,7.3,8,8.6,9.5,10,10.8},
                {1,7.1,8.1,8.9,9.6,10.6,11,12.1},
                {1.25,7.7,8.7,9.6,10.4,11.4,11.9,13},
                {1.5,8.3,9.3,10.2,11,12,12.6,13.7},
                {2,9.2,10.4,11.3,12.2,13.1,13.8,15.1},
                {2.5,9.9,11.3,12.2,13.1,14.1,15,16.3},
                {3,10.6,12,13,14,15,16.1,17.5},
                {3.5,11.2,12.6,13.7,15,16.3,17.4,19},
                {4,11.6,13.2,14.4,16,17.5,18.9,20.6},
                {4.5,12,13.9,15.3,17.1,18.8,20.4,22},
                {5,12.6,14.6,16.3,18.2,20,21.7,23.8},
                {5.5,13.2,15.2,17.1,19.2,21.1,23.2,25.2},
                {6,13.7,16,18.1,20.2,22.5,24.6,25.6},
                {6.5,14.4,16.6,19.1,21.3,23.7,26.1,28.3},
                {7,15.3,17.5,20.1,22.5,25.2,27.6,30},
                {7.5,16.2,18.6,21.2,23.8,27,29.2,31.8},
                {8,17.3,19.9,22.6,25.4,28.8,31.2,34},
                {8.5,18.6,21.5,24,27.4,30.8,33.3,36.5},
                {9,20,23.1,26,29.4,32.8,35.8,39},
                {9.5,21.6,24.8,28,31.7,35.2,38.6,42},
                {10,23,26.6,30.2,34,38.2,41.5,45},
                {10.5,24.8,28.5,32.7,37,41.2,44.8,49.3},
                {11,26.5,30.7,35.2,40,44.4,48.8,53.5},
                {11.5,28.3,32.8,37.6,42.4,47.3,52.4,56.6},
                {12,30.4,35,40,44.8,49.7,54.6,59.2},
                {12.5,32.5,37.4,42,46.8,51.6,56.6,61.5},
                {13,34.6,39.8,44,48.8,53.3,58.3,63.3},
                {13.5,36.5,41.5,45.9,50.5,55,59.5,65},
                {14,38,42.9,47.4,51.8,56.3,60.7,66.3},
                {14.5,39.3,44,48.6,52.8,57.4,61.6,67.5},
                {15,40.3,45,49.6,53.6,58.4,62.3,68.4},
                {15.5,41,46,50.6,54.4,59.3,63.1,69.2},
                {16,41.8,46.7,51.2,55,58,63.8,70},
                {16.5,42.5,47.2,51.8,55.5,60.4,64.5,70.5},
                {17,43,47.6,52.5,56,60.9,65,71},
                {17.5,43,47.6,52.5,56,60.9,65,71},
                {18,43,47.6,52.5,56,60.9,65,71},


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
                {0,47.1,47.8,49,50.2,51,51,9,53,6},
                {0.25,54,55.5,57.5,58.5,60,62.5,64.5},
                {0.5,58,60,62,64.5,66.5,68.5,70.5},
                {0.75,61.5,64.5,66.5,69.5,71,73,75.5},
                {1,64.5,68,70,73,75,77,80},
                {1.25,68,71.5,73.5,76.5,78.5,81,84.5},
                {1.5,71,75,76.5,79.5,82,84.5,88.5},
                {2,76.5,80,83.5,85.5,88.5,91,95},
                {2.5,81.5,85,88,90.5,94,96.5,100},
                {3,85.5,88.5,92,95,98.5,101,104.5},
                {3.5,89,92.5,95.5,98.5,101.5,105,108.5},
                {4,92,95.5,98.5,101.5,105,108,112},
                {4.5,94.7,98,101.5,105,108.8,111.5,115},
                {5,97.5,101.5,104,108,111,114.5,118.5},
                {5.5,100.5,104,107,111,114,117.5,121.5},
                {6,103,107,110,114,117.5,121,125},
                {6.5,105.5,110,113,117,120.5,124,128},
                {7,112,116,119,122.5,126.5,130,134},
                {7.5,112,116,119,122.5,126.5,130,134},
                {8,115,119,121.5,125.5,129.5,130,137},
                {8.5,117,121.5,124.5,128,132,136,140},
                {9,120.5,124.5,127.5,130.5,134.5,138.5,143},
                {9.5,123,127.5,130,133.5,137.5,141.5,146},
                {10,125.5,130,133.5,137,141,144.5,149},
                {10.5,129.5,133.5,137,141,144.5,148.5,153},
                {11,133.5,137.5,141,145,149,152.5,157.5},
                {11.5,137,141.5,145,149,153,157,161.5},
                {12,140.5,145,148,152.5,156.5,160.5,165},
                {12.5,143,147,150.5,154.5,158.5,163,167.5},
                {13,144.5,149,152,156,160,165,169},
                {13.5,146,150,153,157.5,161.5,165.5,170},
                {14,147.5,151,154,158.5,162,166,170.4},
                {14.5,148,151.5,154.5,159,162.5,166.5,170.7},
                {15,148.5,151.7,154.5,159.5,163,166.5,171},
                {15.5,148.5,152,155,159.6,163,166.5,171},
                {16,148.5,152,155,159,163,166.5,171},
                {16.5,148.5,152,155,160,163,166.5,171},
                {17,148.5,152.5,155,160,163,166.5,171},
                {17.5,148.5,152.5,155,160,163,166.5,171},
                {18,148.5,152.5,155,160,163,166.5,171},


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
                {0,32.5,33.4,33.9,34.7,35.4,36,36.6},
                {0.25,37.9,38.5,39.2,40,40.8,41.7,42.3},
                {0.5,40.9,41.4,42,42.8,43.6,44.5,45.4},
                {0.75,42.6,43.2,43.8,44.6,45.4,46.3,47.2},
                {1,43.6,44.3,45,45.8,46.7,47.7,48.7},
                {1.25,44.3,44.9,45.6,46.5,47.4,48.4,49.7},
                {1.5,44.9,45.5,46.2,47.1,48,49,49.8},
                {2,45.8,46.4,47.2,48.1,49.1,50.1,50.9},
                {2.5,46.3,47,47.8,48,49.8,50.8,51.5},
                {3,46.8,47.5,48.4,49.3,50.3,51.1,52},


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
        getMenuInflater().inflate(R.menu.menu_weight_kiz, menu);
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
