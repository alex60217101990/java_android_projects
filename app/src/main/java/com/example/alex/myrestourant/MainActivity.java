package com.example.alex.myrestourant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.app.FragmentManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static android.R.id.content;
import static android.R.id.message;
import static android.R.id.tabhost;
import static android.provider.Telephony.Mms.Part.FILENAME;
import static java.security.AccessController.getContext;

import android.view.View.OnTouchListener;

public class MainActivity extends AppCompatActivity implements OnTouchListener {
    private FrameLayout container;
    int sost1=0;
    private WebView myBrowser;
    private FragmentManager myFragmentManager;
    private Fragment1 myFragment1;
    private Fragment2 myFragment2;
    private Fragment3 myFragment3;
    static int GlobCounterOrders=0;
    final String FILE_NAME = "OOrders.txt";
    static int allSize=0;
    private Handler handler = new Handler();
    static int counter;
    static double time_price;
    static ArrayList<TableMenuDataClass> table1_static = new ArrayList<TableMenuDataClass>();
    static ArrayList<TableWorkersDataClass> table2_static = new ArrayList<TableWorkersDataClass>();
    int sost=1;
    FloatingActionButton fab;
    BottomNavigationView navigation;
    TextView text;
    private boolean mShowingBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        container = (FrameLayout) findViewById(R.id.container);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                myBrowser = (WebView) findViewById(R.id.webview);
                myBrowser.getSettings().setJavaScriptEnabled(true);
                myBrowser.loadUrl("file:///android_asset/index5.html");

                myBrowser.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        sost1++;
                    //    myBrowser.setVisibility(View.INVISIBLE);
                        /*------------------------------------------------------------------------*/
                        if (sost1 > 9) sost1 = 1;
                        switch (sost1) {
                            case 1: {
                                myBrowser=null;
                                myBrowser = (WebView) findViewById(R.id.webview);
                                myBrowser.getSettings().setJavaScriptEnabled(true);
                                myBrowser.loadUrl("file:///android_asset/index.html");

                                break;
                            }
                            case 2: {
                                myBrowser=null;
                                myBrowser = (WebView) findViewById(R.id.webview);
                                myBrowser.getSettings().setJavaScriptEnabled(true);
                                myBrowser.loadUrl("file:///android_asset/index2.html");
                                break;
                            }
                            case 3: {
                                myBrowser=null;
                                myBrowser = (WebView) findViewById(R.id.webview);
                                myBrowser.getSettings().setJavaScriptEnabled(true);
                                myBrowser.loadUrl("file:///android_asset/index3.html");
                                break;
                            }
                            case 4: {
                                myBrowser=null;
                                myBrowser = (WebView) findViewById(R.id.webview);
                                myBrowser.getSettings().setJavaScriptEnabled(true);
                                myBrowser.loadUrl("file:///android_asset/index4.html");
                                break;
                            }
                            case 5: {
                                myBrowser=null;
                                myBrowser = (WebView) findViewById(R.id.webview);
                                myBrowser.getSettings().setJavaScriptEnabled(true);
                                myBrowser.loadUrl("file:///android_asset/index5.html");
                                break;
                            }
                            case 6: {
                                myBrowser=null;
                                myBrowser = (WebView) findViewById(R.id.webview);
                                myBrowser.getSettings().setJavaScriptEnabled(true);
                                myBrowser.loadUrl("file:///android_asset/index6.html");
                                break;
                            }
                            case 7: {
                                myBrowser=null;
                                myBrowser = (WebView) findViewById(R.id.webview);
                                myBrowser.getSettings().setJavaScriptEnabled(true);
                                myBrowser.loadUrl("file:///android_asset/index7.html");
                                break;
                            }
                            case 8: {
                                myBrowser=null;
                                myBrowser = (WebView) findViewById(R.id.webview);
                                myBrowser.getSettings().setJavaScriptEnabled(true);
                                myBrowser.loadUrl("file:///android_asset/index8.html");
                                break;
                            }
                            case 9: {
                                myBrowser=null;
                                myBrowser = (WebView) findViewById(R.id.webview);
                                myBrowser.getSettings().setJavaScriptEnabled(true);
                                myBrowser.loadUrl("file:///android_asset/index9.html");
                                break;
                            }

                        /*------------------------------------------------------------------------*/
                        }
                    return true;
                    }
                });
            }
        });



        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.container);
        assert frameLayout != null;
       /* fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  flipCard();
            }
        });*/


        View parentLayout = findViewById(R.id.main);
        parentLayout.setOnTouchListener(this);
        navigation = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

