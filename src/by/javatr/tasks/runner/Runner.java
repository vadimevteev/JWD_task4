package by.javatr.tasks.runner;

import by.javatr.tasks.creator.Creator;
import by.javatr.tasks.exception.IncorrectFileException;
import by.javatr.tasks.exception.IncorrectPositionException;
import by.javatr.tasks.exception.NullStringException;
import by.javatr.tasks.unit.CharTasks;
import by.javatr.tasks.unit.RegexTasks;
import by.javatr.tasks.unit.StringTasks;
import by.javatr.tasks.valid.CheckingValues;

import java.io.FileNotFoundException;

public class Runner {
    public static void main(String... args) throws FileNotFoundException, IncorrectFileException, NullStringException, IncorrectPositionException {
        String fileName = "C:\\Users\\Test\\IdeaProjects\\JWD_task4\\src\\Text.txt";
       String str = Creator.readTextFromFile(fileName);

       //String str = Creator.readTextFromConsole();

        System.out.println(StringTasks.changeLetter(str,2,'p'));
        System.out.println(StringTasks.changeLetterO(str));
        System.out.println(StringTasks.changeWords(str,3,"substring"));
        System.out.println(StringTasks.removeSymbols(str));
        System.out.println(StringTasks.removeWords(str,5));

        System.out.println(CharTasks.changeLetter(str,2,'a'));
        System.out.println(CharTasks.changeLetterO(str));
        System.out.println(CharTasks.changeWords(str,3,"substring"));
        System.out.println(CharTasks.removeSymbols(str));
        System.out.println(CharTasks.removeWords(str,5));

        System.out.println(RegexTasks.changeLetter(str,2,'g'));
        System.out.println(RegexTasks.changeLetterO(str));
        System.out.println(RegexTasks.changeWords(str,6,"s"));
        System.out.println(RegexTasks.removeSymbols(str));
        System.out.println(RegexTasks.removeWords(str,5));
    }

}
