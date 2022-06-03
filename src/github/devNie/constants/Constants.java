package github.devNie.constants;

public class Constants {
    public enum PALLET {
        WIDTH(2),
        HEIGHT(5),
        OFFSET(3);

        private final int i;
        PALLET(int i){
            this.i = i;
        }

        public int getValue(){return i;}
    }

    public enum BALL {
        RADIUS(1),
        BASE_SPEED(10),
        MAX_SPEED(100);

        private final int i;
        BALL(int i){
            this.i = i;
        }

        public int getValue(){return i;}
    }

    public enum GAME {
        FRAMERATE(60),
        WIDTH(1280),
        HEIGHT(720);

        private final int i;
        GAME(int i){
            this.i = i;
        }

        public int getValue(){return i;}
    }

    public enum COORDS {
        X(0),
        Y(1);

        private final int i;
        COORDS(int i){
            this.i = i;
        }

        public int getValue(){return i;}
    }

    public enum DIRS {
        UP(1),
        DOWN(-1),
        LEFT(-1),
        RIGHT(1),
        X(0),
        Y(1);

        private final int i;
        DIRS(int i){
            this.i = i;
        }

        public int getValue(){return i;}
    }
}
