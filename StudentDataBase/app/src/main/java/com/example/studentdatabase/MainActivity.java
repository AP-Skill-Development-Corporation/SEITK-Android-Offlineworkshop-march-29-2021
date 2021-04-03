package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ename,ecollege;

    StudentDataBase dataBase;

    List<Student> studentList;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tv_result);

        studentList=new ArrayList<>();

        dataBase= Room.databaseBuilder(this,
                StudentDataBase.class,"mydb").allowMainThreadQueries().build();





        findViewById(R.id.savedata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               String n= ename.getText().toString();
               String c= ecollege.getText().toString();

               Student student=new Student();

               student.setName(n);

               student.setCollege(c);

               dataBase.studentDao().insertdata(student);

                Toast.makeText(MainActivity.this, "inserted succesfully", Toast.LENGTH_SHORT).show();
               ename.setText("");
               ecollege.setText("");

            }
        });

        findViewById(R.id.retrivedata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                studentList=dataBase.studentDao().getdata();

                for (int i=0;i<studentList.size();i++)
                {
                    textView.append(""+studentList.get(i).getName()+"\n"+studentList.get(i).getCollege());
                }

            }
        });
    }

    public void delete(View view) {

       //normal db
        Toast.makeText(MainActivity.this, "deleted", Toast.LENGTH_SHORT).show();
    }
}