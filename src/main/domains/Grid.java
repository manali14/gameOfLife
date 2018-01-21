package main.domains;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<Cell> cells = new ArrayList<Cell>();

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public Grid applyTick() {
        Grid grid = new Grid();
        for (Cell cell : this.getCells()) {
            grid.getCells().add(cell.applyRules(this.getCells()));
        }
        return grid;
    }

    @Override
    public String toString() {
        return "Grid{" +
                "cells=" + cells +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid = (Grid) o;

        return cells.equals(grid.cells);

    }

    @Override
    public int hashCode() {
        return cells.hashCode();
    }
}
