package com.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

	//name
	private String name;
	private int population;
	private List<Currency> currencies = new ArrayList<>();

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

	@JsonProperty("name")
	private void unpackNestedNameObject(Map<String, Object> object) {
		this.name = (String) object.get("official");
	}

	@JsonProperty("currencies")
	private void unpackNestedCurrencyObject(Map<String, Map<String, String>> object) {

		// Iterate currencies object from JSON and populate data from it
		for (Map.Entry<String, Map<String, String>> entry : object.entrySet()) {
			String currCode = entry.getKey();
			Map<String, String> currencyMap = entry.getValue();

			this.currencies.add(new Currency(currCode, currencyMap.get("name"), currencyMap.get("symbol")));
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}
