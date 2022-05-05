package com.msisdn.msisdnservice.model;

public class MsisdnModel implements Comparable<MsisdnModel> {

	private long phoneNumber;
	private int count;

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int compareTo(MsisdnModel model) {
		if (phoneNumber == model.phoneNumber) {
			model.setCount(model.getCount() + 1);
		}
		return this.phoneNumber > model.phoneNumber ? 1 : (this.phoneNumber < model.phoneNumber ? -1 : 0);
	}
}