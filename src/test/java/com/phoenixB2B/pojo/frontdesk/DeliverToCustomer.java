package com.phoenixB2B.pojo.frontdesk;

import com.google.gson.Gson;
import com.phoenixB2B.intefaces.IBody;

//    URL to be use http://139.59.91.96:9000/v1/fd/delivertocustomer Method POST
public class DeliverToCustomer implements IBody {
    private int job_id;

    public DeliverToCustomer(int job_id) {
        this.job_id = job_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    @Override
    public String toString() {
        return "DeliverToCustomer{" +
                "job_id=" + job_id +
                '}';
    }

    public String toJson(){
        Gson gs = new Gson();
        return gs.toJson(new DeliverToCustomer(job_id));
    }
}
