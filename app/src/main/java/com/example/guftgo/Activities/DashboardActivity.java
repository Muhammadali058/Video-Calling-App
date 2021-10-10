package com.example.guftgo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.view.View;

import com.example.guftgo.R;
import com.example.guftgo.databinding.ActivityDashboardBinding;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        URL serverURL;
        try {
            serverURL = new URL("https://meet.jit.si");

            JitsiMeetConferenceOptions defaultOptions = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(serverURL)
                    .setWelcomePageEnabled(false)
                    .build();

            JitsiMeet.setDefaultConferenceOptions(defaultOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        binding.joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                        .setRoom(binding.secretCode.getText().toString())
                        .build();

                JitsiMeetActivity.launch(DashboardActivity.this, options);
            }
        });
    }
}