package com.example.employeemanager;

import java.util.Locale;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Login extends Activity implements OnItemSelectedListener {

	SQLiteDatabase db;
	EditText unameedt;
	String unam;
	String pass;
	public int id;
	private TextView txt_hello,user_nametxt;
	private Button btn_en, btn_ru, btn_fr, btn_de;
	private Locale myLocale;    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		ImageView signina=(ImageView)findViewById(R.id.imageView2);
		ImageView signupi=(ImageView)findViewById(R.id.imageView3);
		db = openOrCreateDatabase("Employeemanager", MODE_PRIVATE, null);
		this.user_nametxt=(TextView)findViewById(R.id.textView1);
		this.txt_hello = (TextView)findViewById(R.id.txt_hello);
		Spinner lanspinner=(Spinner)findViewById(R.id.langspinner);
		
		ArrayAdapter<?> adapterlang=ArrayAdapter.createFromResource(this,R.array.language,android.R.layout.simple_spinner_item);
		lanspinner.setAdapter(adapterlang);
		lanspinner.setOnItemSelectedListener(this);
		
		
		loadLocale();
		
		
		
		
		
		
		// Login
		signina.setOnClickListener(new OnClickListener()
		
				{

			public void onClick(View v) {
				EditText passedt = (EditText) findViewById(R.id.editText2);
				EditText unameedt = (EditText) findViewById(R.id.editText1);
				// TextView loginfaild = (TextView)
				// findViewById(R.id.editText3);
				unam = unameedt.getText().toString();
				pass = passedt.getText().toString();

				if ((unam.matches("")) || (pass.matches("")))
				{
					Toast.makeText(getApplicationContext(),	"Enter user name and Password", Toast.LENGTH_LONG).show();
			

				}
				else
				{
				
					Cursor c = db.rawQuery(	"SELECT  username, password from Employee Where username='"	+ unam + "' and password='" + pass + "'",null);

					if (c != null)
					{
						

						if (c.moveToFirst()) 
						{			
							String uname = c.getString(c.getColumnIndex("username"));
							String upass = c.getString(c.getColumnIndex("password"));				
							

							if ((uname.equals(unam)) && (upass.equals(pass))) 
							{

								startActivity(new Intent(Login.this, Home.class));

							} 
							

						}
						else
							//if ((!uname.equals(unam)) || (!upass.equals(pass)))
					
						{
							
							Toast.makeText(getApplicationContext(),	"Invalid username or password", Toast.LENGTH_LONG).show();
							
						
						}

					}

				}
			}

			/*private Context BaseContext() {
				// TODO Auto-generated method stub
				return null;
			}*/
		});
  
		signupi.setOnClickListener(new OnClickListener()

		{

			@Override
			public void onClick(View v) {
				startActivity(new Intent(Login.this, Emp_signup.class));
			}

		});
		
		
	}
	public void loadLocale()
    {
    	String langPref = "Language";
    	SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
    	String language = prefs.getString(langPref, "");
    	changeLang(language);
    }
    
    public void saveLocale(String lang)
    {
    	String langPref = "Language";
    	SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
    	SharedPreferences.Editor editor = prefs.edit();
		editor.putString(langPref, lang);
		editor.commit();
    }

	public void changeLang(String lang)
    {
    	if (lang.equalsIgnoreCase(""))
    		return;
    	myLocale = new Locale(lang);
    	saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        updateTexts();
    }
	
	private void updateTexts()
	{
		txt_hello.setText(R.string.hello_world);
		user_nametxt.setText(R.string.user_name);
		
	}

	
	@Override
	public void onConfigurationChanged(android.content.res.Configuration newConfig) 
	 {
		super.onConfigurationChanged(newConfig);
		if (myLocale != null){
	        newConfig.locale = myLocale;
	        Locale.setDefault(myLocale);
	        getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
	    }
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long arg3) {
		switch (position) 
		{
        case 0:
        	String lang = "en";
        	changeLang(lang);
            break;

        case 1:
            
        	String langf = "fr";
        	changeLang(langf);
			Toast.makeText(getApplicationContext(),"french", Toast.LENGTH_LONG).show();
			
            break;
          case 2:
        	String langr = "ru";
         	changeLang(langr);
			
            break;
            
          case 3:
              

  			
              break;
        }
		
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	}


