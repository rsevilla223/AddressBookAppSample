package com.example.ryansevilla.addressbookappsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class ContactDetailActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);


        Intent intent = getIntent();

        String passedName = intent.getStringExtra("parameter name");
        TextView displayName = (TextView) findViewById(R.id.con_Name);
        displayName.setText(passedName);

        String passedCompany = intent.getStringExtra("parameter company");
        TextView displayCompany = (TextView) findViewById(R.id.con_Comp);
        displayCompany.setText(passedCompany);

        String passedBirthdate = intent.getStringExtra("parameter birthdate");
        TextView displayBirthdate = (TextView) findViewById(R.id.con_Birthdate);
        displayBirthdate.setText(passedBirthdate);

        int passedEmployeeID = intent.getIntExtra("employee", 0);
        TextView displayEmployeeID = (TextView) findViewById(R.id.con_Empid);
        displayEmployeeID.setText(String.format("%d", passedEmployeeID));

        String passedHomephone = intent.getStringExtra("parameter home_phone");
        TextView displayHomephone = (TextView) findViewById(R.id.con_Homephone);
        displayHomephone.setText(passedHomephone);

        String passedMobilephone = intent.getStringExtra("parameter mobile_phone");
        TextView displayMobilephone = (TextView) findViewById(R.id.con_Cellphone);
        displayMobilephone.setText(passedMobilephone);

        String passedWorkphone = intent.getStringExtra("parameter work_phone");
        TextView displayWorkphone = (TextView) findViewById(R.id.con_workPhone);
        displayWorkphone.setText(passedWorkphone);
    }


}
