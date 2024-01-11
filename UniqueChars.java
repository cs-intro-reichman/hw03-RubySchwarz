public class UniqueChars {
    public static void main(String[] args) {
        // Join all command-line arguments into a single string, separated by spaces
        String str = String.join(" ", args);
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    // Processes the input string and returns a new string with all duplicates
    // removed, except for space characters.
    public static String uniqueChars(String str) {

        // Initialize an empty string to store unique characters
        String unique = "";
        boolean duplicate;
        char temp;
        int index;

        // Iterate through each character of the string
        for (int i = 0; i < str.length(); i++) {
            duplicate = false;

            // Check if the current character is not a space
            if (str.charAt(i) != ' ') {
                index = str.indexOf(str.charAt(i));
                temp = str.charAt(index); // Store the character at the found index

                // Check if the current character is a duplicate
                if ((str.charAt(i) == temp) && (i != index))
                    duplicate = true;
            }

            // Add the character to the unique string if it's not a duplicate
            if (!duplicate)
                unique += str.charAt(i);
        }

        // Return the string with unique characters
        return unique;
    }
}
