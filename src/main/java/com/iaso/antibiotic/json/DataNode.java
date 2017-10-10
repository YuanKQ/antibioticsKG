/******************************
 * User: yuan
 * Date: 17-10-10 下午5:16
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.json;

public class DataNode {
    /**
     * 数据节点: 用于api调用时返回节点数据
     * code: 调用状态码, 0表示成功, 非零表示分别表示各种错误信息
     * msg: 调用状态信息, 当code=true, 显示成功信息; 当code=false, 显示错误信息.
     * data: 查询的节点信息
     */
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public DataNode(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
