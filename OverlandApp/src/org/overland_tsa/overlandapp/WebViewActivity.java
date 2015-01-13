package org.overland_tsa.overlandapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity {
	
	private String pageLocation;
	public static final String WEBPAGE_URL = "org.overland_tsa.overlandapp.webview_url";
	
	public WebViewActivity() {
		super();
		this.pageLocation = (String)getIntent().getSerializableExtra(WebViewActivity.WEBPAGE_URL);
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Display the general WebView layout
        setContentView( R.layout.activity_webview );
        
        // choose the page to show
        WebView myWebView = (WebView) findViewById(R.id.webview_frame);
        myWebView.loadUrl( this.pageLocation );
        
    }
	
}
