package xyz.sangcomz.exrxandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx.Observer;
import rx.Subscription;
import rx.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {

    public static PublishSubject<String> stringPublishSubject;
    String a = "b";


    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("a :::::: " + a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringPublishSubject = PublishSubject.create();

        Subscription subscription = stringPublishSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Observable completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Oh no! Something wrong happened");
            }

            @Override
            public void onNext(String s) {
                System.out.println("s :::: " + s);
                a = s;

            }
        });


        startActivity(new Intent(this, Main2Activity.class));

    }
}
