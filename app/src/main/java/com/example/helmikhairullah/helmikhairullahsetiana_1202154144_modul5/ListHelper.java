package com.example.helmikhairullah.helmikhairullahsetiana_1202154144_modul5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Helmi Khairullah on 25/03/2018.
 */

public class ListHelper extends SQLiteOpenHelper {

    // It's a good idea to always define a log tag like this.
    private static final String TAG = TODO_LIST.class.getSimpleName();

    // has to be 1 first time or app will crash
    private static final int DATABASE_VERSION = 1;
    private static final String WORD_LIST_TABLE = "table_kegiatan";
    private static final String DATABASE_NAME = "todolist";

    // Column names...
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "nama";
    public static final String COL_TODO = "list";
    public static final String COL_PRIOR = "priority";

    // Build the SQL query that creates the table.
    private static final String TODO_LIST_TABLE_CREATE =
            "CREATE TABLE " + WORD_LIST_TABLE + " (" +
                    COL_ID + " INTEGER PRIMARY KEY, " +
                    // id will auto-increment if no value passed
                    COL_NAME + " TEXT, " +
                    COL_TODO + " TEXT, " +
                    COL_PRIOR + " INTEGER );";

    // ... and a string array of columns.
    private static final String[] COLUMNS = {COL_ID, COL_NAME, COL_TODO, COL_PRIOR};

    private SQLiteDatabase mWritableDB;
    private SQLiteDatabase mReadableDB;


    public ListHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TODO_LIST_TABLE_CREATE);
        //fillDatabaseWithData(sqLiteDatabase);

    }

    // GAK HARUS ADA SOALNYA AWALNYA EMANG BLM ADA DARTA
//    private void fillDatabaseWithData(SQLiteDatabase sqLiteDatabase) {
//
//        // Create a container for the data.
//        ContentValues values = new ContentValues();
//        values.put(COL_NAME, ) ;
//        values.put(COL_TODO, );
//        values.put(COL_PRIOR, );
//    }

    public TODO_LIST query(int position) {
        String query = "SELECT  * FROM " + WORD_LIST_TABLE +
                " ORDER BY " + COL_ID + " ASC " +
                "LIMIT " + position + ", 1" ;
        Cursor cursor = null;
        TODO_LIST entry = new TODO_LIST();

        try {
            if (mReadableDB == null) {
                mReadableDB = getReadableDatabase();
            }
            cursor = mReadableDB.rawQuery(query, null);
            cursor.moveToFirst();
            entry.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
            entry.setNamaKegiatan(cursor.getString(cursor.getColumnIndex(COL_NAME)));
            entry.setKegiatan(cursor.getString(cursor.getColumnIndex(COL_TODO)));
            entry.setPrioritas(cursor.getInt(cursor.getColumnIndex(COL_PRIOR)));
        } catch (Exception e) {
            Log.d(TAG, "QUERY EXCEPTION! " + e.getMessage());
        } finally {
            cursor.close();
            return entry;
        }

    }

    public long insert(String nama, String kegiatan, int prioritas) {
        long newId = 0;
        ContentValues values = new ContentValues();
        values.put(COL_NAME, nama);
        values.put(COL_TODO, kegiatan);
        values.put(COL_PRIOR, prioritas);
        try {
            if (mWritableDB == null) {
                mWritableDB = getWritableDatabase();
            }
            newId = mWritableDB.insert(WORD_LIST_TABLE, null, values);
        } catch (Exception e) {
            Log.d(TAG, "INSERT EXCEPTION! " + e.getMessage());
        }
        return newId;
    }

    public int delete(int id) {
        int deleted = 0;
        try {
            if (mWritableDB == null) {
                mWritableDB = getWritableDatabase();
            }
            deleted = mWritableDB.delete(WORD_LIST_TABLE, //table name
                    COL_ID + " =? ", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            Log.d(TAG, "DELETE EXCEPTION! " + e.getMessage());
        }
        return deleted;
    }

    public long count() {
        if (mReadableDB == null) {
            mReadableDB = getReadableDatabase();
        }
        long a =  DatabaseUtils.queryNumEntries(mReadableDB, WORD_LIST_TABLE);
        return a;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.w(ListHelper.class.getName(),
                "Upgrading database from version " + i + " to "
                        + i1 + ", which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WORD_LIST_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void drop() {
        SQLiteDatabase database = getReadableDatabase();
        database.execSQL("DROP TABLE IF EXISTS " + WORD_LIST_TABLE);
        onCreate(database);
    }

    public void update(int id, String word) {
    }
}
