package com.example.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@SpringBootTest
class LogApplicationTests {

//    @Test
    void contextLoads() {
    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    class Letter {
        private String name;
        private int age;
        public Letter(int age){
            this.age = age;
        }
//        public   Letter  gs(Letter user){
//            return user;
//        }


    }
    @Autowired
    private RedisTemplate<String, Object> redisTemplate ;
    @Test
    public  void tedsss() {
//        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
//        RedisConnection connection = connectionFactory.getConnection();

        // 往Redis服务端中设置一个String类型的key，值为zhangsan
//       redisTemplate.opsForValue().set("name","zhangsan");
        // 获取并打印这个key的值
        System.out.println(redisTemplate.opsForValue().get("name"));



    }
    @Test
    public void test() {
        Letter user = new Letter("李白", 15);

        //Optional<String,Letter> u = Optional.ofNullable(user).flatMap(s -> ).map()

        //System.out.println(u);
        //Optional<Letter> letter1 = Optional.ofNullable(user);
        //
//        Cal c = (a,b) -> a * b;
//        int i = c.get(3, 4);
       // System.out.println(i);
//        Optional<String> s2 = Optional.ofNullable(user).map(Letter::getName).map(Letter::getName);
//        System.out.println(user);
//        Letter other =  Optional.of(user).orElse(null);
//        System.out.println(other);
//        Asd asd = Letter::new;
//        Letter tests = asd.tests("sds",12);
//        System.out.println(tests);
//        Function<Letter,Integer>  function = e -> e.getAge();
//        Object apply = function.apply(user);
//        System.out.println(apply );
//        Function<Integer,Letter>  function = Letter::new;
//        Object apply = function.apply(13);
//        System.out.println(apply );
//        Function<Integer,Letter>  function =age -> new Letter(age);
//        Object apply = function.apply(13);
//        System.out.println(apply );
       // Function<Letter,Letter> gs = user::gs;
//        Function<Letter, Letter> gs1 = user::gs;
//        Letter apply = gs1.apply(user);
//        System.out.println(apply);
//
//        Function<Letter,String>  function =e -> e.getName();
//        String apply = function.apply(user);
//        System.out.println(apply);
//        Function<Letter,String>  function =Letter::getName;
//        String apply = function.apply(user);
//        System.out.println(apply);
          Supplier<String> ss = user::getName;
          System.out.println( ss.get());
          Optional<String> s2 = Optional.ofNullable(user).map(Letter::getName);
          System.out.println( s2.orElse(null));

    }
     @Test
     public  void tes() {
         log.debug("This is debug message.");
         // 记录info级别的信息
         log.info("This is info message.");
         // 记录error级别的信息
         log.error("This is error message.");
     }
//    interface Cal {
//        int get(int a,int b);
//    }

    interface  Asd{
        Letter tests(Integer integer);


    }

    //古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
    //分析：通过简单的分析我们就可以发现，只有第一、二个月的兔子总数都为一，从第三个月开始，第n个月的兔子总数都是第（n-1）+（n-2）月的。

    @Test
    public  void test1() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第几月");
        int n = in.nextInt();
        //数组a存每个月对应的兔子总数
        int [] a = new int[n];
        //前两个月为1
        a[0]=a[1] = 1;
        for (int i = 2; i < n; i++) {
            a[i] = a[i-1] +a[i-2];
        }
        System.out.println("第"+n+"月兔子总数为:" + a[n-1]);


    }
    //判断101-200之间有多少个素数，并输出所有素数。
    //分析：素数又叫质数，质数是指在大于1的自然数中，除了1和它本身以外，不能被其他自然数整除的数
    //需要注意的点：在第二层for循环中，我用的判断条件是将j<i/2，其实用Math.sqrt(i)更好，可以减少程序的复杂度
    @Test
    public  void test2() {
        int j;
        for (int i = 101; i <= 200; i++) {
            //如果有整除i的数，会跳出循环，j == i/2为false就不会输出i，如果i为素数，一定为奇数，j == i / 2为true，会输出i
            for (j = 2; j < i / 2; j++) {
                if (i % j == 0){
                    break;
                }
            }
            if (j == i / 2) {
                System.out.println(i);
            }
        }

    }
    //打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
    //分析：根据题目我们可以锁定水仙花数的范围，然后将水仙花数的各位拆分，在判断该数是否是水仙花数
    //需要注意的点：对与我这种做法而言，将数拆分时不能直接在i下面赋值，这样a、b、c就是一个确定的数了。需要在for循环的内部定义，使每个i值都对应一个a、b、c

