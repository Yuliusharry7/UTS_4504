package com.harhar.uts_4504;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button email = (Button)this.findViewById(R.id.button);
        email.setOnClickListener(new PesanElektronikListener());

        Button sms = (Button)this.findViewById(R.id.button2);
        sms.setOnClickListener(new PesanSingkatListener());

        Button panggil = (Button)this.findViewById(R.id.button3);
        panggil.setOnClickListener(new TelponListener());
    }


    protected class PesanElektronikListener implements View.OnClickListener {
        public void onClick(View v) {
            String email = "mailTo://";
            Intent iPesanElektronikListener = new Intent(Intent.ACTION_SENDTO, Uri.parse(email));
            iPesanElektronikListener.putExtra("address", "Yuliushrr@gmail.com");
            iPesanElektronikListener.putExtra("mail_body", "Hallo Broo");
            startActivity(iPesanElektronikListener);
        }
    }

    protected class PesanSingkatListener implements View.OnClickListener {

        public void onClick(View v) {
            Intent iPesanSingkatListener = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:081390051742"));

            iPesanSingkatListener.putExtra("sms_body", "Hallo Broo");
            startActivity(iPesanSingkatListener);
        }
    }

    protected class TelponListener implements View.OnClickListener {
        public void onClick(View v) {
            Intent iTelponListener = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:081390051742"));
            startActivity(iTelponListener);
        }
    }
}
