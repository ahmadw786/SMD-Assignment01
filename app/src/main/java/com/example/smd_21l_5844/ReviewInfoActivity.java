package com.example.smd_21l_5844;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReviewInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_info);


        TextView tvSenderName = findViewById(R.id.tvSenderName);
        TextView tvSenderCountry = findViewById(R.id.tvSenderCountry);
        TextView tvSenderAddress = findViewById(R.id.tvSenderAddress);
        TextView tvSenderContactInfo = findViewById(R.id.tvSenderContactInfo);


        TextView tvReceiverName = findViewById(R.id.tvReceiverName);
        TextView tvReceiverCountry = findViewById(R.id.tvReceiverCountry);
        TextView tvReceiverAddress = findViewById(R.id.tvReceiverAddress);
        TextView tvReceiverContactInfo = findViewById(R.id.tvReceiverContactInfo);


        Intent intent = getIntent();




        String senderName = intent.getStringExtra("sender_name");


        String senderCountry = intent.getStringExtra("sender_country");
        String senderAddress = intent.getStringExtra("sender_address");
        String senderContactInfo = intent.getStringExtra("sender_contact_info"); // Correct key here


        String receiverName = intent.getStringExtra("receiver_name");

        String receiverCountry = intent.getStringExtra("receiver_country");
        String receiverAddress = intent.getStringExtra("receiver_address");
        String receiverContactInfo = intent.getStringExtra("receiver_contact_info");


        if (senderName != null) tvSenderName.setText(senderName);
        if (senderCountry != null) tvSenderCountry.setText(senderCountry);
        if (senderAddress != null) tvSenderAddress.setText(senderAddress);
        if (senderContactInfo != null) tvSenderContactInfo.setText(senderContactInfo);

        if (receiverName != null) tvReceiverName.setText(receiverName);
        if (receiverCountry != null) tvReceiverCountry.setText(receiverCountry);
        if (receiverAddress != null) tvReceiverAddress.setText(receiverAddress);
        if (receiverContactInfo != null) tvReceiverContactInfo.setText(receiverContactInfo);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReviewInfoActivity.this, SenderInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
