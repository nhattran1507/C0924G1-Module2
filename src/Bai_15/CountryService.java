package Bai_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryService {

    public List<Country> readCSV(String filePath) {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String code = fields[1].replace("\"", "");
                String name = fields[2].replace("\"", "");
                countries.add(new Country(id, code, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
    public void displayCountries(List<Country> countries) {
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
