package com.example.prati.kachhya;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="data.db";
    private static final String TABLE_NAME="data";
    private static final String COLUMN_ID="std_id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_EMAL="emailAdd";
    private static final String COLUMN_PASSWORD="passwd";
    private static final String COLUMN_YEAR="year";
    private static final String COLUMN_SEMESTER="semester";
    private static final String COLUMN_DAY="day";
    private static final String COLUMN_MONTH="month";
    private static final String COLUMN_DOBYEAR="dobyear";
    private static final String COLUMN_GENDER="gender";
    private static final String COLUMN_PHONENUMBER="phoneNumber";
    SQLiteDatabase db;


    private static final String CREATE_TABLE="create table data(std_id integer primary key not null  , " +" name text not null, emailAdd text not null," +
            "passwd text not null, day text not null, month text not null, year text not null);";

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE);
        this.db=db;



    }
    public void insertContext(Data data){
        db = this.getReadableDatabase();
        ContentValues Values = new ContentValues();
        Values.put(COLUMN_NAME, data.getUserName());
        Values.put(COLUMN_EMAL,data.getEmailAdd());
        Values.put(COLUMN_PASSWORD,data.getPassswd());
        Values.put(COLUMN_PHONENUMBER,data.getPhoneNumber());
        Values.put(COLUMN_YEAR,data.getYear());
        Values.put(COLUMN_SEMESTER,data.getSemester());
        Values.put(COLUMN_DAY,data.getDay());
        Values.put(COLUMN_MONTH,data.getMonth());
        Values.put(COLUMN_DOBYEAR,data.getDobyear());


    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
       this.onCreate(db);



    }

}
