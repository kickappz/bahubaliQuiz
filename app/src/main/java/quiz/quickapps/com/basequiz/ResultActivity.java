package quiz.quickapps.com.basequiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by roope on 5/7/2017.
 */

public class ResultActivity extends Activity {

    TextView playerSkillClassification,scoreValue;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Intent intent = getIntent();
        playerSkillClassification = (TextView)findViewById(R.id.playerSkillClassification);
        scoreValue = (TextView) findViewById(R.id.score);

            score = intent.getIntExtra("scoreValue",0);
            scoreValue.setText(String.valueOf(score));


        if(score>3){
            playerSkillClassification.setText("Congrats! You have the IQ of Bahubali");
        }
        else
        {
            playerSkillClassification.setText("Sorry your IQ is as low as Bicchaladeva");
        }
    }
}
