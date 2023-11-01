package webTesting.resolucionFilaC;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webTesting.tareaCRUDTOKEN.ConfigurationTOKEN;
import webTesting.tareaCRUDTOKEN.factoryRequestTOKEN.FactoryRequest;
import webTesting.tareaCRUDTOKEN.factoryRequestTOKEN.RequestInfo;
import webTesting.tareaCRUDTOKEN.requestTOKEN.RequestTOKEN;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class ejercicio1CreateTokenDeleteTokenCDItem {
    static Random rand = new Random();

    public String post ="post";
    public String put = "put";
    public String get ="get";
    public String delete ="delete";

    public RequestInfo requestInfo;
    public Response response;
    @BeforeEach
    public void before(){
        requestInfo = new RequestInfo();
        requestInfo.setHeaders("Token", "hola");
    }

    @AfterEach
    public void after(){

    }

    @Test
    public void createUserGetTokenCreateProjectDeleteTokenFailCreateProject(){
        ConfigurationTOKEN.user = "hola"+rand.nextInt(255)+rand.nextInt(255)+"@prueba.com";

        JSONObject body = new JSONObject();
        body.put("Email", ConfigurationTOKEN.user);
        body.put("FullName","Vivian Marino");
        body.put("Password",ConfigurationTOKEN.password);

        createUser(ConfigurationTOKEN.user_host+".json", body, post);

        String token = RequestTOKEN.getInstance().getToken();

        requestInfo.setHeaders("Token", token);

        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content","holi como estas");

        createItem(bodyProject, post);

        RequestTOKEN.getInstance().deleteToken();

        bodyProject.put("Content","buenas tardes");

        createItemFailed(bodyProject, post);

    }

    private void createUser(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200)
                .body("FullName", equalTo(body.get("FullName")))
                .body("Email", equalTo(body.get("Email")));
    }

    private void createItem(JSONObject body, String post) {
        requestInfo.setUrl(ConfigurationTOKEN.item_host + ".json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200)
                .body("Content", equalTo(body.get("Content")));
    }

    private void createItemFailed(JSONObject body, String post) {
        requestInfo.setUrl(ConfigurationTOKEN.item_host + ".json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200)
                .body("ErrorMessage", equalTo("Not Authenticated"));
    }
}
