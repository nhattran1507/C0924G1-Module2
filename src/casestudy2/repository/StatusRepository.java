package casestudy2.repository;

import casestudy2.entity.Status;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class StatusRepository {
    private static final String FILE_PATH = "src/casestudy2/data/status.csv";

    public Map<String, Status> getAll() {
        File file = new File(FILE_PATH);
        Map<String, Status> map = new HashMap<>();
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + FILE_PATH);
            return map;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ()
        }
    }
}
