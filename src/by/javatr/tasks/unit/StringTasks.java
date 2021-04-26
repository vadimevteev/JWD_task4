package by.javatr.tasks.unit;

import by.javatr.tasks.exception.IncorrectPositionException;
import by.javatr.tasks.exception.NullStringException;
import by.javatr.tasks.valid.CheckingValues;

public class StringTasks {


    public static String changeLetter(String text, int position, char symbol) throws NullStringException, IncorrectPositionException {
        CheckingValues.checkNullString(text);
        CheckingValues.checkValidPositiveNumber(position);

        int firstLetter = 0;

        for (int lastLetter = 0; lastLetter < text.length(); lastLetter++){

            //если находим знак препинания либо пробел, (lastLetter - 1) будет последний символ этого "слова"
            if(PunctuationMarks.isPunctuationMark(text.charAt(lastLetter))){
                int wordLength = lastLetter - firstLetter;

                if (wordLength >= position) {
                    text = text.substring(0,firstLetter + position - 1) + symbol + text.substring(firstLetter + position);
                }

                //следующий символ после знака препинания будет первым символом следующего "слова"
                firstLetter = lastLetter + 1;
            }
        }

        return text;
    }

    public static String changeLetterO(String text) throws NullStringException {
        CheckingValues.checkNullString(text);

        text = text.replaceAll("pa","po")
                .replaceAll("PA","PO")
                .replaceAll("Pa","Po");

        return text;
    }

    public static String changeWords(String text, int length, String substring) throws IncorrectPositionException, NullStringException {
        CheckingValues.checkNullString(text);
        CheckingValues.checkNullString(substring);
        CheckingValues.checkValidPositiveNumber(length);


        int firstLetter = 0;

        for (int lastLetter = 0; lastLetter < text.length(); lastLetter++){

            //если находим знак препинания либо пробел, (lastLetter - 1) будет последний символ этого "слова"
            if(PunctuationMarks.isPunctuationMark(text.charAt(lastLetter))){

                int wordLength = lastLetter - firstLetter;
                //если совпадает, добавляем нужную строку
                if (wordLength == length)
                    text = text.substring(0,firstLetter) + substring + text.substring(lastLetter);

                //следующий символ после знака препинания будет первым символом следующего "слова"
                firstLetter = lastLetter + 1;
            }
        }
        return text;
    }

    public static String removeSymbols(String text) throws NullStringException {
        CheckingValues.checkNullString(text);

        for(int i = 0; i < text.length(); i++){
            char symbol = text.charAt(i);
            if(symbol < PunctuationMarks.FIRST_CAPITAL_ENG
                    || symbol > PunctuationMarks.LAST_CAPITAL_ENG && symbol < PunctuationMarks.FIRST_LOWERCASE_ENG
                    || symbol > PunctuationMarks.LAST_LOWERCASE_ENG )
                text = text.replace(text.charAt(i),' ');
        }
        return text;
    }


    public static String removeWords(String text, int length) throws NullStringException {
        CheckingValues.checkNullString(text);

        int firstLetter = 0;

        for (int lastLetter = 0; lastLetter < text.length(); lastLetter++){

            //если находим знак препинания либо пробел, (lastLetter - 1) будет последний символ этого "слова"
            if(PunctuationMarks.isPunctuationMark(text.charAt(lastLetter))){

                int wordLength = lastLetter - firstLetter;

                //если выполнено условие, удаляем слово
                if (wordLength == length && PunctuationMarks.isLetterConsonant(text.charAt(firstLetter)))
                    text = text.substring(0,firstLetter) + text.substring(lastLetter);

                //следующий символ после знака препинания будет первым символом следующего "слова"
                firstLetter = lastLetter + 1;
            }
        }

        return text;
    }

}
