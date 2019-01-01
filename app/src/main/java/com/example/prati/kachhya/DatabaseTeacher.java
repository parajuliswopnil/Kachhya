package com.example.prati.kachhya;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;


public class DatabaseTeacher extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="data1.db";
    private static final String TABLE_NAME="data";
    private static final String COLUMN_ID="std_id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_EMAL="emailAdd";
    private static final String COLUMN_PASSWORD="passwd";
    private static final String COLUMN_GENDER="gender";
    private static final String COLUMN_PHONENUMBER="phoneNumber";
    SQLiteDatabase db;

    private static final String CREATE_TABLE="create table data(std_id integer primary key not null  , " +" name text not null, emailAdd text not null," +
            "passwd text not null, year text not null, semester text not null, gender text not null, phoneNumber text not null);";

    public DatabaseTeacher(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db=db;

    }
    public void insertContext(DataTeacher dataTeacher) {
        db = this.getReadableDatabase();
        ContentValues Values = new ContentValues();
        Values.put(COLUMN_NAME, dataTeacher.getName());
        Values.put(COLUMN_EMAL, dataTeacher.getEmailAdd());
        Values.put(COLUMN_PASSWORD, dataTeacher.getPassword());
        Values.put(COLUMN_PHONENUMBER, dataTeacher.getPhoneNumber());
        Values.put(COLUMN_GENDER, dataTeacher.getGender());


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
