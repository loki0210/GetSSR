package com.ccm.getssr.net.converter;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Retrofit 自定义Converter.Factory实现直接接收String
 */
public class ToStringConverterFactory extends Converter.Factory {
    private static final MediaType MEDIA_TYPE = MediaType.parse("text/plain");

    public static Converter.Factory create() {
        return new ToStringConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (String.class.equals(type)) {
            return new Converter<ResponseBody, String>() {
                @Override
                public String convert(@NotNull ResponseBody value) throws IOException {
                    return value.string();
                }
            };
        }
        return null;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations, Retrofit retrofit) {
        if (String.class.equals(type)) {
            return new Converter<String, RequestBody>() {
                @Override
                public RequestBody convert(@NotNull String value) throws IOException {
                    return RequestBody.create(MEDIA_TYPE, value);
                }
            };
        }
        return null;
    }
}