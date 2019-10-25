package com.example.ticketbookingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SqlDatabaseBooking extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Booking_list.db";
    private static final int VERSION=5;
    private static final String TABLE_NAME="Booking_list";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PHONE = "Phone";
    private static final String FROM="_From";
    private static final String TO="_To";
    private static final String DATE = "Date";
    private static final String TIME = "Time";
    private static final String BUS_NAME = "Busname";
    private static final String PERSON = "Person";
    private static final String BUS_TYPE = "Bustype";

    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" TEXT NOT NULL,"+PHONE+" TEXT NOT NULL,"+FROM+" TEXT NOT NULL,"+TO+" TEXT NOT NULL,"+DATE+" TEXT NOT NULL,"+TIME+" TEXT NOT NULL,"+BUS_NAME+" TEXT NOT NULL,"+PERSON+" TEXT NOT NULL,"+BUS_TYPE+" TEXT NOT NULL);";

    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;

    Context context;

    public SqlDatabaseBooking(Context context) {
        super(context,TABLE_NAME,null,VERSION);
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




    public long insertdata(BookingDetails bookingDetails)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(NAME,bookingDetails.getName());
        contentValues.put(PHONE,bookingDetails.getPhone());
        contentValues.put(FROM,bookingDetails.getFrom());
        contentValues.put(TO,bookingDetails.getTo());
        contentValues.put(DATE,bookingDetails.getDate());
        contentValues.put(TIME,bookingDetails.getTime());
        contentValues.put(BUS_NAME,bookingDetails.getBusname());
        contentValues.put(PERSON,bookingDetails.getPerson());
        contentValues.put(BUS_TYPE,bookingDetails.getBustype());


        long rowid=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;

    }
    public Cursor showData()
    {

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery(" SELECT * FROM "+TABLE_NAME,null);



        return cursor;
    }
}
