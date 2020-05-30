package main.java.com.umiko.turingmachine;

public class TuringStateActionTuple {
    private TuringAction action;
    private TuringMovement movement;
    private int nextState;

    public TuringAction getAction() {
        return action;
    }

    public TuringMovement getMovement() {
        return movement;
    }

    public int getNextState() {
        return nextState;
    }

    public TuringStateActionTuple(TuringAction action, TuringMovement movement, int nextState) {
        this.action = action;
        this.movement = movement;
        this.nextState = nextState;
    }
}
