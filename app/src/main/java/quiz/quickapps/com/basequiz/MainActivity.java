package quiz.quickapps.com.basequiz;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import load.LoadQuestions;
import model.QAPojo;

public class MainActivity extends AppCompatActivity {


    List<QAPojo> mQaList = new ArrayList<>();
    Context context = getApplicationContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgVw = (ImageView) findViewById(R.id.img_works);
        TextView txtVw = (TextView) findViewById(R.id.txt_view);

        try {
            LoadQuestions loadQuestions = new LoadQuestions();
            mQaList = loadQuestions.parseJsonToList(context);
            if (mQaList != null && mQaList.size() > 0) {
                Log.i("Base Quiz app", "onCreate: " + mQaList.size() + " -- image name:" + mQaList.get(1).getImg1());
            }
          /*  imgVw.setImageResource(mQaList.get(1).getImg1());
            txtVw.setText(mQaList.get(1).getQuestion());*/
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }
}
