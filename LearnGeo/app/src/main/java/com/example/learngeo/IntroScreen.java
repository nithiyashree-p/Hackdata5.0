package com.example.learngeo;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import io.github.dreierf.materialintroscreen.MaterialIntroActivity;
import io.github.dreierf.materialintroscreen.MessageButtonBehaviour;
import io.github.dreierf.materialintroscreen.SlideFragmentBuilder;

public class IntroScreen extends MaterialIntroActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            getSupportActionBar().hide();
            getBackButtonTranslationWrapper()
                    .setEnterTranslation(View::setAlpha);

            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.colorintro)
                    .buttonsColor(R.color.teal_200)
                    .image(R.drawable.intro2)
                    .title("“The Earth is a fine place and worth fighting for”")
                    .description("—Ernest Hemingway")
                    .build());

            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.colorintro)
                    .buttonsColor(R.color.teal_200)
                    .image(R.drawable.intro)
                    .title("Let us make this World a better place to live !")
                    .build());
        }


    @Override
    public void onFinish() {
        super.onFinish();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}