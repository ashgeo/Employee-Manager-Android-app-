package com.example.employeemanager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Emp_profile extends Activity
{
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emp_profile);
		TextView fnamegot=(TextView)findViewById(R.id.ecode);
		ImageView viewprofile=(ImageView)findViewById(R.id.imageView7);
		//gloabl class variable
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext(); 
		
	     // Get name and email from global/application context  
		final int position  = globalVariable.getPosition();
		final String empcode=globalVariable.getName();
		 globalVariable.setName(empcode);
		
			fnamegot.setText(empcode);	
			db=openOrCreateDatabase("Employeemanager",MODE_PRIVATE,null);
			db.execSQL("CREATE TABLE IF NOT EXISTS Employee(fullname VARCHAR,dob DATE,mstatus VARCHAR,gender VARCHAR,nationality VARCHAR);");	
			Cursor c = db.rawQuery("SELECT  fullname,gname,work_ph,home_ph,hand_ph,jtitle,email  from Employee Where emp_code='"+empcode+ "' ", null);
			c.moveToFirst();
			
		
			TextView fullnametxt=(TextView)findViewById(R.id.fullname);	
			 String fullname = c.getString(c.getColumnIndex("fullname"));
			 fullnametxt.setText( fullname);
			
			TextView jbtitle=(TextView)findViewById(R.id.jobtitle);	
			 String flnmae = c.getString(c.getColumnIndex("jtitle"));
			 jbtitle.setText( flnmae);
			 
			 TextView workph=(TextView)findViewById(R.id.officephno);	
			 String workphone = c.getString(c.getColumnIndex("work_ph"));
			 workph.setText(workphone);
			 
			 TextView handph=(TextView)findViewById(R.id.mobilephno);	
			 String handphone = c.getString(c.getColumnIndex("hand_ph"));
			 handph.setText(handphone);
			 
			 TextView homeph=(TextView)findViewById(R.id.callhomephno);	
			 String hmphone = c.getString(c.getColumnIndex("home_ph"));
			 homeph.setText(hmphone);
			 
			 TextView sms=(TextView)findViewById(R.id.smsphno);	
			 String smsno = c.getString(c.getColumnIndex("hand_ph"));
			 sms.setText(smsno);
			 
			 TextView emailadd=(TextView)findViewById(R.id.emaile);	
			 String emailad = c.getString(c.getColumnIndex("email"));
			 emailadd.setText(emailad);
			 		 
			 
			 
			c.close();
			db.close();
			viewprofile.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View v) {
					startActivity(new Intent(Emp_profile.this,Personale_info.class) );
					
				}
				
			});
			
	}
	

}
