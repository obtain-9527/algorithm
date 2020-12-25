package sword.ffingers;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * input [3,4,5,1,2]
 * 1
 */
public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        int start=0;
        int end=array.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(end-start==1)
                return array[end];
            if(array[mid]>=array[start])
                start=mid;
            if(array[mid]<=array[end])
                end=mid;
        }
        return -1;
    }
   public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
       System.out.println(minNumberInRotateArray(array));

    }
}
