package me.wangfeng.runtimeannotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import me.wangfeng.annotation.BundleMaker;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Item item = new Item();
        Bundle bundle = BundleMaker.make(item);
        if (bundle == null) {
            Log.e(TAG, "bundle is null");
            return;
        }
        Log.i(TAG, "int = " + bundle.getInt("intVal"));
        Log.i(TAG, "double = " + bundle.getDouble("doubleVal"));
        Log.i(TAG, "String = " + bundle.getString("stringVal"));
    }
}
