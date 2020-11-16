package com.example.moviep22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SlidePagerAdapter extends PagerAdapter {

    private Context context;

    private List<Slide> mList;

    public SlidePagerAdapter(Context context, List<Slide> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


        View slideLayout=inflater.inflate(R.layout.slider_item,null);

        ImageView slideimage=slideLayout.findViewById(R.id.movie_slider_iv);
        TextView slideTitle=slideLayout.findViewById(R.id.title_tv);
        slideimage.setImageResource(mList.get(position).getImage());
       slideTitle.setText(mList.get(position).getTitle());

       container.addView(slideLayout);
       return slideLayout;












    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
