package main.java.com.umiko.turingmachine;

public class TuringState {
    private int id;
    private boolean isTerminalState;
    private TuringStateActionTuple actionTuples[];


    public TuringState(int id, boolean isTerminalState, TuringStateActionTuple onZero, TuringStateActionTuple onOne, TuringStateActionTuple onBlank) {
        this.id = id;
        this.isTerminalState = isTerminalState;
        this.actionTuples = new TuringStateActionTuple[]{ onZero, onOne, onBlank };
    }

    public TuringStateActionTuple getAction(TapeAlphabet symbol){
        switch (symbol){
            case ZERO:
                return actionTuples[0];
            case ONE:
                return actionTuples[1];
            case BLANK:
                return actionTuples[2];
            default:
                return null;
        }
    }
}
