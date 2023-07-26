import java.io.BufferedInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//
//        }

        List<Integer> a = new ArrayList<>();
        a.add(234);
        a.add(12);
        a.add(56);
        a.add(7878);

        a.sort(Comparator.comparingInt(o -> o));
        a.remove(0);
        System.out.println(a);
    }
}
