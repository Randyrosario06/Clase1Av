package com.example.randylaptop.clase1av;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {


    public static final String FEED_URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView web = findViewById(R.id.webview);

        String urlya = getIntent().getExtras().getString(FEED_URL);
        if(urlya != null){

            web.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
            web.getSettings().setJavaScriptEnabled(true);
            web.loadUrl(urlya);
        }else {
            Toast.makeText(this,"no me quiero ir sr stark :(",Toast.LENGTH_SHORT);
        }



    }
}
