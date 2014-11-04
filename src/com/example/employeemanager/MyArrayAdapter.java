package com.example.employeemanager;
import java.util.ArrayList;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
/*public class MyArrayAdapter extends Activity
{
	
	
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
}*/
public class MyArrayAdapter extends ArrayAdapter<Student> {

	
	Context context;
	int layoutResourceId;
	private LayoutInflater mInflater;
    String fname;
    Student ne;
	ArrayList<Student> students = new ArrayList<Student>();

	public MyArrayAdapter(Context context, int layoutResourceId,ArrayList<Student> studs)
	{
		super(context, layoutResourceId, studs);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.students = studs;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		
		View item = convertView;
		StudentWrapper StudentWrapper = null;

		if (item == null)
		{
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			item = inflater.inflate(layoutResourceId, parent, false);
			StudentWrapper = new StudentWrapper();
			StudentWrapper.name = (TextView) item.findViewById(R.id.textName);
			StudentWrapper.age = (TextView) item.findViewById(R.id.textempcode);
			StudentWrapper.address = (TextView) item.findViewById(R.id.textposition);
			StudentWrapper.edit = (ImageView) item.findViewById(R.id.btnEdit);
			

			//StudentWrapper.delete = (Button) item.findViewById(R.id.btnDelete);
			//StudentWrapper.checkBox = (CheckBox) item.findViewById(R.id.checkBox1);			
			item.setTag(StudentWrapper);
		} 
		else
		{
			StudentWrapper = (StudentWrapper) item.getTag();
		}

		Student student = students.get(position);
		StudentWrapper.name.setText(student.getName());
		StudentWrapper.age.setText(student.getAge());
		StudentWrapper.address.setText(student.getAddress());
		
		fname= StudentWrapper.name.getText().toString();
	//	ne.setName(fname);
		
	

		
	/*	StudentWrapper.delete.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}*/

			
			
	//});
	
			
		
		/*StudentWrapper.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				Toast.makeText(context, "Checkox", Toast.LENGTH_LONG).show();
			}
			
		});*/
			

		return item;

	}

	protected void startActivity(Intent intent) 
	{
		// startActivity(new Intent(MyArrayAdapter.this,Add_empDetailManager.class) );
	}

	static class StudentWrapper
	{
		TextView name;
		TextView age;
		TextView address;
		ImageView edit;
		//Button delete;
	//CheckBox checkBox;
	}
	private void doButtonOneClickActions(int rowNumber) 
	{
	    // Do the actions for Button one in row rowNumber (starts at zero)
	}
}
