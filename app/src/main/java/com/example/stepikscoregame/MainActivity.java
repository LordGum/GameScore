package com.example.stepikscoregame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // объект типа Bundle от туда и берем сохраненные значения
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // здесь идет установка пакета

        if(savedInstanceState != null ) { //тк при первом запуске у нас нет сохраненные значения
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }

        TextView textViewScore1 = findViewById(R.id.Bottom1); //так мы понимаем какое из активити мы используем
        TextView textViewScore2 = findViewById(R.id.Bottom2);

        textViewScore1.setText(String.valueOf(score1)); //Вставляет нужный нам текст
        textViewScore2.setText(String.valueOf(score2));


        textViewScore1.setOnClickListener(new View.OnClickListener() {  //Мы можем установить слушатель даже на текст
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "Кто-то нажал на кнопку 1");
                textViewScore1.setText(String.valueOf(++score1));
            }
        });

        textViewScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "Кто-то нажал на кнопку 2");
                textViewScore2.setText(String.valueOf(++score2));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { //этот метод вызывает объект типа Bundle в нем мы и будем хранит наши значения
        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}





