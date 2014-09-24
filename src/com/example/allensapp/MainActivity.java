package com.example.allensapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;


public class MainActivity extends ActionBarActivity {
	public final static String EXTRA_MESSAGE = "com.example.allensapp.MESSAGE";
    public static String EXTRA_MESSAGE_FAIL ="com.example.allensapp.MESSAGE";
	EditText objName;
	EditText objPrice;
	EditText objRest;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objName = (EditText)findViewById(R.id.edit_message);
        objPrice =(EditText)findViewById(R.id.add_price_edittext);
        objRest = (EditText)findViewById(R.id.add_rest_edittext);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    private void openSearch() {
        Toast.makeText(this, "Search button pressed", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	// int id = item.getItemId();
    	// if (id == R.id.action_settings) {
    	// return true;
    	// }
    	int id = item.getItemId();
    	if (id == R.id.action_search){
    		openSearch();
    		return true;
    	}
    	else if (id == R.id.action_settings){
    		return true;
    	}
    	else{
    		return super.onOptionsItemSelected(item);
    	}

    

    	
//        return super.onOptionsItemSelected(item);
    }
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {

//    	EditText editText = (EditText) findViewById(R.id.edit_message);
//    	String message = editText.getText().toString();
    	
    	String name = objName.getText().toString();
    	double price;
    	try{
    		price = Double.parseDouble(objPrice.getText().toString());
    	}
    	catch(NumberFormatException ex){
    		price = 0;
    		Intent intent_fail = new Intent(this, PromptReInputActivity.class);
    		intent_fail.putExtra(EXTRA_MESSAGE_FAIL,objPrice.getText().toString()+" is not a valid price\n");
    		startActivity(intent_fail);
    		return;
    	}
    	
    		
    	String rest = objRest.getText().toString();
    	
    	ParseObject foodObj = new ParseObject("food");
    	foodObj.put("name", name);
    	foodObj.put("price", price);
    	foodObj.put("restaurant", rest);
    	foodObj.saveInBackground();
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	intent.putExtra(EXTRA_MESSAGE,"");
    	startActivity(intent);
     
    }
}
