import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {

    @Test
    public void testInfixToPostfixConversion() {
        // Input and expected output for the test cases
        String[][] testCases = {
                {"5+3", "53+"},
                {"2*(4-1)", "241-*"},
                {"3+4*2/(1-5)^2", "342*15-2^/+"},
                {"(7+3)*2", "73+2*"}
        };

        for (String[] testCase : testCases) {
            String input = testCase[0];
            String expectedOutput = testCase[1];

            // Redirect System.out to capture output
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Call your main method with the input
            ByteArrayInputStream inputStream = new ByteArrayInputStream((input + "\nexit\n").getBytes());
            System.setIn(inputStream);
            Main.main(null);

            // Get the captured output
            String actualOutput = outputStream.toString().trim();

            // Assert the output
            assertEquals(expectedOutput, actualOutput);
        }
    }

    @Test
    public void testBrackets() {
        // Input and expected output for the test cases
        String[][] testCases = {
                {"(5+3", "not found )"},
                {"5+3)", "not found ("},
                {"{5+3", "not found }"},
                {"5+3}", "not found {"},
                {"[5+3", "not found ]"},
                {"5+3]", "not found ["}
        };

        for (String[] testCase : testCases) {
            String input = testCase[0];
            String expectedOutput = testCase[1];

            // Redirect System.out to capture output
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Call your main method with the input
            ByteArrayInputStream inputStream = new ByteArrayInputStream((input + "\nexit\n").getBytes());
            System.setIn(inputStream);
            Main.main(null);

            // Get the captured output
            String actualOutput = outputStream.toString().trim();

            // Assert the output
            assertEquals(expectedOutput, actualOutput);
        }
    }
}