public class LowerCase {
    public static void main(String[] args) {
        // Concatenate all command-line arguments into one string, separated by spaces
        StringBuilder inputBuilder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            inputBuilder.append(args[i]);
            if (i < args.length - 1) {
                inputBuilder.append(" ");
            }
        }

        String input = inputBuilder.toString();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Check if the character is an uppercase letter
            if (c >= 'A' && c <= 'Z') {
                // Convert to lowercase
                result.append((char) (c + ('a' - 'A')));
            } else {
                // If not an uppercase letter, add the character as is
                result.append(c);
            }
        }

        // Print the resulting string
        System.out.println(result.toString());
    }
}
