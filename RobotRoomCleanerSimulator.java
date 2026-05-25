import java.util.*;

public class RobotRoomCleanerSimulator {

    interface Robot {

        boolean move();

        void turnLeft();

        void turnRight();

        void clean();
    }

    int[][] dirs = {
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };

    Set<String> visited =
            new HashSet<>();

    public void cleanRoom(Robot robot) {

        backtrack(robot, 0, 0, 0);
    }

    void backtrack(Robot robot,
                   int row,
                   int col,
                   int dir) {

        String key = row + "," + col;

        visited.add(key);

        robot.clean();

        for (int i = 0; i < 4; i++) {

            int newDir =
                    (dir + i) % 4;

            int nr =
                    row + dirs[newDir][0];

            int nc =
                    col + dirs[newDir][1];

            if (!visited.contains(
                    nr + "," + nc)
                && robot.move()) {

                backtrack(
                        robot,
                        nr,
                        nc,
                        newDir
                );

                goBack(robot);
            }

            robot.turnRight();
        }
    }

    void goBack(Robot robot) {

        robot.turnRight();
        robot.turnRight();

        robot.move();

        robot.turnRight();
        robot.turnRight();
    }
                  }
