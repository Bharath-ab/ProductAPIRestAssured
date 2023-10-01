package com.phoenixB2B.pojo.engineer;

import com.google.gson.Gson;
import com.phoenixB2B.intefaces.IBody;
import com.phoenixB2B.pojo.Problems;

import java.util.ArrayList;
import java.util.HashMap;

//Request URL: http://139.59.91.96:9000/v1/engineer/repaircomplete Method : Post
public class RepairComplete implements IBody {
    //Problem Array contains Id,remarks
    private int job_id;
    private ArrayList<HashMap<String,Object>> problems = new ArrayList<HashMap<String,Object>>();

    public RepairComplete(int job_id, ArrayList<HashMap<String, Object>> problems) {
        this.job_id = job_id;
        this.problems = problems;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public ArrayList<HashMap<String, Object>> getProblems() {
        return problems;
    }

    public void setProblems(ArrayList<HashMap<String, Object>> problems) {
        this.problems = problems;
    }

    @Override
    public String toJson() {
        Gson gs = new Gson();
        return gs.toJson(new RepairComplete(job_id,problems));
    }
}
