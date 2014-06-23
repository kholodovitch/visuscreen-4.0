package com.wedeko.visuscreen.player.proto.main.activities;

import java.util.ArrayList;
import java.util.Arrays;

import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.controls.TransitionItemAdapter;
import com.wedeko.visuscreen.player.proto.main.dataobjects.TransitionInfo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ProtoTransitionsActivity extends Activity {
	static ArrayList<TransitionInfo> values;

	static {
		TransitionInfo[] asArray = new TransitionInfo[] {
				new TransitionInfo(R.string.transition_without_transition, R.drawable.transition_without_transition, "transition_none.html"),
				new TransitionInfo(R.string.transition_fade, R.drawable.transition_fade, "transition_fade.html"),
				//new TransitionInfo(R.string.transition_fade_wipe2, R.drawable.transition_fade_wipe2, null),
				new TransitionInfo(R.string.transition_star, R.drawable.transition_star, "transition_star.html"),
				new TransitionInfo(R.string.transition_eye, R.drawable.transition_eye, "transition_eye.html"),
				//new TransitionInfo(R.string.transition_melt, R.drawable.transition_melt, null),
				new TransitionInfo(R.string.transition_horizontal_wipe, R.drawable.transition_horizontal_wipe, "transition_horizontalWipe.html"),
				new TransitionInfo(R.string.transition_horizontal_wipe2, R.drawable.transition_horizontal_wipe2, "transition_horizontalWipe2.html"),
				new TransitionInfo(R.string.transition_vertical_wipe, R.drawable.transition_vertical_wipe, "transition_verticalWipe.html"),
				new TransitionInfo(R.string.transition_vertical_wipe2, R.drawable.transition_vertical_wipe2, "transition_verticalWipe2.html"),
				new TransitionInfo(R.string.transition_diagonal_wipe, R.drawable.transition_diagonal_wipe, "transition_diagonalWipe.html"),
				new TransitionInfo(R.string.transition_diagonal_wipe2, R.drawable.transition_diagonal_wipe2, "transition_diagonalWipe2.html"),
				//new TransitionInfo(R.string.transition_rotate_wipe, R.drawable.transition_rotate_wipe, null),
				//new TransitionInfo(R.string.transition_rotate_wipe2, R.drawable.transition_rotate_wipe2, null),
				new TransitionInfo(R.string.transition_roll, R.drawable.transition_roll, "transition_roll.html"),
				new TransitionInfo(R.string.transition_3D_door, R.drawable.transition_3d_door, "transition_door.html"),
				new TransitionInfo(R.string.transition_3D_rotate, R.drawable.transition_3d_rotate, "transition_rotate.html"),
				new TransitionInfo(R.string.transition_3D_spin, R.drawable.transition_3d_spin, "transition_spin.html"),
				new TransitionInfo(R.string.transition_3D_explosion, R.drawable.transition_3d_explosion, null),
		};
		values = new ArrayList<TransitionInfo>(Arrays.asList(asArray));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proto_transitions);

		ActionBar actionBar = getActionBar();
		actionBar.setTitle("Transition prototypes");
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
				if (item.getTargetHtml() == null) {
					Toast.makeText(ProtoTransitionsActivity.this, "Coming soon...", Toast.LENGTH_SHORT).show();
					return;
				}

				Bundle bundle = new Bundle();
				bundle.putString("target_html", item.getTargetHtml());

				Intent intent = new Intent();
				intent.putExtras(bundle);
				intent.setClass(parent.getContext(), Html5ViewActivity.class);
				startActivity(intent);
			}
		});
	}
}
