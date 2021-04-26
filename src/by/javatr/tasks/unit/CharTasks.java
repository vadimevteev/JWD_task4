package by.javatr.tasks.unit;

import by.javatr.tasks.exception.IncorrectPositionException;
import by.javatr.tasks.exception.NullStringException;
import by.javatr.tasks.valid.CheckingValues;

public class CharTasks {


    public static String changeLetter(String text, int position, char symbol) throws NullStringException, IncorrectPositionException {
        CheckingValues.checkNullString(text);
        CheckingValues.checkValidPositiveNumber(position);

        char[] textArray = text.toCharArray();
        //первый символ каждого "слова"
        int firstLetter = 0;

        for (int lastLetter = 0; lastLetter < textArray.length; lastLetter++){

                //если находим знак препинания либо пробел, (lastLetter - 1) будет последний символ этого "слова"
                if(PunctuationMarks.isPunctuationMark(textArray[lastLetter])){
                    int wordLength = lastLetter - firstLetter;

                    if (wordLength >= position) {
                        textArray[firstLetter + position - 1] = symbol;
                    }

                    //следующий символ после знака препинания будет первым символом следующего "слова"
                    firstLetter = lastLetter + 1;
                }
        }

        return new String(textArray);
    }

    public static String changeLetterO(String text) throws NullStringException {
        CheckingValues.checkNullString(text);
        char[] textArray = text.toCharArray();

        for (int i = 0; i < textArray.length - 1; i++) {
            if (textArray[i] == 'P' && textArray[i + 1] == 'A') {
                textArray[i + 1] = 'O';
            }

            if (textArray[i] == 'p' && textArray[i + 1] == 'a') {
                textArray[i + 1] = 'o';
            }

            if (textArray[i] == 'P' && textArray[i + 1] == 'a') {
                textArray[i + 1] = 'o';
            }
        }

        return new String(textArray);

    }

    public static String changeWords(String text, int length, String substring) throws IncorrectPositionException, NullStringException {
        CheckingValues.checkNullString(text);
        CheckingValues.checkNullString(substring);
        CheckingValues.checkValidPositiveNumber(length);

        char[] textArray = text.toCharArray();
        char[] substringArray = substring.toCharArray();
        int startSize = 0;
        char[] redactedArray = new char[startSize];
        //первый символ каждого "слова"
        int firstLetter = 0;

        for (int lastLetter = 0; lastLetter < textArray.length; lastLetter++){

            //если находим знак препинания либо пробел, (lastLetter - 1) будет последний символ этого "слова"
            if(PunctuationMarks.isPunctuationMark(textArray[lastLetter])){

                int wordLength = lastLetter - firstLetter;
                //если длина слова не совпадает с нужной, просто добавляем в массив слово с последующим знаком препинания
                if (wordLength != length)
                    redactedArray = addWordArray(textArray, firstLetter, lastLetter + 1, redactedArray);

                //если совпадает, добавляем нужную строку, а за ней знак препинания, стоящий за нужным словом
                else {
                    redactedArray = addWordArray(substringArray, 0, substring.length(), redactedArray);
                    redactedArray = addWordArray(textArray, lastLetter, lastLetter + 1, redactedArray);
                }

                //следующий символ после знака препинания будет первым символом следующего "слова"
                firstLetter = lastLetter + 1;
            }
        }

        return new String(redactedArray);
    }

    public static String removeSymbols(String text) throws NullStringException {
        CheckingValues.checkNullString(text);
        char[] textArray = text.toCharArray();
        int startSize = 0;
        char[] redactedArray = new char[startSize];

        for (char c : textArray) {
            if (c >= PunctuationMarks.FIRST_CAPITAL_ENG && c <= PunctuationMarks.LAST_CAPITAL_ENG
                    || c >= PunctuationMarks.FIRST_LOWERCASE_ENG && c <= PunctuationMarks.LAST_LOWERCASE_ENG
                    || c == ' ')
                redactedArray = addToMas(redactedArray, c);
        }

        return new String(redactedArray);

    }

    public static String removeWords(String text, int length) throws NullStringException {
        CheckingValues.checkNullString(text);

        char[] textArray = text.toCharArray();
        int startSize = 0;
        char[] redactedArray = new char[startSize];
        //первый символ каждого "слова"
        int firstLetter = 0;

        for (int lastLetter = 0; lastLetter < textArray.length; lastLetter++){

            //если находим знак препинания либо пробел, (lastLetter - 1) будет последний символ этого "слова"
            if(PunctuationMarks.isPunctuationMark(textArray[lastLetter])){

                int wordLength = lastLetter - firstLetter;

                //если выполнено условие, добавляется только знак препинания и пробел, следующий за словом
                if (wordLength == length && PunctuationMarks.isLetterConsonant(textArray[firstLetter]))
                    redactedArray = addWordArray(textArray, lastLetter, lastLetter + 1, redactedArray);

                    //в ином случае добавляем слово в месте со знаком препинания, идущим после
                else {
                    redactedArray = addWordArray(textArray, firstLetter, lastLetter + 1, redactedArray);

                }

                //следующий символ после знака препинания будет первым символом следующего "слова"
                firstLetter = lastLetter + 1;
            }
        }

        return new String(redactedArray);
    }

    private static char[] addWordArray(char[] startArray,int startIndex, int endIndex, char[] newArray){

        for(int i = startIndex;i < endIndex;i++){
            newArray = addToMas(newArray,startArray[i]);
        }
        return newArray;
    }

    private static char[] addToMas(char[] mas, char element){
        char[] newMas = new char[mas.length + 1];
        System.arraycopy(mas, 0, newMas, 0, mas.length);
        newMas[mas.length] = element;
        return newMas;
    }


}

