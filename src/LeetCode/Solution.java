package LeetCode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ZhongLingYun
 * @Title: Solution
 * @Description: 有效括号问题
 * @date 2018/11/213:59
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("请输入需要判断的有效括号字符串");
        String str=scanner.next();
        // 使用Java自带的栈
        Stack<Character> stack= new Stack<>();
        char[] characters=str.toCharArray();
        for (char c:characters) {
            if(c=='{'||c=='['||c=='('){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    System.out.println("不符合括号匹配,栈中左边括号为空");
                    return;
                }else {
                   if(c=='}'||c==']'||c==')'){
                       // 从栈中拿出一个
                       char pop=stack.pop();
                        if(!(c=='}'&&pop=='{')){
                            if(!(c==')'&&pop=='(')){
                                if(!(c==']'&&pop=='[')){
                                    System.out.println("不符合匹配规则");
                                    return;
                                }
                            }
                        }
                   }
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("符合括号匹配规则");
        }else {
            System.out.println("不符合括号匹配规则,栈中剩余左括号");
        }
    }
}
