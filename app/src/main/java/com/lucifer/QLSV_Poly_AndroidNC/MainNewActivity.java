package com.lucifer.QLSV_Poly_AndroidNC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lucifer.QLSV_Poly_AndroidNC.WebView.MyWebViewClient;

public class MainNewActivity extends AppCompatActivity {
    private EditText addressBar;
    private WebView webView;
    private Button buttonGo;
    private Button buttonStatic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        buttonGo = (Button) findViewById(R.id.button_go);
        buttonStatic = (Button) findViewById(R.id.button_static);

        addressBar = (EditText) findViewById(R.id.editText_addressBar);
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://lms.poly.edu.vn3");


//        webView.setWebViewClient(new MyWebViewClient(addressBar));
//
//        buttonGo.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goUrl();
//            }
//        });
//
//        buttonStatic.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showStaticContent();
//            }
//        });
    }

    private void goUrl() {
        String url = addressBar.getText().toString().trim();
        if (url.isEmpty()) {
            Toast.makeText(this, "Please enter url", Toast.LENGTH_SHORT).show();
            return;
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }


    private void showStaticContent() {
        String staticContent = "<h2>Select web page</h2>"
                + "<ul><li><a href='http://ap.poly.edu.vn'>AP</a></li>"
                + "<li><a href='http://lms.poly.edu.vn'>LMS</a></li></ul>";
        webView.loadData(staticContent, "text/html", "UTF-8");
    }
}

