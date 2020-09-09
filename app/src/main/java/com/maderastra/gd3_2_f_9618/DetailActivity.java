package com.maderastra.gd3_2_f_9618;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.maderastra.gd3_2_f_9618.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    Mahasiswa mhs;
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        String strMhs = getIntent().getStringExtra("objMhs");
        Gson gson = new Gson();
        mhs = gson.fromJson(strMhs, Mahasiswa.class);

        binding.setMhs(mhs);
        binding.setActivity(this);
    }

    public View.OnClickListener btnBackClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent mainActivity = new Intent(DetailActivity.this, MainActivity.class);
            mainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainActivity);
        }
    };
}