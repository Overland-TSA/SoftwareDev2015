package org.overland_tsa.overlandapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity {
	
	private String pageLocation;
	public static final String WEBPAGE_URL = "org.overland_tsa.overlandapp.webview_url";
	
	// constructor that didn't wanna work
	public WebViewActivity() {
		super();
		this.pageLocation = getIntent().getStringExtra(WebViewActivity.WEBPAGE_URL);
	}
	
	public WebViewActivity( String page ) {
		super();
		this.pageLocation = page;
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
