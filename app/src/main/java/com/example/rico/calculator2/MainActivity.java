package com.example.rico.calculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double sum;
    private TextView total;
    private Button butt1;
    private Button butt2;
    private Button butt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = (TextView) findViewById(R.id.totalView);
        Button clearButton = (Button) findViewById(R.id.clearButton);
        Button otherButton = (Button) findViewById(R.id.otherButton);
        butt1 = (Button) findViewById(R.id.button1);
        butt2 = (Button) findViewById(R.id.button2);
        butt3 = (Button) findViewById(R.id.button3);


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = 0.0;
                total.setText("0");
            }
        });

        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butt1.setText("1/2");
                butt2.setText("1/3");
                butt3.setText("1/4");
            }
        });
    }

    public void ButtonPressed(View view){
        Button button = (Button) view;
        String buttonText = (String) button.getText();
        if(buttonText.equals("1/2")||buttonText.equals("1/3")||buttonText.equals("1/4")){
            switch (buttonText) {
                case "1/2": sum = sum + 0.5;
                    break;
                case "1/3": sum = sum + 0.33;
                    break;
                case "1/4": sum = sum+ 0.25;
                    break;
            }
            butt1.setText("1");
            butt2.setText("2");
            butt3.setText("3");
        }
        else{
            double value = Double.parseDouble(buttonText);
            sum = sum + value;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        sum = Double.valueOf(df.format(sum));
        String converted = Double.toString(sum);

        total.setText(converted);
    }

}
