package tests;

import main.domains.Cell;
import main.domains.Coordinate;
import main.domains.Grid;
import main.enums.State;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GameOfLifeTest {

    @Test
    public void testBlockPattern() {
//        Given
        Grid grid = new Grid();
        Cell cell = new Cell(new Coordinate(0, 0, State.LIVE));
        Cell cell1 = new Cell(new Coordinate(0, 1, State.LIVE));
        Cell cell2 = new Cell(new Coordinate(1, 0, State.LIVE));
        Cell cell3 = new Cell(new Coordinate(1, 1, State.LIVE));
        grid.setCells(Arrays.asList(cell, cell1, cell2, cell3));


        Grid newGenGrid = grid.applyTick();

        Grid expectedGrid = new Grid();
        Cell expectedCell = new Cell(new Coordinate(0, 0, State.LIVE));
        Cell expectedCell1 = new Cell(new Coordinate(0, 1, State.LIVE));
        Cell expectedCell2 = new Cell(new Coordinate(1, 0, State.LIVE));
        Cell expectedCell3 = new Cell(new Coordinate(1, 1, State.LIVE));
        expectedGrid.setCells(Arrays.asList(expectedCell, expectedCell1, expectedCell2, expectedCell3));

//        Expect
        Assert.assertEquals(expectedGrid, newGenGrid);
    }

    @Test
    public void testBoatPattern() {
//        Given
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

        Grid newGenGrid = grid.applyTick();

        Grid expectedGrid = new Grid();
        Cell expectedCell = new Cell(new Coordinate(0, 0, State.LIVE));
        Cell expectedCell1 = new Cell(new Coordinate(0, 1, State.LIVE));
        Cell expectedCell2 = new Cell(new Coordinate(0, 2, State.DEAD));
        Cell expectedCell3 = new Cell(new Coordinate(1, 0, State.LIVE));
        Cell expectedCell4 = new Cell(new Coordinate(1, 1, State.DEAD));
        Cell expectedCell5 = new Cell(new Coordinate(1, 2, State.LIVE));
        Cell expectedCell6 = new Cell(new Coordinate(2, 0, State.DEAD));
        Cell expectedCell7 = new Cell(new Coordinate(2, 1, State.LIVE));
        Cell expectedCell8 = new Cell(new Coordinate(2, 2, State.DEAD));
        expectedGrid.setCells(Arrays.asList(expectedCell, expectedCell1, expectedCell2, expectedCell3, expectedCell4, expectedCell5, expectedCell6, expectedCell7, expectedCell8));

//        Expect
        Assert.assertEquals(expectedGrid, newGenGrid);
    }

    @Test
    public void testBlinkerPattern() {
//        Given
        Grid grid = new Grid();
        Cell cell = new Cell(new Coordinate(0, 0, State.DEAD));
        Cell cell1 = new Cell(new Coordinate(0, 1, State.LIVE));
        Cell cell2 = new Cell(new Coordinate(0, 2, State.DEAD));
        Cell cell3 = new Cell(new Coordinate(1, 0, State.DEAD));
        Cell cell4 = new Cell(new Coordinate(1, 1, State.LIVE));
        Cell cell5 = new Cell(new Coordinate(1, 2, State.DEAD));
        Cell cell6 = new Cell(new Coordinate(2, 0, State.DEAD));
        Cell cell7 = new Cell(new Coordinate(2, 1, State.LIVE));
        Cell cell8 = new Cell(new Coordinate(2, 2, State.DEAD));
        grid.setCells(Arrays.asList(cell, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8));

        Grid newGenGrid = grid.applyTick();

        Grid expectedGrid = new Grid();
        Cell expectedCell = new Cell(new Coordinate(0, 0, State.DEAD));
        Cell expectedCell1 = new Cell(new Coordinate(0, 1, State.DEAD));
        Cell expectedCell2 = new Cell(new Coordinate(0, 2, State.DEAD));
        Cell expectedCell3 = new Cell(new Coordinate(1, 0, State.LIVE));
        Cell expectedCell4 = new Cell(new Coordinate(1, 1, State.LIVE));
        Cell expectedCell5 = new Cell(new Coordinate(1, 2, State.LIVE));
        Cell expectedCell6 = new Cell(new Coordinate(2, 0, State.DEAD));
        Cell expectedCell7 = new Cell(new Coordinate(2, 1, State.DEAD));
        Cell expectedCell8 = new Cell(new Coordinate(2, 2, State.DEAD));
        expectedGrid.setCells(Arrays.asList(expectedCell, expectedCell1, expectedCell2, expectedCell3, expectedCell4, expectedCell5, expectedCell6, expectedCell7, expectedCell8));

//        Expect
        Assert.assertEquals(expectedGrid, newGenGrid);
    }

    @Test
    public void testToadPattern() {
//        Given
        Grid grid = new Grid();
        Cell cell = new Cell(new Coordinate(0, 0, State.DEAD));
        Cell cell1 = new Cell(new Coordinate(0, 1, State.DEAD));
        Cell cell2 = new Cell(new Coordinate(0, 2, State.DEAD));
        Cell cell3 = new Cell(new Coordinate(0, 3, State.DEAD));
        Cell cell4 = new Cell(new Coordinate(1, 0, State.DEAD));
        Cell cell5 = new Cell(new Coordinate(1, 1, State.LIVE));
        Cell cell6 = new Cell(new Coordinate(1, 2, State.LIVE));
        Cell cell7 = new Cell(new Coordinate(1, 3, State.LIVE));
        Cell cell8 = new Cell(new Coordinate(2, 0, State.LIVE));
        Cell cell9 = new Cell(new Coordinate(2, 1, State.LIVE));
        Cell cell10 = new Cell(new Coordinate(2, 2, State.LIVE));
        Cell cell11 = new Cell(new Coordinate(2, 3, State.DEAD));
        Cell cell12 = new Cell(new Coordinate(3, 0, State.DEAD));
        Cell cell13 = new Cell(new Coordinate(3, 1, State.DEAD));
        Cell cell14 = new Cell(new Coordinate(3, 2, State.LIVE));
        Cell cell15 = new Cell(new Coordinate(3, 3, State.DEAD));
        grid.setCells(Arrays.asList(cell, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, cell10, cell11, cell12, cell13, cell14, cell15));

        Grid newGenGrid = grid.applyTick();

        Grid expectedGrid = new Grid();
        Cell expectedCell = new Cell(new Coordinate(0, 0, State.DEAD));
        Cell expectedCell1 = new Cell(new Coordinate(0, 1, State.DEAD));
        Cell expectedCell2 = new Cell(new Coordinate(0, 2, State.LIVE));
        Cell expectedCell3 = new Cell(new Coordinate(0, 3, State.DEAD));
        Cell expectedCell4 = new Cell(new Coordinate(1, 0, State.LIVE));
        Cell expectedCell5 = new Cell(new Coordinate(1, 1, State.DEAD));
        Cell expectedCell6 = new Cell(new Coordinate(1, 2, State.DEAD));
        Cell expectedCell7 = new Cell(new Coordinate(1, 3, State.LIVE));
        Cell expectedCell8 = new Cell(new Coordinate(2, 0, State.LIVE));
        Cell expectedCell9 = new Cell(new Coordinate(2, 1, State.DEAD));
        Cell expectedCell10 = new Cell(new Coordinate(2, 2, State.DEAD));
        Cell expectedCell11 = new Cell(new Coordinate(2, 3, State.DEAD));
        Cell expectedCell12 = new Cell(new Coordinate(3, 0, State.DEAD));
        Cell expectedCell13 = new Cell(new Coordinate(3, 1, State.DEAD));
        Cell expectedCell14 = new Cell(new Coordinate(3, 2, State.LIVE));
        Cell expectedCell15 = new Cell(new Coordinate(3, 3, State.DEAD));
        expectedGrid.setCells(Arrays.asList(expectedCell, expectedCell1, expectedCell2, expectedCell3, expectedCell4, expectedCell5, expectedCell6, expectedCell7, expectedCell8, expectedCell9, expectedCell10, expectedCell11, expectedCell12, expectedCell13, expectedCell14, expectedCell15));

//        Expect
        Assert.assertEquals(expectedGrid, newGenGrid);
    }

}
