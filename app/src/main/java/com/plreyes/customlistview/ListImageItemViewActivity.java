package com.plreyes.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

public class ListImageItemViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image_item_view);

        ImageView characterExpandedView = findViewById(R.id.characterExpandedView);

        Bundle imageExpandIntent = getIntent().getExtras();

        assert imageExpandIntent != null;
        int characterImage = imageExpandIntent.getInt("characterImage");
        int characterAudio = imageExpandIntent.getInt("characterAudio");
        MediaPlayer MP = MediaPlayer.create(this, characterAudio);
        MP.start();

        characterExpandedView.setImageResource(characterImage);
    }
}