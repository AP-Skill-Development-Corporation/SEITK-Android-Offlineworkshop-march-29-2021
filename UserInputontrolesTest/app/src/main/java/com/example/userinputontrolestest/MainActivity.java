package com.example.userinputontrolestest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_mobile,et_email,et_password;
    TextView tv_result;
    RadioButton r_male,r_female;
    String gender;
    CheckBox ch_java,ch_android,ch_python;
    Spinner sp_branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.name);
        et_mobile = findViewById(R.id.mobile);
        et_email=findViewById(R.id.email);
        et_password = findViewById(R.id.password);
        r_male = findViewById(R.id.maleradiobutton);
        r_female = findViewById(R.id.femaleradiobutton);
        ch_java = findViewById(R.id.javacheckbox);
        ch_android = findViewById(R.id.androidcheckbox);
        ch_python = findViewById(R.id.pythoncheckbox);
        sp_branch = findViewById(R.id.branchspinner);
        tv_result = findViewById(R.id.resultTextview);
    }

    public void submit(View view) {
        String name = et_name.getText().toString();
        String mobile = et_mobile.getText().toString();
        String email = et_email.getText().toString();
        String pass = et_password.getText().toString();
        if(r_male.isChecked()){
            gender = r_male.getText().toString();
        }

        if(r_female.isChecked()){
            gender = r_female.getText().toString();
        }

        StringBuilder builder = new StringBuilder();
        if(ch_java.isChecked()){
            builder.append(ch_java.getText().toString()+" ");
        }

        if(ch_android.isChecked()){
            builder.append(ch_android.getText().toString()+" ");
        }

        if(ch_python.isChecked()){
            builder.append(ch_python.getText().toString());
        }

        String selectedBranch = sp_branch.getSelectedItem().toString();
        if(name.isEmpty() || mobile.isEmpty()
                || email.isEmpty() || pass.isEmpty()
                || gender.isEmpty() ||
                (sp_branch.getSelectedItemPosition() == 0)){
            Toast.makeText(this, "Please fill the details...",
                    Toast.LENGTH_SHORT).show();
        }else{
            tv_result.setText(name+"\n"+mobile+"\n"+email+"\n"
                    +pass+"\n"+gender+"\n"+builder+"\n"+selectedBranch);
        }



    }
}