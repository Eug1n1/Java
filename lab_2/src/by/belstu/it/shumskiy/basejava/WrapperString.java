package by.belstu.it.shumskiy.basejava;

import java.util.Objects;

/**
 * @author eug1n1
 * @version 0.1
 */
public class WrapperString {

    private String str;

    @Override
    public String toString() {
        return "WrapperString{" +
                "str='" + str + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public WrapperString(String str) {
        this.str = str;
    }

    public void replace(char oldChar, char newChar)
    {
        str.replace(oldChar, newChar);
    }
}
