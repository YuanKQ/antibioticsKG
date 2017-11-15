/******************************
 * User: yuan
 * Date: 17-11-14 上午11:59
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.json;

import com.iaso.antibiotic.model.TESTRestful;

public class DataTEST extends DataStatus {
    public DataTEST(int code, String msg) {
        super(code, msg);
    }
    private TESTRestful data;
    private String link;

    public DataTEST(int code, String msg, TESTRestful data, String link) {
        super(code, msg);
        this.data = data;
        this.link = link;
    }



    public TESTRestful getData() {
        return data;
    }

    public void setData(TESTRestful data) {
        this.data = data;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
