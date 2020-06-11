package com.dimache.farapayeshchart.base.remote.util;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 12/31/2017.
 *
 * Generic class of json recieved from API.
 * this class used in {@link retrofit2.Response}<RemoteModel>
 *
 */

public class RemoteModel<T, E> {

    /*main data of json*/
    @SerializedName("results")
    private T data;
    /*meta data of json*/
    private E meta;

    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public E getMeta() {
        return meta;
    }

    public void setMeta(E meta) {
        this.meta = meta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}