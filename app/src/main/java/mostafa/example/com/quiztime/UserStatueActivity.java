package mostafa.example.com.quiztime;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.color.holo_red_dark;
import static android.graphics.Color.rgb;

public class UserStatueActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userstatue_activity);

        //get user statue (Win or Lose).
        TextView userScore = findViewById(R.id.textFor_Winner);
        userScore.setText(getIntent().getExtras().getString("WinOrLose"));
        userScore.setTextColor(rgb(255, 233, 0));

        //get the userName from EditText From (MainActivity).
        TextView userName = findViewById(R.id.textFor_name);
        userName.setText(getIntent().getExtras().getString("name"));

        //if the user win{set the backgoundColor:Green}
        //if the user Lose{set the backgoundColor:Red}
        RelativeLayout acticity = findViewById(R.id.winnerActivity);
        acticity.setBackgroundColor(getIntent().getExtras().getInt("Color"));
    }
}
