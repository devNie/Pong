package github.devNie.objects;

public interface Collider {
    default void collide() { }
    int[] getCollisionRegion(int[] realOffset);
}
