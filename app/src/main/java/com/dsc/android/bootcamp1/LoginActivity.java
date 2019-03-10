package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_username,et_savepass;
    private String username,savepass;
    private Button btn;
    private TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn.setOnClickListener(this);

        initView();
    }

    private void initView()
    {
        et_username=findViewById(R.id.et_username);
        et_savepass=findViewById(R.id.et_savepass);
        btn=findViewById(R.id.btn_login);
    }

    private void getInfo()
    {
        username=et_username.toString().trim();
        savepass=et_savepass.toString();
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_login:
                getInfo();
                check();
                break;
        }
    }

    private void check()
    {
        if(username.isEmpty() || savepass.isEmpty())
            Toast.makeText(this, "Username or Password is Empty !", Toast.LENGTH_SHORT).show();
        else
        {

        }
    }
}
