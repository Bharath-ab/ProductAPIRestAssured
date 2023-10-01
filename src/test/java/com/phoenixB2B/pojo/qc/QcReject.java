package com.phoenixB2B.pojo.qc;

//http://139.59.91.96:9000/v1/qc/reject Method Post

public class QcReject {
    private int job_id;

    public QcReject(int job_id) {
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
        return "QcReject{" +
                "job_id=" + job_id +
                '}';
    }
}
