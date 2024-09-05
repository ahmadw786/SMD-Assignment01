package com.example.smd_21l_5844;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SenderInfoActivity extends AppCompatActivity {

    private EditText etSenderName, etSenderEmail, etSenderPhone, etSenderCountry, etSenderAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_info);


        etSenderName = findViewById(R.id.etSenderName);
        etSenderEmail = findViewById(R.id.etSenderEmail);
        etSenderPhone = findViewById(R.id.etSenderContactInformation);
        etSenderCountry= findViewById(R.id.etSenderCountry);
        etSenderAddress = findViewById(R.id.etSenderAddress);

        Button nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(v -> {

            String senderName = etSenderName.getText().toString().trim();
            String senderEmail = etSenderEmail.getText().toString();
            String senderPhone = etSenderPhone.getText().toString();
            String senderCountry = etSenderCountry.getText().toString();
            String senderAddress = etSenderAddress.getText().toString();

            if (senderEmail.isEmpty()){
                Toast.makeText(SenderInfoActivity.this, "Kindly Enter Email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(senderEmail).matches()){
                Toast.makeText(SenderInfoActivity.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                return;
            }
            if (senderName.isEmpty()){
                Toast.makeText(SenderInfoActivity.this, "Kindly Enter Name", Toast.LENGTH_SHORT).show();
                return;
            }
            if (senderPhone.isEmpty()){
                Toast.makeText(SenderInfoActivity.this, "Kindly Enter Phone", Toast.LENGTH_SHORT).show();
                return;
            }
            if (senderCountry.isEmpty()){
                Toast.makeText(SenderInfoActivity.this, "Kindly Enter Country", Toast.LENGTH_SHORT).show();
                return;
            }
            if (senderAddress.isEmpty()){
                Toast.makeText(SenderInfoActivity.this, "Kindly Enter Address", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(SenderInfoActivity.this, ReceiverInfoActivity.class);


            intent.putExtra("sender_name", senderName);
            intent.putExtra("sender_country", senderCountry);
            intent.putExtra("sender_address", senderAddress);
            intent.putExtra("sender_contact_info", senderPhone);



            startActivity(intent);
        });
    }
}

