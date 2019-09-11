package ece.course.lab_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Code for Lab 1 task 4
    boolean isDisplayBoy = true;
    String stringNameBoy;
    String stringNameGirl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*
        // Code for Lab 1 task 1
        TextView textView = new TextView(this);
        textView.setText("Adrian Yuen (hcayuen@connect.ust.hk) says Hello World");
        setContentView(textView);
*/
        // Code for Lab 1 task 4
        stringNameBoy = getResources().getString(R.string.nameBoy);
        stringNameGirl = getResources().getString(R.string.nameGirl);
        Button btnPicture = (Button)findViewById(R.id.btnPicture);
        Button btnName = (Button)findViewById(R.id.btnName);
        btnPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvName = (TextView)findViewById(R.id.tvName);
                ImageView ivPicture = (ImageView)findViewById(R.id.ivPicture);
                isDisplayBoy = !isDisplayBoy;
                if (isDisplayBoy) {
                    tvName.setText(stringNameBoy);
                    ivPicture.setImageResource(R.drawable.boy);
                } else {
                    tvName.setText(stringNameGirl);
                    ivPicture.setImageResource(R.drawable.girl);
                }
            }
        });
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = (EditText)findViewById(R.id.etName);
                String input = etName.getText().toString();
                if (!input.isEmpty())
                {
                    if (isDisplayBoy)
                        stringNameBoy = input;
                    else
                        stringNameGirl = input;
                    TextView tvName = (TextView)findViewById(R.id.tvName);
                    tvName.setText(input);
                    etName.setText("");
                    etName.clearFocus();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
