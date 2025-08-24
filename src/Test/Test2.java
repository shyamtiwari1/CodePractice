package Test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        int[] numberOfContainers = new int[]{10, 20, 30, 40, 50};
        int length = 5, width = 10, height = 5;

        List<List<Coordinates>> ans = arrangements(numberOfContainers, length, width, height);
        for (int port = 0; port < ans.size(); port++) {
            System.out.println("Port" + (port + 1) + " containers:");
            System.out.println(ans.get(port));
        }
    }

    public static List<List<Coordinates>> arrangements(int[] numberOfContainers, int length, int width, int height) {
        List<List<Coordinates>> ans = new ArrayList<>();
        int currentPort = 0;
        int containersInCurrentPort = 0;
        List<Coordinates> temp = new ArrayList<>();

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                for (int z = 0; z < height; z++) {
                    if (currentPort >= numberOfContainers.length) {
                        break;
                    }

                    temp.add(new Coordinates(x, y, z));
                    containersInCurrentPort++;

                    if (containersInCurrentPort == numberOfContainers[currentPort]) {
                        ans.add(temp);
                        temp = new ArrayList<>();
                        containersInCurrentPort = 0;
                        currentPort++;
                    }
                }
            }
        }
        if (!temp.isEmpty() && currentPort < numberOfContainers.length) {
            ans.add(temp);
        }

        return ans;
    }

    public static class Coordinates {
        int x, y, z;

        public Coordinates(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + "," + z + ")";
        }
    }
}
