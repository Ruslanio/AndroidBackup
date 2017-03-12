package com.example.ruslan.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String LOG_TAG = "myLogs";

    Button btnAdd, btnRead, btnClear;
    EditText etName, etEmail;
    DataBaseProvider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

        provider = new DataBaseProvider(this);
    }

    @Override
    public void onClick(View view) {
        ContentValues values = new ContentValues();

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase database = provider.getWritableDatabase();

        switch (view.getId()) {
            case R.id.btnAdd:
                Log.d(LOG_TAG, "--- Insert in mytable: ---");

                values.put("name", name);
                values.put("email", email);

                long rowID = database.insert("mytable", null, values);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                break;
            case R.id.btnRead:
                Log.d(LOG_TAG, "--- Rows in mytable: ---");

                Cursor cursor = database.query("mytable", null, null, null, null, null, null);

                if (cursor.moveToFirst()) {

                    int idColIndex = cursor.getColumnIndex("id");
                    int nameColIndex = cursor.getColumnIndex("name");
                    int emailColIndex = cursor.getColumnIndex("email");

                    do {
                        Log.d(LOG_TAG,
                                        "ID = " + cursor.getInt(idColIndex) +
                                        ", name = " + cursor.getString(nameColIndex) +
                                        ", email = " + cursor.getString(emailColIndex));
                    } while (cursor.moveToNext());
                } else {
                    Log.d(LOG_TAG, "0 rows");
                }
                cursor.close();
                break;
            case R.id.btnClear:
                Log.d(LOG_TAG, "--- Clear mytable: ---");

                int clearCount = database.delete("mytable",null,null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;
        }
        provider.close();

    }


    class DataBaseProvider extends SQLiteOpenHelper {
        public DataBaseProvider(Context context) {
            super(context, "dataBase", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            sqLiteDatabase.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "email text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
