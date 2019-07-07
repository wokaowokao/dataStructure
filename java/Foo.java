public class Foo {
    public static void main(String[] args) {
        Hh h1 = new Hh(1);
        Hh h2 = new Hh(2);
        Hh h3 = h2;
        h3.setA(3);

        //值 和 引用
        //当调用方法是 如果传入的基本数据类型 则是值传递
        //如果是对象 则是对象的引用 在方法中 修改此值 原对象值会发生变化
        //修改此值 是值调用 类中方法修改值 setA等
        // 如果 用了= 则代表 打破了引用关系

        //


    }
}
