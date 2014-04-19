package com.infy.balloon.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	
	public static final String TABLE_NAME = "Balloon_HighScore";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN1_NAME = "Name";
	public static final String COLUMN2_NAME = "Score";
	public static final String COLUMN3_NAME = "Date";
	
	private static final String DATABASE_NAME = "Balloon.db";
	private static final int DATABASE_VERSION = 1;
	 
	// Database creation sql statement
	  private static final String DATABASE_CREATE = "create table "
	      + TABLE_NAME + "(" + COLUMN_ID
	      + " integer primary key autoincrement, " + COLUMN1_NAME
	      + " text not null, " + COLUMN2_NAME + " text not null, " + COLUMN3_NAME + " text not null);";

	  public MySQLiteHelper(Context context) {
		    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }
	  
	@Override
	public void onCreate(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(MySQLiteHelper.class.getName(),"Upgrading database from version " + oldVersion + " to "+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

}