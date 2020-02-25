package twenty.Feb;

import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Created by logan on 2020/2/10.
 */
public class TestCharacter {


    @Test
    public void testCharacter() throws Exception {
        // 中文常见字
        String s = "你";
        // 用utf8存储 -3个字节
        //  用存储utf16 4个字节
        // 疑问, s.length 返回码元的长度, 但是无论是utf8还是utf16都不对啊,
        // utf8(1个字节一个码元)应该是返回3, utf16(2个字节个一个码元)应该返回2
        // 但是这个方法却返回1.   看来码元和实际byte存储没有关系, 应该和utf16的编码方案有关系
        System.out.println("1. string length =" + s.length());
        System.out.println("1. string bytes length =" + s.getBytes().length);
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
        System.out.println("3. string bytes length =" + s.getBytes().length);
        System.out.println("3. string char length =" + s.toCharArray().length);
        System.out.println();
    }

    public static void main(String[] args) {
        // 线程不安全的,快速的
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
        System.out.println(builder.toString());

        StringBuilder buffer = new StringBuilder();
        buffer.append("a");
        buffer.append("b");
        System.out.println(buffer.toString());

        String fff = "fff";
        String aaa = new String("fff");
        System.out.println(fff.equals(aaa));

    }
}
