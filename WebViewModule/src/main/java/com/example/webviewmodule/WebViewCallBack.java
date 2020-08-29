package com.example.webviewmodule;

/**
 * @author hugoca on 2020/8/19.
 */
public interface WebViewCallBack {
    void pageStarted(String url);
    void pageFinished(String url);
    void onError();
    void updateTitle(String title);
}
