package it.unimi.di.sweng.lab03;

import java.util.ArrayDeque;

public class ForthInterpreter implements  Interpreter{

    ArrayDeque<Integer> queue;
    public ForthInterpreter(){
        queue = new ArrayDeque<>();

    }
    @Override
    public void input(String program) {
        queue.clear();
        if (program.equals("")){return;}

        String []s = checkRegex(program);

        for(String st : s) {
            if (st.equals("+")) {
                int j = queue.pop();
                j += queue.pop();
                queue.push(j);
            } else {
                queue.add(Integer.parseInt(st));
            }
        }
    }

    private String[] checkRegex(String program) {
        String tmp = program.replaceAll("\\n", " ");
        tmp = tmp.replaceAll(" +", " ");
        return tmp.split(" ");
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
