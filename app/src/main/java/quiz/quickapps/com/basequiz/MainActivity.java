package quiz.quickapps.com.basequiz;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import load.LoadQuestions;
import model.QAPojo;

public class MainActivity extends AppCompatActivity {


    List<QAPojo> mQaList = new ArrayList<>();
    int mScore;
    ImageView imgVw;
    TextView questionTxt;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    Button submitBtn;
    RadioGroup rdGroup;
    int questionNum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            LoadQuestions loadQuestions = new LoadQuestions();
            mQaList = loadQuestions.parseJsonToList(this);
            if (mQaList != null && mQaList.size() > 0) {
                Log.i("Base Quiz app", "onCreate: " + mQaList.size() + " -- image name:" + mQaList.get(1).getImg1());
               // Collections.shuffle(mQaList);
            }
            setupView();

            loadQuestion(questionNum);
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdGroup.getCheckedRadioButtonId()== -1){
                    Toast.makeText(getBaseContext(),"Please select one option to submit",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(rdGroup.getCheckedRadioButtonId()==mQaList.get(questionNum).getAnswer()){
                        mScore++;
                    }
                    if(questionNum-1<mQaList.size()) {
                        questionNum++;
                        rdGroup.clearCheck();
                        loadQuestion(questionNum);
                    }
                    else {
                        Intent intent = new  Intent(MainActivity.this,ResultActivity.class);
                        intent.putExtra("scoreValue",mScore);
                        startActivity(intent);
                    }

                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("quesNum", questionNum);
        if(rdGroup.getCheckedRadioButtonId()!=-1)
        {
            outState.putInt("selectedValue",rdGroup.getCheckedRadioButtonId());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        questionNum=savedInstanceState.getInt("quesNum");
        if(savedInstanceState.containsKey("selectedValue")){

        }

    }

    private void loadQuestion(int index){
            questionTxt.setText(mQaList.get(index).getQuestion());
            imgVw.setImageResource(mQaList.get(index).getImg1());
            radio1.setText(mQaList.get(index).getOption1());
            radio2.setText(mQaList.get(index).getOption2());
            radio3.setText(mQaList.get(index).getOption3());
            radio4.setText(mQaList.get(index).getOption4());

        Toast.makeText(getBaseContext(),"index value : "+index+" list value"+mQaList.size(),Toast.LENGTH_SHORT).show();
    }

    private void setupView(){
         imgVw = (ImageView) findViewById(R.id.img_works);
         questionTxt = (TextView) findViewById(R.id.question_txt);
         radio1 = (RadioButton)findViewById(R.id.option1);
         radio2 = (RadioButton)findViewById(R.id.option2);
         radio3 = (RadioButton)findViewById(R.id.option3);
         radio4 = (RadioButton)findViewById(R.id.option4);
        rdGroup = (RadioGroup)findViewById(R.id.optionsGroup);
         submitBtn = (Button) findViewById(R.id.submit_btn);
    }
}
