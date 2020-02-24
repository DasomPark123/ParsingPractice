package com.openobject.parsingpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onMoveParsing1(View view){
        startActivity(new Intent(this,JsonParsingActivity.class));
    }

    public void onMoveParsing2(View view){
        startActivity(new Intent(this,DataInputActivity.class));
    }




}
