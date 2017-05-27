package bestlauncher.thelauncher;
import android.app.Activity;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SettingsActivity extends Activity {
    TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.layout);
        getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_FULLSCREEN|
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

//        startService(new Intent(this, LockScreenService.class).setAction(Intent.ACTION_SCREEN_OFF));
//        setContentView(R.layout.settings);

        startService(new Intent(this,LockScreenService.class));
        content = new TextView(this);
        content.setText("APP NAME");
        rl.addView(content);

    content = new TextView(getApplicationContext());
    content.setText("I’ve replaced the label");
    rl.addView(content);
}}

