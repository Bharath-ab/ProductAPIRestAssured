package com.phoenixB2B;

import com.phoenixB2B.pojo.LoginToPhoneixApp;
import com.phoenixB2B.pojo.Problems;
import com.phoenixB2B.pojo.engineer.RepairComplete;
import com.phoenixB2B.pojo.frontdesk.*;
import com.phoenixB2B.pojo.qc.QcComplete;
import com.phoenixB2B.pojo.supervisor.EngineerAssignment;
import com.utils.APIHelper;
import com.utils.Verb;
import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static com.utils.TestUtils.getOriginUrl;
import static com.utils.TestUtils.getRefererUrl;

public class PhoenixB2BTest {

    private String token;
    private int id =26568;
    ArrayList<HashMap<String, Object>> prob = new ArrayList<>();


    public void LogIntoPhoenixAPI(String userName, String password) {
        APIHelper helper = new APIHelper();
        token = helper.makeRequest(Verb.POST, "/v1/login", new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer", getRefererUrl()), new Header("DNT", "1"), new LoginToPhoneixApp(userName, password)).then().statusCode(200).and().body("message", Matchers.equalTo("Success")).extract().path("data.token");
    }

    @Test(description = "Create Repair Job API", priority = 1, groups = {"e2e", "smoke", "sanity"})
    public void createRepairJobAPI() {
        LogIntoPhoenixAPI("iamfd", "password");
        APIHelper helper = new APIHelper();
        prob.add(new Problems(1, "Red Dragon").getProblems());
        prob.add(new Problems(2, "Problem Two Created from Java API").getProblems());
        prob.add(new Problems(3, "Problem Three Created from Java API").getProblems());
        ValidatableResponse response = helper.makeRequest(Verb.POST, "/v1/job/create", new Header("Authorization", token), new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer", getRefererUrl()), new Header("DNT", "1"), new CreateRepairJob(1, 2, 1, 1, new CustomerDetails("Bharath", "Varma", "9848022338", "", "bharath.varma@outlook.com", "").getCustomer(), new CustomerAddress(121, "B2B", "Menon", "Sindh Province", "North West Blank", "200015", "India", "Assam").getCustomer_address(), new CustomerProduct("2022-11-04T08:06:23.000Z", "WOLFOYAMITO999", "WOLFOYAMITO999", "WOLFOYAMITO999", "", 1, 1).getCustomer_product(), prob)).then().statusCode(200).and().body("message", Matchers.equalTo("Job created successfully. "));
        id = Integer.parseInt(response.extract().path("data.id").toString().trim());
        String jobNumber = response.extract().path("data.job_number");
        System.out.println("Job ID: " + id + "\t" + "Job Number: " + jobNumber);
    }

    @Test(dependsOnMethods = "createRepairJobAPI", description = "Engineer Assign API", priority = 4, groups = {"e2e", "smoke", "sanity"})
    public void engineerAssign() {
        LogIntoPhoenixAPI("iamsup", "password");
        APIHelper helper = new APIHelper();
        helper.makeRequest(Verb.POST, "/v1/engineer/assign", new Header("Authorization", token), new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer", getRefererUrl()), new Header("DNT", "1"), new EngineerAssignment(id, 2)).then().statusCode(200).and().body("message", Matchers.equalTo("Engineer assigned successfully"));
        System.out.println("Engineer Assigned Successfully");
    }


    @Test(dependsOnMethods = "engineerAssign", description = "Repair Complete API", priority = 5, groups = {"e2e", "smoke", "sanity"})
    public void repairComplete() {
        LogIntoPhoenixAPI("iameng", "password");
        APIHelper helper = new APIHelper();
        helper.makeRequest(Verb.POST, "/v1/engineer/repaircomplete", new Header("Authorization", token), new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer", getRefererUrl()), new Header("DNT", "1"), new RepairComplete(id, prob)).then().statusCode(200).and().body("message", Matchers.equalTo("Repair successful."));
        System.out.println("Repair Completed for Job Successfully");
    }

    @Test(dependsOnMethods = "repairComplete", description = "QC Complete API", priority = 6, groups = {"e2e", "smoke", "sanity"})
    public void qcComplete() {
        LogIntoPhoenixAPI("iamQC", "password");
        APIHelper helper = new APIHelper();
        helper.makeRequest(Verb.POST, "/v1/qc", new Header("Authorization", token), new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer", getRefererUrl()), new Header("DNT", "1"), new QcComplete(id)).then().statusCode(200).and().body("message", Matchers.equalTo("QC completed successfully"));
        System.out.println("QC Completed for Job Successfully");
    }


    @Test(dependsOnMethods = "qcComplete", description = "Delivery Success API", priority = 7, groups = {"e2e", "smoke", "sanity"})
    public void deliverySuccess() {
        LogIntoPhoenixAPI("iamfd", "password");
        APIHelper helper = new APIHelper();
        helper.makeRequest(Verb.POST, "/v1/fd/delivertocustomer", new Header("Authorization", token), new Header("Content-Type", "application/json"), new Header("Origin", getOriginUrl()), new Header("Referer", getRefererUrl()), new Header("DNT", "1"), new DeliverToCustomer(id)).then().statusCode(200);
        System.out.println("Delivered Device Successfully");
    }

}
