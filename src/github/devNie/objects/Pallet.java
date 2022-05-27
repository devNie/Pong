package github.devNie.objects;

import github.devNie.constants.Constants.PALLET;
import github.devNie.constants.Constants.COORDS;

public class Pallet implements Collider {
    private int pos = 0;

    public int getPos() {
        return pos;
    }
    public void move(int units) {
        pos += units;
    }
    public void setPos(int newPos) {
        pos = newPos;
    }

    @Override
    public int[] getCollisionRegion(int[] realOffset) {
        return (new int[]{PALLET.WIDTH.getValue() - realOffset[COORDS.X.getValue()],
                PALLET.HEIGHT.getValue() - realOffset[COORDS.Y.getValue()]});
    }
}
