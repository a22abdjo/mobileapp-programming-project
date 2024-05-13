package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


    @SuppressWarnings("FieldCanBeLocal")
    public static class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {


        private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
        private final String JSON_FILE = "mountains.json";

        ArrayList<Mountain> items = new ArrayList<>();

        ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();

        private RecyclerViewAdapter adapter;

        private Gson gson;
            private WebView myWebView;

            public void showExternalWebPage() {
                // TODO: Add your code for showing external web page here
                myWebView.loadUrl("file:///android_res/layout/activity_main.xml");
            }

            public void showInternalWebPage() {
                // TODO: Add your code for showing internal web page here
                myWebView.loadUrl("https://his.se");

                //Intent intent = new Intent(MainActivity.this,SkorActivity.class);
                //startActivity(intent);

            }

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                Toolbar toolbar= findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);

                myWebView = findViewById(R.id.my_webview);
                myWebView.setWebViewClient(new WebViewClient()); // Do not open in Chrome!
                myWebView.loadUrl("file:///android_res/layout/activity_main.xml");
                gson = new Gson();


                for (int i = 0; i < items.size(); i++) {
                    Log.d("Kyckling", items.get(i).toString());
                    recyclerViewItems.add(new RecyclerViewItem(items.get(i).toString()));
                }
                new JsonFile(this, this).execute(JSON_FILE);
                //new JsonTask(this).execute(JSON_URL);

                adapter = new RecyclerViewAdapter(this, recyclerViewItems, new RecyclerViewAdapter.OnClickListener() {
                    @Override
                    public void onClick(RecyclerViewItem item) {
                        Toast.makeText(com.example.project.MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });

                RecyclerView view = findViewById(R.id.recycler_view);
                view.setLayoutManager(new LinearLayoutManager(this));
                view.setAdapter(adapter);


            }

            public boolean onOptionsItemSelected(MenuItem item) {
                //noinspection SimplifiableIfStatement
                int id = item.getItemId();
                if (id == R.id.action_external_web) {
                    Log.d("==>", "Will display external web page");
                    showExternalWebPage();
                    return true;
                }

                if (id == R.id.action_internal_web) {
                    Log.d("==>", "Will display internal web page");
                    showInternalWebPage();
                    return true;
                }
                return super.onOptionsItemSelected(item);
            }

            @Override
            public void onPostExecute(String json) {
                Log.d("MainActivity", "" + json);

                Type type = new TypeToken<List<Skor>>() {
                }.getType();
                items = gson.fromJson(json, type);
                for (int i = 0; i < items.size(); i++) {
                    Log.d("Kyckling2", items.get(i).toString());
                    recyclerViewItems.add(new RecyclerViewItem(items.get(i).toString()));
                }
                //adapter.notifyDataSetChanged();
            }
        }
}


