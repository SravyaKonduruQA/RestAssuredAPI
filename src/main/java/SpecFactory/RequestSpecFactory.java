package SpecFactory;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestSpecFactory {


        // Create a reusable RequestSpecification dynamically
        public static RequestSpecification createRequestSpec(String baseUri, Map<String, String> headers, Map<String, String> queryParams,Map<String, String> cookies) {
            RequestSpecBuilder builder = new RequestSpecBuilder()
                    .setBaseUri(baseUri)
                    .setContentType(ContentType.JSON);

            // Add headers if provided
            if (headers != null) {
                builder.addHeaders(headers);
            }

            //Add cookies if provided
            if(cookies!=null){
                builder.addCookies(cookies);

            }

            // Add query params if provided
            if (queryParams != null) {
                builder.addQueryParams(queryParams);
            }

            return builder.build();
        }
    }

