package com.example.rpws.chapters.SpringBootAesome.service;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.rpws.chapters.SpringBootAesome.model.Temperature2;

import rx.Subscriber;

public class RxSeeEmitter extends SseEmitter
{
    static final long SSE_SESSION_TIMEOUT = 30 * 60 * 1000L;

    private final Subscriber<Temperature2> subscriber;

    public RxSeeEmitter()
    {
        super(SSE_SESSION_TIMEOUT);

        this.subscriber = new Subscriber<Temperature2>()
        {

            @Override
            public void onCompleted()
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onError(Throwable e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onNext(Temperature2 t)
            {
                try {
                    RxSeeEmitter.this.send(t);

                } catch (Exception e) {
                    unsubscribe();
                }
            }

        };
        onCompletion(subscriber::unsubscribe);
        onTimeout(subscriber::unsubscribe);
    }

    public Subscriber<Temperature2> getSubscriber()
    {
        return subscriber;
    }

}
