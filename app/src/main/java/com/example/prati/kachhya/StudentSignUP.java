package com.example.prati.kachhya;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class StudentSignUP extends AppCompatActivity {

    Database helper =new Database(this);
    String[] spinnerList = {"First", "Second", "Third", "Fourth"};
    String[] spinnerList1 = {"First", "Second"};
    String[] dayList = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
            "27","28","29","30","31"};
    String[] monthList = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
    String[] yearList = {"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996",
            "1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016",
            "2017","2018"};



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

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(StudentSignUP.this,android.R.layout.simple_dropdown_item_1line,dayList);
        MaterialBetterSpinner betterSpinner2 = (MaterialBetterSpinner) findViewById(R.id.dobdate);
        betterSpinner2.setAdapter(arrayAdapter2);

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(StudentSignUP.this,android.R.layout.simple_dropdown_item_1line,monthList);
        MaterialBetterSpinner betterSpinner3 = (MaterialBetterSpinner) findViewById(R.id.dobmonth);
        betterSpinner3.setAdapter(arrayAdapter3);

        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(StudentSignUP.this,android.R.layout.simple_dropdown_item_1line,yearList);
        MaterialBetterSpinner betterSpinner4 = (MaterialBetterSpinner) findViewById(R.id.dobyear);
        betterSpinner4.setAdapter(arrayAdapter4);
        }

        public void onSignUpClick(View v){
            if (v.getId()== R.id.submitBtn){
                EditText name = (EditText)findViewById(R.id.name);
                EditText department = (EditText)findViewById(R.id.department);
                EditText email = (EditText)findViewById(R.id.email);
                EditText password1 = (EditText)findViewById(R.id.password1);
                EditText password2 = (EditText)findViewById(R.id.password2);
                MaterialBetterSpinner year = (MaterialBetterSpinner)findViewById(R.id.year);
                MaterialBetterSpinner semester = (MaterialBetterSpinner)findViewById(R.id.semester);
                MaterialBetterSpinner dobyear = (MaterialBetterSpinner)findViewById(R.id.dobyear);
                MaterialBetterSpinner dobmonth = (MaterialBetterSpinner)findViewById(R.id.dobmonth);
                MaterialBetterSpinner dobdate = (MaterialBetterSpinner)findViewById(R.id.dobdate);
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
                String dobmonthstr = dobmonth.getText().toString();
                String semesterstr = semester.getText().toString();
                String dobyearstr = dobyear.getText().toString();
                String dobdatestr = dobdate.getText().toString();
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
                    data.setDobyear(dobyearstr);
                    data.setSemester(semesterstr);
                    data.setDay(dobdatestr);
                    data.setMonth(dobmonthstr);
                    data.setGender(gendMalestr);
                    data.setGender(gendFemalestr);
                    data.setGender(gendOthersstr);


                    helper.insertContext(data);

                    }
                }


            }
        }

