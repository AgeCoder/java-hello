import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    // ANSI color codes for colorful console output (works in most terminals)
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        // Print startup message
        System.out.println(CYAN + "===============================================" + RESET);
        System.out.println(GREEN + "🚀 Hello from Vedant's Jenkins + Docker Build!" + RESET);
        System.out.println(CYAN + "===============================================\n" + RESET);

        // Print current time
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(YELLOW + "🕒 Current Time: " + currentTime + RESET);

        // Print environment information
        System.out.println(BLUE + "💻 System Information:" + RESET);
        System.out.println("   OS Name: " + System.getProperty("os.name"));
        System.out.println("   OS Version: " + System.getProperty("os.version"));
        System.out.println("   Java Version: " + System.getProperty("java.version"));
        System.out.println("   User: " + System.getProperty("user.name"));

        // Handle command-line arguments
        if (args.length > 0) {
            System.out.println("\n📦 Arguments passed to the program:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("   arg[" + i + "]: " + args[i]);
            }
        } else {
            System.out.println("\nℹ️ No command-line arguments provided.");
        }

        // Example success message
        System.out.println(GREEN + "\n✅ Build and execution completed successfully!" + RESET);
    }
}
