package com.fima.cardsui.overflow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;

@SuppressLint("NewApi")
public class PopupOverflowMenu extends OverflowMenu {

	PopupMenu mOverflow;

	@Override
	public void show() {
		mOverflow.show();
	}

	@Override
	protected void createView(Context context, View anchor) {
		mOverflow = new PopupMenu(context, anchor);

		for (OverflowItem item : overflowItems) {
			mOverflow.getMenu().add(Menu.NONE, item.getOverflowId(), Menu.NONE,
					item.getText());
		}

		mOverflow.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				if (mListener != null)
					mListener.onOverflowMenuItemClicked(item.getItemId());
				return true;
			}
		});
	}

	@Override
	public void dismiss() {
		mOverflow.dismiss();
	}

}
