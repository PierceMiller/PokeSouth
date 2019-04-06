package pokesouth.com.pokesouth;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Map_Pokemo extends Fragment {

    View v;

    public Map_Pokemo() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_raid_map,container, false);

        WebView webView = (WebView) v.findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://map.pokemo.nz/");

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setAppCacheEnabled(true);

        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);

        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){

            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }else{
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        return v;
    }
}