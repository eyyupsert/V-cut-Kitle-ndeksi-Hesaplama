package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView boy_txt, durum_txt,ideal_txt,kilo_txt;
    private SeekBar seekBar;
    private RadioGroup cinsiyet;
    private boolean erkekmi = true;
    private double boy = 0.0 ;
    private int kilo = 30 ;
    private RadioGroup.OnCheckedChangeListener radioGroupOlayIsteyicisi = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.cbox_bay)
            {
                erkekmi = true;
            }

            else if (checkedId == R.id.cbox_bayan)
            {
                erkekmi = false;
            }

            guncelle();
        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarOlayIsleyicisi = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            kilo = progress;
            guncelle();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {

        }
    };

    private TextWatcher editTextOlayIsleyicisi = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                boy = Double.parseDouble(s.toString()) / 100.0;
            } catch (NumberFormatException e) {
                boy = 0.0;
            }
            guncelle();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.boy_editTxt);
        boy_txt = (TextView) findViewById(R.id.txt_boy);
        durum_txt = (TextView) findViewById(R.id.txt_durum);
        ideal_txt = (TextView) findViewById(R.id.txt_idealKilo);
        kilo_txt = (TextView) findViewById(R.id.txt_kilo);
        seekBar = (SeekBar) findViewById(R.id.seekBar_kilo);
        cinsiyet = (RadioGroup)findViewById(R.id.rdgrp_cinsiyet);
        seekBar.setOnSeekBarChangeListener(seekBarOlayIsleyicisi);
        editText.addTextChangedListener(editTextOlayIsleyicisi);
        cinsiyet.setOnCheckedChangeListener(radioGroupOlayIsteyicisi);

        guncelle();

    }

    private void guncelle()
    {

        kilo_txt.setText(String.valueOf(kilo)+" kg");
        boy_txt.setText(String.valueOf(boy));
        int ideal_kiloBay= (int) (50+2.3*(boy*100*0.39-60));
        int ideal_kiloBayan= (int) (45.5+2.3*(boy*100*0.39-60));
        double VKI = kilo/(boy*boy);
        if(erkekmi == true)
        {
            ideal_txt.setText(String.valueOf(ideal_kiloBay));
            if(VKI<=20.7)
            {
                durum_txt.setBackgroundResource(R.color.zayif);
                durum_txt.setText(R.string.zayif);
            }
            else if ()
            {

            }
        }
        else if(erkekmi == false)
            {
                ideal_txt.setText(String.valueOf(ideal_kiloBayan));
            }
    }


}
