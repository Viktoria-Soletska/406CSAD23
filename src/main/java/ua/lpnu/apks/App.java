package ua.lpnu.apks;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println(buildGreeting());
    }

    public static String buildGreeting() {
        return "Hello, World!";
    }
}
