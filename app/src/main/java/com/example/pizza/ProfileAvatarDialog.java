package com.example.pizza;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ProfileAvatarDialog extends DialogFragment {

    private static final int REQUEST_CODE_CAMERA = 0;
    private static final int REQUEST_CODE_GALLERY = 1;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View root = inflater.inflate(R.layout.fragment_profile_avatar_dialog, null);
        Button cameraButton = root.findViewById(R.id.cameraButton);
        Button galleryButton = root.findViewById(R.id.galleryButton);
        Button cancelButton = root.findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().cancel();
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamera, REQUEST_CODE_CAMERA);
                getDialog().cancel();
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);
                getDialog().cancel();
            }
        });

        builder.setView(root);
        return builder.create();
    }
}
