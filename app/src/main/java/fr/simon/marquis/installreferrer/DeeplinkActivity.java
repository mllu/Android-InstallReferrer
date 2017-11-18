package fr.simon.marquis.installreferrer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;

public class DeeplinkActivity extends Activity {
    private TextView deeplink;
    private TextView installReferrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeplink);

        deeplink = (TextView) findViewById(R.id.deeplink);
        installReferrer = (TextView) findViewById(R.id.install_referrer);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null && data.isHierarchical()) {

            String uri = this.getIntent().getDataString();
//            Log.d("debug", "deeplink: "+data.toString());
            Log.d("debug", "Deep link clicked " + uri);
            StringBuilder sb = new StringBuilder();
            sb.append("<b>Deeplink:</b>")
                    .append("<br/>")
                    .append(uri);
            deeplink.setText(Html.fromHtml(sb.toString()));
            deeplink.setMovementMethod(new LinkMovementMethod());
            return;
        }

        String dl = intent.getStringExtra(MainActivity.DEEPLINK);
        Log.d("debug", "got deeplink " + dl);

        // Capture the layout's TextView and set the string as its text
        deeplink.setText(dl);

        String ir = intent.getStringExtra(MainActivity.INSTALL_REFERRER);
        Log.d("debug", "got install referrer " + ir);

        installReferrer.setText(ir);
    }
}
