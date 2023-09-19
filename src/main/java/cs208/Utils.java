package cs208;

/**
 * Utility class containing static methods that are used in multiple places
 */
public class Utils
{
    /**
     * Repeats the given character the specified number of times and returns the resulting string
     *
     * @param character such as '-', '*', '=', etc.
     * @param numberOfRepeats the number of times to repeat the character
     * @return a string containing the character repeated the specified number of times
     *         (e.g., returns "----" if character is '-' and numberOfRepeats is 4)
     */
    public static String characterRepeat(Character character, int numberOfRepeats)
    {
        String buffer = "";
        for (int i = 0; i < numberOfRepeats; i++)
        {
            buffer += character;
        }
        return buffer;
    }

    /**
     * Returns the given word in its plural form if the given number of times is not 1
     *
     * @param wordInSingularForm such as "class", "student", etc.
     * @param numberOfTimes such as 0, 1, 2, etc.
     * @return the given word in its plural form if the given number of times is not 1
     *         (e.g., returns "classes" if wordInSingularForm is "class" and numberOfTimes is 0, 2 or more)
     *         (e.g., returns "class" if wordInSingularForm is "class" and numberOfTimes is 1)
     */
    public static String pluralize(String wordInSingularForm, int numberOfTimes)
    {
        if (numberOfTimes == 1)
        {
            return numberOfTimes + " " + wordInSingularForm;
        }

        // hardcoded values for exceptions
        switch (wordInSingularForm)
        {
            // add exceptions here
            case "class":
                return numberOfTimes + " " + wordInSingularForm + "es";

            default:
                return numberOfTimes + " " + wordInSingularForm + "s";
        }
    }
}
