package mostafa.example.com.quiztime;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class ProgrammingActivity extends AppCompatActivity {

    public int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programming_activity);

        //get the userName from the first activity
        final TextView userName = findViewById(R.id.textView_name);
        userName.setText(getIntent().getExtras().getString("name"));

        final Button scoreBtn = findViewById(R.id.score_Btn);
        Button resetBtn = findViewById(R.id.reset);

        scoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton correct_q1 = findViewById(R.id.answer_q1_Programming);
                RadioButton correct_q2 = findViewById(R.id.answer_q2_Programming);
                RadioButton correct_q3 = findViewById(R.id.answer_q3_Programming);
                RadioButton correct_q4 = findViewById(R.id.answer_q4_Programming);

                CheckBox answerA_q5 = findViewById(R.id.answer_q5_CheckBoxA);
                CheckBox answerB_q5 = findViewById(R.id.answer_q5_CheckBoxB);
                CheckBox answerC_q5 = findViewById(R.id.answer_q5_CheckBoxC);

                CheckBox answerA_q6 = findViewById(R.id.answer_q6_CheckBoxA);
                CheckBox answerB_q6 = findViewById(R.id.answer_q6_CheckBoxB);
                CheckBox answerC_q6 = findViewById(R.id.answer_q6_CheckBoxC);

                CheckBox answerA_q7 = findViewById(R.id.answer_q7_CheckBoxA);
                CheckBox answerB_q7 = findViewById(R.id.answer_q7_CheckBoxB);
                CheckBox answerC_q7 = findViewById(R.id.answer_q7_CheckBoxC);

                CheckBox answerA_q8 = findViewById(R.id.answer_q8_CheckBoxA);
                CheckBox answerB_q8 = findViewById(R.id.answer_q8_CheckBoxB);
                CheckBox answerC_q8 = findViewById(R.id.answer_q8_CheckBoxC);

                EditText editText1 = findViewById(R.id.answer_q9Programming);
                String answerOfq9 = editText1.getText().toString();

                EditText editText2 = findViewById(R.id.answer_q10Programming);
                String answerOfq10 = editText2.getText().toString();

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

                //on click the correct CheckBox {increase score by 1 }
                if (answerA_q5.isChecked() && !answerB_q5.isChecked() && answerC_q5.isChecked()) {
                    score++;
                }
                if (answerA_q6.isChecked() && !answerB_q6.isChecked() && answerC_q6.isChecked()) {
                    score++;
                }
                if (answerA_q7.isChecked() && answerB_q7.isChecked() && !answerC_q7.isChecked()) {
                    score++;
                }
                if (!answerA_q8.isChecked() && answerB_q8.isChecked() && answerC_q8.isChecked()) {
                    score++;
                }
                if (answerOfq9.equals("kotlin") || answerOfq9.equals("Kotlin")) {
                    score++;
                }
                if (answerOfq10.equals("Udacity") || answerOfq9.equals("udacity")) {
                    score++;
                }

                //if two answer is correct{get user name+ start new activity+the user is win}
                if (score >= 5) {
                    String nameValue = userName.getText().toString();
                    Intent isWinner = new Intent(ProgrammingActivity.this, UserStatueActivity.class);
                    isWinner.putExtra("name", nameValue + "\n" + getString(R.string.your_score));
                    isWinner.putExtra("WinOrLose", score + "/10" + "\n" + getString(R.string.you_win));
                    isWinner.putExtra("Color", rgb(32, 201, 139));

                    //show Toast Message when the user win
                    Context context = getApplicationContext();
                    CharSequence text = "You Win!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    startActivity(isWinner);


                    //if the answers<4 {get user name+ start new activity+ the user is lose}
                } else if (score < 5) {
                    String nameValue = userName.getText().toString();
                    Intent isloser = new Intent(ProgrammingActivity.this, UserStatueActivity.class);
                    isloser.putExtra("name", nameValue + "\n" + getString(R.string.your_score));
                    isloser.putExtra("WinOrLose", score + "/10" + "\n" + getString(R.string.you_lose));
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

