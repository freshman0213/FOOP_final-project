package effect;

import livingObject.LivingObject;
import livingObject.cd.NormalCDState;

public class CDEffect implements Effect {
    private int cd;
    private int length;

    public CDEffect(int cd, int length) {
        this.cd = cd;
        this.length = length;
    }

    @Override
    public void apply(LivingObject livingObject) {
        livingObject.changeCD(new NormalCDState(length, livingObject, cd));
    }
}