/*------------------------------------------------------------------------------------------------------------*/
        final ImageView ibHandle = (ImageView) findViewById(R.id.handle);
        // alpha 0 до 255
        SlidingDrawer slidingdrawer = (SlidingDrawer) findViewById(R.id.drawer);
        slidingdrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            public void onDrawerOpened() {
                ibHandle.setImageResource(R.drawable.ic_arrow_forward_black_24dp);
            }
        });
        slidingdrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            public void onDrawerClosed() {
                ibHandle.setImageResource(R.drawable.ic_arrow_back_black_24dp);
            }
        });
        slidingdrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {

            public void onScrollEnded() {
                // TODO Auto-generated method stub
                navigation.animate().scaleX(1).scaleY(1).setDuration(500).start();
            }

            public void onScrollStarted() {
                // TODO Auto-generated method stub

                navigation.animate().scaleX(0).scaleY(0).setDuration(500).start();
            }
        });
/*------------------------------------------------------------------------------------------------------------*/
        text = (TextView) findViewById(R.id.text_message);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.exit: {
                    finish();
                    text.setText("Exit");
                    return true;
                }
                case R.id.tables: {
                    // Show status bar
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    loadFragment(new Fragment1(), 2);
                    text.setText("Таблица базы данных:");
                    return true;
                }
                case R.id.del_table: {
                    // Show status bar
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    /*del fragment*/
                    loadFragment(new Fragment4(),3);
                    text.setText("Удаление информации из базы данных:");
                    return true;
                }
                case R.id.add_table1: {
                    // Hide status bar
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    loadFragment(new Fragment2(), 4);
                    text.setText("Добавление информации в таблицу заказов:");
                    return true;
                }
                case R.id.add_table2: {
                    // Show status bar
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    loadFragment(new Fragment3(), 5);
                    text.setText("Добавление информации в таблицу сотрудников:");
                    /*3 fragment*/
                    return true;
                }
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment, int counter) {
        FragmentTransaction ft;
      //  if (counter % 2 == 0) {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.background4, R.animator.background1,
                            R.animator.background2, R.animator.background3)
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
    }


            @Override
            public boolean onTouch (View v, MotionEvent event){

                // получаем координаты касания
                float mX = event.getX();
                float mY = event.getY();

                // переключатель в зависимости от типа события
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: { // нажатие
                    }
                    case MotionEvent.ACTION_MOVE: { // движение
                        Display display = getWindowManager().getDefaultDisplay();
                        int width = display.getWidth();  // deprecated
                        int height = display.getHeight();  // deprecated
                        if (mX > width / 2) {
                            sost++;
                        } else sost--;
                        if (sost > 4) sost = 1;
                        if (sost < 1) sost = 4;
                        switch (sost) {
                            case 2: {
                                // Show status bar
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                                loadFragment(new Fragment1(), 2);
                                text.setText("Таблица базы данных:");
                            }
                            case 1: {
                                // Show status bar
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                                text.setText("Exit:");
                                break;
                            }
                            case 3: {
                                // Show status bar
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                                text.setText("Удаление информации из базы данных:");
                                break;
                            }
                            case 4: {
                                // Hide status bar
                                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                                loadFragment(new Fragment2(), 4);
                                text.setText("Добавление информации в таблицу заказов:");
                                break;
                            }
                            case 5: {
                                // Show status bar
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                                loadFragment(new Fragment3(), 5);
                                text.setText("Добавление информации в таблицу сотрудников:");
                                break;
                            }
                        }
                    }
                    break;
                    case MotionEvent.ACTION_UP: // отпускание

                    case MotionEvent.ACTION_CANCEL:
                        // ничего не делаем
                        break;
                }
                return true;
            }
}



