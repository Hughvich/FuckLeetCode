# 每个题所用到的‘技术’

### B1 德州扑克
- Map,HashMap各种用法，entrySet,getValue, getKey, 
- entrySet遍历方法:
  for (Map.Entry<String, Integer> entry:count.entrySet()){
      entry.getValue()
      ...
  }

### B2 字符串子序列II
- 字符串的处理：str.charAt()

### B3 分苹果
- 接收int的方法
  int num = Integer.parseInt(in.nextLine());
- Comparable和Comparator的用法：  
  将最小的挑出来：  
  weights.sort(Comparator.comparingInt(o -> o));  
  或者weights.sort((o1, o2) -> o1 - o2);
  或者weights.sort(Integer::compareTo);  
  倒序：weights.sort(Comparator.reverseOrder());
- 位运算：weightA = weightA ^ weights.get(i);
  * a = 0101
  * b = 1100
  * a &= b: a = 1100
  * |=: 1101
  * 异或^=: 1001
  * 非~
- 还有位运算的 >> <<右移 左移  

### B4 事件推送
- 用"" + [其他类型] 的格式将其他类型转换为字符串

### B5 路灯照明
- 保留小数的方法两种：
  * （不会四舍五入）String.format("%.2f",f);
  * （四舍五入，推荐）DecimalFormat df = new DecimalFormat("#.00");  
    df.format(f);

### B6 补活未成活胡杨
- 滑动窗口：LC#904
- https://zhuanlan.zhihu.com/p/61564531

### B7 统计射击比赛成绩
- 输入为 多行 1,2,3,4,5 这种可以用逗号和换行分隔符
  in.useDelimiter("[,\n]");
- 将以下这种两行输入转换为map，如3=[53,80,55],7=[68,16,100]这种
  * 3,3,7,4,4,4,4,7,7,3,5,5,5
  * 53,80,68,24,39,76,66,16,100,55,53,80,55
  ```
  // 生成map
  Map<Integer, List<Integer>> IDScore = new HashMap<>();
  for (int i = 0; i < N; i++) {
      // getOrDefault如果相同id，获取前面生成的列表，否则生成新的
      List<Integer> list = IDScore.getOrDefault(id.get(i), new LinkedList<>());
      list.add(score.get(i));
      IDScore.put(id.get(i), list);
  }
  ```
- 用.stream().filter()获取map里出现3次以上（value的list长度>=3）的entrySet对象，
  并且升降排序.sorted(lambda expression)
  ```
  IDScore.entrySet().stream().filter(x -> x.getValue().size() >= 3)
        .sorted((o1, o2) -> {
            Integer sum1 = sumScore(o1.getValue());
            Integer sum2 = sumScore(o2.getValue());
            if (sum1.equals(sum2))
                return o2.getKey() - o1.getKey(); // 相同分数按照id大小降序
            else
                return sum2 - sum1; // 分数降序
        })
  ```
- .map()方法使用
- 另一种排序：list.sort(Integer::compareTo);

### B8 高矮个子排队
- try-catch捕获非法输入情况
- 无限序列 转换成List集合的方法：
  Arrays.stream(in.nextLine().split(" "))
  .map(Integer::parseInt)
  .collect(Collectors.toList());
### B9 非严格递增连续数字序列
- char的比较：如果是数字，ch >= '0' && ch <= '9'
- 其他情况，如果是字母等，则取补集
### B10 最大股票收益
- 转换字符串为整数组： 
* 输入：2Y 3S 4S 6Y 8S
* 输出：[2,3,4,6,8]
- 单个char转为int，如果（int）强转，会变成ASCII码，如'2'对应50，
Integer.parInt(String.valueOf(x))
  或者 str.charAt(i) - '0'
  
### B11 （及以后的200分 先空着

### B12 单词重量
- 还是用到保留小数的处理，DecimalFormat可以四舍五入处理任何格式（double，float之类）


### B16 太阳能板最大面积
- 输入数据在多组量比较大的时候，用BufferedInputStream更快：
  Scanner in = new Scanner(new BufferedInputStream(System.in));
- 三目运算符简化：ip.get(left) < ip.get(right) ? ip.get(left++) : ip.get(right--);

### B17 整数对最小和
- arrays数组用IntStream求和：int sum = IntStream.of(nums).sum();

### B20 