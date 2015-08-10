package com.ctepe.persentil_hesaplama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by ctepe on 2.8.2015.
 */
public class persentil_fragment extends Fragment {

    TextView weight_ideal, height_ideal, weight_persentil, height_persentil, vucut_alani_display, boy_agirlik_display, bas_cevre_ideal, bas_cevre_persentil;
    TextView ideal_text, persen_text, agirlik2_text, boy2_text, bas_cevre2_text, vucut_alani_text, boya_gore_agirlik_text;

    public persentil_fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.persentil_fragment, container, false);

        agirlik2_text = (TextView) rootview.findViewById(R.id.textView5);
        boy2_text = (TextView) rootview.findViewById(R.id.textView6);
        bas_cevre2_text = (TextView) rootview.findViewById(R.id.textView7);
        ideal_text = (TextView) rootview.findViewById(R.id.textView8);
        persen_text = (TextView) rootview.findViewById(R.id.textView9);
        vucut_alani_text = (TextView) rootview.findViewById(R.id.textView10);
        boya_gore_agirlik_text = (TextView) rootview.findViewById(R.id.textView11);


        weight_ideal = (TextView) rootview.findViewById(R.id.text_agirlik_ideal);
        height_ideal = (TextView) rootview.findViewById(R.id.text_ideal_boy);
        bas_cevre_ideal = (TextView) rootview.findViewById(R.id.text_ideal_bas_cevre);

        weight_persentil = (TextView) rootview.findViewById(R.id.text_agirlik_persentil);
        height_persentil = (TextView) rootview.findViewById(R.id.text_boy_persentil);
        bas_cevre_persentil = (TextView) rootview.findViewById(R.id.text_persentil_bas_cevre);

        vucut_alani_display = (TextView) rootview.findViewById(R.id.text_vucut_alani);
        boy_agirlik_display = (TextView) rootview.findViewById(R.id.text_boy_gore_agirlik);

        if (MainActivity.flag == "erkek"){
            agirlik2_text.setBackgroundResource(R.drawable.cell_shape_erkek);
            boy2_text.setBackgroundResource(R.drawable.cell_shape_erkek);
            bas_cevre2_text.setBackgroundResource(R.drawable.cell_shape_erkek);
            ideal_text.setBackgroundResource(R.drawable.cell_shape_erkek);
            persen_text.setBackgroundResource(R.drawable.cell_shape_erkek);
            vucut_alani_text.setBackgroundResource(R.drawable.cell_shape_erkek);
            boya_gore_agirlik_text.setBackgroundResource(R.drawable.cell_shape_erkek);

            weight_ideal.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            height_ideal.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            bas_cevre_ideal.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            weight_persentil.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            height_persentil.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            bas_cevre_persentil.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            vucut_alani_display.setBackgroundResource(R.drawable.cell_shape_ic_erkek);
            boy_agirlik_display.setBackgroundResource(R.drawable.cell_shape_ic_erkek);

            weight_ideal.setText(weight_erkek.weight_ideal_sonuc);
            weight_persentil.setText(weight_erkek.weight_persentil_sonuc);
            height_ideal.setText(weight_erkek.height_ideal_sonuc);
            height_persentil.setText(weight_erkek.height_persentil_sonuc);
            bas_cevre_ideal.setText(weight_erkek.bas_cevre_ideal_sonuc);
            bas_cevre_persentil.setText(weight_erkek.bas_cevre_persentil_sonuc);
            vucut_alani_display.setText(weight_erkek.vucut_alan_sonuc);
            boy_agirlik_display.setText(weight_erkek.boya_gore_agirlik_sonuc);

        }
        else {
            agirlik2_text.setBackgroundResource(R.drawable.cell_shape_kiz);
            boy2_text.setBackgroundResource(R.drawable.cell_shape_kiz);
            bas_cevre2_text.setBackgroundResource(R.drawable.cell_shape_kiz);
            ideal_text.setBackgroundResource(R.drawable.cell_shape_kiz);
            persen_text.setBackgroundResource(R.drawable.cell_shape_kiz);
            vucut_alani_text.setBackgroundResource(R.drawable.cell_shape_kiz);
            boya_gore_agirlik_text.setBackgroundResource(R.drawable.cell_shape_kiz);


            weight_ideal.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            height_ideal.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            bas_cevre_ideal.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            weight_persentil.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            height_persentil.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            bas_cevre_persentil.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            vucut_alani_display.setBackgroundResource(R.drawable.cell_shape_ic_kiz);
            boy_agirlik_display.setBackgroundResource(R.drawable.cell_shape_ic_kiz);


            weight_ideal.setText(weight_kiz.weight_ideal_sonuc);
            weight_persentil.setText(weight_kiz.weight_persentil_sonuc);
            height_ideal.setText(weight_kiz.height_ideal_sonuc);
            height_persentil.setText(weight_kiz.height_persentil_sonuc);
            bas_cevre_ideal.setText(weight_kiz.bas_cevre_ideal_sonuc);
            bas_cevre_persentil.setText(weight_kiz.bas_cevre_persentil_sonuc);
            vucut_alani_display.setText(weight_kiz.vucut_alan_sonuc);
            boy_agirlik_display.setText(weight_kiz.boya_gore_agirlik_sonuc);

        }



        return rootview;
    }
}