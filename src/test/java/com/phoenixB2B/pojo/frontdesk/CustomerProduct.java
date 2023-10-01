package com.phoenixB2B.pojo.frontdesk;

import java.util.HashMap;

public class CustomerProduct {
    private HashMap<String, Object> customer_product = new HashMap<String, Object>();

    public CustomerProduct(String dop, String serial_number, String imei1, String imei2, String popurl, int product_id, int mst_model_id) {
        customer_product.put("dop", dop);
        customer_product.put("serial_number", serial_number);
        customer_product.put("imei1", imei1);
        customer_product.put("imei2", imei2);
        customer_product.put("popurl", popurl);
        customer_product.put("product_id", String.valueOf(product_id));
        customer_product.put("mst_model_id", String.valueOf(mst_model_id));
    }

    public HashMap<String, Object> getCustomer_product() {
        return customer_product;
    }

    public void setCustomer_product(HashMap<String, Object> customer_product) {
        this.customer_product = customer_product;
    }

    @Override
    public String toString() {
        return "CustomerProduct{" +
                "customer_product=" + customer_product +
                '}';
    }
}
