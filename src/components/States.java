package components;

import java.util.HashSet;

public class States extends HashSet<State>{

    public boolean intersects(States states) {
        for (State state: states){
            if (this.contains(state))
                return true;
        }
        return  false;
    }
}
