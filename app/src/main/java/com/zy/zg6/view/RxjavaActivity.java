package com.zy.zg6.view;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.zy.core.view.BaseActivity;
import com.zy.log.ZLog;
import com.zy.log.ZLogManager;
import com.zy.zg6.R;
import com.zy.zg6.entity.UserEntity;
import com.zy.zg6.mvvmdemo.view.UserLoginActivity;

import org.reactivestreams.Subscription;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RxjavaActivity extends BaseActivity {
    private Button btnRxjavaTest1;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);

    }

    @SuppressLint("AutoDispose")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        btnRxjavaTest1 = (Button) findViewById(R.id.btn_rxjava_Test1);

        btnRxjavaTest1.setOnClickListener((view)->{
//            Observable.create(new ObservableOnSubscribe<String>() {
//                @Override
//                public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                    emitter.onNext("1");
//                    emitter.onNext("2");
//                    emitter.onError(new NullPointerException("null"));
//                    emitter.onComplete();
//
////                    emitter.onError(new NullPointerException("null"));
//                }
//            }).subscribe(new Observer<String>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//                    ZLogManager.getInstance().d("onsubscribe");
//
//                }
//
//                @Override
//                public void onNext(String s) {
//                    ZLogManager.getInstance().d("s="+s);
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    ZLogManager.getInstance().e("e="+e.getLocalizedMessage());
//                }
//
//                @Override
//                public void onComplete() {
//                    ZLogManager.getInstance().d("complete");
//                }
//            });

//            Flowable.create(new FlowableOnSubscribe<String>() {
//                @Override
//                public void subscribe(FlowableEmitter<String> emitter) throws Exception {
//                    emitter.onNext("11");
//                    emitter.onNext("22");
//                    emitter.onComplete();
//                }
//            }, BackpressureStrategy.LATEST)
//                    .subscribe(new FlowableSubscriber<String>() {
//                @Override
//                public void onSubscribe(Subscription s) {
//                    s.request(Integer.MAX_VALUE);
//
//                    ZLogManager.getInstance().d("subscribe");
//                }
//
//                @Override
//                public void onNext(String s) {
//                    ZLogManager.getInstance().d("s="+s);
//                }
//
//                @Override
//                public void onError(Throwable t) {
//                    ZLogManager.getInstance().e("error->"+t.getLocalizedMessage());
//                }
//
//                @Override
//                public void onComplete() {
//                    ZLogManager.getInstance().d("complete");
//                }
//            });

//            Observable.just("1","2").subscribe(new Consumer<String>() {
//                @Override
//                public void accept(String s) throws Exception {
//                    ZLogManager.getInstance().d("s="+s);
//                }
//            });

//            Observable.timer(2, TimeUnit.SECONDS)
//                    .subscribe(new Consumer<Long>() {
//                        @Override
//                        public void accept(Long aLong) throws Exception {
//                            ZLogManager.getInstance().d(""+aLong);
//                        }
//                    });
//            Observable.interval(1,TimeUnit.SECONDS)
//                    .subscribe(new Consumer<Long>() {
//                        @Override
//                        public void accept(Long aLong) throws Exception {
//                            ZLogManager.getInstance().d(""+aLong);
//                        }
//                    });

//            Observable.intervalRange(3,10,2,1,TimeUnit.SECONDS)
//                    .subscribe(new Consumer<Long>() {
//                        @Override
//                        public void accept(Long aLong) throws Exception {
//                            ZLogManager.getInstance().d(""+aLong);
//                        }
//                    });

//            Observable.create(new ObservableOnSubscribe<UserEntity>() {
//                @Override
//                public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
//                    emitter.onNext(new UserEntity());
//                }
//            }).map(new Function<UserEntity, String>() {
//                @Override
//                public String apply(UserEntity s) throws Exception {
//                    return s.getName();
//                }
//            }).subscribe(new Consumer<String>() {
//                @Override
//                public void accept(String integer) throws Exception {
//                    ZLogManager.getInstance().d(""+integer);
//                }
//            });

//            List<String> list=new ArrayList<>();
//            for (int i=0;i<20;i++){
//                list.add(""+i);
//            }
//
//            Observable.fromIterable(list).buffer(2)
//                    .subscribe(new Consumer<List<String>>() {
//                        @Override
//                        public void accept(List<String> strings) throws Exception {
//                            for (int n=0;n<strings.size();n++){
//                                ZLogManager.getInstance().d(""+strings.get(n));
//                            }
//                            ZLogManager.getInstance().d("--------------------------");
//                        }
//                    });

//            Observable<String> stringObservable = Observable.just("1", "2", "3");
//            Observable<Integer> integerObservable=Observable.just(11,22,33);
//
//            Observable.concat(stringObservable,integerObservable).subscribe(new Consumer<Object>() {
//                @Override
//                public void accept(Object object) throws Exception {
//                    ZLogManager.getInstance().d(""+object.toString());
//                }
//            });

//            Observable.create(new ObservableOnSubscribe<String>() {
//                @Override
//                public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                    emitter.onNext("11");
//                    emitter.onNext("22");
//                    emitter.onComplete();
//                }
//            }).doOnEach(new Consumer<Notification<String>>() {
//                @Override
//                public void accept(Notification<String> stringNotification) throws Exception {
//                    ZLogManager.getInstance().d("doOnEach is execute...");
//                }
//            }).doOnNext(new Consumer<String>() {
//                @Override
//                public void accept(String s) throws Exception {
//                    ZLogManager.getInstance().d("onNext before");
//                }
//            }).doAfterNext(new Consumer<String>() {
//                @Override
//                public void accept(String s) throws Exception {
//                    ZLogManager.getInstance().d("onNext after");
//                }
//            }).subscribe(new Consumer<String>() {
//                @Override
//                public void accept(String s) throws Exception {
//                    ZLogManager.getInstance().d(s);
//                }
//            });

//            Observable
//                    .interval(1, TimeUnit.SECONDS)
//                    .takeUntil(Observable.timer(5, TimeUnit.SECONDS))
//                    .subscribe(new Consumer<Long>() {
//                        @Override
//                        public void accept(Long aLong) throws Exception {
//                            Log.d("123", String.valueOf(aLong));
//                        }
//                    });

//            Observable.range(0, 10)
//                    .takeWhile(new Predicate<Integer>() {
//                        @Override
//                        public boolean test(Integer integer) throws Exception {
//                            if (integer < 6)
//                                return true;
//                            return false;
//                        }
//                    })
//                    .subscribe(new Consumer<Integer>() {
//                        @Override
//                        public void accept(Integer integer) throws Exception {
//                            Log.d("123", String.valueOf(integer));
//                        }
//                    });

//            Observable.range(1, 5)
//                    .elementAt(3,21)
//                    .subscribe(new Consumer<Integer>() {
//                        @Override
//                        public void accept(Integer integer) throws Exception {
//                            Log.d("123", String.valueOf(integer));
//                        }
//                    });

//            Single.create(new SingleOnSubscribe<String>() {
//                @Override
//                public void subscribe(SingleEmitter<String> emitter) throws Exception {
//                    emitter.onSuccess("");
//                    emitter.onError(new NullPointerException());
//                }
//            }).subscribe(new Consumer<String>() {
//                @Override
//                public void accept(String s) throws Exception {
//
//                }
//            });

//            Completable.create(new CompletableOnSubscribe() {
//                @Override
//                public void subscribe(CompletableEmitter emitter) throws Exception {
//
//                }
//            }).subscribe(new CompletableObserver() {
//                @Override
//                public void onSubscribe(Disposable d) {
//
//                }
//
//                @Override
//                public void onComplete() {
//
//                }
//
//                @Override
//                public void onError(Throwable e) {
//
//                }
//            });

//            Maybe.create(new MaybeOnSubscribe<String>() {
//                @Override
//                public void subscribe(MaybeEmitter<String> emitter) throws Exception {
//
//                }
//            }).subscribe(new MaybeObserver<String>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//
//                }
//
//                @Override
//                public void onSuccess(String s) {
//
//                }
//
//                @Override
//                public void onError(Throwable e) {
//
//                }
//
//                @Override
//                public void onComplete() {
//
//                }
//            });

//            Observable.interval(1,TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))
//                    .subscribe(new Observer<Long>() {
//                        @Override
//                        public void onSubscribe(Disposable d) {
//
//                        }
//
//                        @Override
//                        public void onNext(Long aLong) {
//                            Log.d("123", "onNext: "+aLong);
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//
//                        }
//
//                        @Override
//                        public void onComplete() {
//                            Log.d("123", "onComplete: ");
//                        }
//                    });

//            Observable.interval(1,TimeUnit.SECONDS)
//                    .subscribe(new Consumer<Long>() {
//                        @Override
//                        public void accept(Long aLong) throws Exception {
//
//                        }
//                    });
            startActivity(UserLoginActivity.class);

        });
    }

    int method1(){
       return 1+2;
    }
}