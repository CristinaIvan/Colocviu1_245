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
        // intent from parent
        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();

        // process information from data ...
        String sum = intentFromParent.getStringExtra("ALL TERMS");
        String[] numbers = sum.replaceAll("\\s","").split("\\+", 10);

        int finalSum = 0;
        for (String num : numbers) {
            finalSum += Integer.parseInt(num);
        }

        // intent to parent
        Intent intentToParent = new Intent();
        intentToParent.putExtra("Sum", finalSum);
        setResult(RESULT_OK, intentToParent);
        finish();
    }
}
