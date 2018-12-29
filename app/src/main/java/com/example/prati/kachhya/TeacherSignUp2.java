package com.example.prati.kachhya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class TeacherSignUp2 extends AppCompatActivity {
    String[] dayList = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
            "27","28","29","30","31"};
    String[] monthList = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
    String[] yearList = {"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996",
            "1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016",
            "2017","2018"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_sign_up2);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(TeacherSignUp2.this, android.R.layout.simple_dropdown_item_1line,dayList);
        MaterialBetterSpinner materialBetterSpinner = (MaterialBetterSpinner) findViewById(R.id.android_material_design_spinner) ;
        materialBetterSpinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(TeacherSignUp2.this,android.R.layout.simple_dropdown_item_1line,monthList);
        MaterialBetterSpinner materialBetterSpinner1 = (MaterialBetterSpinner) findViewById(R.id.semester) ;
        materialBetterSpinner1.setAdapter(arrayAdapter1);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(TeacherSignUp2.this,android.R.layout.simple_dropdown_item_1line,yearList);
        MaterialBetterSpinner materialBetterSpinner2 = (MaterialBetterSpinner) findViewById(R.id.android_material_design_spinner2) ;
        materialBetterSpinner2.setAdapter(arrayAdapter2);
    }





}
