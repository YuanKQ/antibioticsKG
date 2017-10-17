/******************************
 * User: yuan
 * Date: 17-10-10 下午5:16
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.json;

public class DataNode extends DataStatus{
    /**
     * 数据节点: 用于api调用时返回节点数据
     * data: 查询的节点信息
     */
    private Object data;

/*    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }*/

    public Object getData() {
        return data;
    }

    public DataNode(int code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }
}
