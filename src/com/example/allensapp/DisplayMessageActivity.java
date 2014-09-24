package com.example.allensapp;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class DisplayMessageActivity extends ActionBarActivity {
	private ListView foodListView;

	private ArrayAdapter arrayAdapterName;
	private ArrayAdapter arrayAdapterPrice;
	private ArrayAdapter arrayAdapterRest;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		Intent intent = getIntent();
		foodListView = (ListView)findViewById(R.id.listview_row_layout);
//		foodPriceListView= (ListView)findViewById(R.id.foodPriceListView);
//		foodRestListView = (ListView)findViewById(R.id.foodRestListView);
		final Context thisContext = this;
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("food");
//		query.whereEqualTo("playerName", "Dan Stemkoski");
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> foodList, ParseException e) {

		    	if (e == null) {
//		        	foodNameList = new String[foodList.size()];
//		        	foodPriceList = new String[foodList.size()];
//		        	foodRestList = new String[foodList.size()];
//		        	for (int i =0; i<foodList.size(); i++){
//		        		foodNameList[i] = foodList.get(i).get("name").toString();
//		        		foodPriceList[i] = foodList.get(i).get("price").toString();
//		        		foodRestList[i] = foodList.get(i).get("restaurant").toString();
//		        	}
//		        	arrayAdapterName = new ArrayAdapter(thisContext, layout.simple_list_item_1,foodNameList);
//		        	arrayAdapterPrice = new ArrayAdapter(thisContext, layout.simple_list_item_1,foodPriceList);
//		        	arrayAdapterRest = new ArrayAdapter(thisContext, layout.simple_list_item_1,foodRestList);
//		        	foodNameListView.setAdapter(arrayAdapterName);
//		        	foodPriceListView.setAdapter(arrayAdapterPrice);
////		        	foodRestListView.setAdapter(arrayAdapterRest);
//		            
		        	FoodAdapter thisFoodAdapter = new FoodAdapter(thisContext, foodList);
		        	foodListView.setAdapter(thisFoodAdapter);
		        	
		        } else {
//		            Log.d("score", "Error: " + e.getMessage());
		        }
		    }


		});
		
//		TextView textView = new TextView(this);
//		textView.setTextSize(40);
//		textView.setText("");
//		
//		
//		setContentView(textView);
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
