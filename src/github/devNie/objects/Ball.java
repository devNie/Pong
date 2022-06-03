package github.devNie.objects;

import github.devNie.constants.Constants.DIRS;
import github.devNie.constants.Constants.COORDS;
import github.devNie.constants.Constants.BALL;

public class Ball implements Collider {
    private DIRS[] direction;
    private int[] pos = new int[]{0,0};

    public void push() {
        direction = new DIRS[2];

        for (int i = 0; i <= 1; i++) {
            int ch = (int)Math.round(Math.random());

            if (ch > 0) {
                direction[i] = ((i==0) ? DIRS.DOWN : DIRS.RIGHT);
            } else {
                direction[i] = ((i==0) ? DIRS.UP : DIRS.LEFT);
            }
        }

    }

    public void bounce() {
        if (direction[DIRS.X.getValue()] == DIRS.LEFT) {
            direction[DIRS.X.getValue()] = DIRS.RIGHT;
        } else {
            direction[DIRS.X.getValue()] = DIRS.LEFT;
        }

        if (direction[DIRS.Y.getValue()] == DIRS.UP) {
            direction[DIRS.Y.getValue()] = DIRS.DOWN;
        } else {
            direction[DIRS.Y.getValue()] = DIRS.UP;
        }
    }

    @Override
    public boolean collide(Collider tgt) {  // think of a solution to check region intersection
            int[] rectX = tgt.getCollisionRegion()[COORDS.X.getValue()];
            int[] rectY = tgt.getCollisionRegion()[COORDS.Y.getValue()];

            // Nearest X and Y to the ball
            int Xn = Math.max(rectX[0], Math.min(pos[COORDS.X.getValue()], rectX[1]));
            int Yn = Math.max(rectY[0], Math.min(pos[COORDS.Y.getValue()], rectY[1]));

            // Difference between X of nearest and X of ball center
            int dX = Xn-pos[COORDS.X.getValue()];
            int dY = Yn-pos[COORDS.Y.getValue()];

            return Math.pow(dX, 2) + Math.pow(dY, 2) <= Math.pow(BALL.RADIUS.getValue(), 2);
    }
}
