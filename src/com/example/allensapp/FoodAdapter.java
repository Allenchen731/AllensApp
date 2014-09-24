package com.example.allensapp;

import java.util.ArrayList;
import java.util.List;

import com.parse.ParseObject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FoodAdapter extends ArrayAdapter<ParseObject>{
		private Context context;

		private List<ParseObject> foodList;
		public FoodAdapter(Context context,List<ParseObject> foodList){
			super(context,R.layout.custom_row,foodList);
			this.foodList = foodList;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) 
		    {
		        LayoutInflater inflater = (LayoutInflater) context
		                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		        View rowView = inflater.inflate(R.layout.custom_row, parent, false);

		        TextView textview_name = (TextView) rowView.findViewById(R.id.listview_row_name);
		        TextView textview_price = (TextView) rowView.findViewById(R.id.listview_row_price);
		        TextView textview_rest = (TextView) rowView.findViewById(R.id.listview_row_rest);
		        
		        
		        textview_name.setText(foodList.get(position).get("name").toString());
		        textview_price.setText(foodList.get(position).get("price").toString());
		        textview_rest.setText(foodList.get(position).get("restaurant").toString());
		        return rowView;
		    }	
}

