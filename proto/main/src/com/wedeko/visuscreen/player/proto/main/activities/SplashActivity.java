package com.wedeko.visuscreen.player.proto.main.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.wedeko.visuscreen.player.proto.R;

public class SplashActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);

		Handler handler = new Handler();
		// Close splash screen on specified timeout
		handler.postDelayed(new Runnable() {
			public void run() {
				Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
				startActivity(intent);
				finish();
			}
		}, 5000);
	}

}
