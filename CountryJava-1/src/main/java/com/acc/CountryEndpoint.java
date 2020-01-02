package com.acc;


import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.countryinfo.schemas.Country;
import com.countryinfo.schemas.GetCountryRequest;
import com.countryinfo.schemas.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
	
	@PayloadRoot(namespace="http://www.countryinfo.com/schemas", localPart="getCountryRequest")
	@ResponsePayload
	public GetCountryResponse countryRequest(@RequestPayload GetCountryRequest countryRequest) throws Exception {
		
		String countryName = countryRequest.getName();
		System.out.println(countryName);
		CountryRepository cr = new CountryRepository();
		Country c = cr.findCountry(countryName);
		GetCountryResponse response = new GetCountryResponse();
		response.setCountryStatus(c.getName());
		response.setCapitalStatus(c.getCapital());
		return response;
	}
	
}
