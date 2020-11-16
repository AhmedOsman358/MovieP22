package com.example.moviep22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MovieDetials extends AppCompatActivity {

    private ImageView MovieThumbnailImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detials);

        String movieTitle=getIntent().getExtras().getString("title");
     int imageRecource=getIntent().getExtras().getInt("imageURL");
        MovieThumbnailImg=findViewById(R.id.movie_details_iv);
        MovieThumbnailImg.setImageResource(imageRecource);

    }
}