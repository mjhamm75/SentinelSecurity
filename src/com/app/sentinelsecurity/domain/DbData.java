package com.app.sentinelsecurity.domain;

import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DbData {
	public static final String DB_NAME = "sentinel_security";
	public static final int DB_VERSION = 1;

	public static final String TABLE_QUESTION = "question";
	public static final String Q_ID = BaseColumns._ID;

	public static final String Q_NOTIFY_1 = "notify_1";
	public static final String Q_NOTIFY_2 = "notify_2";
	public static final String Q_NOTIFY_3 = "notify_3";

	public static final String Q_SYSTEM_1 = "system_1";
	public static final String Q_SYSTEM_2 = "system_2";
	public static final String Q_SYSTEM_3 = "system_3";
	public static final String Q_SYSTEM_4 = "system_4";
	public static final String Q_SYSTEM_5 = "system_5";
	public static final String Q_SYSTEM_6 = "system_6";
	public static final String Q_SYSTEM_7 = "system_7";
	public static final String Q_SYSTEM_8 = "system_8";
	public static final String Q_SYSTEM_9 = "system_9";
	public static final String Q_SYSTEM_10 = "system_10";
	public static final String Q_SYSTEM_11 = "system_11";
	public static final String Q_SYSTEM_12 = "system_12";
	public static final String Q_SYSTEM_13 = "system_13";
	public static final String Q_SYSTEM_14 = "system_14";

	public static final String Q_SUPERVISORY_1 = "supervisory_1";
	public static final String Q_SUPERVISORY_2 = "supervisory_2";
	public static final String Q_SUPERVISORY_3 = "supervisory_3";
	public static final String Q_SUPERVISORY_4 = "supervisory_4";
	public static final String Q_SUPERVISORY_5 = "supervisory_5";
	public static final String Q_SUPERVISORY_6 = "supervisory_6";
	public static final String Q_SUPERVISORY_7 = "supervisory_7";

	public static final String Q_MONITORING_1 = "monitoring_1";
	public static final String Q_MONITORING_2 = "monitoring_2";
	public static final String Q_MONITORING_3 = "monitoring_3";

	public static final String Q_NOTIFICATION_RESUME_1 = "notification_resume_1";
	public static final String Q_NOTIFICATION_RESUME_2 = "notification_resume_2";
	public static final String Q_NOTIFICATION_RESUME_3 = "notification_resume_3";

	public static final String CREATE_TABLE_QUESTION = String.format("Create table %s (%s integer primary key, "
			+ "%s int, %s int, %s int, %s int, %s int, " + "%s int, %s int, %s int, %s int, %s int, "
			+ "%s int, %s int, %s int, %s int, %s int, " + "%s int, %s int, %s int, %s int, %s int, "
			+ "%s int, %s int, %s int, %s int, %s int, " + "%s int, %s int, %s int, %s int, %s int)", TABLE_QUESTION,
			Q_ID, Q_NOTIFY_1, Q_NOTIFY_2, Q_NOTIFY_3, Q_SYSTEM_1, Q_SYSTEM_2, Q_SYSTEM_3, Q_SYSTEM_4, Q_SYSTEM_5,
			Q_SYSTEM_6, Q_SYSTEM_7, Q_SYSTEM_8, Q_SYSTEM_9, Q_SYSTEM_10, Q_SYSTEM_11, Q_SYSTEM_12, Q_SYSTEM_13,
			Q_SYSTEM_14, Q_SUPERVISORY_1, Q_SUPERVISORY_2, Q_SUPERVISORY_3, Q_SUPERVISORY_4, Q_SUPERVISORY_5,
			Q_SUPERVISORY_6, Q_SUPERVISORY_7, Q_MONITORING_1, Q_MONITORING_2, Q_MONITORING_3, Q_NOTIFICATION_RESUME_1,
			Q_NOTIFICATION_RESUME_2, Q_NOTIFICATION_RESUME_3);

	Context context;
	DbHelper dbHelper;
	SQLiteDatabase db;

	public DbData(Context context) {
		this.context = context;
		dbHelper = new DbHelper();
		// db = dbHelper.getWritableDatabase();
		// dbHelper.onUpgrade(db, 1, 2);
	}

	public void createQuestion(Question question) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		db.insert(TABLE_QUESTION, null, values);
		closeDb();
	}
	
	public void updateQuestion(Map<String, String> question) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		

		addContentValue("", "", values);
		
		db.update(TABLE_QUESTION, values, BaseColumns._ID + "= 1", null);
		closeDb();
	}
	
	private void addContentValue(String name, String value, ContentValues values) {
		if(value != null && !value.equals("")) {
			values.put(name, value);
		}
	}

	private void closeDb() {
		db.close();
	}

	class DbHelper extends SQLiteOpenHelper {

		public DbHelper() {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_TABLE_QUESTION);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("drop TABLE " + TABLE_QUESTION + ";");
			onCreate(db);
		}
	}
}
