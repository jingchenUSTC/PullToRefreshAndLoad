package com.jingchen.pulltorefresh.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.jingchen.pulltorefresh.MyAdapter;
import com.jingchen.pulltorefresh.MyListener;
import com.jingchen.pulltorefresh.PullToRefreshLayout;
import com.jingchen.pulltorefresh.R;

public class PullableListViewActivity extends Activity
{
	private ListView listView;
	private PullToRefreshLayout ptrl;
	private boolean isFirstIn = true;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		ptrl = ((PullToRefreshLayout) findViewById(R.id.refresh_view));
		ptrl.setOnRefreshListener(new MyListener());
		listView = (ListView) findViewById(R.id.content_view);
		initListView();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus)
	{
		super.onWindowFocusChanged(hasFocus);
		// 第一次进入自动刷新
		if (isFirstIn)
		{
			ptrl.autoRefresh();
			isFirstIn = false;
		}
	}

	/**
	 * ListView初始化方法
	 */
	private void initListView()
	{
		List<String> items = new ArrayList<String>();
		for (int i = 0; i < 30; i++)
		{
			items.add("这里是item " + i);
		}
		MyAdapter adapter = new MyAdapter(this, items);
		listView.setAdapter(adapter);
		listView.setOnItemLongClickListener(new OnItemLongClickListener()
		{

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				Toast.makeText(
						PullableListViewActivity.this,
						"LongClick on "
								+ parent.getAdapter().getItemId(position),
						Toast.LENGTH_SHORT).show();
				return true;
			}
		});
		listView.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				Toast.makeText(PullableListViewActivity.this,
						" Click on " + parent.getAdapter().getItemId(position),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
