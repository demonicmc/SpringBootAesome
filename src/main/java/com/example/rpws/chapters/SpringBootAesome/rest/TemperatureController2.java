package com.example.rpws.chapters.SpringBootAesome.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.rpws.chapters.SpringBootAesome.service.RxSeeEmitter;
import com.example.rpws.chapters.SpringBootAesome.service.TemperatureSensor2;

@RestController
public class TemperatureController2
{
    private final TemperatureSensor2 temperatureSensor2;

    public TemperatureController2(TemperatureSensor2 temperatureSensor2)
    {
        super();
        this.temperatureSensor2 = temperatureSensor2;
    }

    @RequestMapping(value = "/temperature-stream2", method = RequestMethod.GET)
    public SseEmitter events(HttpServletRequest request)
    {
        RxSeeEmitter emitter = new RxSeeEmitter();
        temperatureSensor2.temperatureStream().subscribe(emitter.getSubscriber());
        
        return emitter;
    }
}
