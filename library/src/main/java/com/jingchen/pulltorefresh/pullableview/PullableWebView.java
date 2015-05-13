package com.jingchen.pulltorefresh.pullableview;

import android.view.View;
import android.webkit.WebView;

public class PullableWebView extends Pullable {
	private WebView mContent;

	public PullableWebView(View view) {
		mContent = (WebView) view;
	}

	@Override
	public boolean canPullDown() {
		if (!canPullDown)
			return false;
		if (mContent.getScrollY() == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean canPullUp() {
		if (!canPullUp)
			return false;
		if (mContent.getScrollY() >= mContent.getContentHeight()
				* mContent.getScale() - mContent.getMeasuredHeight())
			return true;
		else
			return false;
	}
}
