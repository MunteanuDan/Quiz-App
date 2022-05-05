package eu.ase.tema_quiz_munteanu_dan_cristian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Quiz extends AppCompatActivity {

    RadioGroup rg1, rg2, rg3, rg4, rg5;
    Button btnReset, btnSubmit;

    Integer n;

    TextView tvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        rg1 = findViewById(R.id.rgMotor);
        rg2 = findViewById(R.id.rgViteza);
        rg3 = findViewById(R.id.rgInclinare);
        rg4 = findViewById(R.id.rgConectareBluetooth);
        rg5 = findViewById(R.id.rgGreutateMaxima);
        btnReset = findViewById(R.id.buttonReset);
        btnSubmit = findViewById(R.id.buttonSubmit);

        n = 0;

        tvTimer = findViewById(R.id.tv_timer);
        long duration = TimeUnit.MINUTES.toMillis(1);

        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                        , TimeUnit.MILLISECONDS.toMinutes(l)
                        ,TimeUnit.MILLISECONDS.toSeconds(l) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                tvTimer.setText(sDuration);
            }

            @Override
            public void onFinish() {
                    Intent intent = new Intent(Quiz.this, ExpiredTimeActivity.class);
                    startActivity(intent);
            }
        }.start();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId1 = rg1.getCheckedRadioButtonId();
                int checkedId2 = rg2.getCheckedRadioButtonId();
                int checkedId3 = rg3.getCheckedRadioButtonId();
                int checkedId4 = rg4.getCheckedRadioButtonId();
                int checkedId5 = rg5.getCheckedRadioButtonId();
                if (checkedId1 == -1 || checkedId2 == -1 || checkedId3 == -1 || checkedId4 == -1 || checkedId5 == -1 ) { // Niciun radioButton nu e selectat
                    Toast.makeText(Quiz.this, "Nu ati completat toate campurile!", Toast.LENGTH_LONG).show();
                } else {  // daca este un radioButton selectat
                    findRadioButton1(checkedId1);
                    findRadioButton2(checkedId2);
                    findRadioButton3(checkedId3);
                    findRadioButton4(checkedId4);
                    findRadioButton5(checkedId5);
                    Toast.makeText(Quiz.this, n.toString(), Toast.LENGTH_LONG).show();

                    if(n<=5)
                    {
                        Intent intent = new Intent(Quiz.this, Rezultat1.class );
                        startActivity(intent);
                        finish();
                    }else if(n>5 && n<=9)
                    {
                        Intent intent = new Intent(Quiz.this, Rezultat2.class );
                        startActivity(intent);
                        finish();
                    }else if(n>9 && n<=13)
                    {
                        Intent intent = new Intent(Quiz.this, Rezultat3.class );
                        startActivity(intent);
                        finish();
                    }


                    n = 0;
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg1.clearCheck(); // sa dam reset la cele selectate
                rg2.clearCheck();
                rg3.clearCheck();
                rg4.clearCheck();
                rg5.clearCheck();
                n = 0;
            }
        });
    }

    private void findRadioButton1(int checkedId) {
        switch (checkedId) {
            case R.id.radioButton1: {

                n = n + 1;
                break;
            }
            case R.id.radioButton2: {

                n = n + 2;
                break;
            }
        }
    }

    private void findRadioButton2(int checkedId2) {
        switch (checkedId2) {
            case R.id.radioButton3: {
                n = n + 1;
                break;
            }
            case R.id.radioButton4: {
                n = n + 2;
                break;
            }
            case R.id.radioButton5: {
                n = n + 3;
                break;
            }
        }
    }

    private void findRadioButton3(int checkedId3) {
        switch (checkedId3) {
            case R.id.radioButton6: {
                n = n + 1;
                break;
            }
            case R.id.radioButton7: {
                n = n + 2;
                break;
            }
            case R.id.radioButton8: {
                n = n + 3;
                break;
            }
        }
    }

    private void findRadioButton4(int checkedId3) {
        switch (checkedId3) {
            case R.id.radioButton9: {
                n = n + 1;
                break;
            }
            case R.id.radioButton10: {
                n = n + 2;
                break;
            }
        }
    }

    private void findRadioButton5(int checkedId3) {
        switch (checkedId3) {
            case R.id.radioButton11: {
                n = n + 1;
                break;
            }
            case R.id.radioButton12: {
                n = n + 2;
                break;
            }
            case R.id.radioButton13: {
                n = n + 3;
                break;
            }
        }
    }


}