package com.wedeko.visuscreen.player.proto.main.activities;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.wedeko.visuscreen.player.proto.main.PlayerApplication;

public class ProtoLocalContentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		WebView webView = new WebView(this);
		webView.setClickable(true);

		WebSettings wSettings = webView.getSettings();
		//wSettings.setJavaScriptEnabled(true);
		wSettings.setUseWideViewPort(true);
		wSettings.setLoadWithOverviewMode(true);

		WebClientClass webViewClient = new WebClientClass();
		webView.setWebViewClient(webViewClient);
		WebChromeClient webChromeClient = new WebChromeClient();
		webView.setWebChromeClient(webChromeClient);

		webView.loadUrl("file://" + PlayerApplication.getStorageDirectory() + "/index.html");
		setContentView(webView);
	}
}
