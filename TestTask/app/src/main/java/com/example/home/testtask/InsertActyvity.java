package com.example.home.testtask;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

public class InsertActyvity extends AppCompatActivity {

    EditText etName, etBirthday, etPhone;
    int DIALOG_DATE = 1;
    int myYear = 2017;
    int myMonth = 7;
    int myDay = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_actyvity);
        etName = (EditText) findViewById(R.id.name);
        etBirthday = (EditText) findViewById(R.id.birthday);
        etPhone = (EditText) findViewById(R.id.phone);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", etName.getText().toString());
                intent.putExtra("birthday",etBirthday.getText().toString());
                intent.putExtra("phone",etPhone.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        ImageButton datePicker = (ImageButton) findViewById(R.id.datePicker);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_DATE);
            }
        });
    }
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, myYear, myMonth, myDay);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            etBirthday.setText(myDay + "." + myMonth + "." + myYear);
        }
    };


}
