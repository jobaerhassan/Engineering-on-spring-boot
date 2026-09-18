package com.own.eosp;

public class RealImage implements Image {
	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(); // অবজেক্ট তৈরির সময়ই ভারী কাজ হচ্ছে
	}

	private void loadFromDisk() {
		System.out.println("ডিস্ক থেকে লোড হচ্ছে: " + fileName);
	}

	@Override
	public void display() {
		System.out.println("ডিসপ্লে করা হচ্ছে: " + fileName);
	}
}

