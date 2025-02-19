package org.terrakube.client.spring.autoconfigure;

import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class CustomFeignDecoder implements Decoder {

    private final GsonDecoder gsonDecoder; // Use GsonDecoder for JSON responses

    public CustomFeignDecoder() {
        this.gsonDecoder = new GsonDecoder(); // Initialize Gson decoder
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException {
        // Check if the response is binary (application/octet-stream)
        if (type == byte[].class) {

            // Read binary response as byte[]
            return response.body().asInputStream().readAllBytes();
        }

        // If not binary, use GsonDecoder for normal JSON handling
        return gsonDecoder.decode(response, type);
    }
}
