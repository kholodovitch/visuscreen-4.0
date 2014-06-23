package com.wedeko.visuscreen.player.proto.main.activities;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.AssetsHelper;
import com.wedeko.visuscreen.player.proto.main.DownloadHelper;
import com.wedeko.visuscreen.player.proto.main.IProgressable;
import com.wedeko.visuscreen.player.proto.main.PlayerApplication;

public class SplashActivity extends Activity {

	private final String BASE_URL = "http://home.kholodovitch.com/share/_/";
	private final String FILE_NAME = "Imagefilm_Salat_mit_Garnelen.mp4";

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
				progressBar.setProgress(progress <= 100 ? progress : 100);
				progressBar.postInvalidate();
				progressText.setText(text);
			}
		});
	}

	private class InitOperation extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			File localVideo = new File(PlayerApplication.getStorageDirectory() + "/video/" + FILE_NAME);
			
			if (!localVideo.exists() || localVideo.length() != 37776551) {
				localVideo.getParentFile().mkdirs();
				IProgressable downloadProgress = new IProgressable() {
					@Override
					public void progress(double progress) {
						setProgress((int) progress, "Downloading video file (36 MB)");
					}
				};
				String downloadResult = DownloadHelper.downloadVideo(BASE_URL + FILE_NAME, localVideo.getAbsolutePath(), downloadProgress);
				if (downloadResult != null)
				{
					setProgress(100, downloadResult);
					try {
						Thread.sleep(5*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

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
