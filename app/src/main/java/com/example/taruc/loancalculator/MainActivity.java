package com.example.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";

    EditText editTextvp;
    EditText editTextdp;
    EditText editTextrp;
    EditText editTextir;
    EditText editTextsalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextvp = (EditText) findViewById(R.id.editTextPrice);
        editTextdp = (EditText) findViewById(R.id.editTextDownpayment);
        editTextrp = (EditText) findViewById(R.id.editTextRepayment);
        editTextir = (EditText) findViewById(R.id.editTextInterest);
        editTextsalary = (EditText) findViewById(R.id.editTextSalary);
    }

    public void calculateLoan (View view) {

        //TODO: claculate monthly payment and determine the loan status
        double monthlypayment = 0;
        String status = "Approved";
        double totalInterest = 0;
        double totalLoan = 0;

        Double vp = Double.parseDouble(editTextvp.getText().toString());
        Double dp = Double.parseDouble(editTextdp.getText().toString());
        Double rp = Double.parseDouble(editTextrp.getText().toString());
        Double ir = Double.parseDouble(editTextir.getText().toString());
        Double salary = Double.parseDouble(editTextsalary.getText().toString());

        totalInterest = (vp - dp) * (ir/100) * (rp/12);
        totalLoan = (vp - dp) + totalInterest;
        monthlypayment = totalLoan / rp;

        if(monthlypayment > (salary * 0.3)) {

            status = "Rejected";
        }

        //Create an Explicit Intent
        Intent intent = new Intent(this, ActivityResult.class);

        //TODO: passing data using putExtra method
        //format : putExtra(TAG, value)
        intent.putExtra(MONTHLY_PAYMENT, monthlypayment);
        intent.putExtra(LOAN_STATUS, status);

        startActivity(intent);
    }
}
