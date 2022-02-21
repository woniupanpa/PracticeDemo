package com.example.admin.frameworkdemo.Rxjava;

import io.reactivex.Observable;
import timber.log.Timber;

/**
 * @author yanjim
 * @Date 2021/6/17 11:05
 */
public class Test {
    public static void main(String[] args) {
        test().subscribe(number->{
            System.out.println("number--->" + number);
        });
    }

    private static Observable<Integer> test(){
       return Observable.create(emitter->{
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onComplete();
        });
    };
}
