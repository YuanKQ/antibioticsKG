/******************************
 * User: yuan
 * Date: 17-10-11 上午9:13
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.json;

public class DataStatus {
    /*
    * 调用结果的状态信息
    * code: 调用状态码, 0表示成功, 非零表示分别表示各种错误信息
    * msg: 调用状态信息, 当code=true, 显示成功信息; 当code=false, 显示错误信息.
    * */
    protected int code;
    protected String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public DataStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
