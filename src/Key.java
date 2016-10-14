public class Key {

    private final State initialState;
    private final String alphabet;

    public Key(State initialState, String alphabet) {
        this.initialState = initialState;
        this.alphabet = alphabet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;

        Key key = (Key) o;

        if (!initialState.equals(key.initialState)) return false;
        return alphabet.equals(key.alphabet);

    }

    @Override
    public int hashCode() {
        int result = initialState.hashCode();
        result = 31 * result + alphabet.hashCode();
        return result;
    }
}
