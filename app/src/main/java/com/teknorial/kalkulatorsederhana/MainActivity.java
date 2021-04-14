package com.teknorial.kalkulatorsederhana;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel
    private EditText mEditTextBilanganPertama;
    private EditText mEditTextBilanganKedua;
    private Spinner mSpinnerOperator;
    private Button mButtonHitung;
    private TextView mTextViewHasil;

    private Double mBilanganPertama;
    private Double mBilanganKedua;
    private String mOperator;
    private Double mHasilPerhitungan = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi variabel widget
        mEditTextBilanganPertama = findViewById(R.id.et_bilangan_pertama);
        mEditTextBilanganKedua = findViewById(R.id.et_bilangan_kedua);
        mSpinnerOperator = findViewById(R.id.spn_operator);
        mButtonHitung = findViewById(R.id.btn_hitung);
        mTextViewHasil = findViewById(R.id.tv_hasil);

        //onclick listener pada widget button
        mButtonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mEditTextBilanganPertama.getText().toString().equals("")) {
                    mEditTextBilanganPertama.setError("Kamu Belum Memasukkan Bilangan Pertama");
                    return;
                }

                if (mEditTextBilanganKedua.getText().toString().equals("")) {
                    mEditTextBilanganKedua.setError("Kamu belum memasukkan bilangan Kedua");
                    return;
                }

                //mengambil value dari widget EditText dan mengubah menjadi tipe data double
                mBilanganPertama = Double.valueOf(mEditTextBilanganPertama.getText().toString());
                mBilanganKedua = Double.valueOf(mEditTextBilanganKedua.getText().toString());
                //mengambil value 'operator' yang dipilih dalam widget spinner
                mOperator = mSpinnerOperator.getSelectedItem().toString();

                //menggunakan switch case untuk mengecek setiap case berdasarkan operator(mOperator) yang dipilih
                switch (mOperator) {
                    case "+":
                        mHasilPerhitungan = mBilanganPertama + mBilanganKedua;
                        break;
                    case "-":
                        mHasilPerhitungan = mBilanganPertama - mBilanganKedua;
                        break;
                    case "x":
                        mHasilPerhitungan = mBilanganPertama * mBilanganKedua;
                        break;
                    case "/":
                        mHasilPerhitungan = mBilanganPertama / mBilanganKedua;
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Kamu belum memilih operator", Toast.LENGTH_SHORT).show();
                        break;
                }

                //Mengubah value dari double menjadi string (String.valueOf()) dan menampilkannya ke widget TextView
                mTextViewHasil.setText(String.valueOf(mHasilPerhitungan));
            }
        });
    }
}