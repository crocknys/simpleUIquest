package fr.wildcodeschool.simpleuiquest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox mboite = findViewById(R.id.buton);

        mboite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                EditText mnom = findViewById(R.id.firstname);
                EditText mprenom = findViewById(R.id.lastname);
                Button accept = findViewById(R.id.accept);

                if (b)
                {
                    mnom.setEnabled(true);
                    mprenom.setEnabled(true);
                    accept.setEnabled(true);
                } else {
                    mnom.setEnabled(false);
                    mprenom.setEnabled(false);
                    accept.setEnabled(false);
                }
            }
        });

    }


    public void acceptance (View view) {
        TextView congration = findViewById(R.id.congratulation);
        EditText mnom = findViewById(R.id.firstname);
        EditText mprenom = findViewById(R.id.lastname);
        String mFinalNom = mnom.getText().toString();
        String mFinalPrenom =mprenom.getText().toString();
        String CongratMessage = getString(R.string.congrats) + " " + mFinalPrenom + " " + mFinalNom;

        // if ((mFinalNom.matches("")) ) {
        //    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_LONG).show();
        // } if (mFinalPrenom.matches("")) {
        //    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_LONG).show();
        // } else {
        //    Toast.makeText(getApplicationContext(), "Congratulation " + mFinalNom + " " + mFinalPrenom, Toast.LENGTH_LONG).show();

        if ( (mFinalNom.length() < 2) || (mFinalPrenom.length() < 2) ) {
            Toast.makeText(getApplicationContext(), R.string.field_empty, Toast.LENGTH_LONG).show();
        }else{
            findViewById(R.id.congratulation).setVisibility(view.VISIBLE);
            congration.setText(CongratMessage);
        }
    }


}

