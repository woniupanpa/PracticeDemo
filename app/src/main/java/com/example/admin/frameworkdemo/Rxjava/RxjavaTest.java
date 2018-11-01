package com.example.admin.frameworkdemo.Rxjava;

import android.content.Context;
import android.util.Log;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;


public class RxjavaTest {
    private Context context;
    private final static String TAG = RxjavaTest.class.getSimpleName();
    public RxjavaTest(Context mContext) {
        context = mContext;
    }

    public void ObservableTest(){
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                //Log.d(TAG, "ObservableEmitter");
                //Log.d(TAG, "Observable thread is" + Thread.currentThread().getName());
                emitter.onNext(12);
                emitter.onNext(13);
                emitter.onNext(14);
                emitter.onNext(15);
                emitter.onComplete();
            }
        });
        Observer<Integer> observer = new Observer<Integer>() {
            private int i;
            private Disposable mDisposable;
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
                mDisposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                /*i++;
                if(i == 3){
                    mDisposable.dispose();
                }*/
                Log.d(TAG, "onNext"+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };

        observable.subscribe(observer);
    }


    public void SingleTest(){
        Log.d(TAG, "SingleTest");
    }

    public void CompletableTest(){
        Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {
                emitter.onComplete();
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "CompletableTestdoOnComplete");
            }
        })
        .subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "CompletableTestonSubscribe");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "CompletableTestonComplete");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "CompletableTestonError");
            }
        });
    }

    public void ComplicatedTest(){
        Completable.complete()
                .doOnComplete(()->{
                    Log.d(TAG, "doOncomplete");
                })
                .toSingleDefault(5)
                .map(a -> {
                    Log.d(TAG, "11111"+Thread.currentThread().getName());
                    return a*4;
                })
                .observeOn(Schedulers.io())
                .flatMapObservable(b ->{
                    Log.d(TAG, "b--->" +b);
                    Log.d(TAG, "22222"+Thread.currentThread().getName());
                    return Observable.just(b*2);
                }).doOnNext(c->{
            Log.d(TAG, "c--->"  + c);
        }).observeOn(AndroidSchedulers.mainThread())
                .doOnNext(d->{
                    Log.d(TAG, "d--->" +d);
                    Log.d(TAG, "33333"+Thread.currentThread().getName());
                }).subscribe();
    }
}
