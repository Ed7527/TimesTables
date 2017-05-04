package com.edwardtorpy.timestables;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> timesTable;

    public void createTimesTableList(int multiplyBy) {

        timesTable.clear();
        multiplyBy++;

        for (int i =1; i < 13; i++) {

            String timeTableAnswer = multiplyBy + " x " + i + " = " + i * multiplyBy;
            timesTable.add(timeTableAnswer);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView timesTableView = (ListView) findViewById(R.id.timesTableList);

        timesTable = new ArrayList<>();
        createTimesTableList(0);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTable);
        timesTableView.setAdapter(arrayAdapter);


        SeekBar numberSelector = (SeekBar) findViewById(R.id.numberSeekBar);
        numberSelector.setMax(15);

        numberSelector.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                createTimesTableList(progress);
                arrayAdapter.addAll();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
