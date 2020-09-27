/**
 * #Nondeterministic_Finite_Automaton
 * Simulates a NFA.
 * 
 * This is an implementation of a Non deterministic finite automaton. 
 * The program reads a set of words from a file and then outputs the series of visited states for a word in the language. 
 *
 * Transitions are stored in a HashMap, in which the current state and transition's symbol are key and the target states are stored in Sets.
 * 
 * The goal of this repo is to use datastructures in the best way possible to optimise the time complexity of the program. 
 * 
 * @author Devops_Mika
 */

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class NFA<S, A> {
    Map<String, List<S>> transitions;
	
    /**
     * Constructs the Nfa and assigns states.
     * @param states all NFA states
     */
    public NFA() {
        this.transitions = new HashMap<>();
    }

    /**
     * Adds the transitions of the given NFA
     * @param q current state
     * @param a transition from q to p
     * @param p next state
     */
    public void addTransition(S q, A a, S p) {
        String key = q.toString() + a;
        if (!transitions.containsKey(key)) {
            List<S> tar = new ArrayList<>();
            tar.add(p);
            transitions.put(key, tar);
        }
        else{
            List<S> tar = transitions.get(key);
            tar.add(p);
            transitions.put(key, tar);
        }
    }

    /**
     * Follows the sequence of transitions starting from a given state
     * @param q starting state
     * @param w sequence of words
     * @return set of all reached final states
     */
    public List<S> simulate(S q, char[] w){
        List<S> ans = new ArrayList<>();
        ans.add(q);
        for(int index = 0; index < w.length; index++){
            List<S> H = new ArrayList<>();
            for (S st : ans){
                String key = st.toString() + w[index];
                List<S> tar = transitions.get(key);
                if (tar != null) {
                    for (S s : tar) {
                        if(!H.contains(s)) H.add(s);
                    }
                }
            }
            ans = H;
        }
        return ans;
    }
}
