public class Test {
    public static void main(String[] args) {
        String str1 = "ab";
        changeString(str1);
        str1 = str1 + "ccc";
        System.out.println("str="+str1);
    }

    private static void changeString(String str) {
        str = "cd";
        //str = "cd";是被解释为如下：
        //str = new String("cd");
    }
}
