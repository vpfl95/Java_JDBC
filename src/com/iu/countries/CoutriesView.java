package com.iu.countries;

import java.util.ArrayList;

public class CoutriesView {
	
	public void view(ArrayList<CountriesDTO> countries) {
		for(CountriesDTO country: countries) {
			System.out.println(country.getCountry_id()+" "
							+country.getCountry_name()+" "
							+country.getRegion_id());
			
		}
	}
	
	public void view(CountriesDTO country) {
		System.out.println(country.getCountry_id()+" "
				+country.getCountry_name()+" "
				+country.getRegion_id());

	}
}
