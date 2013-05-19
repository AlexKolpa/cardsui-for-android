package com.cardsui.example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.objects.OverflowCard;
import com.fima.cardsui.objects.OverflowCard.OverflowItemClickListener;
import com.fima.cardsui.views.CardUI;

public class MainActivity extends Activity {

	private CardUI mCardView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// init CardView
		mCardView = (CardUI) findViewById(R.id.cardsview);
		mCardView.setSwipeable(false);

		// add AndroidViews Cards
		mCardView.addCard(new MyCard("Get the CardsUI view"));
		mCardView.addCardToLastStack(new MyCard("for Android at"));
		MyCard androidViewsCard = new MyCard("www.androidviews.net");
		androidViewsCard.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.androidviews.net/"));
				startActivity(intent);

			}
		});
		mCardView.addCardToLastStack(androidViewsCard);

		// add one card, and then add another one to the last stack.
		mCardView.addCard(new MyCard("2 cards"));
		mCardView.addCardToLastStack(new MyCard("2 cards"));

		// add one card
		mCardView.addCard(new MyImageCard("Nexus 4 Part 1", R.drawable.url1));
		mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 2",
				R.drawable.url2));
		mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 3",
				R.drawable.url3));

		// create a stack
		CardStack stack = new CardStack();
		stack.setTitle("title test");

		// add 3 cards to stack
		stack.add(new MyCard("3 cards"));
		stack.add(new MyCard("3 cards"));
		stack.add(new MyCard("3 cards"));

		// add stack to cardView
		mCardView.addStack(stack);

		mCardView.addCard(new MyOverflowCard(R.id.overflow, "Overflow Card 1"));
		MyOverflowCard overflowCard = new MyOverflowCard(R.id.overflow,
				"Overflow Card 2");
		overflowCard.addItem("Action 1", 1);
		overflowCard.addItem("Action 2", 2);
		overflowCard.addItem("Action 3", 3);
		mCardView.addCardToLastStack(overflowCard);
		MyOverflowCard callbackCard = new MyOverflowCard(R.id.overflow,
				"Overflow Card 2");
		callbackCard.addItem("Action 1", 1);
		callbackCard.addItem("Action 2", 2);
		callbackCard.addItem("Action 3", 3);
		callbackCard
				.setOverflowItemClickListener(new OverflowItemClickListener() {

					@Override
					public void onOverflowItemClicked(OverflowCard card, int id) {
						Toast.makeText(MainActivity.this,
								"Item " + id + " pressed!", Toast.LENGTH_SHORT)
								.show();

					}
				});
		mCardView.addCardToLastStack(callbackCard);

		// draw cards
		mCardView.refresh();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
