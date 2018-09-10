import java.io.BufferedReader;

public class Test22 {

    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = "abc";
        if (s1==s2) System.out.println("1");
        else System.out.println(2);
        if (s1.equals(s2)) System.out.println(3);
        else System.out.println(4);
        System.out.println(s1);
        System.out.println(s2);
        Test22 test22 = new Test22();
        System.out.println(test22.hashCode());
        Test22 test23 = new Test22();
        System.out.println(test23.hashCode());
        Test22 test24 = new Test22();
        System.out.println(test24.hashCode());
        Test22 test25 = new Test22();
        System.out.println(test25.hashCode());
        System.out.println(s1.hashCode());
        System.out.println("ddd".hashCode());
        String s3 = new String("ccc");
        System.out.println(s3.hashCode());
    }
}
