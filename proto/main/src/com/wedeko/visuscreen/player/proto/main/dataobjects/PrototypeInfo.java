package com.wedeko.visuscreen.player.proto.main.dataobjects;

import com.wedeko.visuscreen.player.proto.main.PlayerApplication;

public class PrototypeInfo {
	private String name;
	private String description;
	private int imageId = -1;
	private Class<?> nextActivityClass;

	public PrototypeInfo(int nameId, int descriptionId, int imageId, Class<?> nextActivityClass) {
		setName(PlayerApplication.Context.getResources().getString(nameId));
		setDescription(PlayerApplication.Context.getResources().getString(descriptionId));
		setImageId(imageId);
		setNextActivityClass(nextActivityClass);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public Class<?> getNextActivityClass() {
		return nextActivityClass;
	}

	public void setNextActivityClass(Class<?> nextActivityClass) {
		this.nextActivityClass = nextActivityClass;
	}
}
