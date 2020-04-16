package twenty;

import com.google.common.collect.Lists;
import twenty.Jan.TestSum;

import java.util.List;

/**
 * Created by logan on 2020/2/7.
 */
public class Foo {

    public int a = 0;

    public Foo(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "a=" + a +
                '}';
    }

    public static void cascade() {
        List<String> list = Lists.newArrayList();
        int i = 0;
        while(true) {
            list.add(("ffff" + (++i)).intern());
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Bar bar = new Bar();
        System.out.println(bar.getAa());
        System.out.println(bar.getFf());
        bar.setBar2(new Bar2());
        System.out.println(bar.getBar2().getStr());
        System.out.println("=============");
        Bar cloneBar = bar.clone();
        bar.getBar2().setStr("8888");
        System.out.println(cloneBar.getAa());
        System.out.println(cloneBar.getFf());
        System.out.println(cloneBar.getBar2().getStr());
        System.out.println("=============");
        System.out.println("equals:" + bar.equals(cloneBar));
    }
}
