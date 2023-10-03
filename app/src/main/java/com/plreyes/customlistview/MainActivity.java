package com.plreyes.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


// SplashScreenActivity -> MainActivity -> Item onClick -> Image Activity
public class MainActivity extends AppCompatActivity {
    ListView characterItems;
    Integer[] characterImages = {
        R.drawable.guy,
        R.drawable.hashirams,
        R.drawable.itachi,
        R.drawable.kakashi,
        R.drawable.madara,
        R.drawable.naruto,
        R.drawable.neji,
        R.drawable.obito,
        R.drawable.sasuke,
        R.drawable.shisui
    };

    String[] characterNames = {
            "guy",
            "hashirams",
            "itachi",
            "kakashi",
            "madara",
            "naruto",
            "neji",
            "obito",
            "sasuke",
            "shisui"
    };

    Integer[] audios = {
        R.raw.guy,
            R.raw.hashirama,
            R.raw.itachi,
            R.raw.kakashi,
            R.raw.madara,
            R.raw.naruto,
            R.raw.neji,
            R.raw.obito,
            R.raw.sasuke,
            R.raw.shisui
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Custom List Item
        CharacterItemListAdapter itemListAdapter = new CharacterItemListAdapter();
        characterItems = findViewById(R.id.listCharacters);
        characterItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent characterImageExpandIntent = new Intent(MainActivity.this, ListImageItemViewActivity.class);
                characterImageExpandIntent.putExtra("characterImage", characterImages[i]);
                characterImageExpandIntent.putExtra("characterAudio", audios[i]);
                startActivity(characterImageExpandIntent);
            }
        });
        characterItems.setAdapter(itemListAdapter);
    }

    class CharacterItemListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return characterImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.character_item, null);
            ImageView imgCharacter = view.findViewById(R.id.imgCharacter);
            TextView txtCharacterName = view.findViewById(R.id.txtCharacterName);
            imgCharacter.setImageResource(characterImages[i]);
            txtCharacterName.setText(characterNames[i]);
            return view;

        }
    }
}