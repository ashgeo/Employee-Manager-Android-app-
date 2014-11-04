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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Add_newEmpManager extends Activity
{
	String fullnameedt, dobedt, mstatusedt, genderedt,nationalityedt,date,empcodetxt,fnametxt,gnametxt;
	SQLiteDatabase db;
	private int myYear, myMonth, myDay;
	static final int ID_DATEPICKER = 0;
	String chkboxgender,chkboxmstatus;
	String fullnametxt,dobtxt,mstatustxt,gendertxt,nationalitytxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
		//EditText empcodeedt=(EditText)findViewById(R.id.editText1);
		//EditText fnameedt=(EditText)findViewById(R.id.editText2);
		//EditText gnameedt=(EditText)findViewById(R.id.editText3);
		//EditText fullnameedt=(EditText)findViewById(R.id.editText4);		
		EditText nation=(EditText)findViewById(R.id.editText5);
		
		
		db=openOrCreateDatabase("Employeemanager",MODE_PRIVATE,null);
		//Tabe creation
		db.execSQL("CREATE TABLE IF NOT EXISTS Employee(fullname VARCHAR,dob DATE,mstatus VARCHAR,gender VARCHAR,nationality VARCHAR);");	
		
		//Global variable
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext(); 
		
		
		prsnbtn.setOnClickListener(new OnClickListener()
		
		{
			
			@Override
			public void onClick(View v)
			{
				

				EditText empcodeedt=(EditText)findViewById(R.id.editText1);
				EditText fnameedt=(EditText)findViewById(R.id.editText2);
				EditText gnameedt=(EditText)findViewById(R.id.editText3);
				EditText editText4=(EditText)findViewById(R.id.editText4);
				fullnameedt=editText4.getText().toString();
				EditText nation=(EditText)findViewById(R.id.editText5);
				nationalityedt=nation.getText().toString();
				empcodetxt=empcodeedt.getText().toString();
				fnametxt=fnameedt.getText().toString();
				gnametxt=gnameedt.getText().toString();		
	
				globalVariable.setEmpCode(empcodetxt);
				
		         dobedt=date;
		         mstatusedt=chkboxmstatus;
		         genderedt=chkboxgender;
		         
		     	Cursor c = db.rawQuery(	"SELECT  username  from Employee Where emp_code='"+empcodetxt + "' ", null);

				if (c != null) 
				{
					if (c.moveToFirst()) 
					{
						Toast.makeText(getApplicationContext(),"Emp Code already exist", Toast.LENGTH_LONG).show();
					}

					else  
					{
		         
		         db.execSQL("INSERT INTO Employee(fname,gname,emp_code,fullname,dob,mstatus,gender,nationality) VALUES('"+fnametxt+ "','"+gnametxt+ "','"+ empcodetxt+ "','"
							+ fullnameedt+ "','"+  dobedt+ "','"+   mstatusedt+ "','"+  genderedt+ "','"+ nationalityedt+ "');");

                 db.close();
		        // db.execSQL("INSERT INTO Employee(fullname,dob, mstatus, gender,nationality) VALUES('"+fullnameedt+"','"+dobedt+"','"+mstatusedt+"' ,'"+genderedt+"','"+nationalityedt+"')WHERE username='"+ name + "'");
			   startActivity(new Intent(Add_newEmpManager.this,Add_empDetailManager.class) );
			}
				}
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
    	    Toast.makeText(Add_newEmpManager.this, "- onCreateDialog -", 
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
      Toast.makeText(Add_newEmpManager.this, date, 
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
		Toast.makeText(Add_newEmpManager.this, "Single", 
	    	      Toast.LENGTH_LONG).show();
	}
	else if(married.isChecked())
	{
		single.setEnabled(false);
		chkboxmstatus="Married";
		Toast.makeText(Add_newEmpManager.this, "Married", 
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
			Toast.makeText(Add_newEmpManager.this, "Male", 
		    	      Toast.LENGTH_LONG).show();
		}
		else if(female.isChecked())
		{
			male.setEnabled(false);
			chkboxgender="Female";
			Toast.makeText(Add_newEmpManager.this, "Female", 
		    	      Toast.LENGTH_LONG).show();
		}
		
		
	}

		
		
		
		
		
	}


