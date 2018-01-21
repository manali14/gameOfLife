package main;

import main.domains.Cell;
import main.domains.Coordinate;
import main.domains.Grid;
import main.enums.State;

import java.util.Arrays;

public class GameOfLifeMain {
    public static void main(String[] args) {
        Grid grid = new Grid();
        Cell cell = new Cell(new Coordinate(0, 0, State.LIVE));
        Cell cell1 = new Cell(new Coordinate(0, 1, State.LIVE));
        Cell cell2 = new Cell(new Coordinate(0, 2, State.DEAD));
        Cell cell3 = new Cell(new Coordinate(1, 0, State.LIVE));
        Cell cell4 = new Cell(new Coordinate(1, 1, State.DEAD));
        Cell cell5 = new Cell(new Coordinate(1, 2, State.LIVE));
        Cell cell6 = new Cell(new Coordinate(2, 0, State.DEAD));
        Cell cell7 = new Cell(new Coordinate(2, 1, State.LIVE));
        Cell cell8 = new Cell(new Coordinate(2, 2, State.DEAD));

        grid.setCells(Arrays.asList(cell, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8));

        Grid grid1 = grid.applyTick();
        System.out.println(grid1);
    }
}
