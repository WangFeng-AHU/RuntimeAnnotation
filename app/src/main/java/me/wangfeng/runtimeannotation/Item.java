package me.wangfeng.runtimeannotation;

import me.wangfeng.annotation.BundleField;

/**
 * Created by wangfeng on 17/2/15.
 */

public class Item {

    @BundleField(key = "intVal")
    int intVal = 1;

    @BundleField(key = "doubleVal")
    double doubleVal = 2.0;

    @BundleField(key = "stringVal")
    String stringVal = "string";
}
