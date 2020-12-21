package sword.ffingers;

/**
 * 算法题目1: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * 39n≤39  0，1，1，2，3，5，8
 * 1.解析此提 此时可见时间复杂的为2的n次方
 *               n = 4
 *        n = 3    +    n = 2
 *     n = 2 + n = 1  n = 1 + n = 0
 *n = 1 + n = 0
 *
 */
public class Fabonacci {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        System.out.println(fabonacci(40));
        long end1 = System.currentTimeMillis();
        System.out.println("fabonacci使用时间为：" + (end1- start1));
        long start2 = System.currentTimeMillis();
        System.out.println(optimizationFabonacci(40));
        long end2 = System.currentTimeMillis();
        System.out.println("optimizationFabonacci使用时间为：" + (start2-end2));
    }

    /**
     * 常规操作直接递归得到
     * @param n
     * @return
     */
    public static int fabonacci(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        return fabonacci(n - 1) + fabonacci(n - 2);

    }

    /**
     * 优化做法
     * 1.思想是保存两个之然后往上推出最后结果
     * 初始化2个书 a=0，b=1;
     * 让    h= a+b;推出下一个值
     * 循环解决问题此复杂度应该为n
     */
    public static int optimizationFabonacci(int n){
        int num = 0;
        int a = 0;
        int b = 1;
        //初始时已经与两个值a与b 已经有值所以需要循环必须减少
        for (int i = 0; i < n-1; i++) {
            //推出下以为值
            num = a + b;
            //保留上一次的结果便于下一次值的出现
            a = b;
            //相同
            b = num;
        }
      return num;
    }
}
