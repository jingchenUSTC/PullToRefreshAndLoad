package com.jingchen.pulltorefresh.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

public class PullableExpandableListView extends Pullable {
	private ExpandableListView mContent;

	public PullableExpandableListView(View view) {
		mContent = (ExpandableListView) view;
	}

	@Override
	public boolean canPullDown() {
		if (!canPullDown)
			return false;
		if (mContent.getCount() == 0) {
			// 没有item的时候也可以下拉刷新
			return true;
		} else if (mContent.getFirstVisiblePosition() == 0
				&& mContent.getChildAt(0).getTop() >= 0) {
			// 滑到顶部了
			return true;
		} else
			return false;
	}

	@Override
	public boolean canPullUp() {
		if (!canPullUp)
			return false;
		if (mContent.getCount() == 0) {
			// 没有item的时候也可以上拉加载
			return true;
		} else if (mContent.getLastVisiblePosition() == (mContent.getCount() - 1)) {
			// 滑到底部了
			if (mContent.getChildAt(mContent.getLastVisiblePosition()
					- mContent.getFirstVisiblePosition()) != null
					&& mContent.getChildAt(
							mContent.getLastVisiblePosition()
									- mContent.getFirstVisiblePosition())
							.getBottom() <= mContent.getMeasuredHeight())
				return true;
		}
		return false;
	}
}
