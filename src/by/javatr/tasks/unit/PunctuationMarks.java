package by.javatr.tasks.unit;

import by.javatr.tasks.exception.NullStringException;
import by.javatr.tasks.valid.CheckingValues;

public class PunctuationMarks {
    public final static char FIRST_CAPITAL_ENG = 'A';
    public final static char LAST_CAPITAL_ENG = 'Z';
    public final static char FIRST_LOWERCASE_ENG = 'a';
    public final static char LAST_LOWERCASE_ENG = 'z';
    public static final Character[] PUNCTUATION_CHARS = {'.', ',', ':', ';', '!', '?', '-', ' ', '\n', '\"', ')', '(', '«', '»'};
    public static final char[] CONSONANT_LETTERS = {'B', 'C', 'D', 'F', 'G', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'S', 'T', 'V', 'X', 'Z',
            'H', 'R', 'W', 'Y', 'b', 'c', 'd', 'f', 'g', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 's', 't', 'v', 'x', 'z',
            'h', 'r', 'w', 'y' };

    public static boolean isPunctuationMark(char symbol){
        for (Character punctuationChar : PUNCTUATION_CHARS) {
            if (symbol == punctuationChar)
                return true;
        }
        return false;
    }

    public static boolean isLetterConsonant(char letter) {

        for (char consonantLetter : PunctuationMarks.CONSONANT_LETTERS)
            if (letter == consonantLetter)
                return true;

        return false;
    }

}
