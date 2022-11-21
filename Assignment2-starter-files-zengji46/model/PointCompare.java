package model;

import java.util.Comparator;

public class PointCompare implements Comparator<TetrisPoint> {
    public int compare(TetrisPoint a, TetrisPoint b) {
        if(b.x == a.x && b.y == a.y) return 0;
        if(a.x > b.x || a.x == b.x && a.y > b.y) return 1;
        return -1;
    }
}
