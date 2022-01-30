package com.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.beans.Country;
import com.beans.Currency;
import com.beans.ExchangeRate;

@Component
public class CountryUtility {

	private String countryApiUri = "https://restcountries.com/v3.1/name/";
	private String accessKey = "31678939fe50baa5250b2c5f";
	private String exchRateApiUri = "https://v6.exchangerate-api.com/v6/" + accessKey + "/pair/";
	private String toCurrencyCode = "IDR";

	private List<ExchangeRate> exchRateStorage = new ArrayList<>();

	public Country[] getCountryDetails(String name) {
		Country[] countries = null;

		if (name != null && name.length() > 0) {

			String requestUri = countryApiUri + name;
			RestTemplate restTemplate = new RestTemplate();
			countries = restTemplate.getForObject(requestUri, Country[].class);
		}
		return countries;

	}

	public void populateExchangeRate(Country[] countryList) {
		ExchangeRate exchRate = null;

		for (int i = 0; i < countryList.length; i++) {

			List<Currency> currencyList = countryList[i].getCurrencies();

			for (int j = 0; j < currencyList.size(); j++) {

				exchRate = getExchangeRate(currencyList.get(j).getCurrencyCode(), toCurrencyCode);

				if (exchRate != null) {
					currencyList.get(j).setRateToIDR(exchRate.getRate());

				}
			}

		}

	}

	public ExchangeRate getExchangeRate(String fromCurrency, String toCurrency) {
		ExchangeRate rate = null;
		if (fromCurrency != null && toCurrency != null) {
			
			RestTemplate restTemplate = new RestTemplate();
			String requestUri = exchRateApiUri + fromCurrency + "/" + toCurrency;
			String json = restTemplate.getForObject(requestUri, String.class);

			JsonParser springParser = JsonParserFactory.getJsonParser();
			Map<String, Object> map = springParser.parseMap(json);

			// if response is successful from external API then get rate from it.
			if ("success".equals(map.get("result"))) {
				rate = new ExchangeRate(fromCurrency, toCurrency,
						Double.valueOf(map.get("conversion_rate").toString()));

				// Store Exchange rates in a list queries so far.
				exchRateStorage.add(rate);

			}

		}
		return rate;

	}
}
