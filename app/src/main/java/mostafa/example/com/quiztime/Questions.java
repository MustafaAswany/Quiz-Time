package mostafa.example.com.quiztime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Questions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);
        final EditText userName = findViewById(R.id.editText_name);
        final ImageButton mathBtn = findViewById(R.id.mathButton);
        final ImageButton programmingBtn = findViewById(R.id.programmingBtn);

        mathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get userName from EditText From (MainActivity).
                String nameValue=userName.getText().toString();
                //Start new Activity (math)
                Intent MIntent = new Intent(Questions.this, Math.class);
                MIntent.putExtra("name", nameValue);
                startActivity(MIntent);
                finish();
            }
        });

        programmingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get userName from EditText From (MainActivity).
                String nameValue=userName.getText().toString();
                //Start new Activity (programming)
                Intent MIntent = new Intent(Questions.this, programming.class);
                MIntent.putExtra("name", nameValue);
                startActivity(MIntent);
                finish();
            }
        });

    }
}
