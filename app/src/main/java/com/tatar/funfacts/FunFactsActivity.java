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

    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";

    // view variables
    private RelativeLayout container;
    private TextView funcFactTextView;
    private Button showFunFactButton;

    // providers
    private FactProvider factProvider = new FactProvider();
    private ColorProvider colorProvider = new ColorProvider();

    private String fact = factProvider.facts[0];
    private int color = Color.parseColor(colorProvider.colors[8]);

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

                fact = factProvider.getRandomFact();
                funcFactTextView.setText(fact);

                color = Color.parseColor(colorProvider.getRandomColor());
                container.setBackgroundColor(color);
                showFunFactButton.setTextColor(color);
            }
        });

        Log.d(TAG, "Logs from onCreate()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, fact);
        outState.putInt(KEY_COLOR, color);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        fact = savedInstanceState.getString(KEY_FACT);
        funcFactTextView.setText(fact);

        color = savedInstanceState.getInt(KEY_COLOR);
        container.setBackgroundColor(color);
        showFunFactButton.setTextColor(color);
    }
}
