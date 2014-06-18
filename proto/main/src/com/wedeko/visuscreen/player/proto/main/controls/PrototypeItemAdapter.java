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
import com.wedeko.visuscreen.player.proto.main.dataobjects.PrototypeInfo;

public class PrototypeItemAdapter extends ArrayAdapter<PrototypeInfo> {

	private Context context;
	private ArrayList<PrototypeInfo> items;
	private int bg_even;
	private int bg_odd;

	public PrototypeItemAdapter(Context context, int textViewResourceId, ArrayList<PrototypeInfo> items) {
		super(context, textViewResourceId, items);
		this.context = context;
		this.items = items;

		bg_even = context.getResources().getColor(R.color.bg_even);
		bg_odd = context.getResources().getColor(R.color.bg_odd);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.row_prototype, parent, false);
		TextView textName = (TextView) rowView.findViewById(R.id.test_button_text1);
		TextView textDescription = (TextView) rowView.findViewById(R.id.test_button_text2);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.test_button_image);
		PrototypeInfo prototypeItem = items.get(position);

		if (prototypeItem.getNextActivityClass() == null) {
			textName.setEnabled(false);
			textDescription.setEnabled(false);
		}
		textName.setText(prototypeItem.getName());
		textDescription.setText(prototypeItem.getDescription());
		imageView.setImageResource(prototypeItem.getImageId());

		if (position % 2 == 0)
			rowView.setBackgroundColor(bg_even);
		else
			rowView.setBackgroundColor(bg_odd);

		return rowView;
	}

}