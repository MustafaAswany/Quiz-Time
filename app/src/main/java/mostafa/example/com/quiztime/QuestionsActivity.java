package mostafa.example.com.quiztime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);
        final EditText userName = findViewById(R.id.editText_name);
        final ImageButton mathBtn = findViewById(R.id.mathBtn);
        final ImageButton programmingBtn = findViewById(R.id.programmingBtn);

//        coming soon
        final ImageButton scienceBtn = findViewById(R.id.scienceBtn);
        final ImageButton otherBtn = findViewById(R.id.otherBtn);
        final ImageButton soonBtn1 = findViewById(R.id.soonBtn1);
        final ImageButton soonBtn2 = findViewById(R.id.soonBtn2);

        mathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get userName from EditText From (MainActivity).
                String nameValue=userName.getText().toString();
                //Start new Activity (math)
                Intent MIntent = new Intent(QuestionsActivity.this, MathActivity.class);
                MIntent.putExtra("name", nameValue);
                startActivity(MIntent);
            }
        });

        programmingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get userName from EditText From (MainActivity).
                String nameValue=userName.getText().toString();
                //Start new Activity (ProgrammingActivity)
                Intent MIntent = new Intent(QuestionsActivity.this, ProgrammingActivity.class);
                MIntent.putExtra("name", nameValue);
                startActivity(MIntent);
            }
        });

//        Coming soon
        scienceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence text = "This section will be available soon!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        //        Coming soon
        otherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence text = "This section will be available soon!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        //        Coming soon
        soonBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence text = "This section will be available soon!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        //        Coming soon
        soonBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence text = "This section will be available soon!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}
