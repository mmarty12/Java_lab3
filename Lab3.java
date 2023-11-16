import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Character.isDigit;

//my student's book #1317
public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder text = new StringBuilder("anaconda AnnA apricot");
        System.out.print(text);
        System.out.print("\nEnter a letter to sort by: ");
        char targetLetter = scan.next().charAt(0);
        if (isDigit(targetLetter)) {
            System.out.println("The input cannot be a number.");
            return;
        }

        boolean letterExist = false;
        for (int i = 0; i < text.length(); i++) {
            if (Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(targetLetter)) {
                letterExist = true;
                break;
            }
        }

        if (!letterExist) {
            System.out.println("The letter '" + targetLetter + "' does not exist in the text.");
            return;
        }

        StringBuilder curWord = new StringBuilder();
        List<StringBuilder> textList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (Character.isAlphabetic(character)) {
                curWord.append(character);
            } else {
                if (!curWord.isEmpty()) {
                    textList.add(curWord);
                    curWord = new StringBuilder();
                }
            }
        }

        if (!curWord.isEmpty()) {
            textList.add(curWord);
        }

        textList.sort((word1, word2) -> {
            int count1 = countOccurrences(word1, targetLetter);
            int count2 = countOccurrences(word2, targetLetter);
            return Integer.compare(count1, count2);
        });

        System.out.println("Sorted Words by Quantity of letter '" + targetLetter + "':");
        for (StringBuilder word : textList) {
            System.out.println(word);
        }

        scan.close();

    }

    private static int countOccurrences(StringBuilder sb, char targetLetter) {
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (Character.toLowerCase(sb.charAt(i)) == targetLetter) {
                count++;
            }
        }
        return count;
    }
}