    @Test
    public  void test3() {
        for ( int i = 100; i <1000 ; i++) {
            int a = i/100;
            int b = i/10%10;
            int c = i%10;
            if (a*a*a + b*b*b + c*c*c == i){
                System.out.println(i);
            }

        }

    }
    //第四题：将一个正整数分解质因数。例如：输入90,打印出90=233 *5。
    //分析：分解质因数，只需要用输入的数n从2开始，慢慢往上除就行了
    //需要注意的点：以输入90为例，当i=3时，45/3=15，此时15%3==0，所以还需要以3为被除数，这就需要我们定义的被除数i不能使用一次就i++，具体怎么做请参照下面的程序

    @Test
    public  void test4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int n = sc.nextInt();
        int i = 2;
        while (n >= i) {
            if (n == i) {
                System.out.println(n);
                break;
            } else if (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            } else {
                i++;
            }
        }

    }
    //第五题：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
    //分析：条件运算符是唯一一个三目运算符，语法:语句1 if条件表达式else语句2。条件运算符在执行时，会先对条件表达式进行求值判断如果判断结果为true，就执行语句1，并返回执行结果。如果判断结果为false，就执行语句2，并返回执行结果。
    //需要注意的点：本题条件运算的返回结果是字符，所以grade应该定义为char

    @Test
    public  void test5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int n = sc.nextInt();
        char s = n >= 60 ? (n >= 90 ? 'A' :'B') :'C';
        System.out.println(s);

    }
    //第六题：输入两个正整数m和n，求其最大公约数和最小公倍数。
    //分析：其它的点都容易，主要是对最大公约数的求法，一般有三种算法，在这里我展示了两种，有兴趣的朋友可以查查
    //需要注意的点：在使用辗转相除法求最大公约数时需要事先知道两个数的大小关系，但用更相减损法的时候不需要知道两个数的大小关系。


    @Test
    public  void test6() {
        //辗转相除法
       Scanner sc = new Scanner(System.in);
       System.out.println("请输入两个数：");
       int a = sc.nextInt();
       int b = sc.nextInt();
        if (a < b) {
            int t;
            t = a;
            a = b;
            b = t;
        }
        int a1 = a, b1 = b;// 向a、b的原值保留用来求最小公倍数
        while (a1 % b1 != 0) {// 辗转相除法
            int temp = b1;
            b1 = a1 % b1;
            a1 = temp;
        }
        int c = a * b / b1;// 最小公倍数
        System.out.println("最大公约数为：" + b1 + ",最小公倍数为：" + c);


    }
    @Test
    public  void test06() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int a1 = a, b1 = b;// 向a、b的原值保留用来求最小公倍数
        while (a1 != b1) {// 更相减损法
            if (a1 > b1) {
                a1 -= b1;
            } else {
                b1 -= a1;
            }
        }
        int c = a * b / b1;// 最小公倍数
        System.out.println("最大公约数为：" + b1 + ",最小公倍数为：" + c);
    }

    //第七题：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
    //分析：这题主要是要历遍全部字符以及判断字符属于哪一类
    //需要注意的点：在Java中没有直接从键盘上接收char型字符的方法，因此我们在需要从键盘上接收字符时可以借助String类型的字符串，然后通过toCharArray()方法将之保存到char[]类型的数组中，或者自己写一个简单的方法来接收字符

    @Test
    public  void test7() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] > '0' && ch[i] < '9') {
                count1++;
            } else if ((ch[i] > 'a' && ch[i] < 'z') || (ch[i] > 'A' && ch[i] < 'Z')) {
                count2++;
            } else if (ch[i] == ' ') {
                count3++;
            } else {
                count4++;
            }
        }
        System.out.println("数字的个数为：" + count1);
        System.out.println("字符的个数为：" + count2);
        System.out.println("空格的个数为：" + count3);
        System.out.println("其它字符的个数为：" + count4);

    }

    //第八题：求s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
    //分析：这题主要是要得到各项的值
    //需要注意的点：无
    @Test
    public  void test8() {
        Scanner sc = new Scanner(System.in);
        //a的值
        int a = sc.nextInt();
        //加几次
        int b = sc.nextInt();
        int s =0;
        int [] n = new int[b];
        n[0] = a;
        for (int i = 1; i < b ; i++) {
            n[i] = a*(int)(Math.pow(10, i))+n[i-1];
        }
        for (int ds:n) {
            s+=ds;
        }
        System.out.println(s);


    }
    @Test
    public  void test08() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int b = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            b += a;
            sum += b;
            a *= 10;
        }
        System.out.println(sum);

    }
    //第九题：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程 找出1000以内的所有完数。
    //分析：因子就是除去这个数本身之外，所有可以被这个数整除的数
    //需要注意的点：在第一层for循环和第二层for循环之间需要让sum=0，不然会影响最后一个if（）对下一个值的判断
    @Test
    public  void test9() {
        int a =1;
        int sum =0;
        while (a < 1000){
            for (int i = 1; i < a; i++) {
                if(a%i==0){
                    sum+=i;
                }
            }
            if(a == sum){
                System.out.println(a);
            }
            sum =0;
            a++;
        }



    }

    //第十题：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
    //分析：第十次落地时反弹了九次
    //需要注意的点：无
    @Test
    public  void test10() {
        //距离地面的高度
        double a =100.0;
        double b ;
        //回弹到最高点经历的路程
        double sum = 0.0;
        for (int i = 1; i <= 10; i++) {
            b = a/2;
            sum += (a +b);
            a = b;
        }
        System.out.println("共"+(sum-a));
        System.out.println("高度"+a);

    }
    @Test
    public  void test010() {
        double h = 100, s = h;
        for (int i = 1; i < 10; i++) {
            h /= 2;
            s += (h * 2);
        }
        System.out.println("小球第十次落地时经过的路程为：" + s + "  第十次反弹的高度为:" + h / 2);
    }
    //第十一题：有1、2、3、4四个数字，能组成多少个互不相同且一个数字中无重复数字的三位数？并把他们都输入。
    //分析：这题只需用三层for循环即可
    //需要注意的点：无

    @Test
    public  void test11() {
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i != j && j != k && k != i) {
                        System.out.println(i * 100 + j * 10 + k);
                        count++;
                    }
                }
            }
        }
    }

    //第十二题：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；40万到60万之间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润，求应发放奖金总数？
    //分析：可以通过利润各部分提成的不同将利润分成不同的部分，再利用if语句解决
    //需要主要的点：不能用switch语句，我第一次就想用switch，结果编译器报错以下是截图
    //在这里插入图片描述
    //意思是switch（）括号里的形参变量不能是double类型的，只能是整型，字符串和枚举类型的

    @Test
    public  void test12() {


    }
    //第十三题：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
    //分析：如果一个正整数 a 是某一个整数 b 的平方，那么这个正整数 a 叫做完全平方数。零也可称为完全平方数。
    //需要注意的点： 这个数的取值可能不止一个，所以不能if语句条件成立后就跳出while循环，另外，i的可能取值要从-100开始


    @Test
    public  void test13() {

    }

    //第十四题：输入某年某月某日，判断这一天是这一年的第几天？
    //分析：这个问题主要是要判断出每个月的天数，另外平年和闰年的二月天数不同
    //需要注意的点：闰年可以被四整除但不可以被四百整除，或者可以被四百整除（因为截图的范围有限，所以看着比较挤）
    @Test
    public  void test14() {

    }

    //第十五题：输入三个整数x,y,z，请把这三个数由小到大输出。
    //分析：没什么好说的，这题可以用别的方法做，这里列出最直接的
    //需要注意的点：比较三次，大数到前面
    @Test
    public  void test15() {

    }

    //第十六题：输出9*9口诀。
    //分析：考for循环的嵌套
    //需要注意的点：一次内层循环结束后应该换行
    @Test
    public  void test16() {

    }
    //第十七题：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下 的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
    //分析：可以用for循环，也可以用方法的递归。
    //需要注意的点：用for循环时一共循环了九次

    @Test
    public  void test17() {

    }
    //第十八题：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
    //分析：通过三层for循环历遍所有可能性，通过题意设置判断语句
    //需要注意的点：在判断之前需要设置if语句排除三个队员重复参赛

    @Test
    public  void test18() {

    }

    //第十九题：打印出如下图案（菱形） （图形显示不了，不知道怎么弄，反正就是个星号组成的菱形，不知道的可以搜搜）
    //*
    //分析：本题主要考逻辑思维能力，将菱形分为上下两个部分，然后考虑每行输出空格和花的个数
    //需要注意的点：需要注意什么时候不换行，什么时候换行
    @Test
    public  void test19() {

    }

    //第二十题：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13…求出这个数列的前20项之和。
    //分析：可以看出，除第一项外，下一项的分子等于上一项的分子加上分母，下一项的分母等于上一项的分子
    //需要注意的点：对下一项的分子和分母复制时借助临时变量
    @Test
    public  void test20() {

    }
    //第二十一题：求1+2!+3!+…+20!的和。
    //分析：写个求阶乘的方法，再在循环中调用即可
    //需要注意的点：sum和m的值应该用long类型
    @Test
    public  void test21() {

    }
    //第二十二题：利用递归方法求5!。
    //分析：关键是递归的代码
    //需要注意的点：在截图中用的递归方法不是静态（static）的，所以如果想要使用需要先实例化这个方法所属于的类
    @Test
    public  void test22() {

    }
    //第二十三题：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？
    //分析：还是递归，和上一题差不多
    //需要注意的点：无
    @Test
    public  void test23() {

    }
    //第二十四题：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
    //分析：用String类型来接收数据更方便（对本题的要求来说）
    //需要注意的点：无

    @Test
    public  void test24() {

    }
    //第二十五题：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
    //分析：这题有很多种做法，我写的有点取巧，只是对这个题，题改一下就不行了
    //需要注意的点：无
    @Test
    public  void test25() {

    }

    //第二十六题：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续 判断第二个字母。
    //分析：可以用if或switch，用switch更简单一些，这里我直接用网上的代码了
    //需要注意的点：Java提供的方法里没有直接输入char型数值的方法，需要自己创建一个，当然，你也可以用其它方法

    @Test
    public  void test26() {

    }
    //第二十七题：求100之内的素数
    //分析：素数就是只能被1和自己整除的数
    //需要注意的点：对数的历遍需要从3开始，但数字2也是素数，所以需要提前输出2
    @Test
    public  void test27() {

    }
    //第二十八题：对10个数进行排序
    //分析：这种题很常见，有许多方法，比如冒泡法、选择法等
    //需要注意的点：注意下标
    //选择法：
    @Test
    public  void test28() {

    }
    //第二十九题：求一个3*3矩阵对角线元素之和
    //分析：用双层for循环，如果i==j就输出
    //需要注意的点：无
    @Test
    public  void test29() {

    }
    //第三十题：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
    //分析：关键是判断出输入的数应该在那个位置插入
    //需要注意的点：注意下标
    @Test
    public  void test30() {

    }
    //第三十一题：将一个数组逆序输出。
    //分析：这里我是默认数组是int类型的，
    //需要注意的点：无
    //第一种
    @Test
    public  void test31() {

    }
    //第三十二题：取一个整数a从右端开始的4～7位。
    //分析：用字符数组解决，简单直接
    //需要注意的点：最好判断一下输入的数字是否符合要求
    @Test
    public  void test32() {

    }

    //第三十三题：打印出杨辉三角形（要求打印出10行如下图）
    //1
    //1 1
    //1 2 1
    //1 3 3 1
    //1 4 6 4 1
    //1 5 10 10 5 1
    //…………
    //分析：除了第一行和每行第一个元素之外，其余的每行的第x个元素都等于上一行的的第x-1个元素和第x个元素之和
    //需要注意的点：需要注意最后两个for循环是如何输出的，输出了几个

    @Test
    public  void test33() {

    }

    //第三十四题：输入3个数a,b,c，按大小顺序输出。
    //分析：比较三次即可
    //需要注意的点：无
    @Test
    public  void test34() {

    }
    //第三十五题：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
    //分析：这里我默认输入的数组为int型的
    //需要注意的点：如果恰好最大的是最后一个并且最小的是第一个，那么交换两次会抵消，需要再交换一次
    @Test
    public  void test35() {

    }

    //第三十六题：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
    //分析：可以借助空数组
    //需要注意的点：代码只是提供一种思想，不一定要全盘照抄
    @Test
    public  void test36() {

    }

    //第三十七题：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
    //分析：定义一个布尔类型的数组然后用while循环选择出符合要求的数
    //需要注意的点：需要注意若是人数变量循环到末尾需使人数变量归零。
    @Test
    public  void test37() {

    }

    //第三十八题：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
    //分析：直接调用length方法即可，也可以用toCharArray()方法
    //需要注意的点：
    @Test
    public  void test38() {

    }
    //第三十九题：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+…+1/n,当输入n为奇数时，调用函数1/1+1/3+…+1/n(利用指针函数)
    //    分析：编写一个方法，根据输入数据的奇偶性执行不同的操作
    //    需要注意的点：求和时需要用double类型
    @Test
    public  void test39() {

    }
    //第四十题：字符串排序。
    //分析：和我们常做的int类型排序差不多，只是把int换成了String而已，只需用一个字符串比较的方法，再用冒泡法等方法排序 ，这里我直接把网上的代码改了改，我看的那个代码是写一个字符串比较的方法。
    //需要注意的点：无
    @Test
    public  void test40() {

    }

    //第四十一题：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
    //分析： 需要用循环，判定的条件为初始在执行运算后的数值可以被四整除，且该操作需连续四次判定为正确
    //需要注意的点：在得到结果后需跳出while循环

    @Test
    public  void test41() {

    }

    //第四十二题：809*??=800*??+9*??+1 其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果。
    //分析：原来题目的这个等式无解，去掉加一就有解了，但是这个等式也没有什么意义了，因为它对于任何数字都成立，所以只用管这题的第二个条件即可
    //需要注意的点：如果用while循环记得在得到结果后跳出循环，我在写的时候就经常犯这个错误

    @Test
    public  void test42() {

    }
    //第四十三题：题目：求0—7所能组成的奇数个数。
    ////组成1位数是4个。
    ////组成2位数是74个。
    ////组成3位数是784个。
    ////组成4位数是7884个。
    ////…
    //分析：虽然题目没有明说数字可不可以重复，但从下面组成数字的个数我们可以看出数字是可以重复的，直接用循环搞定
    //需要注意的点：注意条件是奇数

    @Test
    public  void test43() {

    }

    //第四十四题：一个偶数总能表示为两个素数之和。
    //分析：先写出求素数的方法
    //需要注意的点：由于用除sqrt(n)的方法求出的素数不包括2和3，因此在判断是否是素数程序中人为添加了一个3。
    @Test
    public  void test44() {

    }
