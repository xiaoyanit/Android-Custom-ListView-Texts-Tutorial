package com.androidbegin.customlistview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.view.View;

public class MainActivity extends Activity {

	// Declare Variables
	ListView list;
	ListViewAdapter adapter;
	String[] rank;
	String[] country;
	String[] population;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_main);

		// Generate sample data
		rank = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		country = new String[] { "China", "India", "United States",
				"Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh",
				"Russia", "Japan" };

		population = new String[] { "1,354,040,000", "1,210,193,422",
				"315,761,000", "237,641,326", "193,946,886", "182,912,000",
				"170,901,000", "152,518,015", "143,369,806", "127,360,000" };

		// Locate the ListView in listview_main.xml
		list = (ListView) findViewById(R.id.listview);

		// Pass results to ListViewAdapter Class
		adapter = new ListViewAdapter(this, rank, country, population);
		// Binds the Adapter to the ListView
		list.setAdapter(adapter);
		// Capture button clicks on ListView items
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Send single item click data to SingleItemView Class
				Intent i = new Intent(MainActivity.this, SingleItemView.class);
				// Pass all data rank
				i.putExtra("rank", rank);
				// Pass all data country
				i.putExtra("country", country);
				// Pass all data population
				i.putExtra("population", population);
				// Pass a single positio
				i.putExtra("position", position);
				// Open SingleItemView.java Activity
				startActivity(i);
			}

		});
	}

	// Not using options menu in this tutorial
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
