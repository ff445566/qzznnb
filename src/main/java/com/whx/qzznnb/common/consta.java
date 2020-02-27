package com.whx.qzznnb.common;


/**
 * 接口返回类
 */
public class consta {
    public static final String CURRENT_USER = "currentuser";
    public static final String  EMAIL="email";
    public static final String  USERNAME="username";

    public interface role {
        int Role_custome = 0; // 普通用户
        int Role_Admin = 1;    //  管理者

    }
    public interface  CartCheck{
       int  CHECK=1; // 1b表示选中状态
        int UnCHECK=0;
    }
    public interface Cartquanlity{
       String   Limitquanlity_Enough= "enough";
       String    Limitquanlity_NOTEnough= "notenough";
    }

    public interface  productListOrder{
         //Set<String> set= Sets.newHashSet("price_desc","price_asc");
    }

    public  enum getProductStatus{
        NO_STATUS(1,"产品在线");
        private int status;
        private String value;
         getProductStatus(int status,String value){
                  this.status=status;
                  this.value=value;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
