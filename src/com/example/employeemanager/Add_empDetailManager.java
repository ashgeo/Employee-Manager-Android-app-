package com.example.employeemanager;

import java.sql.Date;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Add_empDetailManager extends Activity implements OnItemSelectedListener
{
	SQLiteDatabase db;
	String jtitle, dep, emp_grp, resign_date, sick_leave,date;
	String jbtitl,dp,empgrp,resignday,sleave;
	private int myYear, myMonth, myDay;
	static final int ID_DATEPICKER = 0;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_new_emp_details);
		Button empdetails=(Button)findViewById(R.id.btnempdetails);
		Button em=(Button)findViewById(R.id.button1);
		EditText skleave=(EditText)findViewById(R.id.editText2);
		
		
		//gloabl class variable
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext(); 
				
		// Get name and email from global/application context  
		final String empcode  = globalVariable.getEmpcode();  
		
		
		//open datbase
				db=openOrCreateDatabase("Employeemanager",MODE_PRIVATE,null);
				//Tabe creation
				//db.execSQL("CREATE TABLE IF NOT EXISTS Employee(jtitle VARCHAR(50),dep VARCHAR(50),emp_grp VARCHAR(50),resign_date DATE,sick_leave NVARCHAR(100);");	
				
		
		
		Spinner depspinner=(Spinner)findViewById(R.id.depspnr);
		Spinner empgropspn=(Spinner)findViewById(R.id.empgropspnr);
		
		ArrayAdapter<?> adapterempgrp=ArrayAdapter.createFromResource(this,R.array.Employeegroup,android.R.layout.simple_spinner_item);
		empgropspn.setAdapter(adapterempgrp);
		empgropspn.setOnItemSelectedListener(this);
		
		
		ArrayAdapter<?> adapterdep=ArrayAdapter.createFromResource(this,R.array.Departments,android.R.layout.simple_spinner_item);
		depspinner.setAdapter(adapterdep);
		depspinner.setOnItemSelectedListener(this);
		skleave.setKeyListener(null);
		
		empdetails.setOnClickListener(new OnClickListener()
		
		{
			
			@Override
			public void onClick(View v)			
			
			{
				EditText jbtitle=(EditText)findViewById(R.id.editText1);
				jbtitl=jbtitle.getText().toString();
				
				Spinner spnrdep=(Spinner)findViewById(R.id.depspnr);
				dp=spnrdep.getSelectedItem().toString();
				
				Spinner emp_grp=(Spinner)findViewById(R.id.empgropspnr);
				empgrp=emp_grp.getSelectedItem().toString();
				
				db.execSQL("UPDATE  Employee  SET jtitle = '"+jbtitl+"',dep='"+dp+"',emp_grp='"+empgrp+"' WHERE emp_code='"+ empcode + "'");   
                db.close();
		
				
				startActivity(new Intent(Add_empDetailManager.this,Add_empContactManager.class) );
			}
			
		});
		
		
		
			}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*public void onItemSelected(AdapterView<?> arg0, View view, int i,long l)
{
		
		TextView myText=(TextView) view;
		Toast.makeText(this, "You Selected"+myText.getText(),Toast.LENGTH_SHORT).show();
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) 
	{
		// TODO Auto-generated method stub
		
	}}*/
	
	
	public void onItemSelected1(AdapterView<?> arg0, View view, int i,long l)
	{
			
			TextView myText=(TextView) view;
			Toast.makeText(this, "You Selected"+myText.getText(),Toast.LENGTH_SHORT).show();
			
		}
	
		public void onNothingSelected1(AdapterView<?> arg0) 
		{
			// TODO Auto-generated method stub
			
		
	
	
	
		}
		//Setting Date Picker on Click button
		
		

}
