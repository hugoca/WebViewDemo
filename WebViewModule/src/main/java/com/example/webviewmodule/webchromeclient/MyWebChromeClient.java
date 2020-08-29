package com.example.webviewmodule.webchromeclient;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.example.webviewmodule.WebViewCallBack;

/**
 * @author hugoca on 2020/8/19.
 */
public class MyWebChromeClient extends WebChromeClient {
    private static final String TAG = "MyWebChromeClient";
    private WebViewCallBack mWebViewcallBack;

    public MyWebChromeClient(WebViewCallBack mWebViewcallBack) {
        this.mWebViewcallBack = mWebViewcallBack;
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        if (mWebViewcallBack != null) {
            mWebViewcallBack.updateTitle(title);
        } else {
            Log.e(TAG, "WebViewCallBack is null.");
        }
    }

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Log.d(TAG,consoleMessage.message());
        return super.onConsoleMessage(consoleMessage);
    }
}
