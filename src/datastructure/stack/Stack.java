package datastructure.stack;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

/**
 * @Author weimin
 * @Date 2020/10/12 0012 17:55
 */
public class Stack {
    private Object[] data;
    private int top = -1;
    private int size;

    public Stack(int size) {
        this.size = size;
        data = new Object[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Object o) {
        if (isFull()) {
            throw new RuntimeException("the stack is full");
        }
        data[++top] = o;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("the stack is empty");
        }
        return data[top--];
    }

    public int count() {
        return top + 1;
    }

    public Object getTop() {
        if (isEmpty()) {
            throw new RuntimeException("the stack is empty");
        }
        return data[top];
    }

    public static int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static int opera(int num1, int num2, char oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isOpera(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    // 没有括号的
    public static int calculator(String s) {
        Stack number = new Stack(10);
        Stack operation = new Stack(10);
        char[] chars = s.toCharArray();

        String num = "";
        for (char c : chars) {
            if (isNumber(c)) {
                num = num + c;
            } else {
                number.push(Integer.parseInt(num));
                num = "";
                if (operation.isEmpty()) {
                    operation.push(c);
                } else {
                    if (priority(c) >= priority((char) operation.getTop())) {
                        operation.push(c);
                    } else {
                        char pop = (char) operation.pop();
                        int num2 = (int) number.pop();
                        int num1 = (int) number.pop();
                        int opera = opera(num1, num2, pop);
                        number.push(opera);
                        operation.push(c);

                    }
                }
            }
        }

        number.push(Integer.parseInt(num));
        while (!operation.isEmpty()) {
            char pop = (char) operation.pop();
            int num2 = (int) number.pop();
            int num1 = (int) number.pop();
            int opera = opera(num1, num2, pop);
            number.push(opera);
        }

        return (int) number.pop();
    }


    // "2-((2+4)-(3*(2+3)))+5"
    //处理带括号的
    public static int calculator1(String s) {
        Stack number = new Stack(10);
        Stack operation = new Stack(10);
        Stack kuohao = new Stack(10);

        char[] chars = s.toCharArray();

        String num = "";

        for (char c : chars){
            if(isNumber(c)){
                // 如果是数字，先不着急压入数栈，可能是多位数
                num = num + c;
            }else {
                if(!"".equals(num)){
                    number.push(Integer.parseInt(num));
                    num = "";
                }
                // 是运算符
                if(isOpera(c)){
                    if(operation.isEmpty()){
                        operation.push(c);
                    }else {
                        if(kuohao.isEmpty()){
                            if(priority(c)<=priority((char)operation.getTop())){
                                //
                                char pop = (char) operation.pop();

                                int num2 = (int) number.pop();
                                int num1 = (int) number.pop();
                                int opera = opera(num1, num2, pop);
                                number.push(opera);
                                operation.push(c);
                            }else {
                                operation.push(c);
                            }
                        }else {
                            operation.push(c);
                        }
                    }
                }else {
                    if(c =='('){
                        kuohao.push(c);
                    }else if(c==')'){
                        if(!operation.isEmpty()){
                            char pop = (char) operation.pop();

                            int num2 = (int) number.pop();
                            int num1 = (int) number.pop();
                            int opera = opera(num1, num2, pop);
                            number.push(opera);

                            kuohao.pop();
                        }

                    }
                }


            }
        }
        if(!"".equals(num)){
            number.push(Integer.parseInt(num));
        }

        while (!operation.isEmpty()){
            char pop = (char) operation.pop();

            int num2 = (int) number.pop();
            int num1 = (int) number.pop();
            int opera = opera(num1, num2, pop);
            number.push(opera);
        }


        return (int) number.pop();

    }

    //String s = "20/5+20*6-71";
    // 20,5,/,20,6,*,+,71,-
    public static void nibolan(String s){
        Stack number = new Stack(20);
        Stack operation = new Stack(10);

        char[] chars = s.toCharArray();

        String num = "";
        for (char c : chars){
            if(isNumber(c)){
                num = num + c;
            }
            else {
                if(!"".equals(num)){
                    number.push(num);
                    num = "";
                }

                if (isOpera(c)){
                    if (operation.isEmpty()){
                        operation.push(c);
                    }else {
                        if(priority(c)>=priority((char)operation.getTop())){
                            operation.push(c);
                        }else {
                            while (!operation.isEmpty()){
                                Object pop = operation.pop();
                                number.push(pop);
                            }
                            operation.push(c);
                        }
                    }
                }
            }
        }

        if(!"".equals(num)){
            number.push(num);
        }

        while (!operation.isEmpty()){
            Object pop = operation.pop();
            number.push(pop);
        }




    }

    public static void main(String[] args) {
        Stack number = new Stack(5);
        Stack operation = new Stack(5);

        //String s = "1+(2+6)*4-8";//25
        String s = "20/5+20*6-71";
        String ss = "2-((20+4)-(30*(2+3)))+5";


        //System.out.println(calculator(s));

        //System.out.println(calculator1(ss));

        nibolan(s);

    }


}
