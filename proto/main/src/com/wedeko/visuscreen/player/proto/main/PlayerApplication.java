package com.wedeko.visuscreen.player.proto.main;

import java.io.File;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class PlayerApplication extends Application {
	public static Context Context;

	@Override
	public void onCreate() {
		super.onCreate();

		Context = getApplicationContext();

		AssetsHelper.copyFilesToSdCard();
	}

	public static boolean canWriteOnExternalStorage() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			Log.v("PlayerApplication", "Yes, can write to external storage.");
			return true;
		}

		return false;
	}

	public static String getStorageDirectory() {
		String contentFolderStr = canWriteOnExternalStorage() ? (Context.getExternalFilesDir(null).getAbsolutePath()) : (Context.getApplicationInfo().dataDir + "/storage/");
		File contentFolder = new File(contentFolderStr);

		contentFolder.mkdirs();

		return contentFolder.getAbsolutePath();
	}
}
