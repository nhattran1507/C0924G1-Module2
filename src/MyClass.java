public class MyClass {
    private static int count= 0;
    public MyClass(){
        count++;
    }
    public static int getCount(){
        return count;
    }
    public static void main(String[] args){
        MyClass obj = new MyClass();
        MyClass obj2 = new MyClass();
        System.out.println(MyClass.getCount());
    }
}
