package com.himtech.datasource;

public class Withholding {
	
	private String month;
	private String amountFor;
	private String exchangeRate;
	private String amountVND;
	
	public Withholding(String month, String amountFor, String exchangeRate, String amountVND){
		this.month = month;
		this.amountFor = amountFor;
		this.exchangeRate = exchangeRate;
		this.amountVND = amountVND;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getAmountFor() {
		return amountFor;
	}
	public void setAmountFor(String amountFor) {
		this.amountFor = amountFor;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getAmountVND() {
		return amountVND;
	}
	public void setAmountVND(String amountVND) {
		this.amountVND = amountVND;
	}

}