//第四十五题：判断一个素数能被几个9整除 ，题目错了吧？能被9整除的就不是素数了！所以改成整数了。（这题目是我直接在网上复制的）
//分析：直接while，没什么好说的
//需要注意的点：无

    @Test
    public  void test45() {

    }


    //第四十六题：两个字符串连接程序
    //分析：直接用加号就行（我直接粘贴网上的代码了）
    //需要注意的点：无
    @Test
    public  void test46() {

    }

    //第四十七题：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。
    //分析：无（不想写了，直接粘贴网上的）
    //需要注意的点：最好加上对读取的数值的判断
    @Test
    public  void test47() {

    }

    //第四十八题：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。
    //分析：直接while即可
    //需要注意的点：需要判断输入的数字
    @Test
    public  void test48() {

    }


    //第四十九题：计算字符串中子串出现的次数
    //分析：先输入字符串和子串，再将所有字符串中所有符合子串长度的子串放在String数组中，最后进行比较
    //需要注意的点： 因为不计算重叠的子串，所以跳过配对之后的部分拆分子串，需要再配对成功后改变i的值
    @Test
    public  void test49() {

    }
    //第五十题：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），计算出平均成绩，把原有的数据和计算出的平均分数存放在磁盘文件 "stud "中。
    //分析：定义一个学生类，包含学生的信息和成绩和一个计算平均成绩的方法
    //需要注意的点
    @Test
    public  void test50() {

    }








}
