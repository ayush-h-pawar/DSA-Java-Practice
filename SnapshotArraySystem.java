import java.util.*;

public class SnapshotArraySystem {

    int snapId;

    List<TreeMap<Integer, Integer>> snaps;

    public SnapshotArraySystem(int length) {

        snapId = 0;

        snaps = new ArrayList<>();

        for (int i = 0; i < length; i++) {

            TreeMap<Integer, Integer> map =
                    new TreeMap<>();

            map.put(0, 0);

            snaps.add(map);
        }
    }

    public void set(int index,
                    int val) {

        snaps.get(index)
             .put(snapId, val);
    }

    public int snap() {

        return snapId++;
    }

    public int get(int index,
                   int snap_id) {

        return snaps.get(index)
                    .floorEntry(snap_id)
                    .getValue();
    }

    public static void main(String[] args) {

        SnapshotArraySystem sa =
                new SnapshotArraySystem(3);

        sa.set(0, 5);

        System.out.println(
                sa.snap()
        );

        sa.set(0, 6);

        System.out.println(
                sa.get(0, 0)
        );
    }
}
