package com.wedeko.visuscreen.player.proto.main.activities;

import android.os.Bundle;

import com.wedeko.visuscreen.player.proto.R;
import com.wedeko.visuscreen.player.proto.main.PlayerApplication;
import com.wedeko.visuscreen.player.proto.main.controls.VideoEnabledWebView;

public class ProtoLocalContentActivity extends Html5ViewActivity {
	private VideoEnabledWebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		webView = (VideoEnabledWebView) findViewById(R.id.webView);
		webView.loadUrl("file://" + PlayerApplication.getStorageDirectory() + "/video.html");
	}
}
