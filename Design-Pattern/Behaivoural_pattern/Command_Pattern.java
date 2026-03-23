import java.util.Stack;

class Light{
    public void on(){
        System.out.println("Light turned on");
    }

    public void off(){
        System.out.println("Light turned off");
    }
}


class AC{
    public void on(){
        System.out.println("AC turned on");
    }
    public void off(){
        System.out.println("AC turned off");
    }
}

class NaiveRemoteControl{
    private Light light;
    private AC ac;
    private String lastAction = "";

    public NaiveRemoteControl(Light light,AC ac){
        this.light = light;
        this.ac = ac;
    }

    public void pressLightOn(){
        ac.on();
        lastAction= "AC_ON";

    }

    public void pressACOFF(){
        ac.off();
         lastAction= "AC_OFF";
    }


    public void pressUndo(){
        switch(lastAction){
            case "Light_ON" : light.off();
             lastAction = "LIGHT_OFF";
             break;
             case "LIGHT_OFF": light.on();
             lastAction = "LIGHT_ON";
             break;
             case "AC_ON": ac.off();
             lastAction = "AC_OFF";
             break;
             case "AC_OFF": ac.on();
             lastAction = "AC_ON";
             break;
             default: System.out.println("No action to undo");

        }
    }

}

interface Command{
    void execute();
    void undo();
}
class LightOnCommand implements Command{
    private Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }
    public void undo(){
        light.off();
    }
}


class LightOffCommand implements Command{
    private Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.off();
    }
    public void undo(){
        light.on();
    }
}

class AcONCommand implements Command{
    private AC ac;
    public AcONCommand(AC ac){
        this.ac = ac;
    }
    public void execute(){
        ac.on();
    }
    public void undo(){
        ac.off();
    }
}

class AcOffCommand implements Command{
    private AC ac;
    public AcOffCommand(AC ac){
        this.ac = ac;
    }
    public void execute(){
        ac.off();
    }
    public void undo(){
        ac.on();
    }
}


class RemoteControl{
    private Command[] buttons = new Command[6];
    private Stack<Command> commandHistory = new Stack<>();
    public void setCommand(int slot,Command command){
        buttons[slot] = command;

    }

    public void pressButton(int slot){
        if(buttons[slot]!= null){
            buttons[slot].execute();
            commandHistory.push(buttons[slot]);
        }else{
            System.out.println("No command assigned to slot"+slot);
        }

    }

    public void pressUndo(){
        if(!commandHistory.isEmpty()){
            commandHistory.pop().undo();
        }else{
            System.out.println("No commands to undo");
        }
    }
}

public class Command_Pattern {

    public static void main(String[] args) {
        Light light = new Light();
        AC ac = new AC();

        Command lightOn = new LightOnCommand(light);
        Command lightoff = new LightOffCommand(light);
        Command acon = new AcONCommand(ac);
        Command acoff = new AcOffCommand(ac);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightoff);
        remote.setCommand(2, acon);
        remote.setCommand(3, acoff);
        remote.setCommand(4, acoff);
        remote.pressUndo();

    }
}