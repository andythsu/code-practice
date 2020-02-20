/**
 * @Author asu
 * @Date 2/19/2020
 * @Description Format number to word. Number is expected to be from 0 - 999
 **/
public class NumberToWord {
    private String[] singleDigit = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] doubleDigit = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
//    String[] multiTen = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public String convert(int number) {
        StringBuilder sb = new StringBuilder();

        // get middle digit first
        int middleDigit = (number / 10) % 10;

        if (middleDigit == 1) {
            // get first digit
            int firstDigit = (number % 10);
            sb.append(doubleDigit[(middleDigit * 10 + firstDigit) - 10]);
            int lastDigit = (number / 100);
            if (lastDigit != 0) {
                sb.insert(0, singleDigit[lastDigit] + " ");
            }
        } else {

        }

        return sb.toString();
    }
}
