package com.majidhhdri.kheili.kheili;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.majidhhdri.kheili.kheili.R;

public class MainActivity extends AppCompatActivity {

    int questionNumber = 1;
    ImageView solution;
    TextView counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solution = (ImageView)findViewById(R.id.solution);
        int id = getApplicationContext().getResources().getIdentifier("dini0001", "drawable", getPackageName());
        solution.setImageResource(id);
        Button plusOne = (Button)findViewById(R.id.plus_1);
        Button minusOne = (Button)findViewById(R.id.minus_1);
        Button plusTen = (Button)findViewById(R.id.plus_10);
        Button minusTen = (Button)findViewById(R.id.minus_10);
        Button plusHund = (Button)findViewById(R.id.plus_100);
        Button minusHund = (Button)findViewById(R.id.minus_100);
        Button plusThous = (Button)findViewById(R.id.plus_1000);
        Button minusThous = (Button)findViewById(R.id.minus_1000);
        CardView card = (CardView) findViewById(R.id.card);
        plusOne.setOnClickListener(getListener(1));
        minusOne.setOnClickListener(getListener(-1));
        plusTen.setOnClickListener(getListener(10));
        minusTen.setOnClickListener(getListener(-10));
        plusHund.setOnClickListener(getListener(100));
        minusHund.setOnClickListener(getListener(-100));
        plusThous.setOnClickListener(getListener(1000));
        minusThous.setOnClickListener(getListener(-1000));
        card.setOnClickListener(getListener(1));

        plusOne.setOnLongClickListener(getLongListener(1));
        minusOne.setOnLongClickListener(getLongListener(-1));
        plusTen.setOnLongClickListener(getLongListener(10));
        minusTen.setOnLongClickListener(getLongListener(-10));
        plusHund.setOnLongClickListener(getLongListener(100));
        minusHund.setOnLongClickListener(getLongListener(-100));
        plusThous.setOnLongClickListener(getLongListener(1000));
        minusThous.setOnLongClickListener(getLongListener(-1000));

        card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int num = -1;
                if(questionNumber + num <= 2873 && questionNumber + num >= 1)
                    questionNumber+= num;
                String questionNumberString = Integer.toString(questionNumber);
                int id = getApplicationContext().getResources().getIdentifier("dini" + ("0000" + questionNumberString).substring(questionNumberString.length()), "drawable", getPackageName());
                solution.setImageResource(id);
                return true;
            }
        });



    }
    public View.OnClickListener getListener(final int num) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionNumber + num <= 2873 && questionNumber + num >= 1)
                    questionNumber+= num;
                String questionNumberString = Integer.toString(questionNumber);
                int id = getApplicationContext().getResources().getIdentifier("dini" + ("0000" + questionNumberString).substring(questionNumberString.length()), "drawable", getPackageName());
                solution.setImageResource(id);
            }
        };
    }
    public  View.OnLongClickListener getLongListener(final int num1) {
        return new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final int num = num1 * 2;
                if(questionNumber + num <= 2873 && questionNumber + num >= 1)
                    questionNumber+= num;
                String questionNumberString = Integer.toString(questionNumber);
                int id = getApplicationContext().getResources().getIdentifier("dini" + ("0000" + questionNumberString).substring(questionNumberString.length()), "drawable", getPackageName());
                solution.setImageResource(id);
                return true;
            }
        };
    }
}