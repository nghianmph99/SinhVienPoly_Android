package com.lucifer.QLSV_Poly_AndroidNC.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.lucifer.QLSV_Poly_AndroidNC.model.Student;
import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    private static final String TAG = "DBManager";
    private static final String DATABASE_NAME = "students_manager";
    private static final String TABLE_NAME = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String PHONE_NUMBER = "phone";
    private static final String EMAIL = "email";
    private static final int VERSION = 1;

    private Context context;
    private String SQLQuerry = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT, " +
            EMAIL + " TEXT, " +
            PHONE_NUMBER + " TEXT, " +
            ADDRESS + " TEXT) ";


    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
        Log.d(TAG, "DBManager: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuerry);
        Log.d(TAG, "onCreate: ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, student.getmName());
        values.put(ADDRESS, student.getmAddress());
        values.put(PHONE_NUMBER, student.getmNumber());
        values.put(EMAIL, student.getmEmail());
        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d(TAG, "addStudent Successfully");
    }

    public List<Student> getAllStudent() {
        List<Student> listStudent = new ArrayList<>();

        String selectQuerry = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuerry, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setmID(cursor.getInt(0));
                student.setmName(cursor.getString(1));
                student.setmEmail(cursor.getString(2));
                student.setmAddress(cursor.getString(3));
                student.setmNumber(cursor.getString(4));
                listStudent.add(student);
            } while (cursor.moveToNext());
        }
        db.close();
        return listStudent;
    }

    public int updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,student.getmName());
        contentValues.put(ADDRESS,student.getmAddress());
        contentValues.put(EMAIL,student.getmEmail());
        contentValues.put(PHONE_NUMBER,student.getmNumber());
        int number = db.update(TABLE_NAME,contentValues,ID+"=?",new String[]{String.valueOf(student.getmID())});
        return number;
    }
    public int deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(id)});
    }
}
