package com.umkc.firebase;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Sentiment extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;
    String sentiment;


    private class AskWatsonTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... textsToAnalyse) {
            System.out.println(editText.getText());

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText("what is happening inside a thread - running watson alchemy api");
                }
            });


            sentiment = "Test Sentiment";
            System.out.println(sentiment);

            return sentiment;
        }

        @Override
        protected void onPostExecute(String result){
            textView.setText("The message's sentiment is : " +result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView = (TextView) findViewById(R.id.sentimentoutput);
        editText = (EditText) findViewById(R.id.input_sentiment_text);
        button = (Button) findViewById(R.id.btnAnalyze);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Logging to the console that the button pressed for the text :" +editText);
                textView.setText("Dispalying at the UI the sentiment to be checked for :" +editText.getText());

                AskWatsonTask task = new AskWatsonTask();
                task.execute(new String[]{});
            }
        });
    }
}
