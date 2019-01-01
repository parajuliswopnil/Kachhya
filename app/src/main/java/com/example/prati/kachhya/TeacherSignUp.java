package com.example.prati.kachhya;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class TeacherSignUp extends AppCompatActivity{
    DatabaseTeacher helper = new DatabaseTeacher(this);
   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.teacher_sign_up);

       Button teacherSubmit = (Button) findViewById(R.id.techsubmitBtn);
       teacherSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent1 = new Intent();
               intent1.setClass(TeacherSignUp.this, MainLogin.class);
               startActivity(intent1);
           }
       });
   }

       public void onSignpClick1(View v){
           if(v.getId()==R.id.techsubmitBtn){
               EditText name = (EditText)findViewById(R.id.techName);
               EditText emailId = (EditText) findViewById(R.id.techEmail);
               EditText department = (EditText)findViewById(R.id.techDepart);
               EditText phoneNumber = (EditText)findViewById(R.id.techPhn);
               EditText password = (EditText)findViewById(R.id.techPass);
               EditText confirmPassword = (EditText)findViewById(R.id.techPass1);
               RadioButton male = (RadioButton)findViewById(R.id.techgendMale);
               RadioButton female = (RadioButton)findViewById(R.id.techgendFemale);
               RadioButton others = (RadioButton)findViewById(R.id.techgendOthers);

               String namestr1 = name.getText().toString();
               String emailstr1 = emailId.getText().toString();
               String departmentstr1 = department.getText().toString();
               String phoneNumberstr1 = phoneNumber.getText().toString();
               String passwordstr1 = password.getText().toString();
               String passwordstr2 = confirmPassword.getText().toString();
               String gendMalestr1 = male.getText().toString();
               String gendFemale1 = female.getText().toString();
               String gendOthers1 = others.getText().toString();

               if (!passwordstr1.equals(passwordstr2)){
                   Toast.makeText(this, "PASSWORD DO NOT MATCH", Toast.LENGTH_SHORT).show();
               }

               else {
                   DataTeacher dataTeacher = new DataTeacher();
                   dataTeacher.setName(namestr1);
                   dataTeacher.setEmailAdd(emailstr1);
                   dataTeacher.setGender(gendFemale1);
                   dataTeacher.setGender(gendMalestr1);
                   dataTeacher.setGender(gendOthers1);
                   dataTeacher.setPhoneNumber(phoneNumberstr1);
                   dataTeacher.setDepartment(departmentstr1);

                   helper.insertContext(dataTeacher);

               }


           }





   }







}
