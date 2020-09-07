# Nondeterministic_Finite_Automaton
Simulates a NFA.

This is an implementation of a Non deterministic finite automaton. 
The program reads a set of words from a file and then outputs the series of visited states for a word in the language. 

Transitions are stored in a HashMap, in which the current state and transition's symbol are key and the target states are stored in Sets.

The goal of this repo is to use datastructures in the best way possible to optimise the time complexity of the program. 
