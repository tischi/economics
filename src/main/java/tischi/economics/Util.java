package tischi.economics;

import java.util.ArrayList;

public class Util {
    public static ArrayList<Integer> makeSteps(int numSteps) {
        final ArrayList<Integer> steps = new ArrayList<>();

        for (int i = 0; i < numSteps; i++) {
            steps.add(i);
        }
        return steps;
    }
}
