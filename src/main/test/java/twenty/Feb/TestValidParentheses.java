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

        // 中文常见字
        String s = "你";
       // 用utf8存储 -3个字节
      //  用存储utf16 4个字节
        // 疑问, s.length 返回码元的长度, 但是无论是utf8还是utf16都不对啊,
        // utf8(1个字节一个码元)应该是返回3, utf16(2个字节个一个码元)应该返回2
        // 但是这个方法却返回1.   看来码元和实际byte存储没有关系, 应该和utf16的编码方案有关系
        System.out.println("1. string length =" + s.length());
        System.out.println("1. string bytes length =" + s.getBytes(Charset.forName("UTF-16BE")).length);
        System.out.println("1. string char length =" + s.toCharArray().length);
        System.out.println();
        // emojis
        s = "👦";
        System.out.println("2. string length =" + s.length());
        System.out.println("2. string bytes length =" + s.getBytes().length);
        System.out.println("2. string char length =" + s.toCharArray().length);
        System.out.println();
        // 中文生僻字
        s = "𡃁";
        System.out.println("3. string length =" + s.codePointCount(0, s.length()));
        System.out.println("3. string bytes length =" + s.getBytes(Charset.forName("UTF-16BE")).length);
        System.out.println("3. string char length =" + s.toCharArray().length);
        System.out.println();

        Character ss = '你';





    }
}
