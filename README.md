# KitalulusAssignment

Summary Points: 

1-v6.exchangerate-api is used to get exchange rate instead of recommended fixer.io due to restrictions on free account subscription plan. 

2-OAuth2 with google account is used in this project. Custom get token logic can implemented by exposing a getToken endpoint which will return token in response after validating username and password sent in request. User will then send new requests using that token. 

3-Country and currency data can be cached to serve requests without inquiring from external API. Timestamp can be added with object after which it becomes outdated. Latest data will be fetched from external API if data is outdated or not found in application cache.  

4-For storing exchange rates queried so far, a list is used for now but this can be replaced by database. 

5-Constant strings used in this project should be fetched from database to avoid changing code if access key or url is changed. 
