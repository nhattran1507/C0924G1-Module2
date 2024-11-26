package Bai_15;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Cung cấp tệp nguồn và tệp đích dưới dạng tham số lệnh.");
            return;
        }
        String sourcePath = args[0];
        String targetPath = args[1];
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại: " + sourcePath);
            return;
        }
        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại: " + targetPath);
            return;
        }
        int copiedCharacters = copyFile(sourceFile, targetFile);
        if (copiedCharacters >= 0) {
            System.out.println("Sao chép thành công! Số ký tự đã sao chép: " + copiedCharacters);
        } else {
            System.out.println("Sao chép thất bại.");
        }
    }

    private static int copyFile(File sourceFile, File targetFile) {
        int count = 0;
        try (FileReader reader = new FileReader(sourceFile); FileWriter writer = new FileWriter(targetFile)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
                count++;
            }

        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép tệp: " + e.getMessage());
            return -1;
        }
        return count;
    }
}

