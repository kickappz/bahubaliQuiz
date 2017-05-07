package quiz.quickapps.com.basequiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by roope on 5/7/2017.
 */

public class ResultActivity extends Activity {

    TextView playerSkillClassification,scoreValue;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        playerSkillClassification = (TextView)findViewById(R.id.playerSkillClassification);
        scoreValue = (TextView) findViewById(R.id.score);

        if(savedInstanceState.containsKey("scoreValue")){
            score = savedInstanceState.getInt("scoreValue");
            scoreValue.setText(score);
        }

        if(score>7){
            playerSkillClassification.setText("Bahubali");
        }
        else
        {
            playerSkillClassification.setText("Bicchaladeva");
        }
    }
}
