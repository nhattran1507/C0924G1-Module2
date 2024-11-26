package Bai_15;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "countries.csv";
        CountryService countryService = new CountryService();
        List<Country> countries = countryService.readCSV(filePath);
        countryService.displayCountries(countries);
    }
}
