package SpecFactory;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecFactory {

        public static ResponseSpecification createResponseSpec(int expectedStatusCode) {
            return new ResponseSpecBuilder()
                    .expectStatusCode(expectedStatusCode)
                    .expectContentType(ContentType.JSON)
                    .build();
        }



}
