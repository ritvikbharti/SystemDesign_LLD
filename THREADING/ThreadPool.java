import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;







class EmailService {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);


    public static void sendEmail(String recipient, String subject, String body) {
        executor.execute(() -> {
            // Simulate sending email
            System.out.println("Sending email to: " + recipient + " on thread: " + Thread.currentThread().getName());
         
            try {
                Thread.sleep(2000); // Simulate time taken to send email
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Email sent to: " + recipient);
        });
    }
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++) {
            String recipient = "user" + i + "@example.com";
            String subject = "Welcome!";
            String body = "Hello User " + i + ", welcome to our service!";
            sendEmail(recipient, subject, body);
        }
        executor.shutdown();
    }

}

public class ThreadPool {
    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        emailService.sendEmail("Mantu", "Hello", "Welcome to Java Threading!");
    }
}
