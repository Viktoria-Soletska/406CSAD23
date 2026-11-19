package ua.lpnu.apks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void buildGreetingReturnsHelloWorld() {
        assertEquals("Hello, World!", App.buildGreeting());
    }

    @Test
    void mainOutputsHelloWorld() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (PrintStream captured = new PrintStream(buffer, true, StandardCharsets.UTF_8)) {
            System.setOut(captured);
            App.main(new String[0]);
        } finally {
            System.setOut(originalOut);
        }

        assertEquals("Hello, World!" + System.lineSeparator(),
                buffer.toString(StandardCharsets.UTF_8));
    }
}
