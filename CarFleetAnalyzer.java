import java.util.Arrays;

public class CarFleetAnalyzer {

    static class Car {

        int position;
        int speed;
        double arrivalTime;

        Car(int position, int speed, int target) {

            this.position = position;
            this.speed = speed;

            this.arrivalTime =
                    (double) (target - position)
                            / speed;
        }
    }

    public int carFleet(
            int target,
            int[] position,
            int[] speed) {

        int n = position.length;

        Car[] cars =
                new Car[n];

        for (int i = 0; i < n; i++) {

            cars[i] =
                    new Car(
                            position[i],
                            speed[i],
                            target
                    );
        }

        Arrays.sort(
                cars,
                (a, b) ->
                        b.position - a.position
        );

        int fleets = 0;
        double currentTime = 0;

        for (Car car : cars) {

            if (car.arrivalTime > currentTime) {

                fleets++;
                currentTime = car.arrivalTime;
            }
        }

        return fleets;
    }

    public static void main(String[] args) {

        CarFleetAnalyzer solver =
                new CarFleetAnalyzer();

        int target = 12;

        int[] position = {
                10,
                8,
                0,
                5,
                3
        };

        int[] speed = {
                2,
                4,
                1,
                1,
                3
        };

        System.out.println(
                solver.carFleet(
                        target,
                        position,
                        speed
                )
        );
    }
}
