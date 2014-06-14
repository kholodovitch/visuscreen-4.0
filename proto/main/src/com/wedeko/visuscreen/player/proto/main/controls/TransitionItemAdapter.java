package com.wedeko.visuscreen.player.proto.main.controls;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.dataobjects.TransitionInfo;

public class TransitionItemAdapter extends ArrayAdapter<TransitionInfo> {

	private Context context;
	private ArrayList<TransitionInfo> items;
	private int bg_even;
	private int bg_odd;

	public TransitionItemAdapter(Context context, int textViewResourceId, ArrayList<TransitionInfo> items) {
		super(context, textViewResourceId, items);
		this.context = context;
		this.items = items;

		bg_even = context.getResources().getColor(R.color.bg_even);
		bg_odd = context.getResources().getColor(R.color.bg_odd);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.row_transition, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.transition_name);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		TransitionInfo transitionItem = items.get(position);

		textView.setText(transitionItem.getName());
		imageView.setImageResource(transitionItem.getImageId());

		if (position % 2 == 0)
			rowView.setBackgroundColor(bg_even);
		else
			rowView.setBackgroundColor(bg_odd);

		return rowView;
	}


}