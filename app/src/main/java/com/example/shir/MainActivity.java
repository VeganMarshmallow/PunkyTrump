package com.example.shir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    TextView question;
    int questionNumber = 0;
    String[] questions = {
            "When Mexico sends its people, they're not sending their best. They're not sending you. They're not sending you",
            "The beauty of me is that I’m very rich",
            "When you get off a plane at [New York Airport] Laguardia, it's like a third world country",
            "We will have so much winning if I get elected you may get bored with winning. Believe me. We are going to start winning big league",
            "Here's all you have to know about men and women: women are crazy, men are stupid",
            "God must love stupid people, He made so many"
    };

    boolean[] answears = { true, true, true,true,false,false};

    public void submitAnswear(boolean answear)
    {
        if(answear==answears[questionNumber])
        {
            Toast.makeText(MainActivity.this, "correct!!!!!!!!!!!!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "wrong, you punk", Toast.LENGTH_LONG).show();
        }
    }

    public void nextQuestion()
    {
        if (questionNumber >= questions.length -1){
            question.setText("no more questions");
            return;
        }

        questionNumber++;
        question.setText("did trump say: " + questions[questionNumber]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView)findViewById(R.id.question);

        final String s = (String) question.getText();
        question.setText(s + questions[questionNumber]);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("SHIR!", "you asked a question");
                Toast.makeText(MainActivity.this, "did trump say "+questions[0], Toast.LENGTH_LONG).show();
            }
        });

        Button yes = (Button) findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAnswear(true);
                nextQuestion();

            }
        });

        Button no = (Button) findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAnswear(false);
                nextQuestion();
            }
        });



    }
}
