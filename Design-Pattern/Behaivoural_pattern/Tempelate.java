
abstract class NotificationSender{
    public final void sendNotification(String to, String message){
        checkRateLimits(to);
        validateFormat(to);
        String formattedMessage = formatMessage(message);
        logBeforeSend(formattedMessage, to);
        send(to, formattedMessage);
        updateAnalytics(to);
    }
}
private void checkRateLimits(String to){
    System.out.println("Checking rate limits for: " + to);
}
private void validateFormat(String to){
    System.out.println("Validating format for: " + to);
}
private String formatMessage(String message){
    return message.trim();
}
private void logBeforeSend(String message, String to){
    System.out.println("Logging before send: "+ message +" to " + to);
}   
private void updateAnalytics(String to){
    System.out.println("Analytics updated for: "+ to);
}






class EmailNotificateion{
    public void sendEmail(String to ,String message){
        System.out.println("Checking rate limits for: " + to);
        System.out.println("Validating email format for: " + to);
        String formattedMessage = message.trim();

        System.out.println("Logging before send: "+ formattedMessage +" to " + to);
        String composedMessage = "<html><body>" + formattedMessage + "</body></html>";
        System.out.println("Sending email to: " + to+" with content: " + composedMessage);
        System.out.println("Analytics updated for: "+ to);
      
    }
}
class SMSNotification{
    public void sendSMS(String to ,String message){
        System.out.println("Checking rate limits for: " + to);
        System.out.println("Validating phone number format for: " + to);
        String formattedMessage = message.trim();

        System.out.println("Logging before send: "+ formattedMessage +" to " + to);
        String composedMessage = formattedMessage;
        System.out.println("Sending SMS to: " + to+" with content: " + composedMessage);
        System.out.println("Analytics updated for: "+ to);
      
    }
}






public class Tempelate{
    public static void main(String[] args) {
        
    }
}