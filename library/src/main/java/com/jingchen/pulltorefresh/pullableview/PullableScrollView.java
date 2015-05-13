package com.jingchen.pulltorefresh.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class PullableScrollView extends Pullable {
	private ScrollView mContent;

	public PullableScrollView(View view) {
		mContent = (ScrollView) view;
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
		if (mContent.getScrollY() >= (mContent.getChildAt(0).getHeight() - mContent
				.getMeasuredHeight()))
			return true;
		else
			return false;
	}
}
