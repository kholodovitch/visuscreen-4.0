package com.wedeko.visuscreen.player.proto.main.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import com.mogoweb.chrome.WebView;
import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.PlayerApplication;

public class Html5ViewActivity extends Activity {

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set layout
		setContentView(R.layout.activity_html5view);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		// Save the web view
		webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
		webView.getSettings().setJavaScriptEnabled(true);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			String targetHtml = bundle.getString("target_html");
			if (targetHtml != null)
				webView.loadUrl("file://" + PlayerApplication.getStorageDirectory() + "/" + targetHtml);
		}
	}
}
