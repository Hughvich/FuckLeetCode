package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * B96|We Are A Team
 * 总共有n个人在机房，每个人有一个标号(1<=标号<=n)，他们分成了多个团队，需要你根据收到的m条消息判定指定的两个人是否在一个团队中，具体的:
 *
 * 1.消息构成为abc，整数a、b分别代表两个人的标号，整数c代表指令
 *
 * 2.c==0代表a和b在一个团队内
 *
 * 3.c==1代表需要判定a和b的关系，如果a和b是一个团队，输出一行’we are a team’,如果不是，输出一行'we are not a team'
 *
 * 4.c为其他值，或当前行a或b超出1~n的范围，输出da pian zi
 *
 * 输入描述
 *
 * 1.第一行包含两个整数n，m(1<=n,m<100000),分别表示有n个人和m条消息
 *
 * 2.随后的m行，每行一条消息，消息格式为:abc(1<=a,b<=n,0<=c<=1)
 *
 * 输出描述
 *
 * 1.c==1,根据a和b是否在一个团队中输出一行字符串，在一个团队中输出we are a team不在一个团队中输出'we are not a team'
 *
 * 2.c为其他值，或当前行a或b的标号小于1或者大于n时，输出字符串da pian zi
 *
 * 3.如果第一行n和m的值超出约定的范围时，输出字符串”Null“。
 *
 * 示例1：
5 7
1 2 0
4 5 0
2 3 0
1 2 1
2 3 1
4 5 1
1 5 1
 * 输出：
 * We are a team
 * We are a team
 * We are a team
 * We are not a team
 *
 * 示例2：
5 6
1 2 0
1 2 1
1 5 0
2 3 1
2 5 1
1 3 2
 * 输出：
 * We are a team
 * We are not a team
 * We are a team
 * da pian zi
 */
public class B96WeAreATeam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            lists.add(Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList()));
        }

        UF uf = new UF(n + 1);
        for (int i = 0; i < m; i++) {
            int a = lists.get(i).get(0);
            int b = lists.get(i).get(1);
            int c = lists.get(i).get(2);
            if (a < 1 || a > n || b < 1 || b > n)
                System.out.println("da pian zi");
            if (c == 0)
                uf.unionConnect(a,b);
            else if (c ==  1) {
                if (uf.find(a) == uf.find(b))
                    System.out.println("We are a team");
                else System.out.println("We are not a team");
            } else System.out.println("da pian zi");
        }

    }
}

class UF {
    int[] item;
    int result;

    public UF(int n) {
        item = new int[n + 1];
        result = n;
        for (int i = 0; i < n; i++) {
            item[i] = i;
        }
    }

    public int find (int x) {
        if (x != item[x])
            return item[x] = find(item[x]);
        return x;
    }

    // merge
    public void unionConnect(int x, int y) {
        int itemX = find(x);
        int itemY = find(y);

        if (itemX != itemY) {
            item[itemY] = itemX;
            result--;
        }
    }
}
