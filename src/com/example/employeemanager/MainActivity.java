package com.example.employeemanager;





import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

Thread timer;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Button mybutton=(Button) findViewById(R.id.mainbtn);
		timer=new Thread()
		{
			public void run()
			{
				
			
			try
			{
				
				sleep(8000);
			}
			catch(InterruptedException e)
			{
			e.printStackTrace();	
			}
			finally 
			{
				Intent splash= new Intent(MainActivity.this,Login.class);
				startActivity(splash);
			}
		}
	
		};
	
timer.start();
	
/*mybutton.setOnClickListener(new OnClickListener()
	
	{
		
		@Override
		public void onClick(View v)
		{
			startActivity(new Intent(MainActivity.this,Login.class) );
		}
		
	});*/

}


}