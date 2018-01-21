package main.domains;

import main.enums.State;

public class Coordinate {
    private Integer xPos;
    private Integer yPos;
    private State state;

    public Integer getxPos() {
        return xPos;
    }

    public void setxPos(Integer xPos) {
        this.xPos = xPos;
    }

    public Integer getyPos() {
        return yPos;
    }

    public void setyPos(Integer yPos) {
        this.yPos = yPos;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Coordinate(Integer xPos, Integer yPos, State state) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (!xPos.equals(that.xPos)) return false;
        if (!yPos.equals(that.yPos)) return false;
        return state == that.state;

    }

    @Override
    public int hashCode() {
        int result = xPos.hashCode();
        result = 31 * result + yPos.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }
}
