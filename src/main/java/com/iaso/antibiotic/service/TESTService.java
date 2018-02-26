/******************************
 * User: yuan
 * Date: 17-11-14 下午3:17
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package com.iaso.antibiotic.service;

import com.iaso.antibiotic.exception.DuplicateResourceException;
import com.iaso.antibiotic.json.DataTEST;
import com.iaso.antibiotic.model.TESTRestful;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TESTService {
    private static final AtomicInteger countId = new AtomicInteger();
    private static List<TESTRestful> restfulArrayList = new ArrayList<TESTRestful>();
    static {
        restfulArrayList.add(new TESTRestful(countId.incrementAndGet(), "pi", 3.14, "circumference ratio"));
        restfulArrayList.add(new TESTRestful(countId.incrementAndGet(), "toothbrush", 68.0, "The price of a toothbrush."));
        restfulArrayList.add(new TESTRestful(countId.incrementAndGet(), "shoe", 168.9, "The price of a pair of shoe."));
    }
    public DataTEST createResource(TESTRestful dataTEST) throws DuplicateResourceException{
        if (findByName(dataTEST.getName()) != -1)
            throw new DuplicateResourceException(dataTEST.getName());
        int newId = countId.incrementAndGet();
        restfulArrayList.add(new TESTRestful(newId, dataTEST));
        return new DataTEST(0, "success", dataTEST, String.format("/api/TEST/%d", newId));
    }


    private int findByName(String name) {
        int index = 0;
        for (TESTRestful testRestful: restfulArrayList) {

            if (testRestful.getName().equalsIgnoreCase(name))
                return index;
            index ++;
        }
        return -1;
    }


    public DataTEST updateResource(TESTRestful testRestful) {
        int index = findByName(testRestful.getName());
        if (index == -1)
            throw new NullPointerException(testRestful.getName());

        int before = restfulArrayList.get(index).getId();
        TESTRestful newTESTRestful = new TESTRestful(before, testRestful);
        restfulArrayList.set(index, newTESTRestful);
        return new DataTEST(0, "success", newTESTRestful, String.format("/api/TEST/%d", before));
    }


    public DataTEST deleteResource(int id) {
        for (Iterator<TESTRestful> iterator = restfulArrayList.iterator(); iterator.hasNext();){
            TESTRestful testRestful = iterator.next();
            if (testRestful.getId() == id) {
                iterator.remove();
                return new DataTEST(0, "success", testRestful, String.format("Delete /api/TEST/%d", id));
            }
        }

        throw new NullPointerException(Integer.toString(id));
    }
}
