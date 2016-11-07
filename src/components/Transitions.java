package components;

public interface Transitions {
    public <T> T getNextState(State currentState, String currentAlphabet);
}
