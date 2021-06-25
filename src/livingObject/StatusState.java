package livingObject;

import fsm.State;

import java.awt.*;

public interface StatusState extends State {
    StatusState copy(); // for return to default state
    Image getImage();
}
