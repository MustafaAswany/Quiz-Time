package mostafa.example.com.quiztime;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.graphics.Color.rgb;


public class Math extends AppCompatActivity {

    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_activity);
        //get the userName from the first activity
        final TextView userName = findViewById(R.id.textView_name);
        userName.setText(getIntent().getExtras().getString("name"));

        final Button scoreBtn = findViewById(R.id.score_Btn);
        Button resetBtn = findViewById(R.id.reset);

        scoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton correct_q1 = findViewById(R.id.answer_q1Math);
                RadioButton correct_q2 = findViewById(R.id.answer_q2Math);
                RadioButton correct_q3 = findViewById(R.id.answer_q3Math);
                RadioButton correct_q4 = findViewById(R.id.answer_q4Math);

                //on click the correct redioButton {increase score by 1 }
                if (correct_q1.isChecked()) {
                    score++;
                }
                if (correct_q2.isChecked()) {
                    score++;
                }
                if (correct_q3.isChecked()) {
                    score++;
                }
                if (correct_q4.isChecked()) {
                    score++;
                }

                //if two answer is correct{get user name+ start new activity+the user is win}
                if (score >= 2) {
                    String nameValue = userName.getText().toString();
                    Intent isWinner = new Intent(Math.this, UserStatue.class);
                    isWinner.putExtra("name", nameValue + "\n" + getString(R.string.your_score));
                    isWinner.putExtra("WinOrLose", score + "/4" + "\n" + getString(R.string.you_win));
                    isWinner.putExtra("Color", rgb(32, 201, 139));
                    startActivity(isWinner);
                    finish();

                    //if the answers<2 {get user name+ start new activity+ the user is lose}
                } else if (score < 2) {
                    String nameValue = userName.getText().toString();
                    Intent isloser = new Intent(Math.this, UserStatue.class);
                    isloser.putExtra("name", nameValue + "\n" + getString(R.string.your_score));
                    isloser.putExtra("WinOrLose", score + "/4" + "\n" + getString(R.string.you_lose));
                    isloser.putExtra("Color", rgb(196, 27, 69));
                    startActivity(isloser);
                    finish();
                }

            }
        });

        //if on click reset Button close the app
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
