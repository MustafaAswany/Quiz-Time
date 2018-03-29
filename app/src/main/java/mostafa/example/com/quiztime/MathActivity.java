package mostafa.example.com.quiztime;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;


public class MathActivity extends AppCompatActivity {

    public int score;

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

                EditText editText1 = findViewById(R.id.answer_q5Math);
                String answerOfq5 = editText1.getText().toString();

                EditText editText2 = findViewById(R.id.answer_q6Math);
                String answerOfq6 = editText2.getText().toString();

                //on click the correct radioButton {increase score by 1 }
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
                if (answerOfq5.equals("four") || answerOfq5.equals("4")) {
                    score++;
                }
                if (answerOfq6.equals("700")) {
                    score++;
                }
                //if two answer is correct{get user name+ start new activity+the user is win}
                if (score >= 3) {
                    String nameValue = userName.getText().toString();
                    Intent isWinner = new Intent(MathActivity.this, UserStatueActivity.class);
                    isWinner.putExtra("name", nameValue + "\n" + getString(R.string.your_score));
                    isWinner.putExtra("WinOrLose", score + "/6" + "\n" + getString(R.string.you_win));
                    isWinner.putExtra("Color", rgb(32, 201, 139));

                    //show Toast Message when the user win
                    Context context = getApplicationContext();
                    CharSequence text = "You Win!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    startActivity(isWinner);


                    //if the answers<3 {get user name+ start new activity+ the user is lose}
                } else if (score < 3) {
                    String nameValue = userName.getText().toString();
                    Intent isloser = new Intent(MathActivity.this, UserStatueActivity.class);
                    isloser.putExtra("name", nameValue + "\n" + getString(R.string.your_score));
                    isloser.putExtra("WinOrLose", score + "/6" + "\n" + getString(R.string.you_lose));
                    isloser.putExtra("Color", rgb(196, 27, 69));

                    //show Toast Message when the user Lose
                    Context context = getApplicationContext();
                    CharSequence text = "You Lost! Try Again";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    startActivity(isloser);

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
