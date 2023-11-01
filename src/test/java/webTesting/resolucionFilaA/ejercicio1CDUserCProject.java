package webTesting.resolucionFilaA;

import webTesting.clasesCRUDBasicAuth.Configuration;
import webTesting.clasesCRUDBasicAuth.factoryRequest.FactoryRequest;
import webTesting.clasesCRUDBasicAuth.test.TestBase;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import webTesting.tareaCRUDTOKEN.ConfigurationTOKEN;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class ejercicio1CDUserCProject extends TestBase {
    static Random rand = new Random();

    @Test
    public void createUserCreateProjectDeleteUserCreateProject(){

        //create user
        Configuration.user="hola"+rand.nextInt(255)+rand.nextInt(255)+"@prueba.com";

        JSONObject body = new JSONObject();
        body.put("Email", Configuration.user);
        body.put("FullName","Vivian Marino");
        body.put("Password",Configuration.password);


        this.createUser(Configuration.user_host +".json", body, post);

        //create project

        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content","holi como estas");

        this.createProject(bodyProject, post);

        //delete user

        this.deleteUser(body);

        //create project failed

        bodyProject.put("Content","bye");

        this.createProjectFail(bodyProject, post);
    }

    private void createUser(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("FullName", equalTo(body.get("FullName"))).
                body("Email", equalTo(body.get("Email")));
    }

    private void createProject(JSONObject body, String post) {
        requestInfo.setUrl(ConfigurationTOKEN.project_host+".json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void deleteUser(JSONObject body) {
        requestInfo.setUrl(Configuration.user_host +"/0.json")
                .setBody(body.toString());
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("FullName", equalTo(body.get("FullName"))).
                body("Email", equalTo(body.get("Email")));
    }

    private void createProjectFail(JSONObject body, String post) {
        requestInfo.setUrl(ConfigurationTOKEN.project_host+".json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200)
                .body("ErrorMessage", equalTo("Account doesn't exist"));
    }
}