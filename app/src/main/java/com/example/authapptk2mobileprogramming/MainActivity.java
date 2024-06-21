package com.example.authapptk2mobileprogramming;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private LinearLayout imagesContainer;

    // URLs of the images (replace with your actual image URLs)
    private String[] imageUrls = {
            "https://randomfox.ca/images/11.jpg",
            "https://randomfox.ca/images/60.jpg",
            "https://randomfox.ca/images/123.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imagesContainer = findViewById(R.id.images_container);

        // Load images dynamically
        for (String imageUrl : imageUrls) {
            loadImage(imageUrl);
        }
    }

    private void loadImage(String imageUrl) {
        // Create new ImageView dynamically
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 16, 0, 16); // Adjust margins as needed
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // Load image using Picasso
        Picasso.get().load(imageUrl).into(imageView);

        // Add ImageView to the container
        imagesContainer.addView(imageView);
    }
}