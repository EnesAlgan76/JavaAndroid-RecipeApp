package com.msku.example.hacininyeri;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.msku.example.hacininyeri.models.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddRecipeActivity extends AppCompatActivity implements OnCategoryClickListener {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri;
    private FirebaseFirestore mFirestore;
    private StorageReference mStorageRef;

    String selectedCategory = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        List<Category> categoryList = FirebaseHelper.getCategoryList();

        RecyclerView recyclerViewCategory = findViewById(R.id.rv_add_categories);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SelectCategoryAdapter categoryAdapter = new SelectCategoryAdapter(this, categoryList);
        recyclerViewCategory.setAdapter(categoryAdapter);

        mFirestore = FirebaseFirestore.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference("recipe_images");

        Button btnSelectImage = findViewById(R.id.btnSelectImage);
        ImageView imageViewSelected = findViewById(R.id.imageViewSelected);

        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
            }
        });

        findViewById(R.id.buttonGenerate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedImageUri == null) {
                    Toast.makeText(AddRecipeActivity.this, "Lütfen bir resim seçin", Toast.LENGTH_SHORT).show();
                    return;
                }

                String recipeName = ((EditText) findViewById(R.id.editTextRecipeName)).getText().toString();
                String contentTitle = ((EditText) findViewById(R.id.editTextContents)).getText().toString();
                String preparation = ((EditText) findViewById(R.id.editTextPreparation)).getText().toString();
                String time = ((EditText) findViewById(R.id.editTextTime)).getText().toString();

                if(selectedCategory==""){
                    Toast.makeText(AddRecipeActivity.this, "Lütfen bir kategori seçin", Toast.LENGTH_SHORT).show();
                    return;
                }

                uploadImageAndSaveRecipe(recipeName, contentTitle, preparation, time);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            ImageView imageViewSelected = findViewById(R.id.imageViewSelected);
            imageViewSelected.setVisibility(View.VISIBLE);
            imageViewSelected.setImageURI(selectedImageUri);
        }
    }

    //    @Override


    private void uploadImageAndSaveRecipe(final String recipeName, final String contentTitle, final String preparation, final String time) {
        final StorageReference imageRef = mStorageRef.child(System.currentTimeMillis() + ".jpg");

        imageRef.putFile(selectedImageUri).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                    String imageUrl = uri.toString();
                    saveRecipeToFirestore(recipeName, contentTitle, preparation, time, imageUrl);
                });
            } else {
                Toast.makeText(AddRecipeActivity.this, "Resim yükleme hatası", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveRecipeToFirestore(String recipeName, String contentTitle, String preparation, String time, String imageUrl) {
        Map<String, Object> recipeMap = new HashMap<>();
        recipeMap.put("recipeName", recipeName);
        recipeMap.put("contentTitle", contentTitle);
        recipeMap.put("preparation", preparation);
        recipeMap.put("time", time);
        recipeMap.put("imageUrl", imageUrl);
        recipeMap.put("category", selectedCategory);
        recipeMap.put("userId", Constants.userId);

        mFirestore.collection("recipes")
                .add(recipeMap)
                .addOnSuccessListener(documentReference -> {
                    documentReference.update("id",documentReference.getId());
                    Toast.makeText(AddRecipeActivity.this, "Tarif başarıyla kaydedildi", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(AddRecipeActivity.this, "Firestore kayıt hatası", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onCategoryClick(String categoryName) {
        selectedCategory = categoryName;
    }
}
