package webTesting.resolucionFilaC;

import webTesting.clasesCRUDBasicAuth.Configuration;
import webTesting.clasesCRUDBasicAuth.factoryRequest.FactoryRequest;
import webTesting.clasesCRUDBasicAuth.factoryRequest.RequestInfo;
import webTesting.clasesCRUDBasicAuth.test.TestBase;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class ejercicio2CD4Users extends TestBase {
    static List<JSONObject> users = new ArrayList<JSONObject>();

    static Random rand = new Random();
    @Test
    public void createUserCreateProjectDeleteUserCreateProject(){
        //create user
        for(int i=0; i<4; i++){
            requestInfo = new RequestInfo();

            JSONObject body = new JSONObject();
            body.put("Email", "VivianMarino"+rand.nextInt(500)+rand.nextInt(500)+"@prueba.com");
            body.put("FullName","Vivian Marino");
            body.put("Password",Configuration.password);

            requestInfo.setHeaders("User", body.get("Email").toString());
            requestInfo.setHeaders("Password", body.get("Password").toString());

            this.createUser(Configuration.user_host +".json", body, post);

            users.add(body);
        }

        for(JSONObject user : users){
            Configuration.user=user.get("Email").toString();
            requestInfo = new RequestInfo();
            requestInfo.setHeaders("User", user.get("Email").toString());
            requestInfo.setHeaders("Password", user.get("Password").toString());
            this.deleteUser(user);
        }


    }

    private void createUser(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("FullName", equalTo(body.get("FullName"))).
                body("Email", equalTo(body.get("Email")));
    }

    private void deleteUser(JSONObject body) {
        requestInfo.setUrl(Configuration.user_host +"/0.json")
                .setBody(body.toString());
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("FullName", equalTo(body.get("FullName"))).
                body("Email", equalTo(body.get("Email")));
    }
}
