package com.innovativeminds.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ApplicationErrorReport;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void mksClick(View view)
    {
        EditText height = (EditText)findViewById(R.id.editTxtHeight);
        EditText weight =(EditText)findViewById(R.id.editTextWeight);
        height.setHint(getResources().getString(R.string.height)+"(in meteres)");
        weight.setHint(getResources().getString(R.string.weight)+"(in kilograms)");
    }

    public void fpsClick(View view)
    {
        EditText height = (EditText)findViewById(R.id.editTxtHeight);
        EditText weight =(EditText)findViewById(R.id.editTextWeight);
        height.setHint(getResources().getString(R.string.height)+"(in feets)");
        weight.setHint(getResources().getString(R.string.weight)+"(in pounds)");
    }


    public void btnClick(View view)
    {
        RadioButton rdbtnFps = (RadioButton)findViewById(R.id.rdbtnFps) ;
        RadioButton rdbtnMks = (RadioButton)findViewById(R.id.rdbtnMks) ;
        EditText height = (EditText)findViewById(R.id.editTxtHeight);
        EditText weight =(EditText)findViewById(R.id.editTextWeight);

        if(rdbtnFps.isChecked())
        {
//            Context con = getApplicationContext();
//            String text = "Hello";
//            Toast tst = Toast.makeText(con,text,Toast.LENGTH_SHORT);
//            tst.show();

            if(height.getText().toString().matches("")){
                height.setError("Please enter your height");
                return;
            }
            else if(weight.getText().toString().matches("")){
                weight.setError("Please enter your weight");
                return;
            }
            float wght = Float.parseFloat(weight.getText().toString());
            float hght = Float.parseFloat(height.getText().toString());
            float bmiPnd = BmiCalculator.bmiInPound(wght,hght);
            TextView txtVw = (TextView)findViewById(R.id.txtvwRes);
            txtVw.setText("Your bmi is "+String.valueOf(bmiPnd));


        }
        else if(rdbtnMks.isChecked())
        {
            if(height.getText().toString().matches("")){
                height.setError("Please enter your height");
                return;
            }
            else if(weight.getText().toString().matches("")){
                weight.setError("Please enter your weight");
                return;
            }
            float wght = Float.parseFloat(weight.getText().toString());
            float hght = Float.parseFloat(height.getText().toString());
            float bmiMks = BmiCalculator.bmiInKg(wght,hght);
            TextView txtVw = (TextView)findViewById(R.id.txtvwRes);
            txtVw.setText("Your bmi is "+String.valueOf(bmiMks));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton rdbtnMks = (RadioButton)findViewById(R.id.rdbtnMks) ;
        rdbtnMks.setChecked(true);
        mksClick(null);

    }
}
