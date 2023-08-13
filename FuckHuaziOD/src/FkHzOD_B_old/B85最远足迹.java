package FkHzOD_B_old;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * B|85|最远足迹|数据结构|100|
 * 某探险队负责对地下洞穴进行探险。探险队成员在进行探险任务时，随身携带的记录器会不定期地记录自身的坐标，
 * 但在记录的间《中也会记录其他数据。探索工作结束后，探险队需要获取了其探险过程中相对于探险队总部的最远的足迹位置。
 * 仪器记录坐标时，坐标的数据格式为(x,y)，如(1,2)、(100,200)，其中0<S<1000，0<y<1000，
 * 同时存在非法坐标，如(01.1).(1,01)，(0,100)属于非法坐标。
 * 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为 x * x + y * y；
 * 若两个坐标相对总部的距离相同，则第一次到达的坐标为最远足迹；
 * 若记录仪中的坐标全都不合法，输出总部坐标(0,0)
 *
 * 输入：字符串，记录仪中数据，ferga13fdsf3(100,200)f2r3rfasf(300,400)
 * 输出：字符串，最远足迹到达的坐标，如(300,400)
 *
 * 示例1：ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)
 * 输出：(5,10)
 * 示例2：asfefaweawfaw(0,1)fe
 * 输出(0,0)
 *
 * 思路：
 * 直接遍历字符串，找到左右括号，
 * 判断是否有效，然后找最大
 *
 *
 */
public class B85最远足迹 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ipstr = in.nextLine();
        char[] ip = ipstr.toCharArray();
        double max = 0;
        int maxX = 0;
        int maxY = 0;
        List<String> list = new ArrayList<>();
        String coord = "";
        for (int i = 0; i < ip.length; i++) {
            if (ip[i] == '(') {
                int start = i;
                while (ip[i] != ')') {
                    i++;
                }
                coord = ipstr.substring(start + 1, i);
                list.add(coord);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(",");
            if (split[0].charAt(0) != '0' && split[1].charAt(0) != '0') {
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                if (x != 0 && y != 0) {
                    double distance = Math.pow(x, 2.0) + Math.pow(y, 2.0);

                    if (max < distance) {
                        max = distance;
                        maxX = x;
                        maxY = y;
                    }
                }
            }
        }

        System.out.println("(" + maxX + "," + maxY + ")");
    }
}
