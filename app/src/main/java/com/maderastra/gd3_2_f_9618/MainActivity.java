package com.maderastra.gd3_2_f_9618;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.maderastra.gd3_2_f_9618.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Mahasiswa mhs;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mhs = new Mahasiswa();
        binding.setMhs(mhs);
        binding.setActivity(this);
    }

    public View.OnClickListener btnSaveMahasiswa = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent detailActivity = new Intent(MainActivity.this, DetailActivity.class);

            Gson gson = new Gson();
            String strMhs = gson.toJson(mhs);
            detailActivity.putExtra("objMhs", strMhs);
            startActivity(detailActivity);
        }
    };
}