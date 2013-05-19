package com.fima.cardsui.overflow;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ArrayAdapter;

public class DialogOverflowMenu extends OverflowMenu {

	AlertDialog mOverflow;

	@Override
	public void show() {
		mOverflow.show();
	}

	@Override
	protected void createView(Context context, View anchor) {
		ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(context,
				android.R.layout.simple_list_item_1);

		for (OverflowItem item : overflowItems)
			mAdapter.add(item.getText());

		Builder builder = new Builder(context);
		builder.setAdapter(mAdapter, new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (DialogOverflowMenu.this.mListener != null)
					DialogOverflowMenu.this.mListener
							.onOverflowMenuItemClicked(overflowItems.get(which)
									.getOverflowId());
			}
		});

		mOverflow = builder.create();
	}

	@Override
	public void dismiss() {
		mOverflow.dismiss();
	}
}
