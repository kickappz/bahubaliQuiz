package load;

import android.app.Activity;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import model.QAPojo;

/**
 * Created by roope on 5/5/2017.
 */

/*
*
* Reads Json from text and parse it to required model list
* */
public class LoadQuestions{

    private List<QAPojo> mListData = new ArrayList<>();


// Parse Json to list
    public List<QAPojo> parseJsonToList(Context context){
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context));
            JSONArray jArray = obj.getJSONArray("questions");
            if (jArray != null) {
                for (int i=0;i<jArray.length();i++){
                    JSONObject jo =  jArray.getJSONObject(i);

                    QAPojo qa = new QAPojo();
                    int res = context.getResources().getIdentifier("img"+i,"drawable",context.getPackageName());
                    qa.setQuestion(jo.getString("questionTxt"));
                    qa.setQuestionNumber(Integer.parseInt(jo.getString("questionNum")));
                    qa.setOption1(jo.getString("option1"));
                    qa.setOption2(jo.getString("option2"));
                    qa.setOption3(jo.getString("option3"));
                    qa.setOption4(jo.getString("option4"));
                    qa.setAnswer(Integer.parseInt(jo.getString("answer")));
                    qa.setImg1(res);
                    mListData.add(qa);


                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return mListData;
    }

    // Load Json from asset folder
    private String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("qalist.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
