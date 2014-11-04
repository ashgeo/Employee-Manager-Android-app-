package com.example.employeemanager;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.R.string;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Add_new_employee extends Activity
{
String fullnameedt, dobedt, mstatusedt, genderedt,nationalityedt,date;
SQLiteDatabase db;
private int myYear, myMonth, myDay;
static final int ID_DATEPICKER = 0;
String chkboxgender,chkboxmstatus;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_new_employee);
		Button prsnbtn=(Button)findViewById(R.id.persnbtn);
		Button datePickerButton=(Button)findViewById(R.id.button1);
		datePickerButton.setOnClickListener(datePickerButtonOnClickListener);
		CheckBox single=(CheckBox)findViewById(R.id.checkBox1);
		CheckBox married=(CheckBox)findViewById(R.id.checkBox2);
		CheckBox male=(CheckBox)findViewById(R.id.checkBox3);
		CheckBox female=(CheckBox)findViewById(R.id.checkBox4);
	
		TextView test=(TextView)findViewById(R.id.textView6);
		TextView welcome=(TextView)findViewById(R.id.textView10);
		
		//gloabl class variable
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext(); 
		
		// Get name and email from global/application context  
		final String name  = globalVariable.getName();  
		final String email = globalVariable.getEmail(); 
		
		
		welcome.setText("Welcome"+" "+email);
		
		
		//open datbase
		db=openOrCreateDatabase("Employeemanager",MODE_PRIVATE,null);
		//Tabe creation
		db.execSQL("CREATE TABLE IF NOT EXISTS Employee(fullname VARCHAR,dob DATE,mstatus VARCHAR,gender VARCHAR,nationality VARCHAR);");	
		
		Cursor c = db.rawQuery(	"SELECT  emp_code,fname,gname  from Employee Where username='"+ name + "' ", null);
		c.moveToFirst();
		String empCode = c.getString(c.getColumnIndex("emp_code"));
		EditText empcode=(EditText)findViewById(R.id.editText1);
		empcode.setText(empCode);
		//setting not editable
		empcode.setKeyListener(null);
		
		String firstName = c.getString(c.getColumnIndex("fname"));
		EditText fnameshow=(EditText)findViewById(R.id.editText2);
		fnameshow.setText(firstName);
		fnameshow.setKeyListener(null);
		
		String GivenName = c.getString(c.getColumnIndex("gname"));
		EditText givenname=(EditText)findViewById(R.id.editText3);
		givenname.setText(GivenName);
		givenname.setKeyListener(null);
		
		c.close();
		
		prsnbtn.setOnClickListener(new OnClickListener()
		
		{
			
			@Override
			public void onClick(View v)
			{
				

				//EditText editText2=(EditText)findViewById(R.id.editText2);
				//EditText editText3=(EditText)findViewById(R.id.editText3);
				EditText editText4=(EditText)findViewById(R.id.editText4);
				fullnameedt=editText4.getText().toString();
				EditText nation=(EditText)findViewById(R.id.editText5);
				nationalityedt=nation.getText().toString();
				//lname=editText3.getText().toString();
		         dobedt=date;
		         mstatusedt=chkboxmstatus;
		         genderedt=chkboxgender;
		         
		         db.execSQL("UPDATE  Employee  SET fullname = '"+fullnameedt+"',dob='"+dobedt+"',mstatus='"+mstatusedt+"',gender='"+genderedt+"',nationality='"+nationalityedt+"' WHERE username='"+ name + "'");   
                 db.close();
		        // db.execSQL("INSERT INTO Employee(fullname,dob, mstatus, gender,nationality) VALUES('"+fullnameedt+"','"+dobedt+"','"+mstatusedt+"' ,'"+genderedt+"','"+nationalityedt+"')WHERE username='"+ name + "'");
			startActivity(new Intent(Add_new_employee.this,Add_new_emp_details.class) );
			}
			
		});
		
	}
	
	//Setting Date Picker on Click button
	
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
    	    Toast.makeText(Add_new_employee.this, "- onCreateDialog -", 
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
      Toast.makeText(Add_new_employee.this, date, 
        Toast.LENGTH_LONG).show();
      datePickerButtonset.setText(date);
     } 
   };

 //Check box Material status
   
  		  
   public void Chkboxmstatusclicked(View v) 
	{
	   CheckBox single=(CheckBox)findViewById(R.id.checkBox1);
		CheckBox married=(CheckBox)findViewById(R.id.checkBox2);
		
		
	if(single.isChecked())
	{
		married.setEnabled(false);
		chkboxmstatus="Single";
		Toast.makeText(Add_new_employee.this, "Single", 
	    	      Toast.LENGTH_LONG).show();
	}
	else if(married.isChecked())
	{
		single.setEnabled(false);
		chkboxmstatus="Married";
		Toast.makeText(Add_new_employee.this, "Married", 
	    	      Toast.LENGTH_LONG).show();
	}

	}
	
//checkbox Gender
   
	public void Chkboxgenderclicked(View v)
	{
		CheckBox male=(CheckBox)findViewById(R.id.checkBox3);
		CheckBox female=(CheckBox)findViewById(R.id.checkBox4);
		if(male.isChecked())
		{
			female.setEnabled(false);
			chkboxgender="Male";
			Toast.makeText(Add_new_employee.this, "Male", 
		    	      Toast.LENGTH_LONG).show();
		}
		else if(female.isChecked())
		{
			male.setEnabled(false);
			chkboxgender="Female";
			Toast.makeText(Add_new_employee.this, "Female", 
		    	      Toast.LENGTH_LONG).show();
		}
		
		
	}
}

