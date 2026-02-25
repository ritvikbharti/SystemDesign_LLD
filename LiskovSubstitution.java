class NotificationService {
    public void sendNotification() {
        System.out.println("Sending notification...");
    }
}

class TextNotificationService extends NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("Sending text notification...");
    }
}
class EmailNotificationService extends NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("Sending email notification...");
    }
}


public class LiskovSubstitution {
    public static void main(String[] args) {
        // Here i can substiute the TextNotificationService with EmailNotificationService without affecting the functionality of the program ie the program will still work as expected without any issues---> Liskov Substitution Principle (LSP)
        NotificationService notificationService = new TextNotificationService();
        notificationService.sendNotification();
    }
}
