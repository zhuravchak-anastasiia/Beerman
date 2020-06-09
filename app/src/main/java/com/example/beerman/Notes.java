package com.example.beerman;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Notes extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper dbHelper;
    Button btnAdd, btnRead, btnClear;
    EditText etData, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener((View.OnClickListener) this);

        btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener((View.OnClickListener) this);

        etData = findViewById(R.id.etData);
        etData.setOnClickListener((View.OnClickListener) this);

        etEmail = findViewById(R.id.etEmail);
        etEmail.setOnClickListener((View.OnClickListener) this);

        dbHelper = new DatabaseHelper(this);
    }


    public void onClick(View v) {

        String name = etData.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {
            case R.id.btnAdd:
                contentValues.put(DatabaseHelper.KEY_NAME, name);
                contentValues.put(DatabaseHelper.KEY_MAIL, email);

                database.insert(DatabaseHelper.TABLE_CONTACTS, null, contentValues);
                break;

            case R.id.btnRead:
                Cursor cursor = database.query(DatabaseHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                while (cursor.moveToNext()){
                    Toast.makeText(getApplicationContext(), "# "+cursor.getString(0),Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Title: "+cursor.getString(1),Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Note: "+cursor.getString(2),Toast.LENGTH_SHORT).show();
                }

                cursor.close();;
                break;

        }
        dbHelper.close();

    }
}
