package tests;

import main.domains.Cell;
import main.domains.Coordinate;
import main.enums.State;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CellTest {

    @Test
    public void checkThatRuleIsAppliedCorrectlyToACellAndTickHappensCorrectly() {
//        Given

        Cell cell = new Cell(new Coordinate(0, 0, State.DEAD));
        Cell cell1 = new Cell(new Coordinate(0, 1, State.LIVE));
        Cell cell2 = new Cell(new Coordinate(0, 2, State.DEAD));
        Cell cell3 = new Cell(new Coordinate(1, 0, State.DEAD));
        Cell cell4 = new Cell(new Coordinate(1, 1, State.LIVE));
        Cell cell5 = new Cell(new Coordinate(1, 2, State.DEAD));
        Cell cell6 = new Cell(new Coordinate(2, 0, State.DEAD));
        Cell cell7 = new Cell(new Coordinate(2, 1, State.LIVE));
        Cell cell8 = new Cell(new Coordinate(2, 2, State.DEAD));
        List<Cell> cells = Arrays.asList(cell, cell1, cell2, cell3, cell5, cell6, cell7, cell8, cell4);

//        When
        Cell newGenCell = cell.applyRules(cells);

//        Then
        Assert.assertEquals(State.DEAD, newGenCell.getCoordinate().getState());

//        When
        Cell newGenCell1 = cell5.applyRules(cells);

//        Then
        Assert.assertEquals(State.LIVE, newGenCell1.getCoordinate().getState());
    }

    @Test
    public void checkIfCorrectNeighboursAreReturnedForACell() {
//        Given
        Cell currentCell = new Cell(new Coordinate(0, 0, State.LIVE));

    }

}
