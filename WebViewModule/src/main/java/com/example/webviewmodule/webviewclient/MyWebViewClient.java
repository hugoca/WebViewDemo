package com.example.webviewmodule.webviewclient;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.webviewmodule.WebViewCallBack;

/**
 * @author hugoca on 2020/8/19.
 */
public class MyWebViewClient extends WebViewClient {
    private static final String TAG="MyWebViewClient";
    private WebViewCallBack mWebViewcallBack;

    public MyWebViewClient(WebViewCallBack mWebViewcallBack) {
        this.mWebViewcallBack = mWebViewcallBack;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if(mWebViewcallBack!=null){
            mWebViewcallBack.pageStarted(url);
        }else {
            Log.e(TAG,"WebViewCallBack is null");
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if(mWebViewcallBack != null) {
            mWebViewcallBack.pageFinished(url);
        } else {
            Log.e(TAG, "WebViewCallBack is null.");
        }
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        if(mWebViewcallBack != null) {
            mWebViewcallBack.onError();
        } else {
            Log.e(TAG, "WebViewCallBack is null.");
        }
    }
}
