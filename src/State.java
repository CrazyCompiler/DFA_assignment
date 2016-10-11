
public class State {

    String name;

    public State(String name) {
        this.name = name;
    }

    public boolean equals(State toCheck ) {
        return this.name == toCheck.name;
    }
}
