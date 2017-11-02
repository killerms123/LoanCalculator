package com.example.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {

    TextView textViewmp;
    TextView textViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewmp = (TextView) findViewById(R.id.textViewMonthlyPayment);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);

        //To recieve data from another Activity
        Intent intent = getIntent(); //Asking "who called me?"
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT, 0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);

        //TODO: Display the outputs
        textViewmp.setText("Monthly Payment : " + String.format("%.2lf", payment));
        textViewStatus.setText("Status : " + status);
    }

    public void closeActivity (View view) {

        //Terminate the current activity
        finish();
    }
}
