package com.phoenixB2B.pojo.qc;

//Request URL: http://139.59.91.96:9000/v1/qc Method : POST

import com.google.gson.Gson;
import com.phoenixB2B.intefaces.IBody;

public class QcComplete implements IBody {
    private int job_id;

    public QcComplete(int job_id) {
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
        return "QcComplete{" +
                "job_id=" + job_id +
                '}';
    }

    @Override
    public String toJson() {
        Gson gs = new Gson();
        return gs.toJson(new QcComplete(job_id));
    }
}
