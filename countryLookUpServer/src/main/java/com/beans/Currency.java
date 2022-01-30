package com.beans;

public class Currency {

	private String currencyCode;
	private String name;
	private String symbol;
	private Double rateToIDR;

	public Currency(String code, String name, String symbol) {
		currencyCode = code;
		this.name = name;
		this.symbol = symbol;
	}

	public Double getRateToIDR() {
		return rateToIDR;
	}

	public void setRateToIDR(Double rateToIDR) {
		this.rateToIDR = rateToIDR;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
