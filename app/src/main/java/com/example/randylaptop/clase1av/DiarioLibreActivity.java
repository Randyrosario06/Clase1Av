package com.example.randylaptop.clase1av;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;
import java.util.List;

import static com.example.randylaptop.clase1av.WebViewActivity.FEED_URL;

public class DiarioLibreActivity extends AppCompatActivity {


    ListView lista;

    private ArrayList<Article> articleArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario_libre);

        lista  = findViewById(R.id.list);
        String url = getIntent().getExtras().getString("URLKEY");
        Parser parser = new Parser();
        parser.onFinish(new Parser.OnTaskCompleted(){
            @Override
            public void onTaskCompleted(ArrayList<Article> list) {

                lista.setAdapter(new FeedAdapter(getApplicationContext(),list));
                articleArrayList = list;
            }

            @Override
            public void onError() {

            }
        });

        parser.execute(url);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String url = articleArrayList.get(position).getLink();
                if(position%2 == 0){

                    Intent inten = new Intent(DiarioLibreActivity.this,WebViewActivity.class);
                    inten.putExtra(FEED_URL,url);
                    startActivity(inten);

                }else{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);

                }
            }
        });
    }
}
