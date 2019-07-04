package com.martin.retrofitwrapper.retrofit.interceptors.network;


import android.support.annotation.NonNull;

import java.io.IOException;

/**
 * Created by martin on 2/8/18.
 */

public class NoConnectionException extends IOException {


  @NonNull
  @Override
  public String getMessage() {
    return "No connectivity exception";
  }
}