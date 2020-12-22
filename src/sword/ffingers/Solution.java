package sword.ffingers;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 1，2，3，4
 * 5，6，7，8
 * 8，10，11，12
 * 13，14，15，16
 */
public class Solution {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},{5,6,7,8}};
        System.out.println(Find(7, arr));;
    }
    //时间复杂度为N + N = 2n;
    //两个for循环的话最差为N*N 因此该方法较好
    public static boolean Find(int target, int [][] array) {
        int len = array.length;
        if(len == 0){
            return false;
        }
        int hlen = array[0].length;
        if(hlen == 0){
            return false;
        }
        for(int i = 0; i < len; i++){
            if(target == array[i][hlen-1]){
                return true;
            }
            if(target < array[i][hlen-1]){
                for(int j = 0; j< hlen -1; j++){
                    if(target == array[i][j]){
                        return true;
                    }
                }
            }
        }
        return false;
    };
}
