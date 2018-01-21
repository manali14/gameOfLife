package main.factory;

import main.impl.DeadCellRule;
import main.impl.LiveCellRule;
import main.TickRules;

public class StateFactory {

    public static TickRules fetchStateRuleClass(String state) {
        switch (state) {
            case ("LIVE"):
                return (new LiveCellRule());
            case ("DEAD"):
                return (new DeadCellRule());
            default:
                return null;
        }
    }
}
