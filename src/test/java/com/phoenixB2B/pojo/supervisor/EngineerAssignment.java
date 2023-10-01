package com.phoenixB2B.pojo.supervisor;

import com.google.gson.Gson;
import com.phoenixB2B.intefaces.IBody;

//Request URL: http://139.59.91.96:9000/v1/engineer/assign Method : POST
public class EngineerAssignment implements IBody {
    private int job_id;
    private int engineer_id;

    public EngineerAssignment(int job_id, int engineer_id) {
        this.job_id = job_id;
        this.engineer_id = engineer_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getEngineer_id() {
        return engineer_id;
    }

    public void setEngineer_id(int engineer_id) {
        this.engineer_id = engineer_id;
    }

    @Override
    public String toString() {
        return "EngineerAssignment{" +
                "job_id=" + job_id +
                ", engineer_id=" + engineer_id +
                '}';
    }

    @Override
    public String toJson() {
        Gson gs = new Gson();
        return gs.toJson(new EngineerAssignment(job_id,engineer_id));
    }
}
