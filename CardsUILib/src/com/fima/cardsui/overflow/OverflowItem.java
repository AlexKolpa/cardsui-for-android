package com.fima.cardsui.overflow;

public class OverflowItem {
	String text;
	int overflowId;
	
	public OverflowItem(String text, int overflowId) {
		this.text = text;
		this.overflowId = overflowId;
	}
	
	public int getOverflowId() {
		return overflowId;
	}
	
	public String getText() {
		return text;
	}
}
