package com.example.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Add_new_emp_contact extends Activity
{
	SQLiteDatabase db;
	String wphone,homphone,haphone,cemail,paddress,pcode1,homaddress,pcode2;
	String work_ph,
	home_ph, hand_ph, email, post_address, post_code, home_address,
	hpost_code;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addnew_emp_contact);
		Button btncontact=(Button)findViewById(R.id.btncontact);

		//gloabl class variable
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext(); 
				
		// Get name and email from global/application context  
		final String name  = globalVariable.getName();  
		
		db=openOrCreateDatabase("Employeemanager",MODE_PRIVATE,null);
		
		btncontact.setOnClickListener(new OnClickListener()
		
		{
			
			@Override
			public void onClick(View v)
			{
				
				EditText edtwph=(EditText)findViewById(R.id.editText1);
				wphone=edtwph.getText().toString();
				
				EditText edthomph=(EditText)findViewById(R.id.editText2);
				homphone=edthomph.getText().toString();
				
				EditText edthandph=(EditText)findViewById(R.id.editText3);
				haphone=edthandph.getText().toString();
				
				EditText edtemail=(EditText)findViewById(R.id.editText4);
				cemail=edtemail.getText().toString();
				
				EditText jbtitle=(EditText)findViewById(R.id.editText5);
				paddress=jbtitle.getText().toString();
				
				EditText edtpaddress=(EditText)findViewById(R.id.editText6);
				pcode1=edtpaddress.getText().toString();
				
				EditText edtpode1=(EditText)findViewById(R.id.editText7);
				homaddress=edtpode1.getText().toString(); 
				
				EditText edtpode2=(EditText)findViewById(R.id.editText8);
				pcode2=edtpode2.getText().toString(); 
				
				
				db.execSQL("UPDATE  Employee  SET work_ph = '"+wphone+"',home_ph='"+homphone+"', hand_ph='"+haphone+"',email='"+cemail+"',post_address='"+paddress+"',post_code='"+pcode1+"',home_address='"+homaddress+"',hpost_code='"+pcode2+"' WHERE username='"+name+ "'");   
                db.close();	
				
				
				
				startActivity(new Intent(Add_new_emp_contact.this,Add_new_emp_other.class) );
			}
			
		});
		
		
	}

}
