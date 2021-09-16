package org.paymob.onlineshop.dto;

import java.util.List;

public class ResponseModel {
    private Long count;
    private List data;

    public ResponseModel(Long count,List data){
        this.count = count;
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
