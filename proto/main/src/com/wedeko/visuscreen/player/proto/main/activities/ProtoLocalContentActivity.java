package com.wedeko.visuscreen.player.proto.main.activities;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ProtoLocalContentActivity extends Activity {

	private WebSettings wSettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		WebView webView = new WebView(this);
		webView.setClickable(true);
		wSettings = webView.getSettings();
		wSettings.setJavaScriptEnabled(true);
		wSettings.setUseWideViewPort(true);
		wSettings.setLoadWithOverviewMode(true);

		/**
		 * <b> Support Classes For WebView </b>
		 */
		WebClientClass webViewClient = new WebClientClass();
		webView.setWebViewClient(webViewClient);
		WebChromeClient webChromeClient = new WebChromeClient();
		webView.setWebChromeClient(webChromeClient);

		/**
		 * Load Our Custom JS Inside WebView
		 */
		File rootsd = Environment.getExternalStorageDirectory();
		File html = new File(rootsd.getAbsolutePath() + "/VisuScreen/index.html");
		webView.loadUrl("file://" + html.getAbsolutePath());
		setContentView(webView);
	}
}
