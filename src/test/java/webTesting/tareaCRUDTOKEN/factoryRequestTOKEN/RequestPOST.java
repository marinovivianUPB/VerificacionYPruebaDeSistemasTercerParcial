package webTesting.tareaCRUDTOKEN.factoryRequestTOKEN;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestPOST implements IRequest {
    @Override
    public Response send(RequestInfo requestInfo) {
        Response response=given()
                .header("Token",requestInfo.getHeader("Token"))
                .body(requestInfo.getBody())
                .log()
                .all().
                when()
                .post(requestInfo.getUrl());
        response.then().log().all();
        return response;
    }
}
