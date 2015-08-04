package com.ctepe.persentil_hesaplama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ctepe on 2.8.2015.
 */

public class kan_basinc_fragment extends Fragment {

    TextView  sistolik_50, diastolik_50, sistolik_90, diastolik_90, sistolik_95, diastolik_95, sistolik_99, diastolik_99;
    TextView kb_persentil_text, sistolik_text, diastolik_text,text_50, text_90, text_95, text_99 ;

    LinearLayout linear_sistolik, linear_diastolik;

    public kan_basinc_fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.kan_basinc_fragment, container, false);

        kb_persentil_text = (TextView) rootview.findViewById(R.id.textView18);
        sistolik_text = (TextView) rootview.findViewById(R.id.textView16);
        diastolik_text = (TextView) rootview.findViewById(R.id.textView17);
        text_50 = (TextView) rootview.findViewById(R.id.textView12);
        text_90 = (TextView) rootview.findViewById(R.id.textView13);
        text_95 = (TextView) rootview.findViewById(R.id.textView14);
        text_99 = (TextView) rootview.findViewById(R.id.textView15);

        linear_sistolik = (LinearLayout) rootview.findViewById(R.id.linear_sistolik);
        linear_diastolik = (LinearLayout) rootview.findViewById(R.id.linear_diastolik);

        sistolik_50 = (TextView) rootview.findViewById(R.id.text_sistolik_50);
        diastolik_50 = (TextView) rootview.findViewById(R.id.text_diastolik_50);
        sistolik_90 = (TextView) rootview.findViewById(R.id.text_sistolik_90);
        diastolik_90 = (TextView) rootview.findViewById(R.id.text_diastolik_90);
        sistolik_95 = (TextView) rootview.findViewById(R.id.text_sistolik_95);
        diastolik_95 = (TextView) rootview.findViewById(R.id.text_diastolik_95);
        sistolik_99 = (TextView) rootview.findViewById(R.id.text_sistolik_99);
        diastolik_99 = (TextView) rootview.findViewById(R.id.text_diastolik_99);

        if (MainActivity.flag == "erkek") {

            kb_persentil_text.setBackgroundResource(R.drawable.cell_shape_erkek);
            text_50.setBackgroundResource(R.drawable.cell_shape_erkek);
            text_90.setBackgroundResource(R.drawable.cell_shape_erkek);
            text_95.setBackgroundResource(R.drawable.cell_shape_erkek);
            text_99.setBackgroundResource(R.drawable.cell_shape_erkek);
            linear_sistolik.setBackgroundResource(R.drawable.cell_shape_erkek);
            linear_diastolik.setBackgroundResource(R.drawable.cell_shape_erkek);

            sistolik_50.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            diastolik_50.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            sistolik_90.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            diastolik_90.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            sistolik_95.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            diastolik_95.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            sistolik_99.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            diastolik_99.setBackgroundResource(R.drawable.cell_shape_ic_erkek);

            sistolik_50.setText(weight_erkek.sistolik_50_sonuc);
            diastolik_50.setText(weight_erkek.diastolik_50_sonuc);
            sistolik_90.setText(weight_erkek.sistolik_90_sonuc);
            diastolik_90.setText(weight_erkek.diastolik_90_sonuc);
            sistolik_95.setText(weight_erkek.sistolik_95_sonuc);
            diastolik_95.setText(weight_erkek.diastolik_95_sonuc);
            sistolik_99.setText(weight_erkek.sistolik_99_sonuc);
            diastolik_99.setText(weight_erkek.diastolik_99_sonuc);

        }
        else {

            kb_persentil_text.setBackgroundResource(R.drawable.cell_shape_kiz);
            text_50.setBackgroundResource(R.drawable.cell_shape_kiz);
            text_90.setBackgroundResource(R.drawable.cell_shape_kiz);
            text_95.setBackgroundResource(R.drawable.cell_shape_kiz);
            text_99.setBackgroundResource(R.drawable.cell_shape_kiz);
            linear_sistolik.setBackgroundResource(R.drawable.cell_shape_kiz);
            linear_diastolik.setBackgroundResource(R.drawable.cell_shape_kiz);

            sistolik_50.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            diastolik_50.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            sistolik_90.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            diastolik_90.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            sistolik_95.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            diastolik_95.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            sistolik_99.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            diastolik_99.setBackgroundResource(R.drawable.cell_shape_ic_kiz);

            sistolik_50.setText(weight_kiz.sistolik_50_sonuc);
            diastolik_50.setText(weight_kiz.diastolik_50_sonuc);
            sistolik_90.setText(weight_kiz.sistolik_90_sonuc);
            diastolik_90.setText(weight_kiz.diastolik_90_sonuc);
            sistolik_95.setText(weight_kiz.sistolik_95_sonuc);
            diastolik_95.setText(weight_kiz.diastolik_95_sonuc);
            sistolik_99.setText(weight_kiz.sistolik_99_sonuc);
            diastolik_99.setText(weight_kiz.diastolik_99_sonuc);
        }

            return rootview;
    }
}