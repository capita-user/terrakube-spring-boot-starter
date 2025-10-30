package io.terrakube.client.spring.autoconfigure;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.gson.GsonEncoder;

import java.lang.reflect.Type;

public class CustomFeignEncoder implements Encoder {

    private final GsonEncoder gsonEncoder; // Default Gson encoder

    public CustomFeignEncoder() {
        this.gsonEncoder = new GsonEncoder(); // Initialize Gson encoder
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        if (object instanceof byte[]) {
            // If it's a byte array, send it as raw binary
            template.body((byte[]) object, null);
        } else {
            // Otherwise, use Gson for normal encoding
            gsonEncoder.encode(object, bodyType, template);
        }
    }
}