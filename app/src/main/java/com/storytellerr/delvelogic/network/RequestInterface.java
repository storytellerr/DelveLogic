package com.storytellerr.delvelogic.network;


import com.storytellerr.delvelogic.model.Android;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("v3/pools")
    Observable<List<Android>> register();
}
