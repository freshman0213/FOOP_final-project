package effect;

import livingObject.LivingObject;
import livingObject.cd.NormalCDState;

public class CDEffect implements Effect {
    private int cd;

    public CDEffect(int cd) {
        this.cd = cd;
    }

    @Override
    public void apply(LivingObject livingObject) {
        livingObject.changeCD(new NormalCDState(500, livingObject, cd));
    }
}
