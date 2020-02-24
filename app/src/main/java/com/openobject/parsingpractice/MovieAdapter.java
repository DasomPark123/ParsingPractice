package com.openobject.parsingpractice;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MovieVO> movieData;


//    MovieVO current;
//    int currentPos = 0;

    MovieAdapter(Context context,ArrayList<MovieVO> list) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        movieData = list;
    }


    //아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_view, parent, false);
        MovieAdapter.ViewHolder holder = new MovieAdapter.ViewHolder(view);
        return holder;
    }

    //position에 해당하는 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String title = movieData.get(position).getTitle();
        String category = movieData.get(position).getCategory();
        String grade = movieData.get(position).getGrade();

        holder.titleTv.setText(title);
        holder.categoryTv.setText(category);
        holder.gradeTv.setText(grade);

//        MovieVO movies = movieData.get(position);
//        holder.setItem(movies);

    }


    //전체 데이터 개수 리턴
    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        TextView categoryTv;
        TextView gradeTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTv = itemView.findViewById(R.id.movie_title);
            categoryTv = itemView.findViewById(R.id.movie_category);
            gradeTv = itemView.findViewById(R.id.movie_grade);
        }

//        public void setItem(MovieVO movies){
//            titleTv.setText(movies.getTitle());
//            categoryTv.setText(movies.getCategory());
//            gradeTv.setText(movies.getGrade());
//        }


    }
}

