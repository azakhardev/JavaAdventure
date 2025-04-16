package cz.vse.adventure.logic.commands;

public class CommandUse implements ICommand{



    @Override
    public String executeCommand(String... parametry) {
        if(parametry.length != 2){
            return "Enter two parameters - what to use and on what you want to use it.";
        }

        return "";
    }

    @Override
    public String getName() {
        return "";
    }
}
