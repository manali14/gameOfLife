package main.impl;

import main.TickRules;
import main.domains.Cell;
import main.enums.State;

import java.util.List;
import java.util.Map;

public class LiveCellRule extends TickRules {

    @Override
    public State applyRulesAndReturnState(Cell currentCell, List<Cell> neighbouringCells) {
//        TODO: Can be refactored by fetching the Count directly.
//        long liveCellCount = currentCell.countLiveCells(neighbouringCells);
        Map<String, Integer> neighbourLiveAndDeadCountMap = deadAndLiveCellsCountMap(neighbouringCells);
        if (neighbourLiveAndDeadCountMap.get("LIVE") < 2 || neighbourLiveAndDeadCountMap.get("LIVE") > 3) {
            return State.DEAD;
        } else {
            return currentCell.getCoordinate().getState();
        }
    }
}
