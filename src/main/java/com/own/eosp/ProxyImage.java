package com.own.eosp;

public class ProxyImage implements Image {
	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		// Lazy Loading: যখন display() কল হবে, কেবল তখনই RealImage তৈরি হবে
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}
