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
    public static String sistolik_50_sonuc,sistolik_90_sonuc,sistolik_95_sonuc,sistolik_99_sonuc, diastolik_50_sonuc,diastolik_90_sonuc,diastolik_95_sonuc,diastolik_99_sonuc;


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
        //dis_layout.setBackgroundColor(Color.parseColor("#50fcd9ff"));

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
        pager = (ViewPager) findViewById(R.id.pager);


        yas.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
        agirlik.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
        boy.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
        bas_cevresi.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
        pager.setBackgroundResource(R.drawable.cell_shape_ic_kiz_fragment);


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

        while((h2 > boy[m][4]) && (m<39)){
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

        DecimalFormat kan_basinc = new DecimalFormat("0");

        double[][] sistolik_50 = {
                {0,83,83,84,85,86,88,89,90},
                {0.25,83,83,84,85,86,88,89,90},
                {0.5,83,83,84,85,86,88,89,90},
                {0.75,83,83,84,85,86,88,89,90},
                {1,83,83,84,85,86,88,89,90},
                {1.25,83,83,84,85,86,88,89,90},
                {1.5,83,83,84,85,86,88,89,90},
                {2,85,85,85,87,88,89,91,91},
                {2.5,85,85,85,87,88,89,91,91},
                {3,86,86,87,88,89,91,92,93},
                {3.5,86,86,87,88,89,91,92,93},
                {4,88,88,88,90,91,92,94,94},
                {4.5,88,88,88,90,91,92,94,94},
                {5,89,89,90,91,93,94,95,96},
                {5.5,89,89,90,91,93,94,95,96},
                {6,91,91,92,93,94,96,97,98},
                {6.5,91,91,92,93,94,96,97,98},
                {7,93,93,93,95,96,97,99,99},
                {7.5,93,93,93,95,96,97,99,99},
                {8,95,95,95,96,98,99,100,101},
                {8.5,95,95,95,96,98,99,100,101},
                {9,96,96,97,98,100,101,102,103},
                {9.5,96,96,97,98,100,101,102,103},
                {10,98,98,99,100,102,103,104,105},
                {10.5,98,98,99,100,102,103,104,105},
                {11,100,100,101,102,103,105,106,107},
                {11.5,100,100,101,102,103,105,106,107},
                {12,102,102,103,104,105,107,108,109},
                {12.5,102,102,103,104,105,107,108,109},
                {13,104,104,105,106,107,109,110,110},
                {13.5,104,104,105,106,107,109,110,110},
                {14,106,106,106,107,109,110,111,112},
                {14.5,106,106,106,107,109,110,111,112},
                {15,107,107,108,109,110,111,113,113},
                {15.5,107,107,108,109,110,111,113,113},
                {16,108,108,108,110,111,112,114,114},
                {16.5,108,108,108,110,111,112,114,114},
                {17,108,108,109,110,111,113,114,115},
                {17.5,108,108,109,110,111,113,114,115},
                {18,108,108,109,110,111,113,114,115},


        };

        if(a2>=1){

            if (boy [x][7]<h2){
                sistolik_50_sonuc = kan_basinc.format(sistolik_50[x][8]);

            }
            else {
                sistolik_50_sonuc = kan_basinc.format(sistolik_50[x][y]);
            }

        }
        else {
            sistolik_50_sonuc = ("-");
        }


        double[][] sistolik_90 = {
                {0,97,97,97,98,100,101,102,103},
                {0.25,97,97,97,98,100,101,102,103},
                {0.5,97,97,97,98,100,101,102,103},
                {0.75,97,97,97,98,100,101,102,103},
                {1,97,97,97,98,100,101,102,103},
                {1.25,97,97,97,98,100,101,102,103},
                {1.5,97,97,97,98,100,101,102,103},
                {2,98,98,99,100,101,103,104,105},
                {2.5,98,98,99,100,101,103,104,105},
                {3,100,100,100,102,103,104,106,106},
                {3.5,100,100,100,102,103,104,106,106},
                {4,101,101,102,103,104,106,107,108},
                {4.5,101,101,102,103,104,106,107,108},
                {5,103,103,103,105,106,107,109,109},
                {5.5,103,103,103,105,106,107,109,109},
                {6,104,104,105,106,108,109,110,111},
                {6.5,104,104,105,106,108,109,110,111},
                {7,106,106,107,108,109,111,112,113},
                {7.5,106,106,107,108,109,111,112,113},
                {8,108,108,109,110,111,113,114,114},
                {8.5,108,108,109,110,111,113,114,114},
                {9,110,110,110,112,113,114,116,116},
                {9.5,110,110,110,112,113,114,116,116},
                {10,112,112,112,114,115,116,118,118},
                {10.5,112,112,112,114,115,116,118,118},
                {11,114,114,114,116,117,118,119,120},
                {11.5,114,114,114,116,117,118,119,120},
                {12,116,116,116,117,119,120,121,122},
                {12.5,116,116,116,117,119,120,121,122},
                {13,117,117,118,119,121,122,123,124},
                {13.5,117,117,118,119,121,122,123,124},
                {14,119,119,120,121,122,124,125,125},
                {14.5,119,119,120,121,122,124,125,125},
                {15,120,120,121,122,123,125,126,127},
                {15.5,120,120,121,122,123,125,126,127},
                {16,121,121,122,123,124,126,127,128},
                {16.5,121,121,122,123,124,126,127,128},
                {17,122,122,122,123,125,126,127,128},
                {17.5,122,122,122,123,125,126,127,128},
                {18,122,122,122,123,125,126,127,128},


        };

        if(a2>=1){

            if (boy [x][7]<h2){
                sistolik_90_sonuc = kan_basinc.format(sistolik_90[x][8]);

            }
            else {
                sistolik_90_sonuc = kan_basinc.format(sistolik_90[x][y]);
            }

        }
        else {
            sistolik_90_sonuc = ("-");
        }


        double[][] sistolik_95 = {
                {0,100,100,101,102,104,105,106,107},
                {0.25,100,100,101,102,104,105,106,107},
                {0.5,100,100,101,102,104,105,106,107},
                {0.75,100,100,101,102,104,105,106,107},
                {1,100,100,101,102,104,105,106,107},
                {1.25,100,100,101,102,104,105,106,107},
                {1.5,100,100,101,102,104,105,106,107},
                {2,102,102,103,104,105,107,108,109},
                {2.5,102,102,103,104,105,107,108,109},
                {3,104,104,104,105,107,108,109,110},
                {3.5,104,104,104,105,107,108,109,110},
                {4,105,105,106,107,108,110,111,112},
                {4.5,105,105,106,107,108,110,111,112},
                {5,107,107,107,108,110,111,112,113},
                {5.5,107,107,107,108,110,111,112,113},
                {6,108,108,109,110,111,113,114,115},
                {6.5,108,108,109,110,111,113,114,115},
                {7,110,110,111,112,113,115,116,116},
                {7.5,110,110,111,112,113,115,116,116},
                {8,112,112,112,114,115,116,118,118},
                {8.5,112,112,112,114,115,116,118,118},
                {9,114,114,114,115,117,118,119,120},
                {9.5,114,114,114,115,117,118,119,120},
                {10,116,116,116,117,119,120,121,122},
                {10.5,116,116,116,117,119,120,121,122},
                {11,118,118,118,119,121,122,123,124},
                {11.5,118,118,118,119,121,122,123,124},
                {12,119,119,120,121,123,124,125,126},
                {12.5,119,119,120,121,123,124,125,126},
                {13,121,121,122,123,124,126,127,128},
                {13.5,121,121,122,123,124,126,127,128},
                {14,123,123,123,125,126,127,129,129},
                {14.5,123,123,123,125,126,127,129,129},
                {15,124,124,125,126,127,129,130,131},
                {15.5,124,124,125,126,127,129,130,131},
                {16,125,125,126,127,128,130,131,132},
                {16.5,125,125,126,127,128,130,131,132},
                {17,125,125,126,127,129,130,131,132},
                {17.5,125,125,126,127,129,130,131,132},
                {18,125,125,126,127,129,130,131,132},



        };

        if(a2>=1){

            if (boy [x][7]<h2){
                sistolik_95_sonuc = kan_basinc.format(sistolik_95[x][8]);

            }
            else {
                sistolik_95_sonuc = kan_basinc.format(sistolik_95[x][y]);
            }

        }
        else {
            sistolik_95_sonuc = ("-");
        }


        double[][] sistolik_99 = {
                {0,108,108,108,109,111,112,113,114},
                {0.25,108,108,108,109,111,112,113,114},
                {0.5,108,108,108,109,111,112,113,114},
                {0.75,108,108,108,109,111,112,113,114},
                {1,108,108,108,109,111,112,113,114},
                {1.25,108,108,108,109,111,112,113,114},
                {1.5,108,108,108,109,111,112,113,114},
                {2,109,109,110,111,112,114,115,116},
                {2.5,109,109,110,111,112,114,115,116},
                {3,111,111,111,113,114,115,116,117},
                {3.5,111,111,111,113,114,115,116,117},
                {4,112,112,113,114,115,117,118,119},
                {4.5,112,112,113,114,115,117,118,119},
                {5,114,114,114,116,117,118,120,120},
                {5.5,114,114,114,116,117,118,120,120},
                {6,115,115,116,117,119,120,121,122},
                {6.5,115,115,116,117,119,120,121,122},
                {7,117,117,118,119,120,122,123,124},
                {7.5,117,117,118,119,120,122,123,124},
                {8,119,119,120,121,122,123,125,125},
                {8.5,119,119,120,121,122,123,125,125},
                {9,121,121,121,123,124,125,127,127},
                {9.5,121,121,121,123,124,125,127,127},
                {10,123,123,123,125,126,127,129,129},
                {10.5,123,123,123,125,126,127,129,129},
                {11,125,125,125,126,128,129,130,131},
                {11.5,125,125,125,126,128,129,130,131},
                {12,127,127,127,128,130,131,132,133},
                {12.5,127,127,127,128,130,131,132,133},
                {13,128,128,129,130,132,133,134,135},
                {13.5,128,128,129,130,132,133,134,135},
                {14,130,130,131,132,133,135,136,136},
                {14.5,130,130,131,132,133,135,136,136},
                {15,131,131,132,133,134,136,137,138},
                {15.5,131,131,132,133,134,136,137,138},
                {16,132,132,133,134,135,137,138,139},
                {16.5,132,132,133,134,135,137,138,139},
                {17,133,133,133,134,136,137,138,139},
                {17.5,133,133,133,134,136,137,138,139},
                {18,133,133,133,134,136,137,138,139},



        };

        if(a2>=1){

            if (boy [x][7]<h2){
                sistolik_99_sonuc = kan_basinc.format(sistolik_99[x][8]);

            }
            else {
                sistolik_99_sonuc = kan_basinc.format(sistolik_99[x][y]);
            }

        }
        else {
            sistolik_99_sonuc = ("-");
        }


        double[][] diastolik_50 = {
                {0,38,38,39,39,40,41,41,42},
                {0.25,38,38,39,39,40,41,41,42},
                {0.5,38,38,39,39,40,41,41,42},
                {0.75,38,38,39,39,40,41,41,42},
                {1,38,38,39,39,40,41,41,42},
                {1.25,38,38,39,39,40,41,41,42},
                {1.5,38,38,39,39,40,41,41,42},
                {2,43,43,44,44,45,46,46,47},
                {2.5,43,43,44,44,45,46,46,47},
                {3,47,47,48,48,49,50,50,51},
                {3.5,47,47,48,48,49,50,50,51},
                {4,50,50,50,51,52,52,53,54},
                {4.5,50,50,50,51,52,52,53,54},
                {5,52,52,53,53,54,55,55,56},
                {5.5,52,52,53,53,54,55,55,56},
                {6,54,54,54,55,56,56,57,58},
                {6.5,54,54,54,55,56,56,57,58},
                {7,55,55,56,56,57,58,58,59},
                {7.5,55,55,56,56,57,58,58,59},
                {8,57,57,57,57,58,59,60,60},
                {8.5,57,57,57,57,58,59,60,60},
                {9,58,58,58,58,59,60,61,61},
                {9.5,58,58,58,58,59,60,61,61},
                {10,59,59,59,59,60,61,62,62},
                {10.5,59,59,59,59,60,61,62,62},
                {11,60,60,60,60,61,62,63,63},
                {11.5,60,60,60,60,61,62,63,63},
                {12,61,61,61,61,62,63,64,64},
                {12.5,61,61,61,61,62,63,64,64},
                {13,62,62,62,62,63,64,65,65},
                {13.5,62,62,62,62,63,64,65,65},
                {14,63,63,63,63,64,65,66,66},
                {14.5,63,63,63,63,64,65,66,66},
                {15,64,64,64,64,65,66,67,67},
                {15.5,64,64,64,64,65,66,67,67},
                {16,64,64,64,65,66,66,67,68},
                {16.5,64,64,64,65,66,66,67,68},
                {17,64,64,65,65,66,67,67,68},
                {17.5,64,64,65,65,66,67,67,68},
                {18,64,64,65,65,66,67,67,68},



        };

        if(a2>=1){

            if (boy [x][7]<h2){
                diastolik_50_sonuc = kan_basinc.format(diastolik_50[x][8]);

            }
            else {
                diastolik_50_sonuc = kan_basinc.format(diastolik_50[x][y]);
            }

        }
        else {
            diastolik_50_sonuc = ("-");
        }


        double[][] diastolik_90 = {
                {0,52,52,53,53,54,55,55,56},
                {0.25,52,52,53,53,54,55,55,56},
                {0.5,52,52,53,53,54,55,55,56},
                {0.75,52,52,53,53,54,55,55,56},
                {1,52,52,53,53,54,55,55,56},
                {1.25,52,52,53,53,54,55,55,56},
                {1.5,52,52,53,53,54,55,55,56},
                {2,57,57,58,58,59,60,61,61},
                {2.5,57,57,58,58,59,60,61,61},
                {3,61,61,62,62,63,64,64,65},
                {3.5,61,61,62,62,63,64,64,65},
                {4,64,64,64,65,66,67,67,68},
                {4.5,64,64,64,65,66,67,67,68},
                {5,66,66,67,67,68,69,69,70},
                {5.5,66,66,67,67,68,69,69,70},
                {6,68,68,68,69,70,70,71,72},
                {6.5,68,68,68,69,70,70,71,72},
                {7,69,69,70,70,71,72,72,73},
                {7.5,69,69,70,70,71,72,72,73},
                {8,71,71,71,71,72,73,74,74},
                {8.5,71,71,71,71,72,73,74,74},
                {9,72,72,72,72,73,74,75,75},
                {9.5,72,72,72,72,73,74,75,75},
                {10,73,73,73,73,74,75,76,76},
                {10.5,73,73,73,73,74,75,76,76},
                {11,74,74,74,74,75,76,77,77},
                {11.5,74,74,74,74,75,76,77,77},
                {12,75,75,75,75,76,77,78,78},
                {12.5,75,75,75,75,76,77,78,78},
                {13,76,76,76,76,77,78,79,79},
                {13.5,76,76,76,76,77,78,79,79},
                {14,77,77,77,77,78,79,80,80},
                {14.5,77,77,77,77,78,79,80,80},
                {15,78,78,78,78,79,80,81,81},
                {15.5,78,78,78,78,79,80,81,81},
                {16,78,78,78,79,80,81,81,82},
                {16.5,78,78,78,79,80,81,81,82},
                {17,78,78,79,79,80,81,81,82},
                {17.5,78,78,79,79,80,81,81,82},
                {18,78,78,79,79,80,81,81,82},


        };

        if(a2>=1){

            if (boy [x][7]<h2){
                diastolik_90_sonuc = kan_basinc.format(diastolik_90[x][8]);

            }
            else {
                diastolik_90_sonuc = kan_basinc.format(diastolik_90[x][y]);
            }

        }
        else {
            diastolik_90_sonuc = ("-");
        }

        double[][] diastolik_95 = {
                {0,56,56,57,57,58,59,59,60},
                {0.25,56,56,57,57,58,59,59,60},
                {0.5,56,56,57,57,58,59,59,60},
                {0.75,56,56,57,57,58,59,59,60},
                {1,56,56,57,57,58,59,59,60},
                {1.25,56,56,57,57,58,59,59,60},
                {1.5,56,56,57,57,58,59,59,60},
                {2,61,61,62,62,63,64,65,65},
                {2.5,61,61,62,62,63,64,65,65},
                {3,65,65,66,66,67,68,68,69},
                {3.5,65,65,66,66,67,68,68,69},
                {4,68,68,68,69,70,71,71,72},
                {4.5,68,68,68,69,70,71,71,72},
                {5,70,70,71,71,72,73,73,74},
                {5.5,70,70,71,71,72,73,73,74},
                {6,72,72,72,73,74,74,75,76},
                {6.5,72,72,72,73,74,74,75,76},
                {7,73,73,74,74,75,76,76,77},
                {7.5,73,73,74,74,75,76,76,77},
                {8,75,75,75,75,76,77,78,78},
                {8.5,75,75,75,75,76,77,78,78},
                {9,76,76,76,76,77,78,79,79},
                {9.5,76,76,76,76,77,78,79,79},
                {10,77,77,77,77,78,79,80,80},
                {10.5,77,77,77,77,78,79,80,80},
                {11,78,78,78,78,79,80,81,81},
                {11.5,78,78,78,78,79,80,81,81},
                {12,79,79,79,79,80,81,82,82},
                {12.5,79,79,79,79,80,81,82,82},
                {13,80,80,80,80,81,82,83,83},
                {13.5,80,80,80,80,81,82,83,83},
                {14,81,81,81,81,82,83,84,84},
                {14.5,81,81,81,81,82,83,84,84},
                {15,82,82,82,82,83,84,85,85},
                {15.5,82,82,82,82,83,84,85,85},
                {16,82,82,82,83,84,85,85,86},
                {16.5,82,82,82,83,84,85,85,86},
                {17,82,82,83,83,84,85,85,86},
                {17.5,82,82,83,83,84,85,85,86},
                {18,82,82,83,83,84,85,85,86},



        };

        if(a2>=1){

            if (boy [x][7]<h2){
                diastolik_95_sonuc = kan_basinc.format(diastolik_95[x][8]);

            }
            else {
                diastolik_95_sonuc = kan_basinc.format(diastolik_95[x][y]);
            }

        }
        else {
            diastolik_95_sonuc = ("-");
        }


        double[][] diastolik_99 = {
                {0,64,64,64,65,65,66,67,67},
                {0.25,64,64,64,65,65,66,67,67},
                {0.5,64,64,64,65,65,66,67,67},
                {0.75,64,64,64,65,65,66,67,67},
                {1,64,64,64,65,65,66,67,67},
                {1.25,64,64,64,65,65,66,67,67},
                {1.5,64,64,64,65,65,66,67,67},
                {2,69,69,69,70,70,71,72,72},
                {2.5,69,69,69,70,70,71,72,72},
                {3,73,73,73,74,74,75,76,76},
                {3.5,73,73,73,74,74,75,76,76},
                {4,76,76,76,76,77,78,79,79},
                {4.5,76,76,76,76,77,78,79,79},
                {5,78,78,78,79,79,80,81,81},
                {5.5,78,78,78,79,79,80,81,81},
                {6,80,80,80,80,81,82,83,83},
                {6.5,80,80,80,80,81,82,83,83},
                {7,81,81,81,82,82,83,84,84},
                {7.5,81,81,81,82,82,83,84,84},
                {8,82,82,82,83,83,84,85,86},
                {8.5,82,82,82,83,83,84,85,86},
                {9,83,83,83,84,84,85,86,87},
                {9.5,83,83,83,84,84,85,86,87},
                {10,84,84,84,85,86,86,87,88},
                {10.5,84,84,84,85,86,86,87,88},
                {11,85,85,85,86,87,87,88,89},
                {11.5,85,85,85,86,87,87,88,89},
                {12,86,86,86,87,88,88,89,90},
                {12.5,86,86,86,87,88,88,89,90},
                {13,87,87,87,88,89,89,90,91},
                {13.5,87,87,87,88,89,89,90,91},
                {14,88,88,88,89,90,90,91,92},
                {14.5,88,88,88,89,90,90,91,92},
                {15,89,89,89,90,91,91,92,93},
                {15.5,89,89,89,90,91,91,92,93},
                {16,90,90,90,90,91,92,93,93},
                {16.5,90,90,90,90,91,92,93,93},
                {17,90,90,90,91,91,92,93,93},
                {17.5,90,90,90,91,91,92,93,93},
                {18,90,90,90,91,91,92,93,93},



        };

        if(a2>=1){

            if (boy [x][7]<h2){
                diastolik_99_sonuc = kan_basinc.format(diastolik_99[x][8]);

            }
            else {
                diastolik_99_sonuc = kan_basinc.format(diastolik_99[x][y]);
            }

        }
        else {
            diastolik_99_sonuc = ("-");
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
