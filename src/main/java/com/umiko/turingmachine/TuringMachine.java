package main.java.com.umiko.turingmachine;

import com.sun.org.apache.xalan.internal.xsltc.dom.StepIterator;

import java.util.Collection;
import java.util.HashMap;

public class TuringMachine {

    private HashMap<Integer, TuringState> states;
    private int currentState;
    private int currentTapePosition;
    private int stepCount = 0;
    private TapeAlphabet[] tape = {TapeAlphabet.ONE,TapeAlphabet.ZERO, TapeAlphabet.ONE, TapeAlphabet.ONE, TapeAlphabet.ONE, TapeAlphabet.BLANK};

    private TuringResult result = TuringResult.INCONCLUSIVE;
    private TuringStateActionTuple actionTuple;

    public TuringMachine(HashMap<Integer, TuringState> states, int currentState) {
        this.states = states;
        this.currentState = currentState;
    }

    public void run(){
        while (result==TuringResult.INCONCLUSIVE){
            stepCount++;
            actionTuple = states.get(currentState).getAction(tape[currentTapePosition]);
            Write(actionTuple.getAction());
            Move(actionTuple.getMovement());
            Transition(actionTuple.getNextState());
        }
        System.out.println(String.format("%s in %s steps", result == TuringResult.ACCEPTED ? "Accepted" : "Rejected", stepCount));
    }

    public void Move(TuringMovement movement){
        System.out.print("Moving ");
        switch (movement){
            case LEFT:
                currentTapePosition--;
                System.out.println("Left");
                break;
            case RIGHT:
                currentTapePosition++;
                System.out.println("Right");
                break;
            default:
                System.out.println("Nowhere");

                break;
        }
    }

    public void Write(TuringAction action){
        System.out.print("Writing ");
        switch (action){
            case WRITE_ONE:
                tape[currentTapePosition] = TapeAlphabet.ONE;
                System.out.println("1");

                break;
            case WRITE_ZERO:
                tape[currentTapePosition] = TapeAlphabet.ZERO;
                System.out.println("0");

                break;
            case ERASE:
                tape[currentTapePosition] = TapeAlphabet.BLANK;
                System.out.println("Blank");
                break;
            case MARK_ACCEPT:
                result = TuringResult.ACCEPTED;
                break;
            case MARK_REJECT:
                result = TuringResult.REJECTED;
                break;
            default:
                break;
        }
    }

    public void Transition(int id){
        System.out.println("Transitioning to "+id);

        currentState = id;
    }
}
