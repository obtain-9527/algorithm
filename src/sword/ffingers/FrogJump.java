package sword.ffingers;

/**
 * 题目描述: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 */
public class FrogJump {
    /**
     * 第一中解决方式：
     * f（1） = 1; f(2) = 2，{11, 2} ； f（3） =3， {111， 12， 21}； f(4)=5, {1111, 121, 112, 211, 22}
     *  f(n) = f(n-1) + f(n-2)
     */
    /**
     * 解决方法二：
     * 青蛙从倒序开跳：当开始青蛙跳1格的时候：可以跳到f（n-1）或者跳到f（n-2）而 f(n-1)有可以跳到发f（n-2）或者f(n-3)以此类推
     * 台阶fn
     * @param n
     * @return
     */
    public static int solve(int n){
        int total = 0;
        int a = 1;
        int b = 2;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n > 2){
            for (int i = 0; i < n-2; i++) {
                total = a + b;
                a = b;
                b = total;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(solve(4));
    }

    /**
     * 变态跳台阶问题：
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * 分析; f(n) = 可以有跳1或者2，或者3或者n步因此f(n) = f(n-1)+ f(n-2) + f(n -3) + ... +f(1)
     * f(n-1) = f(n-2) + f(n -3) + ... +f(1)
     * 因此可得到： f(n) = 2f(n-1);
     */
    public static int solve2(int n){
        int total = 0;
        int b = 2;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n > 2){
            for (int i = 0; i < n-2; i++) {
                total = 2 * b;
                b = total;
            }
        }
        return total;
    }
}
