package main;

import main.domains.Cell;
import main.enums.State;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TickRules {
    public abstract State applyRulesAndReturnState(Cell currentCell, List<Cell> neighbouringCells);

    public Map<String, Integer> deadAndLiveCellsCountMap(List<Cell> neighbouringCells) {
        Map<String, Integer> deadLiveNeighbourCountMap = new HashMap<String, Integer>();
        deadLiveNeighbourCountMap.put("LIVE", 0);
        deadLiveNeighbourCountMap.put("DEAD", 0);
        for (Cell cell : neighbouringCells) {
            deadLiveNeighbourCountMap = updateMap(cell, deadLiveNeighbourCountMap);
        }
        return deadLiveNeighbourCountMap;
    }

    private Map<String, Integer> updateMap(Cell cell, Map<String, Integer> deadLiveNeighbourCountMap) {
        if (cell.getCoordinate().getState() == State.LIVE) {
            Integer count = deadLiveNeighbourCountMap.get("LIVE");
            deadLiveNeighbourCountMap.put("LIVE", ++count);
        } else if (cell.getCoordinate().getState() == State.DEAD) {
            Integer count = deadLiveNeighbourCountMap.get("DEAD");
            deadLiveNeighbourCountMap.put("DEAD", ++count);
        }
        return deadLiveNeighbourCountMap;

    }
}
