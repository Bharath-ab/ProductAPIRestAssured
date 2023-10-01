package com.phoenixB2B.pojo;

import java.util.HashMap;

public class Problems {
    private HashMap<String, Object> problems = new HashMap<String, Object>();

    public Problems(int id,String remark) {
        problems.put("id",id);
        problems.put("remark",remark);
        this.problems = problems;
    }

    public HashMap<String, Object> getProblems() {
        return problems;
    }

    public void setProblems(HashMap<String, Object> problems) {
        this.problems = problems;
    }

    @Override
    public String toString() {
        return "Problems{" +
                "problems=" + problems +
                '}';
    }
}
