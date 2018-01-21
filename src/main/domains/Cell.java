package main.domains;

import main.TickRules;
import main.enums.State;
import main.factory.StateFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cell {
    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Cell applyRules(List<Cell> cells) {
        TickRules tickRules = StateFactory.fetchStateRuleClass(getCoordinate().getState().getName());
        Cell cell = new Cell(new Coordinate(this.getCoordinate().getxPos(), this.getCoordinate().getyPos(), this.getCoordinate().getState()));
        if (tickRules != null) {
            cell.getCoordinate().setState(tickRules.applyRulesAndReturnState(this, fetchNeighbouringCells(cells)));
        } else {
            System.out.println("No Rules found for updating the Cell. No changes done.");
        }
        return cell;
    }

    private List<Cell> fetchNeighbouringCells(List<Cell> cells) {
        List<Integer> allowedPositions = Arrays.asList(0, 1);
        return cells.stream().filter((gridCell) ->
                allowedPositions.contains(Math.abs(gridCell.getCoordinate().getxPos() - this.getCoordinate().getxPos())) &&
                        allowedPositions.contains(Math.abs(gridCell.getCoordinate().getyPos() - this.getCoordinate().getyPos())) &&
                        gridCell != this)
                .collect(Collectors.toList());
    }

    public long countLiveCells(List<Cell> cells) {
        List<Integer> allowedPositions = Arrays.asList(0, 1);
        return cells.stream().filter((gridCell) ->
                allowedPositions.contains(Math.abs(gridCell.getCoordinate().getxPos() - this.getCoordinate().getxPos())) &&
                        allowedPositions.contains(Math.abs(gridCell.getCoordinate().getyPos() - this.getCoordinate().getyPos())) &&
                        gridCell != this && gridCell.getCoordinate().getState() == State.LIVE).count();
    }

    public long countDeadCells(List<Cell> cells) {
        List<Integer> allowedPositions = Arrays.asList(0, 1);
        return cells.stream().filter((gridCell) ->
                allowedPositions.contains(Math.abs(gridCell.getCoordinate().getxPos() - this.getCoordinate().getxPos())) &&
                        allowedPositions.contains(Math.abs(gridCell.getCoordinate().getyPos() - this.getCoordinate().getyPos())) &&
                        gridCell != this && gridCell.getCoordinate().getState() == State.DEAD).count();
    }

    @Override
    public String toString() {
        return "Cell{" +
                "coordinate=" + coordinate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return coordinate.equals(cell.coordinate);

    }

    @Override
    public int hashCode() {
        return coordinate.hashCode();
    }
}
