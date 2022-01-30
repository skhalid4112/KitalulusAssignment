package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Country;
import com.beans.ExchangeRate;
import com.utilities.CountryUtility;

@RestController
public class LookUpController {

	@Autowired
	private CountryUtility dataAccessUtility;

	@GetMapping("/countryDetails")
	public Country[] getCountryDetails(@RequestParam String name) {

		// get countries data from External API
		Country[] countryList = dataAccessUtility.getCountryDetails(name);

		// populate exchange rate for official currencies of country
		dataAccessUtility.populateExchangeRate(countryList);

		return countryList;
	}

	@GetMapping("/exchangeRate")
	public ExchangeRate getCountryDetails(@RequestParam String fromCurrency, @RequestParam String toCurrency) {

		return dataAccessUtility.getExchangeRate(fromCurrency, toCurrency);
	}
	
}
