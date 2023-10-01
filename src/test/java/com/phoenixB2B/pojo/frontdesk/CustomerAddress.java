package com.phoenixB2B.pojo.frontdesk;

import java.util.HashMap;

public class CustomerAddress {
    private HashMap<String, String> customer_address = new HashMap<String, String>();

    public CustomerAddress(int flat_number, String apartment_name, String street_name, String landmark, String area, String pincode, String country, String state) {
        customer_address.put("flat_number", String.valueOf(flat_number));
        customer_address.put("apartment_name", apartment_name);
        customer_address.put("street_name", street_name);
        customer_address.put("landmark", landmark);
        customer_address.put("area", area);
        customer_address.put("pincode", pincode);
        customer_address.put("country", country);
        customer_address.put("state", state);
    }

    public HashMap<String, String> getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(HashMap<String, String> customer_address) {
        this.customer_address = customer_address;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "customer_address=" + customer_address +
                '}';
    }

}
