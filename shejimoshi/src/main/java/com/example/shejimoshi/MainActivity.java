package com.example.shejimoshi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shejimoshi.moban.Cricket;
import com.example.shejimoshi.moban.Football;
import com.example.shejimoshi.moban.Game;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //模板方法
        /*Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();*/
    }
}