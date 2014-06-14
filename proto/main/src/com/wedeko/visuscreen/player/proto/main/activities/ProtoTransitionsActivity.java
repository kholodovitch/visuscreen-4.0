package com.wedeko.visuscreen.player.proto.main.activities;

import java.util.ArrayList;
import java.util.Arrays;

import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.controls.TransitionItemAdapter;
import com.wedeko.visuscreen.player.proto.main.dataobjects.TransitionInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ProtoTransitionsActivity extends Activity {
	static ArrayList<TransitionInfo> values;

	static {
		TransitionInfo[] asArray = new TransitionInfo[] { new TransitionInfo(R.string.transition_without_transition, R.drawable.transition_without_transition, "") };
		values = new ArrayList<TransitionInfo>(Arrays.asList(asArray));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proto_transitions);
	}

	@Override
	protected void onStart() {
		super.onStart();

		final ListView listview = (ListView) findViewById(R.id.listview_transitions);

		final TransitionItemAdapter adapter = new TransitionItemAdapter(this, android.R.layout.simple_list_item_1, values);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				final TransitionInfo item = (TransitionInfo) parent.getItemAtPosition(position);

				Bundle bundle = new Bundle();
				bundle.putString("traget_html", item.getTargetHtml());

				Intent intent = new Intent();
				intent.putExtras(bundle);
				intent.setClass(parent.getContext(), Html5ViewActivity.class);
				startActivity(intent);
			}
		});
	}
}
