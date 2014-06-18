package com.wedeko.visuscreen.player.proto.main.activities;

import android.os.Bundle;

import com.mogoweb.chrome.WebView;
import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.PlayerApplication;

public class ProtoLocalContentActivity extends Html5ViewActivity {
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("file://" + PlayerApplication.getStorageDirectory() + "/video.html");
	}
}
