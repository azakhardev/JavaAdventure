package cz.vse.adventure.logic.commands;

public class UseResult {
    private final String message;
    private final boolean shouldRemoveItem;

    public UseResult(String message, boolean shouldRemoveItem) {
        this.message = message;
        this.shouldRemoveItem = shouldRemoveItem;
    }

    public String getMessage() {
        return message;
    }

    public boolean shouldRemoveItem() {
        return shouldRemoveItem;
    }
}