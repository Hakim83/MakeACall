package com.example.mohammed.makeacall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        final CheckBox chkDirectCall = (CheckBox)findViewById(R.id.chkDirectCall);
        Button btnCall = (Button)findViewById(R.id.btnCall);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //specify action depending on option checked
                String intentAction;
                if (chkDirectCall.isChecked()){
                    intentAction = Intent.ACTION_CALL;
                } else {
                    intentAction = Intent.ACTION_DIAL;
                }

                //prepare intent and fire
                String number = etPhoneNumber.getText().toString();
                if (!number.isEmpty()) {
                    Intent callIntent = new Intent(intentAction, Uri.parse("tel:"+number));
                    startActivity(callIntent);
                } else{
                    //You can't call an empty number
                    Toast.makeText(getApplicationContext(),"Please Enter a number",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
