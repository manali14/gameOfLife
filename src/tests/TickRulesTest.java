package tests;

import main.TickRules;
import main.domains.Cell;
import main.domains.Coordinate;
import main.enums.State;
import main.impl.DeadCellRule;
import main.impl.LiveCellRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class TickRulesTest {

    @Test
    public void checkIfDeadAndLiveNeighbourCountIsPopulatedCorrectly() {
//Given
        TickRules tickRules = new LiveCellRule();
        Cell cell = new Cell(new Coordinate(0, 0, State.LIVE));
        Cell cell1 = new Cell(new Coordinate(0, 1, State.LIVE));
        Cell cell2 = new Cell(new Coordinate(1, 0, State.LIVE));
        Cell cell3 = new Cell(new Coordinate(1, 1, State.LIVE));
        Cell cell4 = new Cell(new Coordinate(1, 1, State.DEAD));
        Cell cell5 = new Cell(new Coordinate(1, 1, State.DEAD));

//        When
        Map<String, Integer> deadLiveNeighbourCountMap = tickRules.deadAndLiveCellsCountMap(Arrays.asList(cell, cell1, cell2, cell3));

//        Then
        Assert.assertEquals(4, (long) deadLiveNeighbourCountMap.get("LIVE"));


//        When
        Map<String, Integer> deadLiveNeighbourCountMap1 = tickRules.deadAndLiveCellsCountMap(Arrays.asList(cell, cell1, cell2, cell4, cell5));

//        Then
        Assert.assertEquals(3, (long) deadLiveNeighbourCountMap1.get("LIVE"));
    }

    @Test
    public void testCorrectStateIsReturnedForLiveStateBasisTheRulesApplied() {
//        Given
        LiveCellRule liveCellRule = new LiveCellRule();
        Cell cell = new Cell(new Coordinate(0, 1, State.LIVE));

        Cell neighbourCell1 = new Cell(new Coordinate(0, 0, State.DEAD));
        Cell neighbourCell2 = new Cell(new Coordinate(0, 2, State.DEAD));
        Cell neighbourCell3 = new Cell(new Coordinate(1, 0, State.DEAD));
        Cell neighbourCell4 = new Cell(new Coordinate(1, 1, State.LIVE));
        Cell neighbourCell5 = new Cell(new Coordinate(1, 2, State.DEAD));

//        When
        State newGenState = liveCellRule.applyRulesAndReturnState(cell, Arrays.asList(neighbourCell1, neighbourCell2, neighbourCell3, neighbourCell4, neighbourCell5));

//        Then
        Assert.assertEquals(State.DEAD, newGenState);
    }

    @Test
    public void testCorrectStateIsReturnedForDeadStateBasisTheRulesApplied() {
//        Given
        DeadCellRule deadCellRule = new DeadCellRule();
        Cell cell = new Cell(new Coordinate(1, 0, State.DEAD));

        Cell neighbourCell1 = new Cell(new Coordinate(0, 0, State.DEAD));
        Cell neighbourCell2 = new Cell(new Coordinate(0, 1, State.LIVE));
        Cell neighbourCell3 = new Cell(new Coordinate(1, 1, State.LIVE));
        Cell neighbourCell4 = new Cell(new Coordinate(2, 1, State.LIVE));
        Cell neighbourCell5 = new Cell(new Coordinate(2, 0, State.DEAD));

//        When
        State newGenState = deadCellRule.applyRulesAndReturnState(cell, Arrays.asList(neighbourCell1, neighbourCell2, neighbourCell3, neighbourCell4, neighbourCell5));

//        Then
        Assert.assertEquals(State.LIVE, newGenState);
    }
}
