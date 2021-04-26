package by.javatr.tasks.valid;

import by.javatr.tasks.exception.IncorrectPositionException;
import by.javatr.tasks.exception.NullStringException;

public class CheckingValues {
    public static void checkNullString(String str) throws NullStringException {
        if(str == null)
            throw new NullStringException("String is null");
    }

    public static void checkValidPositiveNumber(int k) throws IncorrectPositionException {
        if(k <= 0)
            throw new IncorrectPositionException("This number should be positive");
    }
}
