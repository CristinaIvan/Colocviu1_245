package ro.pub.cs.systems.eim.Colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Colocviu1_245MainActivity extends AppCompatActivity {
    private EditText nextTerm, allTerms;
    private Button addButton, computeButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String next = nextTerm.getText().toString();
            String all = allTerms.getText().toString();
            switch(v.getId()) {
                case R.id.add_button:
                    if(!next.equals("")) {
                        if(all.equals("")){
                            allTerms.setText(next);
                        } else {
                            allTerms.setText(all + " + " + next);
                        }
                    }
                    break;
                case R.id.compute_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_245SecondaryActivity.class);
                    intent.putExtra("ALL TERMS", all);
                    startActivityForResult(intent, 1);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);

        nextTerm = (EditText)findViewById(R.id.next_term);
        allTerms = (EditText)findViewById(R.id.all_terms);

        addButton = (Button)findViewById(R.id.add_button);
        computeButton = (Button)findViewById(R.id.compute_button);
        addButton.setOnClickListener(buttonClickListener);
        computeButton.setOnClickListener(buttonClickListener);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        int result = intent.getIntExtra("Sum", 0);
        Toast.makeText(this, "The activity returned with result " + result, Toast.LENGTH_LONG).show();
    }
}
