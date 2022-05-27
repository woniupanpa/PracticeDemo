package com.example.admin.frameworkdemo.Rxjava;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class RxjavaTest {
    private final static String TAG = RxjavaTest.class.getSimpleName();
    private Disposable retryDispose;
    private int count = 1;
    int countA = 0;

    public RxjavaTest(Context mContext) {
    }

    public void ObservableTest() {
        Single.fromCallable(()->{
            return 5;
        }).doOnSuccess(integer -> {
            integer++;
        }).flatMapCompletable(integer -> {
            Log.d(TAG, "aa" + integer);
            return Completable.complete();
        }).subscribe();
       /* Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
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
        });*/

        Observable<Integer> observable = Observable.create(emitter -> {
            /*emitter.onNext(12);
            emitter.onNext(13);
            emitter.onNext(14);*/
            //emitter.onNext(15);
            //emitter.onError(new Throwable("aa"));
            emitter.onComplete();
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
                Timber.d("onNext" + integer);
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

        Completable.fromObservable(observable)
                .doOnTerminate(() -> {
                    Timber.d("doOnTerminate");
                })
                .subscribe(() -> {
                    Timber.d("aaaaaaaaaaaa");
                });
       /* observable.doOnComplete(()->{
            Timber.d("doOnComplete");
        }).doOnTerminate(()->{
            Timber.d("doOnTerminate");
        }).subscribe(o->{
            Timber.d(o.toString());
        }, throwable -> {
            Timber.d("error-->" + throwable.getMessage());
        });*/
        /*observable.doOnSubscribe(disposable -> {
                    Log.d(TAG, "doOnSubscribe");
                }
        ).doOnComplete(() -> {
            Log.d(TAG, "doOnComplete");
        }).doOnNext((C) -> {
            Log.d(TAG, "doNext" + C);
        }).subscribe(observer);*/
    }


    @SuppressLint("CheckResult")
    public void SingleTest() {
        Completable.complete()
                .subscribe(() -> Timber.d("test"));
    }

    public Completable andThen1() {
       /* Completable.complete()
                .observeOn(Schedulers.newThread())
                .subscribe(() -> {
                    Log.d(TAG, "andThen1Threadaa--->"+Thread.currentThread().getName());
        });
        Log.d(TAG, "andThen1Thread--->"+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Completable.complete();*/
        return Completable.complete()
                .observeOn(Schedulers.newThread());
    }

    public Completable andThen2() {
        Log.d(TAG, "andThen2Thread--->" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "yjm22222222222");
        return Completable.complete();
    }

    public void andThenTesst() {
        Completable.complete().andThen(andThen1())
                /*.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())*/
                //.observeOn(Schedulers.newThread())
                .doOnComplete(() -> {
                    Log.d(TAG, "doOncompelteThread1--->" + Thread.currentThread().getName());

                    Log.d(TAG, "andComplete1");
                })
                .andThen(andThen2())
                .doOnComplete(() -> {
                    Log.d(TAG, "doOncompelteThread2--->" + Thread.currentThread().getName());
                    Log.d(TAG, "andComplete2");
                }).subscribe(() -> {
            Log.d(TAG, "andComplete3");
        });
    }

    private Completable completableTest1() {
        return Completable.fromCallable(() -> {
            Timber.d("bbbbbbbbbbbbbbbb");
            return Completable.complete();
        });
    }

    public void CompletableTest() {

        Completable.complete()
                .andThen(Completable.fromCallable(() -> {
                    countA += 1;
                    return Completable.complete();
                }))
                .andThen(Completable.fromCallable(() -> {
                    Timber.d("aaaaaaaaacountA " + countA);
                    return Completable.complete();
                }))
                .subscribe(() -> {
                    Timber.d("bbbbbbbbbcountA " + countA);
                });

        /*Completable.create(new CompletableOnSubscribe() {
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
                });*/
    }

    public void ComplicatedTest() {
        Completable.complete()
                .doOnComplete(() -> {
                    Log.d(TAG, "doOncomplete");
                })
                .toSingleDefault(5)
                .map(a -> {
                    Log.d(TAG, "11111" + Thread.currentThread().getName());
                    return a * 4;
                })
                .observeOn(Schedulers.io())
                .flatMapObservable(b -> {
                    Log.d(TAG, "b--->" + b);
                    Log.d(TAG, "22222" + Thread.currentThread().getName());
                    return Observable.just(b * 2);
                }).doOnNext(c -> {
            Log.d(TAG, "c--->" + c);
        }).observeOn(AndroidSchedulers.mainThread())
                .doOnNext(d -> {
                    Log.d(TAG, "d--->" + d);
                    Log.d(TAG, "33333" + Thread.currentThread().getName());
                }).subscribe();
    }


    public void flatmapTest() {
        List<Students> students = new ArrayList<>(3);
        List<String> s1_cousrse = new ArrayList<>(3);
        s1_cousrse.add("English");
        s1_cousrse.add("Chinese");
        s1_cousrse.add("Music");
        List<String> s2_cousrse = new ArrayList<>(3);
        s1_cousrse.add("Physics");
        s1_cousrse.add("Doctor");
        s1_cousrse.add("Computer");
        Students students1 = new Students(s1_cousrse);
        Students students2 = new Students(s2_cousrse);
        students.add(students1);
        students.add(students2);

        //from和just的区别，from把数据展开，just是原来的数据
       /* Observable.just(students).flatMap(student -> {
            Log.d(TAG, "student--->" + student.get(0).getCourse().get(0));
            return Observable.just("112233");
        }).subscribe(course->{
            Log.d(TAG, "course--->" + course);
        });*/

        //from改为fromIterable
        Observable.fromIterable(students).flatMap(student -> {
            return Observable.fromIterable(student.getCourse());
        }).subscribe(course -> {
            Log.d(TAG, "course--->" + course);
        });
    }

    public class Students {
        public List<String> courses;

        public Students(List<String> mCourses) {
            courses = mCourses;
        }

        public List<String> getCourse() {
            return courses;
        }
    }

    //参考：https://blog.csdn.net/lggbxf/article/details/82836695
    public void zipWithTest() {
        Observable.just(10, 20, 30, 40)
                .zipWith(Observable.just("a", "b", "c"), (integer, s) -> {
                    return integer + s;
                }).subscribe((s) -> {
            Log.d(TAG, "zipwithTest--->" + s);
        });
    }

    public void retryTest() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                try {
                    for (int i = 0; i < 10; i++) {
                        if (i == 3) {
                            throw new Exception("出错了");
                        }
                        emitter.onNext(i);
                    }
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
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
                Log.d(TAG, "onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError" + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };

        observable.retry(2).subscribe(observer);
    }

    private Observable doRetry(Observable<Throwable> throwableObservable, int retryTimes) {
        return throwableObservable
                .zipWith(Observable.range(1, retryTimes + 1), (throwable, retryCount) -> {
                    Log.d(TAG, "in zip:" + retryCount);
                    return delayAndCheckCancel(5, 1)
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnComplete(() -> {
                                Log.d(TAG, "retry again" + retryCount);
                            });
                })
                .flatMap(x -> {
                    return x;
                });
    }

    public void retryWhenTest() {

        /*Observable.create(emitter->{
            Log.d(TAG, "执行这个");
            emitter.onError(new Throwable("出错了"));
        }).retryWhen(throwableObservable -> {
            return doRetry(throwableObservable, 2);
        }).doOnSubscribe(disposable->{
            Log.d(TAG, "onSubscribe");
        }).doOnError(throwable->{
            Log.d(TAG, "onError" + throwable);
        }).doOnComplete(()->{
            Log.d(TAG, "onComplete");
        }).subscribe();*/



        /*Observer<Integer> observer = new Observer<Integer>() {
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
                mDisposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError" + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "执行这个");
                emitter.onError(new Throwable("出错了"));
            }
        });

        observable
                //.retryWhen(throwableObservable -> doRetry(throwableObservable, 5))
                .retryWhen(throwableObservable -> {
                    return doRetry(throwableObservable, 5);
                })
                .subscribe(observer);*/

       /* observable.retryWhen(throwableObservable -> {
            return throwableObservable.zipWith(Observable.range(3, 3), (throwable, integer) -> {
                return integer;
            }).flatMap(integer -> {
                //timer 延迟执行的操作符
                Log.i(TAG, "延迟" + integer + "秒");
                return Observable.timer(integer, TimeUnit.SECONDS);
            });
        }).subscribe(observer);*/

        Completable.fromCallable(() -> {
            Log.d(TAG, "aaaaaaaaaaaaaaaaa");
            return Completable.complete();
        }).doOnComplete(() -> {
            Log.d(TAG, "retryWhenStart--->");
        }).andThen(Completable.fromCallable(() -> {
            countA = 2;
            return Completable.complete();
        })).andThen(retryWehnTest1())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    retryDispose = disposable;
                })
                .subscribe(() -> {
                    Log.d(TAG, "retryWhenSuccess--->");
                }, throwable -> {
                    Log.d(TAG, "retryWhenError--->");
                });
    }


    private Observable delayAndCheckCancel(int timeout, int period) {
        Log.d(TAG, "delayAndCheckCancel" + timeout);
        if (timeout <= 0) {
            return Observable.just(timeout);
        }

        return Observable.timer(period, TimeUnit.SECONDS)
                .flatMap(time -> {
                    return delayAndCheckCancel(timeout - period, period);
                });
    }

    public Completable retryWehnTest1() {
        Log.d(TAG, "vvvvvvvvvvvvvvvvvv");
        countA += 1;
        return Completable.fromCallable(() -> {
            Log.d(TAG, "uuuuuuuuuuuu");
            countA += 1;
            return Completable.complete();
        }).andThen(retryWehnTest2())
                .andThen(getSingleTest())
                .flatMapCompletable(integer -> {
                    Log.d(TAG, "countA--->" + countA);
                    Log.d(TAG, "retryWehnTest1--->" + "11111111111");
                    return Completable.error(new Throwable("error"));
                }).retryWhen(throwableFlowable -> throwableFlowable.flatMap(throwable -> handleError(throwable)));
    }

    public Completable retryWehnTest2() {
        return Completable.fromCallable(() -> {
            Log.d(TAG, "wwwwwwwwwww" + count);
            countA += 1;
            return Completable.complete();
        });
    }

    public Single<Integer> getSingleTest() {
        return Single.fromCallable(() -> {
            count++;
            if (count == 5) {
                retryDispose.dispose();
                count = 0;
            }
            Thread.sleep(1500);
            Log.d(TAG, "qqqqqqqqqqqqqqqqq" + count);
            return 1;
        });
    }

    public Single<Integer> getSingleTest2() {
        return Single.fromCallable(() -> {
            Thread.sleep(1000);
            Log.d(TAG, "wwwwwwwwwwwww");
            return 1;
        });
    }

    private Publisher<Integer> handleError(Throwable e) {
        //Timber.e(">>>>>>>>>>>>>> retry");
        return Flowable.just(0);
    }

    public void contactMapTest() {
        Observable.just("1", "2", "3").concatMap(s -> {
            Log.d(TAG, "this is my house" + s);
            return Observable.just(s + "#");
        }).subscribe(s -> {
            Log.d(TAG, "why I am here" + s);
        });
    }

    public void switchIfEmptyTest() {
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
                Log.d(TAG, "onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError" + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
        Observable.empty().concatMap(s -> (
                Observable.just(1, 2, 3))
        ).subscribe(observer);
    }
}
