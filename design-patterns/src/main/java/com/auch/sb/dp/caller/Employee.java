package com.auch.sb.dp.caller;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2023/6/6 09:41
 */
public class Employee {

//    private CallBackInterface callBack = null;

//    //注册回调
//    public  Employee(CallBackInterface callBack) {
//        this.callBack = callBack;
//    }

    //
    public void doSome(CallBackInterface callBack) {
        for (int i = 0; i < 10; i++) {
            System.out.println("第【" + i + "】事情干完了！");
        }
        // 注入+ 扩展
        callBack.execute();
    }
}
