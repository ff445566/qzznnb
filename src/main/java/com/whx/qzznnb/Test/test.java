package com.whx.qzznnb.Test;

/**
 * @ClassName test
 * @Description TODO
 * @Date 2019/11/9 13:39
 * @Version 1.0.0
 **/
public class test {

    private String name; //成员变量
    private  static  String stanam;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private  int  count;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public test(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        stanam="d";

        String vakem = " tttt";
        int i=1;
        test t = new test("name");
        t.setValeu1(vakem, t,i);
        System.out.println("第一种情况");
        System.out.println("vakem:  " + vakem);
        System.out.println("i:  " + i);
        System.out.println("name: " + t.getName());

        System.out.println("第二种情况");
        t.setValeu2(vakem, t,i);
        System.out.println("vakem:  " + vakem);
        System.out.println("i:  " + i);
        System.out.println("name: " + t.getName());
    }

    public void setValeu2(String vake, test t ,int x)  {
        x++;
        vake = "vake";
        t.setName("AA");
    }

    public void setValeu1(String vake, test t,int x) {
        vake = new String();
        x =6;
        t = new test("new name");
    }
}
