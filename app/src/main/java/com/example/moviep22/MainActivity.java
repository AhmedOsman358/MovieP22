package com.example.moviep22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieIetemClickListener {

    private List<Slide>slideList;
    private ViewPager slidePager;
    private TabLayout indicator;
    RecyclerView homeRv;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slidePager=findViewById(R.id.slider_vp);



        indicator=findViewById(R.id.indicator);
       homeRv = (RecyclerView) findViewById(R.id.movie_rv);




        // Prepare List Slide

        slideList=new ArrayList<>();
        slideList.add(new Slide(R.drawable.hunter1,"Hunter X Hunter"));
        slideList.add(new Slide(R.drawable.bat2,"Batman Dark Knight  "));
        slideList.add(new Slide(R.drawable.fan,"Fantastic Beasts "));
        slideList.add(new Slide(R.drawable.h1,"V For Vendeta "));
        slideList.add(new Slide(R.drawable.hoobs,"Hoobs && Show  "));


        SlidePagerAdapter adapter=new SlidePagerAdapter(this,slideList);
        slidePager.setAdapter(adapter);





        // Setup Timer

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SlideTimer(),4000,6000);
        indicator.setupWithViewPager(slidePager,true);






        //Receyclerview Setup


        List<MovieModel>movielist=new ArrayList<>();
        movielist.add(new MovieModel("monster",R.drawable.monsters2));
        movielist.add(new MovieModel("Toy Story 4",R.drawable.toy));
        movielist.add(new MovieModel("Animation Batman",R.drawable.batmone));
        movielist.add(new MovieModel("1917",R.drawable.war));
        movielist.add(new MovieModel("Trimanotor",R.drawable.tr));
        movielist.add(new MovieModel("Gemaini man",R.drawable.gemainman));
        movielist.add(new MovieModel("2Gun",R.drawable.gun));
        movielist.add(new MovieModel("I.T.",R.drawable.iiit));


        MovieAdapter movieAdapter=new MovieAdapter(this,movielist,this);
        homeRv.setAdapter(movieAdapter);
        homeRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));









    }
    public void onMovieClick(MovieModel movie, ImageView movieDetialsImage){

        Intent intent=new Intent(this,MovieDetials.class);

        intent.putExtra("title",movie.getTitle());
        intent.putExtra("ImgURL",movie.getThumbnial());
        ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,movieDetialsImage,"sharedNAme");
        startActivity(intent,options.toBundle());
        Toast.makeText(this, "click work", Toast.LENGTH_SHORT).show();





    }

    class SlideTimer extends TimerTask{


        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (slidePager.getCurrentItem()<slideList.size()-1) {
                       slidePager.setCurrentItem (slidePager.getCurrentItem() + 1);
                    }

                     else slidePager.setCurrentItem(0);
                }
            });
        }
    }

}