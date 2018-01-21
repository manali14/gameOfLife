package main.enums;

public enum State {
    LIVE("LIVE"), DEAD("DEAD");

    private String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
