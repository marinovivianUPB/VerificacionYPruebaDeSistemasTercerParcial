package webTesting.examenFilaB.ejercicio1UsuarioProyectoToken;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webTesting.tareaCRUDTOKEN.ConfigurationTOKEN;
import webTesting.tareaCRUDTOKEN.factoryRequestTOKEN.FactoryRequest;
import webTesting.tareaCRUDTOKEN.factoryRequestTOKEN.RequestInfo;
import webTesting.tareaCRUDTOKEN.requestTOKEN.RequestTOKEN;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class CreateTokenDeleteTokenTest {
    public String post ="post";
    public String put = "put";
    public String get ="get";
    public String delete ="delete";

    public RequestInfo requestInfo;
    public Response response;

    static Random rand = new Random();
    @BeforeEach
    public void before(){
        requestInfo = new RequestInfo();
        requestInfo.setHeaders("Token", "stub");
    }

    @Test
    public void createUserCreateTokenCreateProjectDeleteTokenCreateProjectFail(){

        ConfigurationTOKEN.user="VivianMarino"+rand.nextInt(500)+rand.nextInt(500)+"@prueba.com";

        JSONObject body = new JSONObject();
        body.put("Email", ConfigurationTOKEN.user);
        body.put("FullName","Vivian Marino");
        body.put("Password",ConfigurationTOKEN.password);

        this.createUser(body);

        requestInfo.setHeaders("Token", RequestTOKEN.getInstance().getToken());

        JSONObject projectBody = new JSONObject();
        projectBody.put("Content","This is a project");

        this.createProject(projectBody);

        RequestTOKEN.getInstance().deleteToken();

        projectBody.put("Content","This is another Project");

        this.createProjectFailed(projectBody);
    }

    private void createUser(JSONObject body) {
        requestInfo.setUrl(ConfigurationTOKEN.user_host+".json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("FullName", equalTo(body.get("FullName"))).
                body("Email", equalTo(body.get("Email")));
    }

    private void createProject(JSONObject body) {
        requestInfo.setUrl(ConfigurationTOKEN.project_host + ".json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200)
                .body("Content", equalTo(body.get("Content")));
    }

    private void createProjectFailed(JSONObject body) {
        requestInfo.setUrl(ConfigurationTOKEN.project_host + ".json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200)
                .body("ErrorMessage", equalTo("Not Authenticated"));
    }
}
