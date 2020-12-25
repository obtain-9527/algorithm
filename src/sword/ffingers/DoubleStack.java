package sword.ffingers;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class DoubleStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    private boolean isF = false;

    /**
     * 全双工做法-》半双工做法是将一个固定为push 一个固定为输出
     * @param node
     */
    public void push(int node) {
        if(stack1.isEmpty() && !stack2.isEmpty()){
            if(isF) {
                int size = stack2.size();
                for (int i = 0; i < size; i++) {
                    stack1.push(stack2.pop());
                }
                isF = false;
                stack1.push(node);
            }else{
                stack2.push(node);
            }

        }else {
            if(isF) {
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    stack2.push(stack1.pop());
                }
                isF = false;
                stack2.push(node);
            }else{
                stack1.push(node);
            }

        }
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return 0;
        }
        if(!stack1.isEmpty()){
            if(!isF) {
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    stack2.push(stack1.pop());
                }
                isF = true;
                return stack2.pop();
            }
            return stack1.pop();
        }
        if(!stack2.isEmpty()){
            if(!isF) {
                int size = stack2.size();
                for (int i = 0; i < size; i++) {
                    stack1.push(stack2.pop());
                }
                isF = true;
                return stack1.pop();
            }
            return stack2.pop();
        }
        return 0;
    }

    public static void main(String[] args) {
        DoubleStack doubleStack = new DoubleStack();
        doubleStack.push(1);
        doubleStack.push(2);
        doubleStack.push(3);
        System.out.println(1 + "-" + doubleStack.pop());
        System.out.println(doubleStack.pop());
        doubleStack.push(4);
        System.out.println(doubleStack.pop());
        doubleStack.push(5);
        System.out.println(doubleStack.pop());
        System.out.println(doubleStack.pop());
    }
}
