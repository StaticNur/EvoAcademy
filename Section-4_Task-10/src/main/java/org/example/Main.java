package org.example;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Nokia 9", "HMD Global",150),
                new Phone("Galaxy S9", "Samsung", 300));
        phoneStream.sorted(new SortPhone()).forEach(s -> System.out.printf("%s (%s) - %d \n",
                s.getName(), s.getCompany(), s.getPrice()));
    }
}
class SortPhone implements Comparator<Phone>{
    @Override
    public int compare(Phone a, Phone b) {
        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}
class Phone{
    private String name;
    private String company;
    private Integer price;

    public Phone(String name, String company, Integer coast) {
        this.name = name;
        this.company = company;
        this.price = coast;
    }

    public String getCompany() {
        return company;
    }
    public String getName() {
        return name;
    }
    public Integer getPrice() {
        return price;
    }
}





/*Task 2
public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int[][] maze = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            // Используем BFS для поиска кратчайшего пути
            int result = shortestPath(maze, x1, y1, x2, y2);

            System.out.println(result);
        }

        private static int shortestPath(int[][] maze, int x1, int y1, int x2, int y2) {
            int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // Вверх, вниз, влево, вправо

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[maze.length][maze[0].length];

            queue.offer(new int[]{y1, x1, 0}); // Координаты и длина пути
            visited[y1][x1] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentY = current[0];
                int currentX = current[1];
                int pathLength = current[2];

                if (currentX == x2 && currentY == y2) {
                    return pathLength;
                }

                for (int[] dir : directions) {
                    int newY = currentY + dir[0];
                    int newX = currentX + dir[1];

                    // Проверяем, что новые координаты находятся в пределах лабиринта и ячейка проходима
                    if (isValid(newY, newX, maze.length, maze[0].length) && maze[newY][newX] == 0 && !visited[newY][newX]) {
                        queue.offer(new int[]{newY, newX, pathLength + 1});
                        visited[newY][newX] = true;
                    }
                }
            }
            return 0;
        }

        private static boolean isValid(int y, int x, int N, int M) {
            return y >= 0 && y < N && x >= 0 && x < M;
        }*/
/*Task 1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] cookies = new int[n];
        for (int i = 0; i < n; i++) {
            cookies[i] = scanner.nextInt();
        }
        //бинарный поиск для поиска минимального значения K
        int left = 1;
        int right = 10_000;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canEatAll(cookies, m, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
    private static boolean canEatAll(int[] cookies, int M, int K) {
        for (int i = 0; i < cookies.length; i++) {
            M -= (cookies[i] + K - 1) / K;
        }
        return M >= 0;
    }*/

