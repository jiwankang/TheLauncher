package bestlauncher.thelauncher;

import android.app.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class SettingsActivity extends Activity {
    TextView title;
    TextView app4;
    TextView app3;
    TextView app2;
    TextView app1;
    PackageManager pm;
    String[] applist = new String[4];
    String[] savedSettings = new String[4];

    CharSequence[] allApps = new String[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        pm = getPackageManager();

        LinearLayout rl = (LinearLayout) findViewById(R.id.layout);
        getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_FULLSCREEN |
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

//        startService(new Intent(this, LockScreenService.class).setAction(Intent.ACTION_SCREEN_OFF));
//        setContentView(R.layout.settings);

        startService(new Intent(this, LockScreenService.class));
//        content = new TextView(this);
//        content.setText("Settings");
//        rl.addView(content);

        getSettings();
        loadApps();
        title = (TextView) findViewById(R.id.Title);
        title.setText("SETTINGS");

        app1 = (TextView) findViewById(R.id.app1);
        app1.setText("SWIPE RIGHT");

        app1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("CHOOSE AN APP");
                builder.setItems(allApps, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        writeFile(allApps[which], 0);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.setButton("CONFIRM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            File file = new File(getExternalFilesDir(""), "settings.csv");
                            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                            String fullLine;
                            while ((fullLine = reader.readLine()) != null) {
                                if (fullLine.contains(",")) {
                                    String[] separatedText = fullLine.split(",");
                                    applist[Integer.parseInt(separatedText[1])] = separatedText[0];
                                }
                            }
                            reader.close();

                        } catch (FileNotFoundException e) {
                            System.out.print("File not found");

                        } catch (IOException e2) {
                            System.out.print("IO exception thrown");
                        }
                    }
                });
                alertDialog.show();
            }
        });

        app2 = (TextView) findViewById(R.id.app2);
        app2.setText("SWIPE LEFT");
        app2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("CHOOSE AN APP");
                builder.setItems(allApps, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        writeFile(allApps[which], 1);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.setButton("CONFIRM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            File file = new File(getExternalFilesDir(""), "settings.csv");
                            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                            String fullLine;
                            while ((fullLine = reader.readLine()) != null) {
                                if (fullLine.contains(",")) {
                                    String[] separatedText = fullLine.split(",");
                                    applist[Integer.parseInt(separatedText[1])] = separatedText[0];
                                }
                            }
                            reader.close();

                        } catch (FileNotFoundException e) {
                            System.out.print("File not found");

                        } catch (IOException e2) {
                            System.out.print("IO exception thrown");
                        }
                    }
                });
                alertDialog.show();
            }
        });

        app3 = (TextView) findViewById(R.id.app3);
        app3.setText("SWIPE UP");
        app3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("CHOOSE AN APP");
                builder.setItems(allApps, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        writeFile(allApps[which], 2);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.setButton("CONFIRM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            File file = new File(getExternalFilesDir(""), "settings.csv");
                            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                            String fullLine;
                            while ((fullLine = reader.readLine()) != null) {
                                if (fullLine.contains(",")) {
                                    String[] separatedText = fullLine.split(",");
                                    applist[Integer.parseInt(separatedText[1])] = separatedText[0];
                                }
                            }
                            reader.close();

                        } catch (FileNotFoundException e) {
                            System.out.print("File not found");

                        } catch (IOException e2) {
                            System.out.print("IO exception thrown");
                        }
                    }
                });
                alertDialog.show();
            }
        });

        app4 = (TextView) findViewById(R.id.app4);
        app4.setText("SWIPE DOWN");
        app4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("CHOOSE AN APP");
                builder.setItems(allApps, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        writeFile(allApps[which], 3);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.setButton("CONFIRM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            File file = new File(getExternalFilesDir(""), "settings.csv");
                            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                            String fullLine;
                            while ((fullLine = reader.readLine()) != null) {
                                if (fullLine.contains(",")) {
                                    String[] separatedText = fullLine.split(",");
                                    applist[Integer.parseInt(separatedText[1])] = separatedText[0];
                                }
                            }
                            reader.close();

                        } catch (FileNotFoundException e) {
                            System.out.print("File not found");

                        } catch (IOException e2) {
                            System.out.print("IO exception thrown");
                        }
                    }
                });
                alertDialog.show();
            }
        });
    }

    public void getSettings(){
        try {
            File file = new File(getExternalFilesDir(""), "settings.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String fullLine;
            while((fullLine = reader.readLine()) != null) {
                if (fullLine.contains(",")) {
                    String[] separatedText = fullLine.split(",");
                    applist[Integer.parseInt(separatedText[1])] = separatedText[0];
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
    }
    private void loadApps() {
//get a list of installed apps.
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        Intent i =new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = pm.queryIntentActivities(i, 0);

       // ArrayList<String> appNames = new ArrayList<>();
      //  ArrayList<String> packageNames = new ArrayList<>();

     //   if (packages.size() == availableActivities.size()){
      //      createTextView(rl,"SAME");
      //  }
        int j = 0;
        for (ResolveInfo ri: availableActivities){
            allApps[j] = ri.activityInfo.packageName;
            j++;
            //  appNames.add(ri.loadLabel(pm).toString());
        }
    }

    private TextView createTextView(LinearLayout linearLayout, String lableText)
    {
        TextView tv = new TextView(getApplicationContext());
        tv.setText(lableText);
        linearLayout.addView(tv);
        return tv;
    }

    public void getSavedSettings(){
        try {
            File file = new File(getExternalFilesDir(""), "settings.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String fullLine;
            int i=0;
            while((fullLine = reader.readLine()) != null) {
                    savedSettings[i] = fullLine;
                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
    }

    public void writeFile(CharSequence newSetting, int gestureNumber) {
        try {
            File file = new File(getExternalFilesDir(""), "settings.csv");
            FileWriter writer = new FileWriter(file.getAbsoluteFile());
            PrintWriter printWriter = new PrintWriter(writer);

            CharSequence packageName;
            for (int i = 0; i < 4; i++) {
                if (i != gestureNumber) {
                    packageName = savedSettings[i];
                } else {
                    packageName = newSetting;
                }
                printWriter.println(String.format("%s,%s", packageName, gestureNumber));
            }
            printWriter.close();
            getSavedSettings();
        } catch (IOException e) {

        }

    }
}

