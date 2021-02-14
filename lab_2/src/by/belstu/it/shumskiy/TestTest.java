package by.belstu.it.shumskiy;

import java.util.Objects;

public class TestTest {

    @Override
    public boolean equals(Object o) {
        return this.getTestProp().equals(((TestTest) o).getTestProp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(TestProp);
    }

    @Override
    public String toString() {
        return "TestTest{" +
                "TestProp='" + TestProp + '\'' +
                '}';
    }

    private String TestProp;

    public String getTestProp() {
        return TestProp;
    }

    public void setTestProp(String testProp) {
        TestProp = testProp;
    }

    public TestTest(String prop) {
        setTestProp(prop);
    }

    public String TestFunction(){
        ExtractedMethod();
        return "Hi";

    }

    private void ExtractedMethod() {
        for (int i = 0; i < 10; i++){
            System.out.println("hi" + i);
        }
    }
}
