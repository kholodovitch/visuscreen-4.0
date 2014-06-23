package com.wedeko.visuscreen.player.proto.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.res.AssetManager;
import android.util.Log;

public class AssetsHelper {

	final static String TARGET_BASE_PATH;
	private static AssetManager AssetManager;

	static {
		TARGET_BASE_PATH = PlayerApplication.getStorageDirectory();
		AssetManager = PlayerApplication.Context.getAssets();
	}

	public static void copyFilesToSdCard(IProgressable progressable) {
		copyFileOrDir("", new ArrayList<String>(), true, progressable); // copy all files in assets folder in my project
	}

	private static void copyFileOrDir(String path, ArrayList<String> files, boolean needCopy, IProgressable progressable) {
		String assets[] = null;

		if (needCopy && progressable != null) {
			progressable.progress(0.1);
		}

		try {
			Log.i("tag", "copyFileOrDir() " + path);
			if (!needCopy && (path.endsWith(".html") || path.endsWith(".jpg") || path.endsWith(".png"))) {
				files.add(path);
				return;
			}

			assets = AssetManager.list(path);
			if (assets.length == 0) {
				files.add(path);
			} else {
				String fullPath = TARGET_BASE_PATH + "/" + path;
				Log.i("tag", "path=" + fullPath);
				File dir = new File(fullPath);
				if (!dir.exists() && !path.startsWith("images") && !path.startsWith("sounds") && !path.startsWith("webkit"))
					if (!dir.mkdirs())
						Log.i("tag", "could not create dir " + fullPath);
				for (int i = 0; i < assets.length; ++i) {
					String p;
					if (path.equals(""))
						p = "";
					else
						p = path + "/";

					if (!path.startsWith("images") && !path.startsWith("sounds") && !path.startsWith("webkit"))
						copyFileOrDir(p + assets[i], files, false, null);
				}
			}
			
			if (needCopy) {
				for (int i = 0; i < files.size(); i++) {
					copyFile(files.get(i));

					if (progressable != null) {
						double copyProgress = (i + 1) / (double) files.size();
						progressable.progress(0.1 + copyProgress * 0.9);
					}
				}
			}
		} catch (IOException ex) {
			Log.e("tag", "I/O Exception", ex);
		}
	}

	private static void copyFile(String filename) throws IOException {
		String newFileName = TARGET_BASE_PATH + "/" + filename;
		AssetManager assetManager = PlayerApplication.Context.getAssets();

		InputStream in = null;
		OutputStream out = null;
		try {
			Log.i("tag", "copyFile() " + filename);
			in = assetManager.open(filename);
			out = new FileOutputStream(newFileName);

			byte[] buffer = new byte[1024];
			int read;
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
			in.close();
			in = null;
			out.flush();
			out.close();
			out = null;
		} catch (Exception e) {
			Log.e("tag", "Exception in copyFile() of " + newFileName);
			Log.e("tag", "Exception in copyFile() " + e.toString());
		}
	}
}
