import java.util.Scanner;

public class Doc_so_thanh_chu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số từ 0 - 999: ");
        int number = sc.nextInt();
        String word = convertNumber(number);
        System.out.println("Cách đọc số là: " + word);
    }

    public static String convertNumber(int number) {
        if (number < 0 || number > 999) {
            return "Số phải nằm trong 0 - 999";
        } else if (number == 0) {
            return "zero";
        } else if (number < 10) {
            return convertNumbers10(number);
        } else if (number < 20) {
            return convertNumbers20(number);
        } else if (number < 100) {
            return convertNumbers100(number);
        } else {
            return convertHundreds(number);
        }
    }

    public static String convertNumbers10(int number) {
        switch (number) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "out of ability";
        }
    }

    public static String convertNumbers20(int number) {
        switch (number) {
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                return "out of ability";
        }
    }

    public static String convertNumbers100(int number) {
        int tens = number / 10;
        int ones = number % 10;
        String tensWord = "";

        switch (tens) {
            case 2:
                tensWord = "twenty";
                break;
            case 3:
                tensWord = "thirty";
                break;
            case 4:
                tensWord = "forty";
                break;
            case 5:
                tensWord = "fifty";
                break;
            case 6:
                tensWord = "sixty";
                break;
            case 7:
                tensWord = "seventy";
                break;
            case 8:
                tensWord = "eighty";
                break;
            case 9:
                tensWord = "ninety";
                break;
        }

        String onesWord = convertNumbers10(ones);
        if (ones > 0) {
            return tensWord + " " + onesWord;
        }
        return tensWord;
    }

    public static String convertHundreds(int number) {
        int hundreds = number / 100;
        int remainder = number % 100;
        String word = convertNumbers10(hundreds) + " hundred";
        if (remainder > 0) {
            word += " " + convertNumber(remainder);
        }
        return word;
    }
}