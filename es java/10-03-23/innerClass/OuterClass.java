package innerClass;

/**
 * InnerinnerClass
 */
public class OuterClass {
    int x = 10;

    void getPrivInner() {
        PrivInner priv = new PrivInner();
        System.out.println(priv.b);
    }

    public class InnerClass {
        int y = 5;
    }

    private class PrivInner {
        int b = 8;
    }

    static class StaticInner {
        int b = 8;
    }
}
