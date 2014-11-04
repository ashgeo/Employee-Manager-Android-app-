package com.example.employeemanager;

import android.R.drawable;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class Home extends Activity{
	private View layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		ImageButton addnew=(ImageButton)findViewById(R.id.addnewbtn);
		//Button change=(Button)findViewById(R.id.change_image);
		ImageButton calendar=(ImageButton)findViewById(R.id.imageButton1);
		ImageButton pay=(ImageButton)findViewById(R.id.imageButton2);
		 layout = (View) findViewById(R.layout.home);

		
		addnew.setOnClickListener(new OnClickListener()
		
		{
			
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(Home.this,New.class) );
			}
			
		});
		
		
		
		
		

		calendar.setOnClickListener(new OnClickListener()
		
		{
			
			@Override
			public void onClick(View v)
			{
				
				 startActivity(new Intent(Home.this,Calendar.class) );

				   

			}
			
		});
		
		
		
		

		pay.setOnClickListener(new OnClickListener()
		
		{
			
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(Home.this,Emp_pay.class) );
			}
			
		});
		
			
		
		
		
	}
	

}
