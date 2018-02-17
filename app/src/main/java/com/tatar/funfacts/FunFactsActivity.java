package com.tatar.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    // view variables
    private RelativeLayout container;
    private TextView funcFactTextView;
    private Button showFunFactButton;

    // providers
    private FactProvider factProvider = new FactProvider();
    private ColorProvider colorProvider = new ColorProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // assigning views
        container = findViewById(R.id.container);
        funcFactTextView = findViewById(R.id.funFactTxt);
        showFunFactButton = findViewById(R.id.showFactBtn);

        // button click
        showFunFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funcFactTextView.setText(factProvider.getRandomFact());

                int randomColor = Color.parseColor(colorProvider.getRandomColor());

                container.setBackgroundColor(randomColor);
                showFunFactButton.setTextColor(randomColor);

                //Toast.makeText(FunFactsActivity.this, "This is a toast message", Toast.LENGTH_SHORT).show();
            }
        });

        Log.d(TAG, "Logs from onCreate()");
    }
}
