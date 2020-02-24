package com.openobject.parsingpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataInputActivity extends AppCompatActivity {

    private EditText idEt;
    private EditText passEt;
    private Button loginBtn;
    private TextView resultTv;
    private Button parsingBtn;
    private TextView resultTv2;
    private StringBuffer sb = new StringBuffer();
    private StringBuffer sb2 = new StringBuffer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input);

        idEt = findViewById(R.id.id_et);
        passEt = findViewById(R.id.pass_et);
        loginBtn = findViewById(R.id.login_btn);
        resultTv = findViewById(R.id.result_tv);
        parsingBtn = findViewById(R.id.parsing_btn);
        resultTv2 = findViewById(R.id.result2_tv);

        loginBtn.setOnClickListener(onClickListener);
        parsingBtn.setOnClickListener(onClickListener);

    }

    private ArrayList<ClientVO> clientList = new ArrayList<>();
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            switch (view.getId()) {

                case R.id.login_btn:

                    String startJson = "[";
                    String endJson = "]";

                    if (!sb.toString().equals("")) {
                        sb.append(",");
                    }

                    String temp = "{\"userId\"" + ":" + "\"" + idEt.getText().toString() + "\","
                            + "\"userPassword\"" + ":" + "\"" + passEt.getText().toString() + "\"}";
                    sb.append(temp);
                    resultTv.setText(startJson + sb + endJson);
                    break;

                case R.id.parsing_btn:

                    try {


                        JSONArray jsonArray = new JSONArray(resultTv.getText().toString());

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            ClientVO client = new ClientVO();
                            client.setId(jsonObject.getString("userId"));
                            client.setPassword(jsonObject.getString("userPassword"));

                            clientList.add(client);


                        }


                        sb2.append("[" + clientList.get(clientList.size()-1).getId() + ","
                                + clientList.get(clientList.size()-1).getPassword() + "]\n");


                        resultTv2.setText(sb2);
                        //sb2.setLength(0);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }


        }
    };
}
