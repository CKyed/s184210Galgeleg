package com.example.s184210galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.math.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighscoreActivity extends AppCompatActivity {
    private ArrayList<Integer> highScore = new ArrayList<>();
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Gson gson  = new Gson();
        String json = preferences.getString("highScore","");
        highScore = gson.fromJson(json,ArrayList.class);



        Collections.sort(highScore);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.adapter_view_layout,R.id.highScoreScore,highScore){
            @Override
                    public View getView(int postion, View cachedView, ViewGroup parent){
                View view = super.getView(postion,cachedView,parent);
                TextView listRank = (TextView) view.findViewById(R.id.highScoreRank);
                TextView listScore = (TextView) view.findViewById(R.id.highScoreScore);
                int rank = postion+1;
                listRank.setText("Rank: "+rank);
                listScore.setText("Antal fejl: "+highScore.get(postion));
                return view;
            }


        };
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);
        setContentView(listView);


        //for (int i = 0; i <highScore.size() ; i++) {
        //Har ikke kunne finde en løsning der gør at jeg får int værdien. Har prøvet .intValue()
        //System.out.println("Indlæst: "+ highScore.get(i));
        }
        /*
        for (int i = 0; i < 5; i++) {
            int score = preferences.getInt("score"+i,0);
            if(score!=0){
                highScore.add(score);
            }
        }
        if(highScore.size()!=0){
            //Her skal vi lave vores listview
            for (int i = 0; i < 5; i++) {
                System.out.println("");
            }
        }
        */




}