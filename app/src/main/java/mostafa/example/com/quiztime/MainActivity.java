package mostafa.example.com.quiztime;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wait 2 seconds before the program starts
        int SPLASH_TIME_OUT = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent quest_Intent = new Intent(MainActivity.this, QuestionsActivity.class);
                startActivity(quest_Intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
