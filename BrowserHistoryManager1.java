public class BrowserHistoryManager1 {

    static class Node {

        String url;

        Node previous;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    private Node currentPage;

    public BrowserHistoryManager(
            String homepage) {

        currentPage =
                new Node(homepage);
    }

    public void visit(
            String url) {

        Node newPage =
                new Node(url);

        currentPage.next = newPage;

        newPage.previous =
                currentPage;

        currentPage = newPage;
    }

    public String back(
            int steps) {

        while (steps > 0
                && currentPage.previous != null) {

            currentPage =
                    currentPage.previous;

            steps--;
        }

        return currentPage.url;
    }

    public String forward(
            int steps) {

        while (steps > 0
                && currentPage.next != null) {

            currentPage =
                    currentPage.next;

            steps--;
        }

        return currentPage.url;
    }

    public static void main(String[] args) {

        BrowserHistoryManager browser =
                new BrowserHistoryManager(
                        "leetcode.com"
                );

        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");

        System.out.println(
                browser.back(1)
        );

        System.out.println(
                browser.back(1)
        );

        System.out.println(
                browser.forward(1)
        );

        browser.visit("linkedin.com");

        System.out.println(
                browser.forward(2)
        );

        System.out.println(
                browser.back(2)
        );

        System.out.println(
                browser.back(7)
        );
    }
}
