package com.example.admin.frameworkdemo.Rxjava;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
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


public class RxjavaTest {
    private Context context;
    private final static String TAG = RxjavaTest.class.getSimpleName();

    public RxjavaTest(Context mContext) {
        context = mContext;
    }

    public void ObservableTest() {
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
                Log.d(TAG, "onNext" + integer);
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

        //observable.subscribe(observer);
        observable.doOnSubscribe(disposable -> {
                    Log.d(TAG, "doOnSubscribe");
                }
        ).doOnComplete(() -> {
            Log.d(TAG, "doOnComplete");
        }).doOnNext((C) -> {
            Log.d(TAG, "doNext" + C);
        }).subscribe(observer);
    }


    public void SingleTest() {
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
        Log.d(TAG, "andThen2Thread--->"+Thread.currentThread().getName());
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
                    Log.d(TAG, "doOncompelteThread1--->"+Thread.currentThread().getName());

                    Log.d(TAG, "andComplete1");
                })
                .andThen(andThen2())
                .doOnComplete(() -> {
                    Log.d(TAG, "doOncompelteThread2--->"+Thread.currentThread().getName());
                    Log.d(TAG, "andComplete2");
                }).subscribe(() -> {
                    Log.d(TAG, "andComplete3");
        });
    }

    public void CompletableTest() {
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

    public void retryWhenTest() {
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

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "执行这个。。。");
                emitter.onError(new Throwable("出错了"));
            }
        });

        observable.retryWhen(throwableObservable -> {
            return throwableObservable.zipWith(Observable.range(3, 3), (throwable, integer) -> {
                return integer;
            }).flatMap(integer -> {
                //timer 延迟执行的操作符
                Log.i(TAG, "延迟" + integer + "秒");
                return Observable.timer(integer, TimeUnit.SECONDS);
            });
        }).subscribe(observer);


    }

    public void contactMapTest(){
        Observable.just("1", "2", "3").concatMap(s -> {
            Log.d(TAG, "this is my house"+s);
            return Observable.just(s+"#");
        }).subscribe(s->{
            Log.d(TAG, "why I am here"+s);
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
