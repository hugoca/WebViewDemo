package com.example.webviewmodule;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;


import com.example.webviewmodule.bean.JsParam;
import com.example.webviewmodule.settings.WebViewDefaultSettings;
import com.example.webviewmodule.webchromeclient.MyWebChromeClient;
import com.example.webviewmodule.webviewclient.MyWebViewClient;
import com.google.gson.Gson;

import java.util.Map;

public class BaseWebView extends WebView {
    public static final String TAG = "BaseWebView";
    public BaseWebView(Context context) {
        super(context);
        init();
    }

    public BaseWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init(){
        WebViewDefaultSettings.getInstance().setSettings(this);
        addJavascriptInterface(this, TAG);
    }

    public void registerWebViewCallBack(WebViewCallBack webViewCallBack){
        setWebViewClient(new MyWebViewClient(webViewCallBack));
        setWebChromeClient(new MyWebChromeClient(webViewCallBack));
    }

    @JavascriptInterface
    public void takeNativeAction(final String jsParam){
        Log.i(TAG, jsParam);
        if(!TextUtils.isEmpty(jsParam)) {
            final JsParam jsParamObject = new Gson().fromJson(jsParam, JsParam.class);
            if(jsParamObject != null) {
                if("showToast".equalsIgnoreCase(jsParamObject.name)) {
                    Toast.makeText(getContext(), String.valueOf(new Gson().fromJson(jsParamObject.param, Map.class).get("message")), Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
