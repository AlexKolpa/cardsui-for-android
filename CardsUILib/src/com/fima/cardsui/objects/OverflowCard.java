package com.fima.cardsui.objects;

import android.content.Context;
import android.view.View;

import com.fima.cardsui.overflow.OverflowMenu;
import com.fima.cardsui.overflow.OverflowMenu.OnOverFlowMenuItemClickedListener;

public abstract class OverflowCard extends Card implements OnOverFlowMenuItemClickedListener {

	public interface OverflowItemClickListener {
		public void onOverflowItemClicked(OverflowCard card, int id);
	}
	
	OverflowItemClickListener mListener;
	OverflowMenu mOverflow;
	int mOverflowId;

	public OverflowCard(int overflowId) {
		mOverflow = OverflowMenu.newInstance();
		this.mOverflowId = overflowId;
	}

	public OverflowCard(int overflowId, String title) {
		mOverflow = OverflowMenu.newInstance();
		this.mOverflowId = overflowId;
		this.title = title;
	}

	public OverflowCard(int overflowId, String title, int image) {
		mOverflow = OverflowMenu.newInstance();
		this.mOverflowId = overflowId;
		this.title = title;
		this.image = image;
	}

	public OverflowCard(int overflowId, String title, String desc, int image) {
		mOverflow = OverflowMenu.newInstance();
		this.mOverflowId = overflowId;
		this.title = title;
		this.desc = desc;
		this.image = image;
	}

	public void setOverflowItemClickListener(OverflowItemClickListener listener) {
		mListener = listener;
	}

	@Override
	public View getView(Context context) {

		View cardView = super.getView(context);

		View overflowView = cardView.findViewById(mOverflowId);
		if (overflowView != null) {
			mOverflow.attachToView(context, overflowView);
		}
		return cardView;
	}
	
	@Override
	public View getViewFirst(Context context) {
		View cardView = super.getViewFirst(context);
		
		View overflowView = cardView.findViewById(mOverflowId);
		if (overflowView != null) {
			mOverflow.attachToView(context, overflowView);
		}
		return cardView;
	}
	
	@Override
	public View getViewLast(Context context) {		
		View cardView = super.getViewLast(context);
		View overflowView = cardView.findViewById(mOverflowId);
		if (overflowView != null) {
			mOverflow.attachToView(context, overflowView);			
		}
		return cardView;
	}
	
	public OverflowMenu getOverflowMenu() {
		return mOverflow;
	}
	
	public void addItem(String text, int id) {
		mOverflow.addItem(text, id);
	}

	@Override
	public void onOverflowMenuItemClicked(int id) {
		if (mListener != null)
			mListener.onOverflowItemClicked(this, id);
	}
}
