package com.example.employeemanager;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Personale_info extends Activity{
	SQLiteDatabase db;
	String epcode,fnames,gnames,flname,dobs,msts,gnd,nation,
	jtit,depart,egrp,resgdates,sklvs,fricfin, prorcitizen, 
	prtypes, yrofpr, sick_leave,date,nrics,citiprs,prstrtdate,prtype,yrprs,
	wkph,handphs,hmph,emails,paddrs,pcode,haddrs,hpcode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_info);
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext(); 
		ImageView save =(ImageView)findViewById(R.id.savebtn);
	     // Get name and email from global/application context  
		final int position  = globalVariable.getPosition();
		final String empcode=globalVariable.getName();
		
		db=openOrCreateDatabase("Employeemanager",MODE_PRIVATE,null);
		db.execSQL("CREATE TABLE IF NOT EXISTS Employee(fullname VARCHAR,dob DATE,mstatus VARCHAR,gender VARCHAR,nationality VARCHAR);");	
		Cursor c = db.rawQuery("SELECT   fullname,dob,mstatus,gender,nationality,fname, gname, jtitle, dep, emp_grp, resign_date, sick_leave,nric_fin, pr_citizen, pr_start_date, pr_type, year_of_pr, work_ph,home_ph, hand_ph, email, post_address, post_code, home_address,hpost_code  from Employee Where emp_code='"+empcode+ "' ", null);
		c.moveToFirst();
		//flnametxt.setKeyListener(null);	
		
		EditText ecode=(EditText)findViewById(R.id.editText1);		
		ecode.setText( empcode);
		epcode=ecode.getText().toString();
		ecode.setKeyListener(null);	
		
		
		TextView fnametxt=(TextView)findViewById(R.id.editText2);
	
		 String fname = c.getString(c.getColumnIndex("fname"));
		 fnametxt.setText( fname);
		 
		 
		 TextView gnametxt=(TextView)findViewById(R.id.editText3);	
		 String gname = c.getString(c.getColumnIndex("gname"));
		 gnametxt.setText( gname);
		
		 
		 TextView flnametxt=(TextView)findViewById(R.id.editText4);		
		 String fullname = c.getString(c.getColumnIndex("fullname"));
		 flnametxt.setText(fullname);
		
		 
		 TextView dobtxt=(TextView)findViewById(R.id.editText5);	
		 String dob = c.getString(c.getColumnIndex("dob"));
		 dobtxt.setText(dob);
		 
		 
		 
		TextView mstatustxt=(TextView)findViewById(R.id.editText6);		
		 String mstat = c.getString(c.getColumnIndex("mstatus"));
		 mstatustxt.setText(mstat);
		
		 
		 TextView gendertxt=(TextView)findViewById(R.id.editText7);		
		 String genders = c.getString(c.getColumnIndex("gender"));
		 gendertxt.setText( genders);
		
		 
		 TextView nartiontxt=(TextView)findViewById(R.id.editText8);		
		 String nations = c.getString(c.getColumnIndex("nationality"));
		 nartiontxt.setText( nations);
		 
		 
		 TextView jtittxt=(TextView)findViewById(R.id.editText9);	
			 String jtitle = c.getString(c.getColumnIndex("jtitle"));
		 jtittxt.setText( jtitle);
		
		 
		 TextView Deptxt=(TextView)findViewById(R.id.editText10);		
		 String dep = c.getString(c.getColumnIndex("dep"));
		 Deptxt.setText( dep);
		 
		
		TextView empgrptxt=(TextView)findViewById(R.id.editText11);			
		 String empgrp = c.getString(c.getColumnIndex("emp_grp"));
		 empgrptxt.setText( empgrp);
		
		 
		 TextView resgdatetxt=(TextView)findViewById(R.id.editText12);		
		 String resgdate = c.getString(c.getColumnIndex("resign_date"));
		 resgdatetxt.setText( resgdate);		 
		
		
		 TextView skleavetxt=(TextView)findViewById(R.id.editText13);		 
		 String sickleave = c.getString(c.getColumnIndex("sick_leave"));
		 skleavetxt.setText( sickleave);
		
		 
		 TextView Nrictxt=(TextView)findViewById(R.id.editText14);		
		 String nric = c.getString(c.getColumnIndex("nric_fin"));
		 Nrictxt.setText( nric);
		
		 
		 TextView citiprtxt=(TextView)findViewById(R.id.editText15);	
		 String citipr = c.getString(c.getColumnIndex("pr_citizen"));
		 citiprtxt.setText( citipr);
		
		 
		 TextView prstrtdatetxt=(TextView)findViewById(R.id.editText16);		 
		 String prdate = c.getString(c.getColumnIndex("pr_start_date"));
		 prstrtdatetxt.setText(prdate);
		
		 
		 TextView prtypetxt=(TextView)findViewById(R.id.editText17);	
		 String prtype = c.getString(c.getColumnIndex("pr_type"));
		 prtypetxt.setText(prtype);
		
		 
		 TextView yrprtxt=(TextView)findViewById(R.id.editText18);	
		 String yrpr = c.getString(c.getColumnIndex("year_of_pr"));
		 yrprtxt.setText(yrpr);
		
		 
		 TextView workphtxt=(TextView)findViewById(R.id.editText19);		
		 String wrkph = c.getString(c.getColumnIndex("work_ph"));
		 workphtxt.setText(wrkph);
		
		 
		 TextView handphtxt=(TextView)findViewById(R.id.editText20);		
		 String handph = c.getString(c.getColumnIndex("hand_ph"));
		 handphtxt.setText(handph);
		
		 
		 
		 TextView homephtxt=(TextView)findViewById(R.id.editText21);		
		 String homeph = c.getString(c.getColumnIndex("home_ph"));
		 homephtxt.setText(homeph);
		
		 
		 TextView emailtxt=(TextView)findViewById(R.id.editText22);		
		 String email = c.getString(c.getColumnIndex("email"));
		 emailtxt.setText(email);
		
		 
		 TextView pstaddtxt=(TextView)findViewById(R.id.editText23);		
		 String postadd = c.getString(c.getColumnIndex("post_address"));
		 pstaddtxt.setText(postadd);
		
		 
		 TextView pstcdtxt=(TextView)findViewById(R.id.editText24);				 
		 String postcode = c.getString(c.getColumnIndex("post_code"));
		 pstcdtxt.setText(postcode);
		
		  TextView homeaddtxt=(TextView)findViewById(R.id.editText25);	
		 String homeadd = c.getString(c.getColumnIndex("home_address"));
		 homeaddtxt.setText(homeadd);
		
		 
		 TextView hmpcodedtxt=(TextView)findViewById(R.id.editText26);		
		 String hompcode = c.getString(c.getColumnIndex("hpost_code"));
		 hmpcodedtxt.setText(hompcode);
		
		 
		 
		 
		 
		 
		 save.setOnClickListener(new OnClickListener()
		 {

			@Override
			public void onClick(View v) {
				
				 
				TextView fnametxt=(TextView)findViewById(R.id.editText2);
				fnames=fnametxt.getText().toString();
				
				 
				 
				 TextView gnametxt=(TextView)findViewById(R.id.editText3);
				 gnames=gnametxt.getText().toString();
				
				
				 
				 TextView flnametxt=(TextView)findViewById(R.id.editText4);	
				 flname=flnametxt.getText().toString();
				
				 
				 TextView dobtxt=(TextView)findViewById(R.id.editText5);
				 dobs=dobtxt.getText().toString();
				
				 
				 
				TextView mstatustxt=(TextView)findViewById(R.id.editText6);	
				 msts=mstatustxt.getText().toString();
				 
				
				 
				 TextView gendertxt=(TextView)findViewById(R.id.editText7);
				 gnd=gendertxt.getText().toString();
				
				
				 
				 TextView nartiontxt=(TextView)findViewById(R.id.editText8);
				 nation=nartiontxt.getText().toString();
				
				 
				 TextView jtittxt=(TextView)findViewById(R.id.editText9);	
				 jtit=jtittxt.getText().toString();
				
				 
				 TextView Deptxt=(TextView)findViewById(R.id.editText10);
				 depart=Deptxt.getText().toString();
				
				
				TextView empgrptxt=(TextView)findViewById(R.id.editText11);	
				 egrp=empgrptxt.getText().toString();
				
				 TextView resgdatetxt=(TextView)findViewById(R.id.editText12);	
				 resgdates=resgdatetxt.getText().toString();
				
				
				
				 TextView skleavetxt=(TextView)findViewById(R.id.editText13);
				 sklvs=skleavetxt.getText().toString();
				
				
				 
				 TextView Nrictxt=(TextView)findViewById(R.id.editText14);	
				 nrics=Nrictxt.getText().toString();
				 
				
				 
				 TextView citiprtxt=(TextView)findViewById(R.id.editText15);
				 citiprs=citiprtxt.getText().toString();
				
				 
				 TextView prstrtdatetxt=(TextView)findViewById(R.id.editText16);
				 prstrtdate=prstrtdatetxt.getText().toString();
				
				
				 
				 TextView prtypetxt=(TextView)findViewById(R.id.editText17);
				 prtypes=prtypetxt.getText().toString();
				 
				
				 
				 TextView yrprtxt=(TextView)findViewById(R.id.editText18);
				 yrprs=yrprtxt.getText().toString();
				
				 
				 TextView workphtxt=(TextView)findViewById(R.id.editText19);
				 wkph=workphtxt.getText().toString();
				
				
				 
				 TextView handphtxt=(TextView)findViewById(R.id.editText20);
				 handphs=handphtxt.getText().toString();
				
				 
				 
				 TextView homephtxt=(TextView)findViewById(R.id.editText21);
				 hmph=homephtxt.getText().toString();
				
				
				 
				 TextView emailtxt=(TextView)findViewById(R.id.editText22);	
				emails=emailtxt.getText().toString();
				
				
				 
				 TextView pstaddtxt=(TextView)findViewById(R.id.editText23);
				 paddrs=pstaddtxt.getText().toString();
				
				
				 
				 TextView pstcdtxt=(TextView)findViewById(R.id.editText24);
				 pcode=pstcdtxt.getText().toString();		 
				
				
				  TextView homeaddtxt=(TextView)findViewById(R.id.editText25);
				  haddrs=homeaddtxt.getText().toString();
				
				 
				 TextView hmpcodedtxt=(TextView)findViewById(R.id.editText26);	
				 hpcode=hmpcodedtxt.getText().toString();
				 
				
				
				
				
				
				
				db.execSQL("UPDATE  Employee  SET fullname='"+flname+"',dob='"+dobs+"',mstatus='"+msts+"',gender='"+gnd+"',nationality='"+nation+"',fname='"+fnames+"', gname='"+gnames+"', jtitle='"+jtit+"', dep='"+depart+"', emp_grp='"+egrp+"', resign_date='"+resgdates+"', sick_leave='"+sklvs+"',nric_fin='"+nrics+"', pr_citizen='"+citiprs+"', pr_start_date='"+prstrtdate+"', pr_type='"+prtypes+"', year_of_pr='"+yrprs+"', work_ph='"+wkph+"',home_ph='"+hmph+"', hand_ph='"+hmph+"', email='"+emails+"', post_address='"+paddrs+"', post_code='"+pcode+"', home_address='"+haddrs+"',hpost_code='"+hpcode+"' WHERE emp_code='"+ empcode + "'");   
				
			
				 Toast.makeText(Personale_info.this, "Sucessfully Updated", Toast.LENGTH_LONG).show();
			}
			
		 });
		 
		 
		 
		
		 
		 
		 
		 
		 

		 
		
	}
	

}
