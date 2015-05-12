package com.jingchen.pulltorefresh.pullableview;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class PullableTextView extends TextView implements Pullable
{

	public PullableTextView(Context context)
	{
		super(context);
	}

	public PullableTextView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public PullableTextView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}

	@Override
	public boolean canPullDown()
	{
		return true;
	}

	@Override
	public boolean canPullUp()
	{
		return true;
	}

	private boolean canPullUp = true, canPullDown = true;

	@Override
	public void setPullUp(boolean flag) {
		canPullUp = flag;
	}

	@Override
	public void setPullDown(boolean flag) {
		canPullDown = flag;
	}

}
