

// package DESIGNPATTERNS;

 class JudgeAnalytics {
    private static JudgeAnalytics instance;
    private JudgeAnalytics() {
        // Private constructor to prevent instantiation
    }
    public static JudgeAnalytics getInstance() {
        if (instance == null) {
            instance = new JudgeAnalytics();
        }
        return instance;
    }
    public void analyze() {
        System.out.println("Analyzing judge data...");
    }
}
public class Singelton {

    public static void main(String[] args) {

        JudgeAnalytics analytics1 = JudgeAnalytics.getInstance();
        JudgeAnalytics analytics2 = JudgeAnalytics.getInstance();
        System.out.println(analytics1 == analytics2); // true
        analytics1.analyze();

    }
    
}