package com.example.moviep22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{


    private Context context;
    private List<MovieModel>mdata;
    MovieIetemClickListener movieIetemClickListener;


    public MovieAdapter(Context context, List<MovieModel> mdata,MovieIetemClickListener listener) {
        this.context = context;
        this.mdata = mdata;
        movieIetemClickListener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_movie, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MovieModel movieModel=mdata.get(position);
        holder.movieTitleTv.setText(movieModel.getTitle());
        holder.movieImageIv.setImageResource(movieModel.getThumbnial());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView movieTitleTv;
        private ImageView movieImageIv;


        public MyViewHolder( View itemView) {
            super(itemView);
            movieTitleTv=itemView.findViewById(R.id.item_tiltle_tv);
            movieImageIv=itemView.findViewById(R.id.m_iv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieIetemClickListener.onMovieClick(mdata.get(getAdapterPosition()),movieImageIv);
                }
            });

        }
    }
}
