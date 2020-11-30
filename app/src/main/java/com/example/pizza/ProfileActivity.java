package com.example.pizza;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    ImageView profileImage;
    private ProfileAvatarDialog profileAvatarDialog;
//    private static final int REQUEST_CODE_CAMERA = 0;
//    private static final int REQUEST_CODE_GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileImage = findViewById(R.id.profileImageView);
    }

    public void eMailChange(View view) {
    }

    public void PasswordChange(View view) {
    }

    public void Exit(View view) {
        Intent intent = new Intent(ProfileActivity.this, AuthorizationActivity.class);
        startActivity(intent);
    }

//    public void onClick(View view) {
//        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intentCamera, REQUEST_CODE_CAMERA);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap avatarImage;

        Toast.makeText(this, String.valueOf(profileAvatarDialog.getRequest()), Toast.LENGTH_LONG).show();

        if (requestCode == profileAvatarDialog.getRequest() && resultCode == RESULT_OK) {
            avatarImage = (Bitmap) data.getExtras().get("data");
            profileImage.setImageBitmap(avatarImage);
        }
        if (requestCode == profileAvatarDialog.getRequest() && resultCode == RESULT_OK) {
            try {
                avatarImage = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                profileImage.setImageBitmap(avatarImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onAvatarChangeClick(View view) {
        profileAvatarDialog = new ProfileAvatarDialog();
        FragmentManager manager = getSupportFragmentManager();
        profileAvatarDialog.show(manager, "ProfileAvatarDialog");

//        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
//        galleryIntent.setType("image/*");
//        startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);
    }
}