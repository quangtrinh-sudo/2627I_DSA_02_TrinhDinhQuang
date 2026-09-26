import java.util.ArrayList;
import java.util.List;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;

    private DoublingTest() { }

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        int ignore = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        List<Double> nList = new ArrayList<>();
        List<Double> tList = new ArrayList<>();

        StdDraw.setCanvasSize(800, 400);
        StdDraw.setPenRadius(0.01);

        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);

            nList.add((double) n);
            tList.add(Math.max(time, 0.001)); // Tránh log(0)

            drawPlot(nList, tList);
        }
    }

    private static void drawPlot(List<Double> N, List<Double> T) {
        StdDraw.clear();
        int sz = N.size();
        
        double maxN = N.get(sz - 1), maxT = T.get(sz - 1);
        double minLN = Math.log(N.get(0)), maxLN = Math.log(maxN);
        double minLT = Math.log(T.get(0)), maxLT = Math.log(maxT);

        // Kẻ trục ngăn cách 2 đồ thị
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.line(0.5, 0, 0.5, 1);

        for (int i = 0; i < sz; i++) {
            // 1. Đồ thị Chuẩn (nửa trái [0, 0.5])
            double x1 = 0.05 + 0.4 * (N.get(i) / maxN);
            double y1 = 0.1 + 0.8 * (T.get(i) / maxT);

            // 2. Đồ thị Log-Log (nửa phải [0.5, 1])
            double logN = Math.log(N.get(i)), logT = Math.log(T.get(i));
            double x2 = 0.55 + (maxLN == minLN ? 0 : 0.4 * (logN - minLN) / (maxLN - minLN));
            double y2 = 0.1 + (maxLT == minLT ? 0 : 0.8 * (logT - minLT) / (maxLT - minLT));

            // Vẽ điểm
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(x1, y1);
            StdDraw.point(x2, y2);

            // Nối đường
            if (i > 0) {
                double px1 = 0.05 + 0.4 * (N.get(i - 1) / maxN);
                double py1 = 0.1 + 0.8 * (T.get(i - 1) / maxT);
                
                double pLogN = Math.log(N.get(i - 1)), pLogT = Math.log(T.get(i - 1));
                double px2 = 0.55 + (maxLN == minLN ? 0 : 0.4 * (pLogN - minLN) / (maxLN - minLN));
                double py2 = 0.1 + (maxLT == minLT ? 0 : 0.8 * (pLogT - minLT) / (maxLT - minLT));

                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.line(px1, py1, x1, y1);
                StdDraw.line(px2, py2, x2, y2);
            }
        }
    }
}