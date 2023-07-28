import java.io.BufferedInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
//        List<Integer> id = Arrays.stream(in.nextLine().split(",")).map(Integer::parseInt).toList();
        in.useDelimiter("[,\n]");
//        in.useDelimiter(",");

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a.add(in.nextInt());
        }

        a.stream().toString().replaceAll("^\\[+|\\]+$", "");
        System.out.println(a);
    }
}
