package com.app.sentinelsecurity.domain;

import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DbData {
	public static final String DB_NAME = "sentinel_security";
	public static final int DB_VERSION = 3;

	public static final String TABLE_QUESTION = "question";
	public static final String Q_ID = BaseColumns._ID;

	public static final String Q_NOTIFY_1_YES = "notify_1_y";
	public static final String Q_NOTIFY_2_YES = "notify_2_y";
	public static final String Q_NOTIFY_3_YES = "notify_3_y";

	public static final String Q_NOTIFY_1_NO = "notify_1_n";
	public static final String Q_NOTIFY_2_NO = "notify_2_n";
	public static final String Q_NOTIFY_3_NO = "notify_3_n";

	public static final String Q_NOTIFY_1_COMMENT = "notify_1_comment";
	public static final String Q_NOTIFY_2_COMMENT = "notify_2_comment";
	public static final String Q_NOTIFY_3_COMMENT = "notify_3_comment";

	public static final String Q_SYSTEM_1_YES = "system_1_y";
	public static final String Q_SYSTEM_2_YES = "system_2_y";
	public static final String Q_SYSTEM_3_YES = "system_3_y";
	public static final String Q_SYSTEM_4_YES = "system_4_y";
	public static final String Q_SYSTEM_5_YES = "system_5_y";
	public static final String Q_SYSTEM_6_YES = "system_6_y";
	public static final String Q_SYSTEM_7_YES = "system_7_y";
	public static final String Q_SYSTEM_8_YES = "system_8_y";
	public static final String Q_SYSTEM_9_YES = "system_9_y";
	public static final String Q_SYSTEM_10_YES = "system_10_y";
	public static final String Q_SYSTEM_11_YES = "system_11_y";
	public static final String Q_SYSTEM_12_YES = "system_12_y";
	public static final String Q_SYSTEM_13_YES = "system_13_y";
	public static final String Q_SYSTEM_14_YES = "system_14_y";

	public static final String Q_SYSTEM_1_NO = "system_1_n";
	public static final String Q_SYSTEM_2_NO = "system_2_n";
	public static final String Q_SYSTEM_3_NO = "system_3_n";
	public static final String Q_SYSTEM_4_NO = "system_4_n";
	public static final String Q_SYSTEM_5_NO = "system_5_n";
	public static final String Q_SYSTEM_6_NO = "system_6_n";
	public static final String Q_SYSTEM_7_NO = "system_7_n";
	public static final String Q_SYSTEM_8_NO = "system_8_n";
	public static final String Q_SYSTEM_9_NO = "system_9_n";
	public static final String Q_SYSTEM_10_NO = "system_10_n";
	public static final String Q_SYSTEM_11_NO = "system_11_n";
	public static final String Q_SYSTEM_12_NO = "system_12_n";
	public static final String Q_SYSTEM_13_NO = "system_13_n";
	public static final String Q_SYSTEM_14_NO = "system_14_n";

	public static final String Q_SYSTEM_1_COMMENT = "system_1_comment";
	public static final String Q_SYSTEM_2_COMMENT = "system_2_comment";
	public static final String Q_SYSTEM_3_COMMENT = "system_3_comment";
	public static final String Q_SYSTEM_4_COMMENT = "system_4_comment";
	public static final String Q_SYSTEM_5_COMMENT = "system_5_comment";
	public static final String Q_SYSTEM_6_COMMENT = "system_6_comment";
	public static final String Q_SYSTEM_7_COMMENT = "system_7_comment";
	public static final String Q_SYSTEM_8_COMMENT = "system_8_comment";
	public static final String Q_SYSTEM_9_COMMENT = "system_9_comment";
	public static final String Q_SYSTEM_10_COMMENT = "system_10commentn";
	public static final String Q_SYSTEM_11_COMMENT = "system_11commentn";
	public static final String Q_SYSTEM_12_COMMENT = "system_12commentn";
	public static final String Q_SYSTEM_13_COMMENT = "system_13commentn";
	public static final String Q_SYSTEM_14_COMMENT = "system_14commentn";

	public static final String Q_SUPERVISORY_1_YES = "supervisory_1_y";
	public static final String Q_SUPERVISORY_2_YES = "supervisory_2_y";
	public static final String Q_SUPERVISORY_3_YES = "supervisory_3_y";
	public static final String Q_SUPERVISORY_4_YES = "supervisory_4_y";
	public static final String Q_SUPERVISORY_5_YES = "supervisory_5_y";
	public static final String Q_SUPERVISORY_6_YES = "supervisory_6_y";
	public static final String Q_SUPERVISORY_7_YES = "supervisory_7_y";

	public static final String Q_SUPERVISORY_1_NO = "supervisory_1_n";
	public static final String Q_SUPERVISORY_2_NO = "supervisory_2_n";
	public static final String Q_SUPERVISORY_3_NO = "supervisory_3_n";
	public static final String Q_SUPERVISORY_4_NO = "supervisory_4_n";
	public static final String Q_SUPERVISORY_5_NO = "supervisory_5_n";
	public static final String Q_SUPERVISORY_6_NO = "supervisory_6_n";
	public static final String Q_SUPERVISORY_7_NO = "supervisory_7_n";

	public static final String Q_SUPERVISORY_1_COMMENT = "supervisory_1_comment";
	public static final String Q_SUPERVISORY_2_COMMENT = "supervisory_2_comment";
	public static final String Q_SUPERVISORY_3_COMMENT = "supervisory_3_comment";
	public static final String Q_SUPERVISORY_4_COMMENT = "supervisory_4_comment";
	public static final String Q_SUPERVISORY_5_COMMENT = "supervisory_5_comment";
	public static final String Q_SUPERVISORY_6_COMMENT = "supervisory_6_comment";
	public static final String Q_SUPERVISORY_7_COMMENT = "supervisory_7_comment";

	public static final String Q_MONITORING_1_YES = "monitoring_1_y";
	public static final String Q_MONITORING_2_YES = "monitoring_2_y";
	public static final String Q_MONITORING_3_YES = "monitoring_3_y";

	public static final String Q_MONITORING_1_NO = "monitoring_1_n";
	public static final String Q_MONITORING_2_NO = "monitoring_2_n";
	public static final String Q_MONITORING_3_NO = "monitoring_3_n";

	public static final String Q_MONITORING_1_COMMENT = "monitoring_1_comment";
	public static final String Q_MONITORING_2_COMMENT = "monitoring_2_comment";
	public static final String Q_MONITORING_3_COMMENT = "monitoring_3_comment";

	public static final String Q_NOTIFICATION_RESUME_1_YES = "notification_resume_1_y";
	public static final String Q_NOTIFICATION_RESUME_2_YES = "notification_resume_2_y";
	public static final String Q_NOTIFICATION_RESUME_3_YES = "notification_resume_3_y";

	public static final String Q_NOTIFICATION_RESUME_1_NO = "notification_resume_1_n";
	public static final String Q_NOTIFICATION_RESUME_2_NO = "notification_resume_2_n";
	public static final String Q_NOTIFICATION_RESUME_3_NO = "notification_resume_3_n";

	public static final String Q_NOTIFICATION_RESUME_1_COMMENT = "notification_resume_1_comment";
	public static final String Q_NOTIFICATION_RESUME_2_COMMENT = "notification_resume_2_comment";
	public static final String Q_NOTIFICATION_RESUME_3_COMMENT = "notification_resume_3_comment";

	public static final String CREATE_TABLE_QUESTION = String
			.format("Create table %s (%s integer primary key, " //
					+ "%s int, %s int, %s int, " //
					+ "%s int, %s int, %s int, " //
					+ "%s text, %s text, %s text, " //
					+ "%s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, " //
					+ "%s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, %s int, " //
					+ "%s text,%s text,%s text,%s text,%s text,%s text,%s text,%s text,%s text,%s text,%s text,%s text,%s text,%s text, " //
					+ "%s int, %s int, %s int, %s int, %s int, %s int, %s int, " //
					+ "%s int, %s int, %s int, %s int, %s int, %s int, %s int, " //
					+ "%s text, %s text, %s text, %s text, %s text, %s text, %s text," //
					+ "%s int, %s int, %s int, " // 
					+ "%s int, %s int, %s int, " //
					+ "%s text, %s text, %s text, " //
					+ "%s int, %s int, %s int, " //
					+ "%s int, %s int, %s int," //
					+ "%s text, %s text, %s text " //
					+ ")", //
					
					TABLE_QUESTION, //

					Q_ID, Q_NOTIFY_1_YES, Q_NOTIFY_2_YES, Q_NOTIFY_3_YES, // 
					
					Q_NOTIFY_1_NO, Q_NOTIFY_2_NO, Q_NOTIFY_3_NO, //

					Q_NOTIFY_1_COMMENT, Q_NOTIFY_2_COMMENT, Q_NOTIFY_3_COMMENT, //

					Q_SYSTEM_1_YES, Q_SYSTEM_2_YES, Q_SYSTEM_3_YES, Q_SYSTEM_4_YES, Q_SYSTEM_5_YES, Q_SYSTEM_6_YES, Q_SYSTEM_7_YES, Q_SYSTEM_8_YES, Q_SYSTEM_9_YES, Q_SYSTEM_10_YES, Q_SYSTEM_11_YES, Q_SYSTEM_12_YES, Q_SYSTEM_13_YES, Q_SYSTEM_14_YES, // 
					
					Q_SYSTEM_1_NO, Q_SYSTEM_2_NO, Q_SYSTEM_3_NO, Q_SYSTEM_4_NO, Q_SYSTEM_5_NO, Q_SYSTEM_6_NO, Q_SYSTEM_7_NO, Q_SYSTEM_8_NO, Q_SYSTEM_9_NO, Q_SYSTEM_10_NO, Q_SYSTEM_11_NO, Q_SYSTEM_12_NO, Q_SYSTEM_13_NO, Q_SYSTEM_14_NO, // 
					
					Q_SYSTEM_1_COMMENT, Q_SYSTEM_2_COMMENT, Q_SYSTEM_3_COMMENT, Q_SYSTEM_4_COMMENT, Q_SYSTEM_5_COMMENT, Q_SYSTEM_6_COMMENT, Q_SYSTEM_7_COMMENT, Q_SYSTEM_8_COMMENT, Q_SYSTEM_9_COMMENT, Q_SYSTEM_10_COMMENT, Q_SYSTEM_11_COMMENT, Q_SYSTEM_12_COMMENT, Q_SYSTEM_13_COMMENT, Q_SYSTEM_14_COMMENT, //
					
					Q_SUPERVISORY_1_YES, Q_SUPERVISORY_2_YES, Q_SUPERVISORY_3_YES, Q_SUPERVISORY_4_YES, Q_SUPERVISORY_5_YES, Q_SUPERVISORY_6_YES, Q_SUPERVISORY_7_YES, //

					Q_SUPERVISORY_1_NO, Q_SUPERVISORY_2_NO, Q_SUPERVISORY_3_NO, Q_SUPERVISORY_4_NO, Q_SUPERVISORY_5_NO, Q_SUPERVISORY_6_NO, Q_SUPERVISORY_7_NO, //
					
					Q_SUPERVISORY_1_COMMENT, Q_SUPERVISORY_2_COMMENT, Q_SUPERVISORY_3_COMMENT, Q_SUPERVISORY_4_COMMENT, Q_SUPERVISORY_5_COMMENT, Q_SUPERVISORY_6_COMMENT, Q_SUPERVISORY_7_COMMENT, // 
					
					Q_MONITORING_1_YES, Q_MONITORING_2_YES, Q_MONITORING_3_YES, //

					Q_MONITORING_1_NO, Q_MONITORING_2_NO, Q_MONITORING_3_NO, //
					
					Q_MONITORING_1_COMMENT, Q_MONITORING_2_COMMENT, Q_MONITORING_3_COMMENT, 
					
					Q_NOTIFICATION_RESUME_1_YES, Q_NOTIFICATION_RESUME_2_YES, Q_NOTIFICATION_RESUME_3_YES, // 
					
					Q_NOTIFICATION_RESUME_1_NO, Q_NOTIFICATION_RESUME_2_NO, Q_NOTIFICATION_RESUME_3_NO, //
					
					Q_NOTIFICATION_RESUME_1_COMMENT, Q_NOTIFICATION_RESUME_2_COMMENT, Q_NOTIFICATION_RESUME_3_COMMENT
					
					); //

	Context context;
	DbHelper dbHelper;
	SQLiteDatabase db;

	public DbData(Context context) {
		this.context = context;
		dbHelper = new DbHelper();
		// db = dbHelper.getWritableDatabase();
		// dbHelper.onUpgrade(db, 1, 3);
	}

	public Long createQuestion() {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(Q_NOTIFY_1_YES, "0");
		values.put(Q_NOTIFY_2_YES, "0");
		values.put(Q_NOTIFY_3_YES, "0");
		values.put(Q_NOTIFY_1_NO, "0");
		values.put(Q_NOTIFY_2_NO, "0");
		values.put(Q_NOTIFY_3_NO, "0");
		values.put(Q_SYSTEM_1_YES, "0");
		values.put(Q_SYSTEM_2_YES, "0");
		values.put(Q_SYSTEM_3_YES, "0");
		values.put(Q_SYSTEM_4_YES, "0");
		values.put(Q_SYSTEM_5_YES, "0");
		values.put(Q_SYSTEM_6_YES, "0");
		values.put(Q_SYSTEM_7_YES, "0");
		values.put(Q_SYSTEM_8_YES, "0");
		values.put(Q_SYSTEM_9_YES, "0");
		values.put(Q_SYSTEM_10_YES, "0");
		values.put(Q_SYSTEM_11_YES, "0");
		values.put(Q_SYSTEM_12_YES, "0");
		values.put(Q_SYSTEM_13_YES, "0");
		values.put(Q_SYSTEM_14_YES, "0");
		values.put(Q_SYSTEM_1_NO, "0");
		values.put(Q_SYSTEM_2_NO, "0");
		values.put(Q_SYSTEM_3_NO, "0");
		values.put(Q_SYSTEM_4_NO, "0");
		values.put(Q_SYSTEM_5_NO, "0");
		values.put(Q_SYSTEM_6_NO, "0");
		values.put(Q_SYSTEM_7_NO, "0");
		values.put(Q_SYSTEM_8_NO, "0");
		values.put(Q_SYSTEM_9_NO, "0");
		values.put(Q_SYSTEM_10_NO, "0");
		values.put(Q_SYSTEM_11_NO, "0");
		values.put(Q_SYSTEM_12_NO, "0");
		values.put(Q_SYSTEM_13_NO, "0");
		values.put(Q_SYSTEM_14_NO, "0");
		values.put(Q_SUPERVISORY_1_YES, "0");
		values.put(Q_SUPERVISORY_2_YES, "0");
		values.put(Q_SUPERVISORY_3_YES, "0");
		values.put(Q_SUPERVISORY_4_YES, "0");
		values.put(Q_SUPERVISORY_5_YES, "0");
		values.put(Q_SUPERVISORY_6_YES, "0");
		values.put(Q_SUPERVISORY_7_YES, "0");
		values.put(Q_SUPERVISORY_1_NO, "0");
		values.put(Q_SUPERVISORY_2_NO, "0");
		values.put(Q_SUPERVISORY_3_NO, "0");
		values.put(Q_SUPERVISORY_4_NO, "0");
		values.put(Q_SUPERVISORY_5_NO, "0");
		values.put(Q_SUPERVISORY_6_NO, "0");
		values.put(Q_SUPERVISORY_7_NO, "0");
		values.put(Q_MONITORING_1_YES, "0");
		values.put(Q_MONITORING_2_YES, "0");
		values.put(Q_MONITORING_3_YES, "0");
		values.put(Q_MONITORING_1_NO, "0");
		values.put(Q_MONITORING_2_NO, "0");
		values.put(Q_MONITORING_3_NO, "0");
		values.put(Q_NOTIFICATION_RESUME_1_YES, "0");
		values.put(Q_NOTIFICATION_RESUME_2_YES, "0");
		values.put(Q_NOTIFICATION_RESUME_3_YES, "0");
		values.put(Q_NOTIFICATION_RESUME_1_NO, "0");
		values.put(Q_NOTIFICATION_RESUME_2_NO, "0");
		values.put(Q_NOTIFICATION_RESUME_3_NO, "0");

		// Cursor cursor = db.rawQuery("PRAGMA table_info(" + TABLE_QUESTION +
		// ")", null);
		// if (cursor.moveToFirst()) {
		// do {
		// values.put(cursor.getString(1), 0);
		// } while (cursor.moveToNext());
		// }

		values.remove("_id");

		Long id = db.insert(TABLE_QUESTION, null, values);
		closeDb();
		return id;
	}

	public void updateQuestion(String dbColumn, Boolean isChecked, Long id) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(dbColumn, isChecked ? 1 : 0);

		db.update(TABLE_QUESTION, values, BaseColumns._ID + "=" + id, null);
		closeDb();
	}

	public Cursor getQuestionsFromDB(Long id) {
		db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query(TABLE_QUESTION, null, "_ID = 1", null, null, null, null);
		return cursor;
	}

	public void insertQuestions(Map<String, Question> questions) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();

		for (Map.Entry<String, Question> entry : questions.entrySet()) {
			String key = entry.getKey();
			Question question = entry.getValue();

			if (key != null && question.getIsYesChecked() != null) {
				values.put(key, question.getIsYesChecked() ? 1 : 0);
			}
			if (key != null && question.getIsNoChecked() != null) {
				values.put(key, question.getIsNoChecked() ? 1 : 0);
			}
			db.insert(TABLE_QUESTION, null, values);
		}
		this.closeDb();
	}

	public void closeDb() {
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
//			db.execSQL("drop TABLE " + TABLE_QUESTION + ";");
			onCreate(db);
		}
	}
}
