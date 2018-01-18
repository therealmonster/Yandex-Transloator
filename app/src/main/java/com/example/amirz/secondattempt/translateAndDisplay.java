package com.example.amirz.secondattempt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amirz.secondattempt.models.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class translateAndDisplay extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private TextView translation;
    private Button transBut;


    //API key obtained from Yandex
    private static final String KEY = "trnsl.1.1.20180116T212430Z.71962eff79ce5cd5.6929da3ba779b7f1999c6f556350607075611e0d";

    // Language
    private static final String LANG = "en-ru";

    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.text);
        translation = (TextView) findViewById(R.id.translatedText);
        transBut = (Button) findViewById(R.id.transBut);
        link = (TextView)findViewById(R.id.creditTextView);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        transBut.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.transBut) {
            String text = editText.getText().toString();

            Interface client = ApiService.gettingBuilder().create(Interface.class);
            Call<ResponseModel> call = client.translate(KEY, text, LANG);
            call.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    ResponseModel model = response.body();
                    translation.setText(model.getText()[0]);
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
