package com.jingchen.pulltorefresh.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;


public class PullableImageView extends ImageView implements Pullable
{

	public PullableImageView(Context context)
	{
		super(context);
	}

	public PullableImageView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public PullableImageView(Context context, AttributeSet attrs, int defStyle)
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
