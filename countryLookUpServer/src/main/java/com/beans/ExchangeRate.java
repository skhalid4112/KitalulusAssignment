package com.beans;

public class ExchangeRate {
	private String fromCurrency;
	private String toCurrency;
	private Double rate;
	
	public ExchangeRate(String fromCurrency, String toCurrency, Double rate){
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.setRate(rate);
	}
	
	public String getFromCurrency() {
		return fromCurrency;
		
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

}
