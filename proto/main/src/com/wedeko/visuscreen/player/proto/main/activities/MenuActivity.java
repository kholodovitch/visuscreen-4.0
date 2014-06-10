package com.wedeko.visuscreen.player.proto.main.activities;

import android.app.Activity;
import android.os.Bundle;

import com.wedeko.visuscreen.player.proto.main.R;
import com.wedeko.visuscreen.player.proto.main.controls.RelativeLayoutButton;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_menu);

		RelativeLayoutButton button3 = new RelativeLayoutButton(this, R.id.button_transitions);
		button3.setText(R.id.test_button_text1, "Transitions");
		button3.setText(R.id.test_button_text2, "Testing execution of scene switches: without transitions, linear fade, masking fade, 3D transitions and etc...");
		button3.setImageResource(R.id.test_button_image, R.drawable.button_transitions);
	}
}
