package com.dsc.android.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name, et_email,et_pass,et_con_pass,et_username,et_savepass;
    private Button btn1;
    private String name,email,pass,con_pass;
    private TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new TinyDB(this);
        initView();
        btn1.setOnClickListener(this);
    }

    //Initialising the UI components
    private void initView()
    {
        et_name=findViewById(R.id.et_name);
        et_email=findViewById(R.id.et_email);
        et_pass=findViewById(R.id.et_pass);
        et_con_pass=findViewById(R.id.et_con_pass);
        btn1=findViewById(R.id.btn1);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn1:
                getInfo();
                register();
                break;
        }
    }

    private void getInfo()
    {
        name=et_name.getText().toString().trim();
        email=et_email.getText().toString().trim();
        pass=et_pass.getText().toString();              //never use trim() on password
        con_pass=et_con_pass.getText().toString();
    }

    private void register()
    {
        if(name.isEmpty() || email.isEmpty() || pass.isEmpty() || con_pass.isEmpty())
        {
            Toast.makeText(this, "One or more fields are empty", Toast.LENGTH_LONG).show();
        }
        else
        {
            if(!pass.equals(con_pass))
            {
                Toast.makeText(this, "Password and confirm password do not match!", Toast.LENGTH_LONG).show();
            }
            else
            {
                if(pass.length()<8)
                    Toast.makeText(this, "Use a stronger password !", Toast.LENGTH_SHORT).show();
                else
                {
                    Toast.makeText(this, "User Registered !", Toast.LENGTH_LONG).show();
                    db.putString("name",name);
                    db.putString("email",email);
                    db.putString("password",pass);
                    Intent i = new Intent(this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }
    }

}
