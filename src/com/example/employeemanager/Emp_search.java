package com.example.employeemanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Emp_search extends Activity {

	private ListView lv;
	private EditText et;
	 ArrayAdapter<String> adapter;
	 List<String> arr;
	// ArrayList<String> arr = new ArrayList<String>();

	 ListView listview;
	 SQLiteDatabase db;
	 String fnam;
	 //ArrayAdapter<String> studentArrayAdapter;
	// ArrayList<Employee> studentArray = new ArrayList<Employee>();
	
	
	private String listview_array[] = {"As","dfd"};

	private ArrayList<String> array_sort = new ArrayList<String>();

	int textlength = 0;

	public void onCreate(Bundle savedInstanceState)

	{

		/*studentArray.add(new Employee("Nick", "18", "1st Street"));
		  studentArray.add(new Employee("John", "18", "2st Street"));
		  studentArray.add(new Employee("Anthony", "19", "3rd Street"));
		  studentArray.add(new Employee("James", "20", "5th Street"));
		  studentArray.add(new Employee("Jack", "20", "6th Street"));
		  studentArray.add(new Employee("Jeremy", "20", "7th Street"));
		  studentArray.add(new Employee("Long", "21", "1st Street"));*/
		
		
		//db=openOrCreateDatabase("Employeemanager",MODE_PRIVATE,null);
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.search_emp);
		 lv = (ListView) findViewById(R.id.ListView01);
		 arr = new ArrayList<String>(Arrays.asList(listview_array));
		 adapter= new ArrayAdapter<String>(Emp_search.this, R.layout.list_row,arr);
		//  studentArrayAdapter = new MyArrayAdapter(Emp_search.this, R.layout.list_item, studentArray);
		 lv.setAdapter(adapter);
		 
		/* Cursor c = db.rawQuery("SELECT  fname from Employee", null);
		 if (c.moveToFirst())
			{
				
			 do{
				 arr.add(c.getString(c.getColumnIndex("fname")));
			 
			} while (c.moveToNext());
    } 
	else 
	{
        return;
    }*/


		 
		 lv.setOnItemLongClickListener(new OnItemLongClickListener() 
		{

			@Override
			 public boolean onItemLongClick(AdapterView<?> arg0,android.view.View view, int position, long id)
			
			
			{
				// TODO Auto-generated method stub
				
				//startActivity(new Intent(Emp_search.this,Search.class) );
				removeItemFromList(position); 
				
				return true;

				
			}
			
		});	
		
		

		et = (EditText) findViewById(R.id.EditText01);		

		//lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listview_array));	

		et.addTextChangedListener(new TextWatcher()

		{

			public void afterTextChanged(Editable s)

			{
				// Abstract Method of TextWatcher Interface.

			}

			public void beforeTextChanged(CharSequence s,int start, int count, int after)

			{

				// Abstract Method of TextWatcher Interface.

			}

			@Override
			/*public void onTextChanged(CharSequence arg0, int arg1, int arg2,nt arg3)
			{
				// TODO Auto-generated method stub
				
			}*/
			
			public void onTextChanged(CharSequence s,int start, int before, int count)

			{

				textlength = et.getText().length();

				array_sort.clear();

				for (int i = 0; i < listview_array.length; i++)

				{

					if (textlength <= listview_array[i].length())

					{

						if (et.getText().toString().equalsIgnoreCase((String)listview_array[i].subSequence(0,textlength)))

						{
							array_sort.add(listview_array[i]);
						}
					}
				}

				lv.setAdapter(new ArrayAdapter<String>(Emp_search.this,
						android.R.layout.simple_list_item_1, array_sort));

	}

		});

		  
	
		 //studentArrayAdapter = new MyArrayAdapter(Emp_search.this, R.layout.list_item, studentArray);
		 /* listview= (ListView) findViewById(R.id.ListView01);
		 listview.setItemsCanFocus(false);
		 listview.setAdapter(studentArrayAdapter);

		  listview.setOnItemClickListener(new OnItemClickListener()
		  {

	
		   public void onItemClick(AdapterView<?> parent, View v,
		     final int position, long id) {

		    Toast.makeText(Emp_search.this,
		     "List Item Clicked:" + position, Toast.LENGTH_LONG)
		      .show();
		   }

		@Override
		public void onItemClick(AdapterView<?> arg0, android.view.View arg1,
				int arg2, long arg3) {
			// TODO Auto-generated method stub
			
		}
		  });*/
	
	
	
	
	
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item)
	{
		
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		case R.id.add:
			addMenuItem();
			break;
		}
		
		switch(item.getItemId())
		{
		case R.id.delete:
			deleteMenuItem();
			break;
		}
		switch(item.getItemId())
		{
		case R.id.edit:
			editMenuItem();
			break;
		}
		
		
		return true;
		
	}

	private void addMenuItem() 
	{
		 AlertDialog.Builder builder = new AlertDialog.Builder(Emp_search.this);
		    builder.setTitle("Add New Employe ");
		    builder.setMessage("Are you Sure");	
			
		    builder.setPositiveButton("Yes",new DialogInterface.OnClickListener()
		    {
		     public void onClick(DialogInterface dialog, int which)
		     {
		    	 startActivity(new Intent(Emp_search.this,Add_new_employee.class) );
		     }
		    });	
		    
		    builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.cancel();
				}
			});

		
		    builder.show();
		  
		
	}
	private void deleteMenuItem() 
	{
		
		
	}
	
	private void editMenuItem() {
		// TODO Auto-generated method stub
		
	}
	 protected void removeItemFromList(int position)
	 {
	       final int deletePosition = position;
	        
	        AlertDialog.Builder alert = new AlertDialog.Builder(Emp_search.this);
	    
	        alert.setTitle("Delete");
	        alert.setMessage("Do you want delete this item?");
	        
	         alert.setPositiveButton("YES", new OnClickListener() 
	         {
	             @Override
	            public void onClick(DialogInterface dialog, int which)
	             {
	                // TOD O Auto-generated method stub
	                    
	                    // main code on after clicking yes       	 
	            	
	                   
	                    arr.remove(deletePosition); 
	                   
	                   
	                    adapter.notifyDataSetChanged();
	                    adapter.notifyDataSetInvalidated();
	            
	             }
	        });
	         alert.setNegativeButton("CANCEL", new OnClickListener() {
	             @Override
	            public void onClick(DialogInterface dialog, int which) {
	                // TODO Auto-generated method stub
	                dialog.dismiss();
	            }
	        });
	        
	        
	        alert.show();
	        
	 
		 
		 
		 
		 
		 
		 
	

}
	 
	 
	 
	 
}


