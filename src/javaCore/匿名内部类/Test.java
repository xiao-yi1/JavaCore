package javaCore.匿名内部类;
public class Test {
    private  int id=99;


    public int largestRectangleArea() {
        return 10;

    }
    public static void main(String[] args) {

        Test test1 = new Test()
        {
            public String name="张三";
            public int sq = 01;
            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

        };
        //test1无法访问name属性？？？？
        System.out.println(test1);
    }
}



