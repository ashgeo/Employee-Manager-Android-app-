package com.example.employeemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Emp_signup extends Activity {
	String id, emp_code, fname, gname, jtitle, dep, emp_grp, resign_date, sick_leave,
			nric_fin, pr_citizen, pr_start_date, pr_type, year_of_pr, work_ph,
			home_ph, hand_ph, email, post_address, post_code, home_address,
			hpost_code, empusername, emppassword;
	public int refid;
	String unamesave,fnamesave;
	
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext(); 
		        
		
		
		
		db = openOrCreateDatabase("Employeemanager", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Empsalary(pay_code  INTEGER PRIMARY KEY NOT NULL,paycodecode NVARCHAR(30),reghours DOUBLE,ovrtime DOUBLE,sickpay DOUBLE,vacpay DOUBLE,sal_id INTEGER NOT NULL,FOREIGN KEY(sal_id) REFERENCES Employee(emp_code) );");
		db.execSQL("CREATE TABLE IF NOT EXISTS Employee(id  INTEGER PRIMARY KEY NOT NULL,emp_code NVARCHAR(30),fname VARCHAR(100),gname VARCHAR(100),fullname VARCHAR(100),dob DATE,mstatus VARCHAR(100),gender VARCHAR(100),nationality VARCHAR(50),jtitle VARCHAR(50),dep VARCHAR(50),emp_grp VARCHAR(50),resign_date DATE,sick_leave NVARCHAR(100),nric_fin NVARCHAR(100),pr_citizen VARCHAR(50),pr_start_date DATE,pr_type VARCHAR(50),year_of_pr NVARCHAR(100),work_ph NVARCHAR(50),home_ph NVARCHAR(50),hand_ph NVARCHAR(50),email NVARCHAR(50),post_address TEXT,post_code INTEGER,home_address TEXT,hpost_code INTEGER,username VARCHAR(100),password VARCHAR(100));");

		Button signup = (Button) findViewById(R.id.btnsignup);
		
				
		//Set name and email in global/application context 
		
		

		signup.setOnClickListener(new OnClickListener()

		{

			@Override
			public void onClick(View v) {

				EditText edttxtfname = (EditText) findViewById(R.id.edttxtfname);
				EditText edttxtlname = (EditText) findViewById(R.id.edttxtlname);
				EditText edttxtemp_code = (EditText) findViewById(R.id.edttxtemp_code);
				EditText edttxtusrname = (EditText) findViewById(R.id.edttxtusrname);
				EditText edttxtpassword = (EditText) findViewById(R.id.edttxtpassword);
				fname = edttxtfname.getText().toString();
				gname = edttxtlname.getText().toString();
				emp_code = edttxtemp_code.getText().toString();
				empusername = edttxtusrname.getText().toString();
				emppassword = edttxtpassword.getText().toString();
				unamesave=edttxtusrname.getText().toString();
				fnamesave=fname = edttxtfname.getText().toString();
				
				globalVariable.setName(unamesave);
				globalVariable.setEmail(fnamesave); 
			
				
				
				if ((empusername.matches("")) || (emppassword.matches(""))|| (fname.matches("")) || (emp_code.matches(""))||(gname.matches("")) )
				{
					Toast.makeText(getApplicationContext(),"Enter all inforamtion", Toast.LENGTH_LONG).show();

				}
				else
                   {
					Cursor c = db.rawQuery(	"SELECT  username  from Employee Where username='"+ empusername + "' ", null);

					if (c != null) 
					{
						if (c.moveToFirst()) 
						{
							Toast.makeText(getApplicationContext(),"username already exist", Toast.LENGTH_LONG).show();
						}

						else {

							db.execSQL("INSERT INTO Employee(fname,gname,emp_code,username,password) VALUES('"
									+ fname
									+ "','"
									+ gname
									+ "','"
									+ emp_code
									+ "','"
									+ empusername
									+ "','"
									+ emppassword
									+ "');");

							

							
							 AlertDialog.Builder builder = new AlertDialog.Builder(Emp_signup.this);
							    builder.setTitle("Welcome ");
							    builder.setMessage("Fill your all details ");	
								
							    builder.setPositiveButton("Now",new DialogInterface.OnClickListener()
							    {
							     public void onClick(DialogInterface dialog, int which)
							     {
							    	 startActivity(new Intent(Emp_signup.this,Add_new_employee.class) );
							     }
							    });	
							    
							    builder.setNegativeButton("Later",new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,int id)
									{
										startActivity(new Intent(Emp_signup.this,Home.class) );
										// if this button is clicked, just close
										// the dialog box and do nothing
										dialog.cancel();
									}
								});

							
							    builder.show();
							
							
							
							
							
							

						}

					}

				}
			}

			// startActivity(new Intent(Emp_signup.this,Login.class) );

		});

	}

}
