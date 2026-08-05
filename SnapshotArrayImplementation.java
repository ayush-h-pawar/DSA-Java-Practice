import java.util.ArrayList;
import java.util.List;

public class SnapshotArrayImplementation {

    static class Entry {

        int snapshotId;
        int value;

        Entry(
                int snapshotId,
                int value) {

            this.snapshotId = snapshotId;
            this.value = value;
        }
    }

    private final List<Entry>[] snapshots;

    private int currentSnapshot;

    @SuppressWarnings("unchecked")
    public SnapshotArrayImplementation(
            int length) {

        snapshots =
                new ArrayList[length];

        for (int index = 0;
             index < length;
             index++) {

            snapshots[index] =
                    new ArrayList<>();

            snapshots[index].add(
                    new Entry(
                            0,
                            0
                    )
            );
        }

        currentSnapshot = 0;
    }

    public void set(
            int index,
            int value) {

        List<Entry> entries =
                snapshots[index];

        if (entries.get(entries.size() - 1)
                .snapshotId
                == currentSnapshot) {

            entries.get(entries.size() - 1)
                    .value = value;

        } else {

            entries.add(
                    new Entry(
                            currentSnapshot,
                            value
                    )
            );
        }
    }

    public int snap() {

        return currentSnapshot++;
    }

    public int get(
            int index,
            int snapshotId) {

        List<Entry> entries =
                snapshots[index];

        int left = 0;
        int right = entries.size() - 1;

        while (left <= right) {

            int middle =
                    left + (right - left) / 2;

            if (entries.get(middle).snapshotId
                    <= snapshotId) {

                left = middle + 1;

            } else {

                right = middle - 1;
            }
        }

        return entries.get(right).value;
    }

    public static void main(String[] args) {

        SnapshotArrayImplementation array =
                new SnapshotArrayImplementation(3);

        array.set(0, 5);

        int snapshot =
                array.snap();

        array.set(0, 6);

        System.out.println(
                array.get(
                        0,
                        snapshot
                )
        );
    }
}
