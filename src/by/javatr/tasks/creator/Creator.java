package by.javatr.tasks.creator;


import by.javatr.tasks.exception.IncorrectFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Creator {

    public static String readTextFromFile(String fileName) throws FileNotFoundException, IncorrectFileException {
        if(fileName == null || fileName.isEmpty())
            throw new IncorrectFileException("File is empty or null");

        Scanner scanner = new Scanner(new File(fileName));
        StringBuilder text = new StringBuilder();

        while (scanner.hasNext())
            text.append(scanner.nextLine()).append("\n");

        return text.toString();
    }

    public static String readTextFromConsole() {

        Scanner scanner = new Scanner(System.in);

        String text = "";
        text = scanner.nextLine();

        return text;
    }
}
