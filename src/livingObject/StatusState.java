package livingObject;

import fsm.State;

public interface StatusState extends State {
    StatusState copy(); // for return to default state
}
