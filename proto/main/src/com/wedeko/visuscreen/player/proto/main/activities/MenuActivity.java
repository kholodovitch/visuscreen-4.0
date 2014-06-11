package com.wedeko.visuscreen.player.proto.main.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.controls.RelativeLayoutButton;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_menu);

		setButtonValues(R.id.button_localContent, R.string.menu_localContent_header, R.string.menu_localContent_description, R.drawable.button_transitions, ProtoLocalContentActivity.class);
		setButtonValues(R.id.button_transitions, R.string.menu_transitions_header, R.string.menu_transitions_description, R.drawable.button_transitions, ProtoTransitionsActivity.class);
		setButtonValues(R.id.button_schedule, R.string.menu_schedule_header, R.string.menu_schedule_description, R.drawable.button_transitions, ProtoTransitionsActivity.class);
		setButtonValues(R.id.button_html5_from_json, R.string.menu_html5_from_json_header, R.string.menu_html5_from_json_description, R.drawable.button_transitions, ProtoTransitionsActivity.class);
		setButtonValues(R.id.button_json_server, R.string.menu_json_server_header, R.string.menu_json_server_description, R.drawable.button_transitions, ProtoTransitionsActivity.class);
		setButtonValues(R.id.button_async_client, R.string.menu_async_client_header, R.string.menu_async_client_description, R.drawable.button_transitions, ProtoTransitionsActivity.class);
		setButtonValues(R.id.button_local_storage, R.string.menu_local_storage_header, R.string.menu_local_storage_description, R.drawable.button_transitions, ProtoTransitionsActivity.class);
		setButtonValues(R.id.button_unloading_scenes, R.string.menu_unloading_scenes_header, R.string.menu_unloading_scenes_description, R.drawable.button_transitions, ProtoTransitionsActivity.class);
		setButtonValues(R.id.button_screenshoting, R.string.menu_screenshoting_header, R.string.menu_screenshoting_description, R.drawable.button_transitions, ProtoTransitionsActivity.class);
	}

	protected void setButtonValues(int buttonId, int headerId, int descriptionId, int imageId, final Class<?> nextActivitiy) {
		RelativeLayoutButton button = new RelativeLayoutButton(this, buttonId);
		
		button.setText(R.id.test_button_text1, headerId);
		button.setText(R.id.test_button_text2, descriptionId);
		button.setImageResource(R.id.test_button_image, imageId);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MenuActivity.this, nextActivitiy);
				startActivity(intent);
			}
		});
	}
}
