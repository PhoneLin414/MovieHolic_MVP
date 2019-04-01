package com.example.pla.movieholicmvp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pla.movieholicmvp.R;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        BoomMenuButton bmb = findViewById(R.id.bmb);
    }
}
