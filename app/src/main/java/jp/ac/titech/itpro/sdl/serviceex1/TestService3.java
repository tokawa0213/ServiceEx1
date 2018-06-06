package jp.ac.titech.itpro.sdl.serviceex1;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

//send Message using broad cast

public class TestService3 extends IntentService {
    private final static String TAG = "TestService3";
    public final static String EXTRA_MYARG = "MYARG";
    public final static String ACTION_ANSWER = "ANS";
    public final static String EXTRA_ANSWER = "ANS";

    TestService3() {
        super(TAG);
    }
//
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));

        Intent answerIntent = new Intent();
        answerIntent.setAction(ACTION_ANSWER);
        answerIntent.putExtra(EXTRA_ANSWER,"Hello !");
        sendBroadcast(answerIntent);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}