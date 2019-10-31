package com.example.carloancalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalc.setOnClickListener{
            calcLoan()
        }
    }

    private fun calcLoan(){
        val car_price = editTxtCarPrice.text.toString().toInt()
        val down_payment = editTxtDownP.text.toString().toInt()
        val loan__period = editTxtLoanPeriod.text.toString().toInt()
        val interest_rate = editTxtInterestRate.text.toString().toFloat()

        val car_loan = car_price-down_payment
        val interest = (car_loan*interest_rate*loan__period)/100
        val monthlyP = (car_loan + interest)/loan__period/12
        txtCarLoan.text = getString(R.string.CarLoan) + ": RM ${car_loan}"
        txtInterest.text = getString(R.string.Interest) + ": RM ${interest}"
        txtMonthlyP.text = getString(R.string.MonthlyPayment) + ": RM ${monthlyP}"
    }
    fun resetInput(view: View){
        
        txtMonthlyP.text = ""
        txtInterest.text = ""
        txtMonthlyP.text = ""
    }
}
