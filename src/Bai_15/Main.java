package Bai_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/countries.csv";
        List<List<String>> countries = readCsvFile(filePath);
        if (countries != null) {
            for (List<String> country : countries) {
                printCountry(country);
            }
        }
    }

    public static List<List<String>> readCsvFile(String filePath) {
        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(parseCsvLine(line));
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc tệp: " + e.getMessage());
            return null;
        }

        return records;
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (String data : splitData) {
                result.add(data.trim());
            }
        }
        return result;
    }

    private static void printCountry(List<String> country) {
        if (country.size() < 3) {
            System.out.println("Dòng không hợp lệ: " + country);
            return;
        }

        System.out.println(
                "Country [id= "
                        + country.get(0)
                        + ", code= " + country.get(1)
                        + " , name=" + country.get(2)
                        + "]"
        );
    }
}
