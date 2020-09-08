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

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NFA<S, A> {
    Map<String, Set<S>> transitions;
	
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
        String key = q + " " + a;
        if (!transitions.containsKey(key)) {
            Set<S> tar = new HashSet<>();
            tar.add(p);
            transitions.put(key, tar);
        }
        else{
            Set<S> tar = transitions.get(key);
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
    public Set<S> simulate(S q, char[] w){
        Set<S> ans = new HashSet<>();
        ans.add(q);
        for(int index = 0; index < w.length; index++){
            Set<S> H = new HashSet<>();
	        for (S st : ans){
	            String key = st + " " + w[index];
                Set<S> tar = transitions.get(key);
                if (tar != null) H.addAll(tar);
            }
	        ans = H;
        }
	    return ans;
    }
}
