package twenty;

/**
 * Created by logan on 2020/3/30.
 */
public class Bar implements Cloneable{

    private String aa = "aa";

    private Integer ff = 2;

    private Bar2 bar2;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public Integer getFf() {
        return ff;
    }

    public void setFf(Integer ff) {
        this.ff = ff;
    }

    public Bar2 getBar2() {
        return bar2;
    }

    public void setBar2(Bar2 bar2) {
        this.bar2 = bar2;
    }

    @Override
    protected Bar clone() throws CloneNotSupportedException {
        return (Bar)super.clone();
    }
}
