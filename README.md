# KitalulusAssignment

Summary Points:

Following are summary points and suggestions which can be implemented if we have more time to work on it.

1-v6.exchangerate-api is used to get exchange rate instead of recommended fixer.io due to restrictions on free account subscription plan. 

2-OAuth2 with google account is used in this project. Custom get token logic can be implemented by exposing a getToken endpoint which will return token in response after validating username and password sent in request. User will then send requests using that token. 

3-Frequently accessed Country and Currency data can be cached to serve requests without inquiring from external API. Timestamp can be added with object after which it becomes outdated. Latest data will be fetched from external API if data is outdated or not found in application cache.  

4-For storing exchange rates queried so far, a list is used for now but this can be replaced by database. 

5-Constant strings used in this project should be fetched from database to avoid changing code if access key or url is changed. 

Demo:

1-Get Country Details

API request:
http://localhost:8080/countryDetails?name=pakistan

API response:
[{"name":"Islamic Republic of Pakistan","population":220892331,"currencies":[{"currencyCode":"PKR","name":"Pakistani rupee","symbol":"₨","rateToIDR":76.7035}]}]

1-Get Exchange Rate

API request:
http://localhost:8080/exchangeRate?fromCurrency=USD&toCurrency=PKR

API response:
{"fromCurrency":"USD","toCurrency":"PKR","rate":177.5246}

