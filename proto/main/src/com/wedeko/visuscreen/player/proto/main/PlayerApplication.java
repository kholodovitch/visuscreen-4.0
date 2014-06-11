package com.wedeko.visuscreen.player.proto.main;

import java.io.File;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
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
		File baseFolder = canWriteOnExternalStorage() ? Environment.getExternalStorageDirectory() : new ContextWrapper(Context).getFilesDir();
		File contentFolder = new File(baseFolder + "/VisuScreen/");
		
		contentFolder.mkdirs();

		return contentFolder.getAbsolutePath();
	}
}
