package it.unimi.di.sweng.lab03;

//prova
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

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


        for (String st : s) {
            int j;
            try {
                switch (st){
                    case "+":
                        j = queue.pop();
                        j += queue.pop();
                        queue.push(j);
                        break;
                    case "*":
                        j = queue.pop();
                        j *= queue.pop();
                        queue.push(j);
                        break;
                    default:
                        queue.add(Integer.parseInt(st));
                        break;
                }
            }catch(NumberFormatException e){
                    throw new IllegalArgumentException("Token error '" + st + "'");
            } catch(NoSuchElementException e){
                throw new IllegalArgumentException("Stack Underflow");
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
