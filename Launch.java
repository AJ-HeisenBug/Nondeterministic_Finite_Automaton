/**
 * Class launch provides the required data for NFA.java
 * Also contains the main method
 * 
 * Best performance: java -XX:+UseParallelGC -Xms2048m -Xmx2048m Launch
 */

import java.io.*;
import java.util.List;

public class Launch<S, A> {
    /**
     * Gets the transitions required to build a NFA
     * @param nfa the NFA to build
     */
    public static void getTransitions(NFA<Integer, String> nfa){
        try {
            BufferedReader myReader = new BufferedReader(new FileReader("trans"));
            String tmp;
            while ((tmp = myReader.readLine()) != null) {
                String[] data = tmp.split(" ");
                nfa.addTransition(Integer.valueOf(data[0]), data[1], Integer.valueOf(data[2]));
                
            }
            myReader.close(); 
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * reads the words from 2020_H09_input
     * @param eingabe the List that stores the data
     */
    public static void read_words(char[][] eingabe){
        try {
            BufferedReader myReader = new BufferedReader(new FileReader("input"));
            String tmp; 
            int index = 0;
            while ((tmp = myReader.readLine()) != null) {
                eingabe[index] = tmp.toCharArray();
                index++;
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        NFA<Integer, String> nfa = new NFA<>();
        getTransitions(nfa);
        char[][] eingabe = new char[4][];
        read_words(eingabe);   
        for (char[] e : eingabe){
            // long z = System.currentTimeMillis();
            List<Integer> reachable = nfa.simulate(7, e);
            System.out.println(reachable);
            // System.out.println(System.currentTimeMillis()-z);
        }
    }
}
