package com.example.studentdatabase;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student
{
    public Student() {
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "sname")
    String name;
    @ColumnInfo(name = "scollege")
    String college;

    public Student(@NonNull String name, String college) {
        this.name = name;
        this.college = college;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

}
