import java.util.*;

public class BrowserHistoryManager {

    List<String> history;

    int current;

    public BrowserHistoryManager(String homepage) {

        history = new ArrayList<>();

        history.add(homepage);

        current = 0;
    }

    public void visit(String url) {

        while (history.size() >
               current + 1) {

            history.remove(
                    history.size() - 1
            );
        }

        history.add(url);

        current++;
    }

    public String back(int steps) {

        current =
                Math.max(0,
                         current - steps);

        return history.get(current);
    }

    public String forward(int steps) {

        current =
                Math.min(
                        history.size() - 1,
                        current + steps
                );

        return history.get(current);
    }

    public static void main(String[] args) {

        BrowserHistoryManager bh =
                new BrowserHistoryManager(
                        "google.com"
                );

        bh.visit("youtube.com");
        bh.visit("github.com");

        System.out.println(
                bh.back(1)
        );

        System.out.println(
                bh.forward(1)
        );
    }
}
