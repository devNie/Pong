package github.devNie.objects;

import github.devNie.constants.Constants.PALLET;
import github.devNie.constants.Constants.COORDS;

public class Pallet implements Collider {
    private int pos = 0;
    int[] realOffset = new int[] {0,0};

    public void setRealOffset(int[] newOffset) {
        realOffset = newOffset;
    }

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
    public int[][] getCollisionRegion() {
        return (new int[][]{
                {realOffset[COORDS.X.getValue()], realOffset[COORDS.X.getValue()]+PALLET.WIDTH.getValue()-1},
                {realOffset[COORDS.Y.getValue()], realOffset[COORDS.Y.getValue()]+PALLET.HEIGHT.getValue()-1}
        });
    }
}
