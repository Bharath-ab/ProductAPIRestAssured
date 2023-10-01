package com.phoenixB2B.pojo.frontdesk;

import com.google.gson.Gson;
import com.phoenixB2B.intefaces.IBody;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateRepairJob implements IBody {
    private int mst_service_location_id;
    private int mst_platform_id;
    private int mst_warrenty_status_id;
    private int mst_oem_id;
    HashMap<String,String> customer = new HashMap<String,String>();
    HashMap<String,String> customer_address = new HashMap<String,String>();
    HashMap<String,Object> customer_product = new HashMap<String,Object>();
    ArrayList<HashMap<String,Object>> problems = new ArrayList<HashMap<String,Object>>();

    public CreateRepairJob(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id, int mst_oem_id, HashMap<String, String> customer, HashMap<String, String> customer_address, HashMap<String, Object> customer_product, ArrayList<HashMap<String, Object>> problems) {
        this.mst_service_location_id = mst_service_location_id;
        this.mst_platform_id = mst_platform_id;
        this.mst_warrenty_status_id = mst_warrenty_status_id;
        this.mst_oem_id = mst_oem_id;
        this.customer = customer;
        this.customer_address = customer_address;
        this.customer_product = customer_product;
        this.problems = problems;
    }

    public int getMst_service_location_id() {
        return mst_service_location_id;
    }

    public void setMst_service_location_id(int mst_service_location_id) {
        this.mst_service_location_id = mst_service_location_id;
    }

    public int getMst_platform_id() {
        return mst_platform_id;
    }

    public void setMst_platform_id(int mst_platform_id) {
        this.mst_platform_id = mst_platform_id;
    }

    public int getMst_warrenty_status_id() {
        return mst_warrenty_status_id;
    }

    public void setMst_warrenty_status_id(int mst_warrenty_status_id) {
        this.mst_warrenty_status_id = mst_warrenty_status_id;
    }

    public int getMst_oem_id() {
        return mst_oem_id;
    }

    public void setMst_oem_id(int mst_oem_id) {
        this.mst_oem_id = mst_oem_id;
    }

    public HashMap<String, String> getCustomer() {
        return customer;
    }

    public void setCustomer(HashMap<String, String> customer) {
        this.customer = customer;
    }

    public HashMap<String, String> getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(HashMap<String, String> customer_address) {
        this.customer_address = customer_address;
    }

    public HashMap<String, Object> getCustomer_product() {
        return customer_product;
    }

    public void setCustomer_product(HashMap<String, Object> customer_product) {
        this.customer_product = customer_product;
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
        return gs.toJson(new CreateRepairJob( mst_service_location_id,  mst_platform_id,  mst_warrenty_status_id,  mst_oem_id,  customer, customer_address,  customer_product, problems));
    }
}

