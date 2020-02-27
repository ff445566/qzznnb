package com.whx.qzznnb.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.io.Serializable;
/*
*简单的进行一个常用封装
*
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化对象 null 时不再接送序列化当中
public class ServeResponse<T> implements Serializable {
    private  String msg;
    private  int  status; //0  1
    private  T data;
    private  ServeResponse(int status){
        this.status=status;
    }
    private  ServeResponse(int status,String msg){
        this.status=status;
        this.msg=msg;
    }
    private  ServeResponse(int status,T data){
        this.status=status;
        this.data=data;
    }

    private  ServeResponse(int status,String msg,T data){
        this.status=status;
        this.msg=msg;
        this.data=data;
    }
      @JsonIgnore
    public boolean isSucess(){
        return  this.status==ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
    //
    public static  <T>ServeResponse<T> createBySuccess(){

        return new ServeResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static <T>ServeResponse<T> createBySuccessMessage(String msg){

        return new ServeResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T>ServeResponse<T> createBySuccess(T data){

        return new ServeResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T>ServeResponse<T> createBySuccess (String msg, T data){

        return new ServeResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    //错误
    public static <T>ServeResponse<T> createByError(){

        return new ServeResponse<T>(ResponseCode.Error.getCode(),ResponseCode.Error.getDesc());
    }
    public static <T>ServeResponse<T> createByErrorMessage(String  errormessage){

        return new ServeResponse<T>(ResponseCode.Error.getCode(),errormessage);
    }

    public static <T>ServeResponse<T> createByErrorCodeMessage(int errorcode,String errormessage){

        return new ServeResponse<T>(errorcode,errormessage);
    }
    public static <T>ServeResponse<T> createBySuccessCodeMessage(int successcode,String successmessage){

        return new ServeResponse<T>(successcode,successmessage);
    }
}
