package com.cardsui.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fima.cardsui.objects.OverflowCard;

public class MyOverflowCard extends OverflowCard {

	public MyOverflowCard(int overflowId) {
		super(overflowId);		
	}
	
	public MyOverflowCard(int overflowId, String title) {
		super(overflowId, title);
	}

	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.card_overflow, null);

		((TextView) view.findViewById(R.id.title)).setText(title);

		return view;
	}

}
