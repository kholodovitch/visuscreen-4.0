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
		webView.loadUrl("http://home.kholodovitch.com/test/html5-transitions/transition_horizontalWipe.html");
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
		webView.getSettings().setJavaScriptEnabled(true);
	}

}
