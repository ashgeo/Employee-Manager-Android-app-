package com.example.employeemanager;

import java.sql.Date;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Add_new_emp_other extends Activity  implements OnItemSelectedListener

{
	final Context context = this;
	SQLiteDatabase db;
	String fricfin, prorcitizen, prtypes, yrofpr, sick_leave,date,prstrtdate;
	String nric_fin, pr_citizen, pr_start_date, pr_type, year_of_pr;
	private int myYear, myMonth, myDay;
	static final int ID_DATEPICKER = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_newemp_other);
		Button btnother=(Button)findViewById(R.id.btnother);
		Button datePickerButton=(Button)findViewById(R.id.button1);
		datePickerButton.setOnClickListener(datePickerButtonOnClickListener);
	
	
		
		//gloabl class variable
				final GlobalClass globalVariable = (GlobalClass) getApplicationContext(); 
						
				// Get name and email from global/application context  
				final String name  = globalVariable.getName();  
				
				
				//open datbase
						db=openOrCreateDatabase("Employeemanager",MODE_PRIVATE,null);
						
		
		
		
		
		Spinner citizentype=(Spinner)findViewById(R.id.spinner1);
		Spinner prtype=(Spinner)findViewById(R.id.spinner2);
		
		ArrayAdapter<?> adapterempgrp=ArrayAdapter.createFromResource(this,R.array.citizen,android.R.layout.simple_spinner_item);
		citizentype.setAdapter(adapterempgrp);
		citizentype.setOnItemSelectedListener(this);
		
		
		
		ArrayAdapter<?> adapterdep=ArrayAdapter.createFromResource(this,R.array.Prtype,android.R.layout.simple_spinner_item);
		prtype.setAdapter(adapterdep);
		prtype.setOnItemSelectedListener(this);
		
		btnother.setOnClickListener(new OnClickListener()
		
		{
			
			@Override
			public void onClick(View v)
			{		
				

				EditText edtfric=(EditText)findViewById(R.id.editText1);
				fricfin=edtfric.getText().toString();
				
				Spinner editprorcitzn=(Spinner)findViewById(R.id.spinner1);
				prorcitizen=editprorcitzn.getSelectedItem().toString();
				
				Spinner edtprtype=(Spinner)findViewById(R.id.spinner2);
				prtypes=edtprtype.getSelectedItem().toString();
				
				EditText edtyrpd=(EditText)findViewById(R.id.editText2);
				yrofpr=edtyrpd.getText().toString();
				prstrtdate=date;
				
				db.execSQL("UPDATE  Employee  SET nric_fin = '"+fricfin+"',pr_citizen='"+prorcitizen+"',pr_start_date='"+prstrtdate+"',pr_type='"+prtypes+"',year_of_pr='"+yrofpr+"' WHERE username='"+ name + "'");   
                db.close();
				
				
				 AlertDialog.Builder builder = new AlertDialog.Builder(Add_new_emp_other.this);
				    builder.setTitle("Udate Message");
				    builder.setMessage("Sucessfully Updated");
				    builder.setPositiveButton("OK",new DialogInterface.OnClickListener()
				    {
				     public void onClick(DialogInterface dialog, int which)
				     {
				    	 

				    	 startActivity(new Intent(Add_new_emp_other.this,Home.class) );
				     }
				    });	    
				
				    builder.show();

			}
			
		});
		
	}
	
	Button.OnClickListener datePickerButtonOnClickListener = new Button.OnClickListener()
    {

   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    final Calendar c = Calendar.getInstance();
    myYear = c.get(Calendar.YEAR);
    myMonth = c.get(Calendar.MONTH);
    myDay = c.get(Calendar.DAY_OF_MONTH);
    showDialog(ID_DATEPICKER);
   }
    };
    protected Dialog onCreateDialog(int id)
    {
    	  // TODO Auto-generated method stub
    	  switch(id){
    	   case ID_DATEPICKER:
    	    Toast.makeText(Add_new_emp_other.this, "- onCreateDialog -", 
    	      Toast.LENGTH_LONG).show();
    	    return new DatePickerDialog(this, myDateSetListener, myYear, myMonth, myDay);
    	   default:
    	    return null;
    	  }
    	 }
    
    private DatePickerDialog.OnDateSetListener myDateSetListener = new DatePickerDialog.OnDateSetListener()
    {
     @Override
     public void onDateSet(DatePicker view, int year,  int monthOfYear, int dayOfMonth)  
     {
    	 Date dat;
    	 Button datePickerButtonset=(Button)findViewById(R.id.button1);    	 
    	
    	 
    	
      // TODO Auto-generated method stub
       date = String.valueOf(dayOfMonth)  + 
        "/ " + String.valueOf(monthOfYear+1) + 
        "/ " +String.valueOf(year) ;
      Toast.makeText(Add_new_emp_other.this, date, 
        Toast.LENGTH_LONG).show();
      datePickerButtonset.setText(date);
     } 
   };	
	
	
	
	
	
	
	
	
	
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}


	public void onNothingSelected(AdapterView<?> arg0)
{
		// TODO Auto-generated method stub
		
	}
	public void onItemSelected1(AdapterView<?> arg0, View view, int i,long l)
	{
			
			TextView myText=(TextView) view;
			Toast.makeText(this, "You Selected"+myText.getText(),Toast.LENGTH_SHORT).show();
			
		}
	
		public void onNothingSelected1(AdapterView<?> arg0) 
		{
			// TODO Auto-generated method stub
			
		
	
	
	
		}
		
		//Date picker
		
}

