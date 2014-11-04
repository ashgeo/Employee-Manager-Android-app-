package com.example.employeemanager;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;

public class New extends Activity {
	ListView listview;
	String edtsearchtxt, abc, removevar;
	EditText srtxt;
	MyArrayAdapter studentArrayAdapter;
	ArrayList<Student> studentArray = new ArrayList<Student>();
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		ImageButton search = (ImageButton) findViewById(R.id.imageButton1);
		srtxt = (EditText) findViewById(R.id.editText1);
		super.onCreate(savedInstanceState);
		ImageView nextpage= (ImageView)findViewById(R.id.btnEdit);
		
	
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext(); 

		setContentView(R.layout.new_layout);
		//Button delete=(Button)findViewById(R.id.btnDelete);
		//Button edit=(Button)findViewById(R.id.btnEdit);
		db = openOrCreateDatabase("Employeemanager", MODE_PRIVATE, null);
		Cursor c = db.rawQuery("SELECT * FROM  Employee", null);
		// c.moveToFirst();

		while (c.moveToNext()) {

			studentArray.add(new Student(c.getString(2), c.getString(1), c
					.getString(10)));
		}
		//c.close();	
		//db.close();

		// set the array adapter to use the above array list and tell the
		// listview to set as the adapter
		// our custom adapter
		studentArrayAdapter = new MyArrayAdapter(New.this, R.layout.list_item,studentArray);
		listview = (ListView) findViewById(R.id.listView1);
		//listview.setItemsCanFocus(true);
		listview.setAdapter(studentArrayAdapter);
		 listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		// nextpage.setFocusable(false);
		// nextpage.setFocusableInTouchMode(false);
		
		listview.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View v,final int position, long id)
			{
				//startActivity(new Intent(New.this,Emp_profile.class) );
			
				globalVariable.setPosition(position);
				// String product = ((TextView) v).getText().toString();
			
				String empcode = ((TextView) v.findViewById(R.id.textempcode)).getText().toString();
				 globalVariable.setName(empcode);
				 //Toast.makeText(New.this, message, Toast.LENGTH_SHORT).show();
				startActivity(new Intent(New.this,Emp_profile.class) );
			
				


			}
		    });
		
		
		 
			
		
		
		listview.setOnItemLongClickListener(new OnItemLongClickListener() 
		{

			@Override
			 public boolean onItemLongClick(AdapterView<?> arg0,android.view.View v, int position, long id)
			
			
			{	
				
				String empcode = ((TextView) v.findViewById(R.id.textempcode)).getText().toString();	
				
				remove(position,empcode);
				
				
				
				return true;

				
			}
			
		});	
		
			
			}
	
	
	

	public void search(View v) 
	{
		ImageButton search = (ImageButton) findViewById(R.id.imageButton1);
		studentArray.clear();
		srtxt = (EditText) findViewById(R.id.editText1);
		db = openOrCreateDatabase("Employeemanager", MODE_PRIVATE, null);
		Cursor cat = db.rawQuery("SELECT  *  from Employee Where fname='"+ srtxt.getText() + "' ", null);
		//cat.moveToFirst();
		while (cat.moveToNext())
		{
			studentArray.add(new Student(cat.getString(2), cat.getString(1),cat.getString(10)));
		}
		studentArrayAdapter = new MyArrayAdapter(New.this, R.layout.list_item,studentArray);
		listview = (ListView) findViewById(R.id.listView1);
		//listview.setItemsCanFocus(false);
		listview.setAdapter(studentArrayAdapter);
	
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.add:
			addMenuItem();
			break;
		}

		switch (item.getItemId()) {
		case R.id.delete:
			deleteMenuItem();
			break;
		}
		switch (item.getItemId()) {
		case R.id.edit:
			editMenuItem();
			break;
		}

		return true;

	}

	private void addMenuItem() 
	{
	startActivity(new Intent(New.this,Add_newEmpManager.class));

	}

	

	private void deleteMenuItem()
	{
		
		startActivity(new Intent(New.this,Add_newEmpManager.class));
	   
	}

	private void editMenuItem() {
		startActivity(new Intent(New.this, Login.class));
	}

	
	public void remove(final int position,final String empcode )
	{
		

		new AlertDialog.Builder(this)
	    .setTitle("Data Saved")
	    .setMessage("Are you sure you want to Delete this Employee")
	    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) 
	        {          
	        	
				// TODO Auto-generated method stub
				
				//startActivity(new Intent(Emp_search.this,Search.class) );
				db.execSQL("DELETE FROM Employee WHERE emp_code='"+ empcode + "'");
				
				//listview.removeViewAt(position);
				studentArray.remove(position);
				studentArrayAdapter.notifyDataSetChanged();
				studentArrayAdapter.notifyDataSetInvalidated();
	        }
	    })
	    .setNegativeButton("No", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            // do nothing
	        }
	    })
	    .show();
	}


	
	
	
	
	
}
