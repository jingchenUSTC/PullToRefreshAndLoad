package com.jingchen.pulltorefresh.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class PullableWebView extends WebView implements Pullable {

	public PullableWebView(Context context) {
		super(context);
	}

	public PullableWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public PullableWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean canPullDown() {
		if (getScrollY() == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean canPullUp() {
		if (getScrollY() >= getContentHeight() * getScale()
				- getMeasuredHeight())
			return true;
		else
			return false;
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
