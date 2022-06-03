package github.devNie.objects;

public interface Collider {
    default boolean collide(Collider tgt){return false;}
    default int[][] getCollisionRegion() {return new int[0][];}
}
