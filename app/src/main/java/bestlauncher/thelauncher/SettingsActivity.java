package bestlauncher.thelauncher;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_FULLSCREEN|
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);


        startService(new Intent(this,LockScreenService.class));
        setContentView(R.layout.settings);

    }
}

