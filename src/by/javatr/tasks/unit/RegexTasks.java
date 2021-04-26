package by.javatr.tasks.unit;

import by.javatr.tasks.exception.IncorrectPositionException;
import by.javatr.tasks.exception.NullStringException;
import by.javatr.tasks.valid.CheckingValues;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTasks {

    public static String changeLetter(String text, int position, char symbol) throws NullStringException, IncorrectPositionException {
        CheckingValues.checkNullString(text);
        CheckingValues.checkValidPositiveNumber(position);

        StringBuilder result = new StringBuilder(text);
        String regex = "\\w{" + position + ",}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

        while (matcher.find()){

            result.setCharAt(matcher.start() + position - 1,symbol);
        }
        return result.toString();
    }

    public static String changeLetterO(String text) throws NullStringException {
        CheckingValues.checkNullString(text);

        StringBuilder result = new StringBuilder(text);
        String regex = "pa|Pa|PA";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

        while (matcher.find()){

            result.setCharAt(matcher.start() + 1,'o');
        }
        return result.toString();
    }

    public static String changeWords(String text, int length, String substring) throws IncorrectPositionException, NullStringException {
        CheckingValues.checkNullString(text);
        CheckingValues.checkNullString(substring);
        CheckingValues.checkValidPositiveNumber(length);

        StringBuilder result = new StringBuilder(text);
        String regex = "\\b\\w{" + length + "}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

        //массив с изначальными индексами совпадений
        List<Integer> indexMatch = new ArrayList<>();
        while (matcher.find())
            indexMatch.add(matcher.start());

        //число, на которое сдвигаются все символы в строке после каждого ее изменения
        int difference = substring.length() - length;
        for(int i = 0;i < indexMatch.size();i++){

            int startPosition = indexMatch.get(i) + difference * i;
            result.replace(startPosition,startPosition + length,substring);
        }

        return result.toString();
    }

    public static String removeSymbols(String text) throws NullStringException {
        CheckingValues.checkNullString(text);

        StringBuilder result = new StringBuilder(text);
        String regex = "[^\\p{Alpha}\\s]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

        while (matcher.find()){

            result.setCharAt(matcher.start(),' ');
        }
        return result.toString();
    }

    public static String removeWords(String text, int length) throws NullStringException {
        CheckingValues.checkNullString(text);

        StringBuilder result = new StringBuilder(text);
        String regex = "\\b[b-df-hj-np-tv-z]\\w{" + (length - 1) + "}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

        List<Integer> indexMatch = new ArrayList<>();
        while (matcher.find())
            indexMatch.add(matcher.start());

        for(int i = 0;i < indexMatch.size();i++){

            int startPosition = indexMatch.get(i) - length * i;
            result.replace(startPosition,startPosition + length,"");
        }

        return result.toString();
    }
}
