package com.example.ticketbookingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Sqldatabasehelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Passenger_list.db";
    private static final int VERSION=3;
    private static final String TABLE_NAME="Passenger_list";
    private static final String ID="_Id";
    private static final String NAME="Name";
    private static final String PHONE = "Phone";
    private static final String EMAIL = "Email";
    private static final String USER_NAME = "UserName";
    private static final String PASSWORD = "Password";

    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" TEXT NOT NULL,"+PHONE+" TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL,"+USER_NAME+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL);";

    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;

    Context context;



    public Sqldatabasehelper(Context context) {
        super(context, TABLE_NAME, null, VERSION);

        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try
        {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Toast.makeText(context,"table is created",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try
        {
            Toast.makeText(context,"onUpgrade is called",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }
        catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
        }

    }


    public long insertdata(UserDetails userDetails)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(NAME,userDetails.getName());
        contentValues.put(PHONE,userDetails.getPhone());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(USER_NAME,userDetails.getUsername());
        contentValues.put(PASSWORD,userDetails.getPassword());

        long rowid=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;

    }


    public Boolean find(String un,String pw)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        Boolean result=false;

        if(cursor.getCount()==0)
        {
            Toast.makeText(context,"NO DATA IS FOUND",Toast.LENGTH_LONG).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                String username = cursor.getString(4);
                String password = cursor.getString(5);
                if (username.equals(un) && password.equals(pw))
                {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
