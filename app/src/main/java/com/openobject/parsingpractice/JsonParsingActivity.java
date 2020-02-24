package com.openobject.parsingpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonParsingActivity extends AppCompatActivity {


    private RecyclerView movieRv;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsing);
        jsonParsing(getJsonString());


    }

    private String getJsonString() {

        String json = "";

        try {
            InputStream is = getAssets().open("Movies.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    private void jsonParsing(String json){

        ArrayList<MovieVO> movieList = new ArrayList<>();

        try{
            JSONObject jsonObject = new JSONObject(json);

            JSONArray movieArray = jsonObject.getJSONArray("Movies");

            for(int i=0; i < movieArray.length(); i++){

                JSONObject movieObject = movieArray.getJSONObject(i);

                MovieVO movie = new MovieVO();

                movie.setTitle(movieObject.getString("title"));
                movie.setGrade(movieObject.getString("grade"));
                movie.setCategory(movieObject.getString("category"));

                movieList.add(movie);

            }

            //recyclerView에 띄우는 부분
            movieRv = findViewById(R.id.movie_rv);
            movieAdapter = new MovieAdapter(this,movieList);
            movieRv.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
            LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            movieRv.setLayoutManager(layoutManager);
            movieRv.setAdapter(movieAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
