package com.wedeko.visuscreen.player.proto.main.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.AssetsHelper;
import com.wedeko.visuscreen.player.proto.main.IProgressable;

public class SplashActivity extends Activity {

	private Handler handler;
	private ProgressBar progressBar;
	private TextView progressText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		progressText = (TextView) findViewById(R.id.textProgress);
		handler = new Handler();

		setProgress(0, "Starting of initialization");
		handler.postDelayed(new Runnable() {
			public void run() {
				new InitOperation().execute("");
			}
		}, 500);
	}

	private void setProgress(final int progress, final String text) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				progressBar.setProgress(progress);
				progressBar.postInvalidate();
				progressText.setText(text);
			}
		});
	}

	private class InitOperation extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			// PlayerApplication.getStorageDirectory();
			AssetsHelper.copyFilesToSdCard(new IProgressable() {
				@Override
				public void progress(double progress) {
					setProgress((int) (progress * 100), "Copying internal resources to SD-card");
				}
			});

			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			setProgress(100, "Completed");

			// Close splash screen on specified timeout
			handler.postDelayed(new Runnable() {
				public void run() {
					Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
					startActivity(intent);
					finish();
				}
			}, 500);
		}

		@Override
		protected void onPreExecute() {
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}
	}
}
