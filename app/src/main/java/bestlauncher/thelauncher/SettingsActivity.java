package bestlauncher.thelauncher;
import android.app.Activity;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


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

        Button createButton = new Button(getApplicationContext());
        createButton.setText("Create File");
        createButton.setOnClickListener(new View.OnClickListener() {
            float x,y,z;
            public void onClick(View v) {
                try {
                    File file = new File(getExternalFilesDir("aaa"), "Lab1.csv");
                    FileWriter writer = new FileWriter(file.getAbsoluteFile());
                    PrintWriter printWriter = new PrintWriter(writer);
                    for(int i=0; i<100; i++){
                        x = fileContents[i][0];
                        y = fileContents[i][1];
                        z = fileContents[i][2];
                        printWriter.println(String.format("%f,%f,%f", x,y,z));
                    }
                    printWriter.close();
                } catch (IOException e) {

                }
            }
        });
        rl.addView( (Button) createButton);
}}

