package com.example.slidingdrawerdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class MainActivity extends Activity {

	private ImageView ivSwitch;
	private GridView gridView;
	private SlidingDrawer drawer;
	private String[] items = { "Alarm", "Calendar", "Camera", "Clock", "Music", "TV" };
	private int[] icons = { R.drawable.alarm, R.drawable.calendar, R.drawable.camera, R.drawable.clock,
			R.drawable.music, R.drawable.tv };
	private List<Map<String, Object>> list;
	private SimpleAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ivSwitch = (ImageView) findViewById(R.id.ivSwitch);
		gridView = (GridView) findViewById(R.id.content);
		list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < icons.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("icon", icons[i]);
			map.put("text", items[i]);
			list.add(map);
		}
		adapter = new SimpleAdapter(this, list, R.layout.grid_item, new String[] { "icon", "text" },
				new int[] { R.id.icon, R.id.text });
		gridView.setAdapter(adapter);
		drawer = (SlidingDrawer) findViewById(R.id.slidingdrawer);

		drawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {

			@Override
			public void onDrawerOpened() {
				ivSwitch.setImageResource(R.drawable.close);
			}
		});
		drawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {

			@Override
			public void onDrawerClosed() {
				ivSwitch.setImageResource(R.drawable.open);
			}
		});
	}

}
