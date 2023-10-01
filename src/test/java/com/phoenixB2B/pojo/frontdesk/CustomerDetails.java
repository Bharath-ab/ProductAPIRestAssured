package com.phoenixB2B.pojo.frontdesk;

import java.util.HashMap;

public class CustomerDetails {
    private HashMap<String, String> customer = new HashMap<String, String>();

    public CustomerDetails(String first_name, String last_name, String mobile_number, String mobile_number_alt, String email_id, String email_id_alt) {
        customer.put("first_name", first_name);
        customer.put("last_name", last_name);
        customer.put("mobile_number", mobile_number);
        customer.put("mobile_number_alt", mobile_number_alt);
        customer.put("email_id", email_id);
        customer.put("email_id_alt", email_id_alt);
    }

    public HashMap<String, String> getCustomer() {
        return customer;
    }

    public void setCustomer(HashMap<String, String> customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "customer=" + customer +
                '}';
    }
}
