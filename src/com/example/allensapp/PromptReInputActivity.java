package com.example.allensapp;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;

public class PromptReInputActivity extends ActionBarActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prompt_reinput);
		Intent intent_fail = getIntent();
		
//		ParseQuery<ParseObject> query = ParseQuery.getQuery("food");
////		query.whereEqualTo("playerName", "Dan Stemkoski");
//		query.findInBackground(new FindCallback<ParseObject>() {
//		    public void done(List<ParseObject> foodList, ParseException e) {
//		        if (e == null) {
//		            Log.d("score", "Retrieved " + foodList.size() + " scores");
//		        } else {
//		            Log.d("score", "Error: " + e.getMessage());
//		        }
//		    }
//		});
		
		
		
		TextView textView = new TextView(this);
		textView.setTextSize(20);
		textView.setText(intent_fail.getStringExtra(MainActivity.EXTRA_MESSAGE_FAIL));
		
		
		setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
