package com.acc;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.countryinfo.schemas.Country;


@Component
public class CountryRepository {
   private static final List<Country> countries = new ArrayList<Country>();

   public CountryRepository(){
      initData();
   }
   public void initData() {
      Country us = new Country();
      us.setName("United States");
      us.setCapital("Washington");
   
      countries.add(us);
   
      Country india = new Country();
      india.setName("India");
      india.setCapital("New Delhi");

      countries.add(india);
    
      Country uk = new Country();
      uk.setName("United Kingdom");
      uk.setCapital("London");
   
      countries.add(uk);
   }
   
   @SuppressWarnings("deprecation")
public Country findCountry(String name) {
      Assert.notNull(name);
      Country result = null;

      for (Country country : countries) {
         if (name.trim().equals(country.getName())) {
            result = country;
         }
      }
      return result;
   }
}