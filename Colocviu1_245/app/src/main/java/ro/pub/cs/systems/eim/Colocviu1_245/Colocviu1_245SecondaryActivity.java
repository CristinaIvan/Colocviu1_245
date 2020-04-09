package ro.pub.cs.systems.eim.Colocviu1_245;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_245SecondaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);
        Intent intentFromMain= getIntent();
        Bundle data = intentFromMain.getExtras();

        String sum = intentFromMain.getStringExtra("ALL TERMS");
        String[] numbers = sum.replaceAll("\\s","").split("\\+", 10);

        int finalSum = 0;
        for (String num : numbers) {
            finalSum += Integer.parseInt(num);
        }

        Intent intentToMain = new Intent();
        intentToMain.putExtra("Sum", finalSum);
        setResult(RESULT_OK, intentToMain);
        finish();
    }
}
