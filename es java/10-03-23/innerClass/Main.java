package innerClass;
public  class Main {
    public static void main(String[] args) {
        OuterClass myOuter= new OuterClass();
        OuterClass.InnerClass inner = myOuter.new InnerClass();
        myOuter.getPrivInner();
        System.out.println(inner.y + myOuter.x);
    }
    
}
