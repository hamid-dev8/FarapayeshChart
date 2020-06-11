package com.dimache.farapayeshchart.base.reactive;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * wrapper of Schedulers used in application.
 * {@link #main()} is android main thread (ui thread)
 * {@link #io()} for network calls, database operations, file system and ... (io operation)
 * {@link #computation()} for complex operations that run in another thread like as process image, compress file and ...
 */

public class RxSchedulers
{
    public static Scheduler main()
    {
        return AndroidSchedulers.mainThread();
    }

    public static Scheduler io()
    {
        return Schedulers.io();
    }

    public static Scheduler computation()
    {
        return Schedulers.computation();
    }

}
