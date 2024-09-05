package com.example.smd_21l_5844;



import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiverInfoActivity extends AppCompatActivity {

    private EditText etReceiverName, etReceiverAddress, etReceiverEmail, etReceiverPhone, etReceiverCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_info);


        etReceiverName = findViewById(R.id.etReceiverName);
        etReceiverAddress = findViewById(R.id.etReceiverAddress);
        etReceiverEmail = findViewById(R.id.etReceiverEmail);
        etReceiverPhone = findViewById(R.id.etReceiverContactInformation);
        etReceiverCountry = findViewById(R.id.etReceiverCountry);

        Button nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(v -> {

            String receiverName = etReceiverName.getText().toString();
            String receiverAddress = etReceiverAddress.getText().toString();
            String receiverEmail = etReceiverEmail.getText().toString();
            String receiverPhone = etReceiverPhone.getText().toString();
            String receiverCountry = etReceiverCountry.getText().toString();

            if (receiverEmail.isEmpty()) {
                Toast.makeText(ReceiverInfoActivity.this, "Kindly Enter Email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(receiverEmail).matches()){
                Toast.makeText(ReceiverInfoActivity.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                return;
            }
            if (receiverName.isEmpty()){
                Toast.makeText(ReceiverInfoActivity.this, "Kindly Enter Name", Toast.LENGTH_SHORT).show();
                return;
            }
            if (receiverPhone.isEmpty()){
                Toast.makeText(ReceiverInfoActivity.this, "Kindly Enter Phone", Toast.LENGTH_SHORT).show();
                return;
            }
            if (receiverCountry.isEmpty()){
                Toast.makeText(ReceiverInfoActivity.this, "Kindly Enter Country", Toast.LENGTH_SHORT).show();
                return;
            }
            if (receiverAddress.isEmpty()){
                Toast.makeText(ReceiverInfoActivity.this, "Kindly Enter Address", Toast.LENGTH_SHORT).show();
                return;
            }


            Intent intent = getIntent();
            String senderName = intent.getStringExtra("sender_name");
            String senderPhone = intent.getStringExtra("sender_contact_info");
            String senderCountry = intent.getStringExtra("sender_country");
            String senderAddress = intent.getStringExtra("sender_address");


            intent = new Intent(ReceiverInfoActivity.this, ReviewInfoActivity.class);

            intent.putExtra("sender_name", senderName);
            intent.putExtra("sender_country", senderCountry);
            intent.putExtra("sender_address", senderAddress);
            intent.putExtra("sender_contact_info", senderPhone);

            intent.putExtra("receiver_name", receiverName);
            intent.putExtra("receiver_country", receiverCountry);
            intent.putExtra("receiver_address", receiverAddress);
            intent.putExtra("receiver_contact_info", receiverPhone);


            startActivity(intent);
            finish();
        });
    }
}

