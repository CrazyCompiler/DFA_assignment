
public class Transition {
    State from ;
    State to;
    char alphabet;

    public Transition(State from, char alphabet, State to) {
        this.from = from;
        this.alphabet = alphabet;
        this.to = to;
    }

    public State getNextState(){
        return to;
    }

    public boolean hasSameFromAndAlphabet(State from, char alphabet){
        return this.from.equals(from) && this.alphabet == alphabet;
    }
}
