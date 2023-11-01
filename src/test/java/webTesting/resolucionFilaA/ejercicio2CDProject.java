package webTesting.resolucionFilaA;

import webTesting.clasesCRUDBasicAuth.factoryRequest.FactoryRequest;
import webTesting.clasesCRUDBasicAuth.test.TestBase;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webTesting.tareaCRUDTOKEN.ConfigurationTOKEN;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class ejercicio2CDProject extends TestBase {

    @Test
    public void create4ProjectsDeleteAllProjects(){

        for(int i=0; i<4; i++){
            JSONObject project = new JSONObject();
            project.put("Content", "Hola Mundo "+i+" he");
            createProject(project, post);
        }

        this.readAllProjects();
        List<Integer> ids = response.then().extract().path("Id");
        Assertions.assertTrue(ids.size()>=4);
        for(Integer id : ids){
            JSONObject project = new JSONObject();
            project.put("Id", id);
            deleteProject(project);
        }

    }

    private void createProject(JSONObject body, String post) {
        requestInfo.setUrl(ConfigurationTOKEN.project_host+".json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void deleteProject(JSONObject body){
        requestInfo.setUrl(ConfigurationTOKEN.project_host+"/"+body.get("Id")+".json")
                .setBody(body.toString());
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Id", equalTo(body.get("Id")))
                .body("Deleted", equalTo(true));
    }

    private void readAllProjects(){
        requestInfo.setUrl(ConfigurationTOKEN.project_host+".json");
        response = FactoryRequest.make(get).send(requestInfo);
    }

}
