package main.java.com.umiko.turingmachine;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, TuringState> states = new HashMap<>();

        TuringState start = new TuringState(0, false,
                new TuringStateActionTuple(TuringAction.ERASE,TuringMovement.RIGHT,1),
                new TuringStateActionTuple(TuringAction.ERASE,TuringMovement.RIGHT,2),
                new TuringStateActionTuple(TuringAction.MARK_ACCEPT, TuringMovement.STAY, 0));
        TuringState search0 = new TuringState(1, false,
                new TuringStateActionTuple(TuringAction.NONE,TuringMovement.RIGHT,1),
                new TuringStateActionTuple(TuringAction.NONE,TuringMovement.RIGHT,1),
                new TuringStateActionTuple(TuringAction.NONE, TuringMovement.LEFT, 3));
        TuringState search1 = new TuringState(2, false,
                new TuringStateActionTuple(TuringAction.NONE,TuringMovement.RIGHT,2),
                new TuringStateActionTuple(TuringAction.NONE,TuringMovement.RIGHT,2),
                new TuringStateActionTuple(TuringAction.NONE, TuringMovement.LEFT, 4));
        TuringState test0= new TuringState(3, false,
                new TuringStateActionTuple(TuringAction.ERASE,TuringMovement.LEFT,5),
                new TuringStateActionTuple(TuringAction.MARK_REJECT,TuringMovement.STAY,3),
                new TuringStateActionTuple(TuringAction.ERASE, TuringMovement.LEFT, 5));
        TuringState test1= new TuringState(4, false,
                new TuringStateActionTuple(TuringAction.MARK_REJECT,TuringMovement.STAY,4),
                new TuringStateActionTuple(TuringAction.ERASE,TuringMovement.LEFT,5),
                new TuringStateActionTuple(TuringAction.ERASE, TuringMovement.LEFT, 5));
        TuringState rewind= new TuringState(5, false,
                new TuringStateActionTuple(TuringAction.NONE,TuringMovement.LEFT,5),
                new TuringStateActionTuple(TuringAction.NONE,TuringMovement.LEFT,5),
                new TuringStateActionTuple(TuringAction.NONE, TuringMovement.RIGHT, 0));

        states.put(0, start);
        states.put(1, search0);
        states.put(2, search1);
        states.put(3, test0);
        states.put(4, test1);
        states.put(5, rewind);

        TuringMachine tm = new TuringMachine(states, 0);
        tm.run();


    }
}
