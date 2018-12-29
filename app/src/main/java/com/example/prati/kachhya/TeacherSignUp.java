package com.example.prati.kachhya;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class TeacherSignUp extends AppCompatActivity{
   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.teacher_sign_up);



       Button nextButton = (Button) findViewById(R.id.nxtBtn);
       nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               intent.setClass(TeacherSignUp.this, TeacherSignUp2.class);
               startActivity(intent);
           }
       });
   }







}
