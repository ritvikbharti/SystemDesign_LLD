import java.util.*;
// Prototype pattern implementation for creating email templates
// Prototype pattern allows us to create new objects by copying existing ones, which can be more efficient than creating new instances from scratch.
// Here, we have an EmailTemplate interface that defines the structure for email templates, and a WelcomeEmail class that implements this interface. 
// The EmailTemplateRegistry class serves as a registry for different email templates, allowing us to retrieve and clone them as needed. In the main method, we demonstrate how to use the prototype pattern to create and modify email templates without affecting the original template.
interface EmailTempelate extends Cloneable{
    EmailTempelate clone();
    void setContent(String content);
    void send(String to);
    public String getContent();
}



class WelcomeEmail implements EmailTempelate{
    private String subject;
    private String content;

    public WelcomeEmail(){
        this.subject = "Welcome to TUf++";
        this.content = "Hi Guys! How are you all.";
    }
    @Override
    public WelcomeEmail clone(){
        try{
            return (WelcomeEmail) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("Clone failed",e);
        }
    }
    @Override
    public void setContent(String content){
        this.content = content;
    }
    @Override
    public String getContent(){
        return content;

    }
    @Override
    public void send(String to){
        System.out.println("Sending to " + to +": [" + subject + "]" + content);

    }
}

class EmailTempelateRegistry{
    private static final Map<String,EmailTempelate> templates = new HashMap<>();

    static{
        templates.put("welcome",new WelcomeEmail());
    }
    public static EmailTempelate getTempelate(String type){
        return templates.get(type).clone();
    }
}

public class Prototype {
    public static void main(String[] args) {
      EmailTempelate welcomeEmail = EmailTempelateRegistry.getTempelate("welcome");
      welcomeEmail.setContent("type1");
      System.out.println(welcomeEmail.getContent());
      EmailTempelate welcomeEmail2 = EmailTempelateRegistry.getTempelate("welcome");
      welcomeEmail2.setContent("Type-2");
      System.out.println(welcomeEmail.getContent());
      System.out.println(welcomeEmail2.getContent());


      
    }
}