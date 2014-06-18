package com.wedeko.visuscreen.player.proto.main.activities;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.controls.PrototypeItemAdapter;
import com.wedeko.visuscreen.player.proto.main.dataobjects.PrototypeInfo;

public class MenuActivity extends Activity {
	static ArrayList<PrototypeInfo> values;

	static {
		PrototypeInfo[] asArray = new PrototypeInfo[] {
				new PrototypeInfo(R.string.menu_localContent_header, R.string.menu_localContent_description, R.drawable.ic_action_sd_storage, ProtoLocalContentActivity.class),
				new PrototypeInfo(R.string.menu_transitions_header, R.string.menu_transitions_description, R.drawable.ic_action_transition, ProtoTransitionsActivity.class),
				new PrototypeInfo(R.string.menu_schedule_header, R.string.menu_schedule_description, R.drawable.ic_action_about, null),
				new PrototypeInfo(R.string.menu_html5_from_json_header, R.string.menu_html5_from_json_description, R.drawable.ic_action_about, null),
				new PrototypeInfo(R.string.menu_json_server_header, R.string.menu_json_server_description, R.drawable.ic_action_about, null),
				new PrototypeInfo(R.string.menu_async_client_header, R.string.menu_async_client_description, R.drawable.ic_action_about, null),
				new PrototypeInfo(R.string.menu_local_storage_header, R.string.menu_local_storage_description, R.drawable.ic_action_about, null),
				new PrototypeInfo(R.string.menu_unloading_scenes_header, R.string.menu_unloading_scenes_description, R.drawable.ic_action_about, null),
				new PrototypeInfo(R.string.menu_screenshoting_header, R.string.menu_screenshoting_description, R.drawable.ic_action_about, null),
		};
		values = new ArrayList<PrototypeInfo>(Arrays.asList(asArray));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
	}

	@Override
	protected void onStart() {
		super.onStart();

		final ListView listview = (ListView) findViewById(R.id.listview_prototypes);

		final PrototypeItemAdapter adapter = new PrototypeItemAdapter(this, android.R.layout.simple_list_item_1, values);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				final PrototypeInfo item = (PrototypeInfo) parent.getItemAtPosition(position);
				if (item.getNextActivityClass() == null)
					return;

				Intent intent = new Intent();
				intent.setClass(parent.getContext(), item.getNextActivityClass());
				startActivity(intent);
			}
		});
	}
}
