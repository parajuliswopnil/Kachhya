package com.example.prati.kachhya;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Intent;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class StudentSignUP extends AppCompatActivity {

    Database helper =new Database(this);
    String[] spinnerList = {"First", "Second", "Third", "Fourth"};
    String[] spinnerList1 = {"First", "Second"};



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_sign_up);









        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(StudentSignUP.this,android.R.layout.simple_dropdown_item_1line,spinnerList);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.year);
        betterSpinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(StudentSignUP.this,android.R.layout.simple_dropdown_item_1line,spinnerList1);
        MaterialBetterSpinner betterSpinner1 = (MaterialBetterSpinner) findViewById(R.id.semester);
        betterSpinner1.setAdapter(arrayAdapter1);

        Button submitBtn = (Button) findViewById(R.id.stdsubmitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setClass(StudentSignUP.this,MainLogin.class);
                startActivity(intent);
            }
        });


        }

        public void onSignUpClick(View v){
            if (v.getId()== R.id.stdsubmitBtn){
                EditText name = (EditText)findViewById(R.id.name);
                EditText department = (EditText)findViewById(R.id.department);
                EditText email = (EditText)findViewById(R.id.email);
                EditText password1 = (EditText)findViewById(R.id.password1);
                EditText password2 = (EditText)findViewById(R.id.password2);
                MaterialBetterSpinner year = (MaterialBetterSpinner)findViewById(R.id.year);
                MaterialBetterSpinner semester = (MaterialBetterSpinner)findViewById(R.id.semester);

                RadioButton gendMale =(RadioButton)findViewById(R.id.gendMale);
                RadioButton gendFemale =(RadioButton)findViewById(R.id.gendFemale);
                RadioButton gendOthers =(RadioButton)findViewById(R.id.gendOthers);
                EditText phnNumber = (EditText)findViewById(R.id.phnNumber);


                String namestr = name.getText().toString();
                String emailstr = email.getText().toString();
                String departmentstr = department.getText().toString();
                String password1str = password1.getText().toString();
                String password2str = password2.getText().toString();
                String phnNumberstr = phnNumber.getText().toString();
                String yearstr = year.getText().toString();

                String semesterstr = semester.getText().toString();

                String gendMalestr = gendMale.getText().toString();
                String gendFemalestr = gendFemale.getText().toString();
                String gendOthersstr = gendOthers.getText().toString();


                if (!password1str.equals(password2str)){
                    Toast.makeText(this, "PASSWORD DO NOT MATCH", Toast.LENGTH_SHORT).show();
                }
                else{
                    Data data = new Data();
                    data.setUserName(namestr);
                    data.setEmailAdd(emailstr);
                    data.setDepartment(departmentstr);
                    data.setPhoneNumber(phnNumberstr);
                    data.setYear(yearstr);

                    data.setSemester(semesterstr);

                    data.setGender(gendMalestr);
                    data.setGender(gendFemalestr);
                    data.setGender(gendOthersstr);


                    helper.insertContext(data);

                    }
                }


            }
        }

