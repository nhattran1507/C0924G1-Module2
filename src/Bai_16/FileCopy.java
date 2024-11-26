package Bai_16;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sourcePath = getInputPath(sc, "Enter the source file path: ");
        if (!checkFileExists(sourcePath)) {
            System.out.println("Source file does not exist.");
            return;
        }
        String targetPath = getInputPath(sc, "Enter the target file path: ");
        if (checkFileExists(targetPath)) {
            if (!confirmOverwrite(sc)) {
                System.out.println("Operation canceled.");
                return;
            }
        }
        try {
            long copiedBytes = copyFile(sourcePath, targetPath);
            System.out.println("Copied " + copiedBytes + " bytes");
        } catch (IOException e) {
            System.err.println("error while copying file" + e.getMessage());
        }
    }
    private static String getInputPath(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
    private static boolean checkFileExists(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }
    private static boolean confirmOverwrite(Scanner sc) {
        System.out.println("Confirm overwrite?");
        String choice = sc.nextLine();
        return choice.equalsIgnoreCase("y");
    }
    private static long copyFile(String sourcePath, String targetPath) throws IOException {
        File source = new File(sourcePath);
        File target = new File(targetPath);
        long totalByte = 0;
        try (
            InputStream inputStream = new FileInputStream(source);
            OutputStream outputStream = new FileOutputStream(target)){
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    totalByte += bytesRead;
                }
            }
        return totalByte;
        }
    }

