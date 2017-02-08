package bootcamp;

        import java.util.Scanner;

/* Teron Briggs
 * 2/6/2017
 */
public class Main {

    public static void main(String[] args) {
        //
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Pig Latin Translator!");
        System.out.println();

        String answer = "";
        // this is the loop to keep translating if the user enters "yes"..
        do {
            System.out.print("Enter a word to translate: ");
            String word = scan.next().toLowerCase();

            // +++ Translate the word,
            String translated = translate(word);
            // then output it.
            System.out.println(translated);

            System.out.print("Do you want to continue? yes/no ");
            answer = scan.next();
            answer = answer.toLowerCase();

        } while (answer.equals("yes"));

        scan.close();
    }

    public static String translate(String word) {
        // find the first vowel
        int vowel = findVowel(word);

        // if it's an invalid word
        if (vowel == -1) {
            return "Invalid " + word;
            // if it's at pos. 0
            // use this ==>if (vowel == 0)
            // add -way to the end
        }else if (vowel == 0) {
            return word + "way";
            // Take the sub string from the vowel to the end..
            // add the substring from 0 until vowel pos. - 1
            // add "ay"
        }else {
            return word.substring(vowel, word.length()) + word.substring(0, vowel) + "ay";
        }
    }

    public static int findVowel(String word) {
        // for loop i from pos 0 to 4 ( or end of word)
        for (int i = 0; i < word.length(); i++) {

            // use charAt() to get the letter
            char letter = word.charAt(i);

            // if it's 'a' or 'e' or 'i' or 'o' or 'u'...
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                return i;

            }
            // return position (variable i)
            // If no vowel is found, return -1..
        }
        return -1;
    }
}


