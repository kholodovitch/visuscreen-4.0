package com.wedeko.visuscreen.player.proto.main.dataobjects;

import com.wedeko.visuscreen.player.proto.main.PlayerApplication;

public class TransitionInfo {
	private String name;
	private int imageId;
	private String targetHtml;
	
	public TransitionInfo(int nameId, int imageId, String targetHtml)
	{
		setName(PlayerApplication.Context.getResources().getString(nameId));
		setImageId(imageId);
		setTargetHtml(targetHtml);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getImageId() {
		return imageId;
	}

	private void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getTargetHtml() {
		return targetHtml;
	}

	private void setTargetHtml(String targetHtml) {
		this.targetHtml = targetHtml;
	}
}