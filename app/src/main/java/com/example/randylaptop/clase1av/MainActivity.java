
package com.example.randylaptop.clase1av;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    public static final String URL_DIARIO = "https://www.diariolibre.com/rss/portada.xml";
    public static final String URL_WIRED = "https://www.wired.com/feed/rss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //String url2 = "Wired"

        Button boton1 = findViewById(R.id.bt1);
        Button boton2 = findViewById(R.id.btn2);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DiarioLibreActivity.class);
                intent.putExtra("URLKEY",URL_DIARIO);

                startActivity(intent);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DiarioLibreActivity.class);
                intent.putExtra("URLKEY",URL_WIRED);

                startActivity(intent);
            }
        });



    }



    }


