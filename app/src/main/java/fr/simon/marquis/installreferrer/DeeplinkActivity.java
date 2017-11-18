package fr.simon.marquis.installreferrer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DeeplinkActivity extends Activity {
    private TextView deeplink;
    private TextView installReferrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeplink);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String dl = intent.getStringExtra(MainActivity.DEEPLINK);
        Log.d("debug", "got deeplink " + dl);

        // Capture the layout's TextView and set the string as its text
        deeplink = (TextView) findViewById(R.id.deeplink);
        deeplink.setText(dl);

        String ir = intent.getStringExtra(MainActivity.INSTALL_REFERRER);
        Log.d("debug", "got install referrer " + ir);

        installReferrer = (TextView) findViewById(R.id.install_referrer);
        installReferrer.setText(ir);
    }
}
