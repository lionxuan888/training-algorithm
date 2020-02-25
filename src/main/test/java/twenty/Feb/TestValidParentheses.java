package twenty.Feb;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by logan on 2020/2/8.
 */
public class TestValidParentheses {
    private static Map<Character,Character> map = new HashMap<Character,Character>();
    static {
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
    }

    /**
     * 此题目, 注意string的常用方法
     * 1. string如何迭代
     * 用 str.charAt(); 或者先转换成array, str.toCharArray(); 不过这个方法是通过复制了实现的,比较占用空间
     * 2 stack的peek方法, 先获取top上元素, 但是不弹出
     * @param
     * @return
     * */
    public static boolean isValid(String s) {

        if (s==null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if (!map.containsKey(currChar)) {
                stack.push(currChar);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (stack.pop().equals( map.get(currChar))) {
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({{}})";
        boolean valid = isValid(str);
        System.out.println("是否是有效的字符串:" + valid);





    }
}
