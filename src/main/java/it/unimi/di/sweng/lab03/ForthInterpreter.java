package it.unimi.di.sweng.lab03;

import java.util.ArrayDeque;
import java.util.Deque;

public class ForthInterpreter implements  Interpreter{

    ArrayDeque<Integer> queue;
    public ForthInterpreter(){
        queue = new ArrayDeque<Integer>();

    }
    @Override
    public void input(String program) {
        queue.clear();
        if (program.equals("")){return;}
        String[] s = program.split(" ");
        for(String st : s) {
            queue.add(Integer.parseInt(st));
        }
    }

    @Override
    public String toString() {
            String s = "";
            for(Integer st : queue) {
                s += st + " ";
            }
            return s + "<- Top";
    }

}
