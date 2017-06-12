package com.github.vaibhavsinha.kong;

import com.github.vaibhavsinha.kong.exception.KongClientException;
import com.github.vaibhavsinha.kong.impl.KongClient;
import com.github.vaibhavsinha.kong.model.consumer.Consumer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by vaibhav on 12/06/17.
 */
public class RetrofitConsumerServiceTest {

    private KongClient kongClient;

    @Before
    public void before() {
        kongClient = new KongClient("http://localhost:8001");
    }

    @Test
    public void testCreateConsumer() throws IOException {
        Consumer request = new Consumer();
        request.setCustomId("1234-5678-9012");

        Consumer response = kongClient.getConsumerService().createConsumer(request);
        System.out.print(response);
        Assert.assertEquals(request.getCustomId(), response.getCustomId());
    }

    @Test
    public void testGetConsumer() throws IOException {
        Consumer response = kongClient.getConsumerService().getConsumer("fd609820-0021-4fdf-9c80-bc692c3e4fe6");
        System.out.print(response);
        Assert.assertEquals("fd609820-0021-4fdf-9c80-bc692c3e4fe6", response.getId());
    }

    @Test(expected = KongClientException.class)
    public void exceptionTest() throws IOException {
        kongClient.getConsumerService().getConsumer("some-random-id");
    }

    @Test
    public void testUpdateConsumer() throws IOException {
        Consumer request = new Consumer();
        request.setCustomId("1234-5678-9012-3456");

        Consumer response = kongClient.getConsumerService().updateConsumer("fd609820-0021-4fdf-9c80-bc692c3e4fe6", request);
        System.out.print(response);
        Assert.assertEquals(request.getCustomId(), response.getCustomId());
    }

    @Test
    public void testCreateOrUpdateConsumer() throws IOException {
        Consumer request = new Consumer();
        request.setCustomId("1234-5678-9012-3456-78");
        request.setId("fd609820-0021-4fdf-9c80-bc692c3e4fe6");
        request.setCreatedAt(123456789L);

        Consumer response = kongClient.getConsumerService().createOrUpdateConsumer(request);
        System.out.print(response);
        Assert.assertEquals(request.getCustomId(), response.getCustomId());
    }

    @Test
    public void testDeleteConsumer() throws IOException {
        kongClient.getConsumerService().deleteConsumer("fd609820-0021-4fdf-9c80-bc692c3e4fe6");
    }
}