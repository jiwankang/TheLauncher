package bestlauncher.thelauncher;
import android.app.Activity;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SettingsActivity extends Activity {
    TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        LinearLayout rl = (LinearLayout)findViewById(R.id.layout);
        rl.setOrientation(LinearLayout.VERTICAL);
        getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_FULLSCREEN|
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

//        startService(new Intent(this, LockScreenService.class).setAction(Intent.ACTION_SCREEN_OFF));
//        setContentView(R.layout.settings);

        startService(new Intent(this,LockScreenService.class));
        content = new TextView(this);
        content.setText("APP NAME");
        rl.addView(content);


try {
    content = new TextView(getApplicationContext());
    content.setText("I’ve replaced the label");
    rl.addView(content);
}catch (Exception e) {
    }
}}

