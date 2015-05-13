package com.jingchen.pulltorefresh.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class PullableDefault extends Pullable {

	public PullableDefault() {
	}

	@Override
	public boolean canPullDown() {
		if (!canPullDown)
			return false;
		return true;
	}

	@Override
	public boolean canPullUp() {
		if (!canPullUp)
			return false;
		return true;
	}

}
