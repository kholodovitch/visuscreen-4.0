package com.wedeko.visuscreen.player.proto.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

public class DownloadHelper {

	public static String downloadVideo(String url, String path, IProgressable downloadProgress) {
		InputStream input = null;
		OutputStream output = null;
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.connect();

			// expect HTTP 200 OK, so we don't mistakenly save error report
			// instead of the file
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				return MessageFormat.format("Server returned HTTP ({0}): {1}", connection.getResponseCode(), connection.getResponseMessage());
			}

			// this will be useful to display download percentage
			// might be -1: server did not report the length
			int fileLength = connection.getContentLength();

			// download the file
			input = connection.getInputStream();
			output = new FileOutputStream(path);

			byte data[] = new byte[4096];
			long total = 0;
			int count;
			while ((count = input.read(data)) != -1) {
				// allow canceling with back button
				/*
				if (isCancelled()) {
					input.close();
					return null;
				}
				*/
				total += count;
				// publishing the progress....
				if (fileLength > 0) // only if total length is known
					downloadProgress.progress(total * 100.0 / fileLength);
				output.write(data, 0, count);
			}
		} catch (Exception e) {
			return e.toString();
		} finally {
			try {
				if (output != null)
					output.close();
				if (input != null)
					input.close();
			} catch (IOException ignored) {
			}

			if (connection != null)
				connection.disconnect();
		}
		return null;
	}
}
