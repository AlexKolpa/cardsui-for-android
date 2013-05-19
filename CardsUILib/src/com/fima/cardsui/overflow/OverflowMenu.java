package com.fima.cardsui.overflow;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class OverflowMenu {
	
	public interface OnOverFlowMenuItemClickedListener {
		public void onOverflowMenuItemClicked(int id);
	}

	protected OnOverFlowMenuItemClickedListener mListener;
	protected List<OverflowItem> overflowItems;
	
	public OverflowMenu() {
		overflowItems = new ArrayList<OverflowItem>();
	}
	
	public void addItem(String text, int id) {
		overflowItems.add(new OverflowItem(text, id));
	}

	public void setOnOverFlowItemClickedListener(
			OnOverFlowMenuItemClickedListener listener) {
		mListener = listener;
	}

	public abstract void show();
	
	public abstract void dismiss();

	public final void attachToView(Context context, View anchor) {
		createView(context, anchor);
		
		anchor.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {				
				show();
			}
		});
	}
	
	protected abstract void createView(Context context, View anchor);
	
	public static OverflowMenu newInstance() {
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
			 return new PopupOverflowMenu();
		} else {
			return new DialogOverflowMenu();
		}
	}
}
