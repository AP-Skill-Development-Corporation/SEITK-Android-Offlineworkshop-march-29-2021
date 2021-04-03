package com.example.studentdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao
{
    @Insert
    public void insertdata(Student student);

    @Query("select * from student_table")
    List<Student> getdata();

    @Delete
    public void deletedata(Student student);
}
