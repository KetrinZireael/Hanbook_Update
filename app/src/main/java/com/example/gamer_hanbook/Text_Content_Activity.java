package com.example.gamer_hanbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity{
        private TextView text_content;
        private Typeface face1;
        private ImageView image_content;
        private int category = 0;
        private int position = 0;
        private int [] array_rpg = {R.string.theWither, R.string.theSkyrim, R.string.Fallout, R.string.MonsterHunter, R.string.Divinity, R.string.Cyberpunk, R.string.Gothic_II};
        private int [] array_image_rpg = {R.drawable.thewitcher, R.drawable.skyrim, R.drawable.fallout, R.drawable.hunter, R.drawable.divinity, R.drawable.cyberpunk, R.drawable.gothic};
        private int [] array_shooter = {R.string.Doom, R.string.HalfLife, R.string.Quake, R.string.BioShock, R.string.Battlefield, R.string.DeadSpace, R.string.Wolfestein};
        private int [] array_strategy = {R.string.Civilization, R.string.XCOM, R.string.StarCraft, R.string.CrusaderKing, R.string.Desperados, R.string.TotalWar, R.string.Anno1800};


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.text_content);
            init();
            reciveIntent();
        }
        private void reciveIntent()
        {
            Intent i = getIntent();
            if(i != null)
            {
                category = i.getIntExtra("category", 0);
                position = i.getIntExtra("position", 0);
            }
            switch (category){
                case 0:
                    image_content.setImageResource(array_image_rpg[position]);
                    text_content.setText(array_rpg[position]);
                    break;
                case 1:
                    image_content.setImageResource(array_image_rpg[position]);
                    text_content.setText(array_shooter[position]);
                    break;
                case 2:
                    image_content.setImageResource(array_image_rpg[position]);
                    text_content.setText(array_strategy[position]);
                    break;
            }
        }

        private  void init(){
            text_content = findViewById(R.id.text_main_content);
            image_content = findViewById(R.id.image_content);
            face1 = Typeface.createFromAsset(this.getAssets(), "fonts/RobotoSlab-VariableFont_wght.ttf");
            text_content.setTypeface(face1);
        }
}
