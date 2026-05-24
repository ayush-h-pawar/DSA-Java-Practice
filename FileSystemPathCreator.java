import java.util.*;

public class FileSystemPathCreator {

    Map<String, Integer> pathMap;

    public FileSystemPathCreator() {

        pathMap = new HashMap<>();

        pathMap.put("", -1);
    }

    public boolean createPath(
            String path,
            int value) {

        if (path.isEmpty() ||
            path.equals("/") ||
            pathMap.containsKey(path)) {

            return false;
        }

        int idx =
                path.lastIndexOf('/');

        String parent =
                path.substring(0, idx);

        if (!pathMap.containsKey(parent))
            return false;

        pathMap.put(path, value);

        return true;
    }

    public int get(String path) {

        return pathMap.getOrDefault(
                path,
                -1
        );
    }

    public static void main(String[] args) {

        FileSystemPathCreator fs =
                new FileSystemPathCreator();

        System.out.println(
                fs.createPath("/a", 1)
        );

        System.out.println(
                fs.get("/a")
        );
    }
}
