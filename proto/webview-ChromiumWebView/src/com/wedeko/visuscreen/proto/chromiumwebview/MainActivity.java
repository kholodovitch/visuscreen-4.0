package com.wedeko.visuscreen.proto.chromiumwebview;

import android.app.Activity;
import android.os.Bundle;

import com.mogoweb.chrome.WebView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		WebView webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("/storage/emulated/0/VisuScreen/transition_fade.html");
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
		webView.getSettings().setJavaScriptEnabled(true);
	}

}
