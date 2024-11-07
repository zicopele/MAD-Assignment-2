package com.example.locationfinder;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    EditText addressInput, latitudeInput, longitudeInput;

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

        // Initialize UI components
        dbHelper = new DBHelper(this);
        addressInput = findViewById(R.id.addressInput);
        latitudeInput = findViewById(R.id.latitudeInput);
        longitudeInput = findViewById(R.id.longitudeInput);

        // Initialize buttons
        Button addButton = findViewById(R.id.addButton);
        Button queryButton = findViewById(R.id.queryButton);
        Button updateButton = findViewById(R.id.updateButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        // Set a click listener for the add button
        addButton.setOnClickListener(v -> {
            String address = addressInput.getText().toString().trim();
            String latitudeStr = latitudeInput.getText().toString().trim();
            String longitudeStr = longitudeInput.getText().toString().trim();

            // Check if any field is empty
            if (address.isEmpty()) {
                showToast("Please enter an address.");
            } else if (latitudeStr.isEmpty()) {
                showToast("Please enter a latitude.");
            } else if (longitudeStr.isEmpty()) {
                showToast("Please enter a longitude.");
            } else {
                double latitude = Double.parseDouble(latitudeStr);
                double longitude = Double.parseDouble(longitudeStr);

                // Add location to the database
                dbHelper.addLocation(address, latitude, longitude);
                showToast("Location added successfully.");
            }
        });

        // Set a click listener for the query button
        queryButton.setOnClickListener(v -> {
            String address = addressInput.getText().toString().trim();

            // Check if the address field is empty
            if (address.isEmpty()) {
                showToast("Please enter an address to search.");
            } else {
                Cursor cursor = dbHelper.getLocation(address);

                // Check if location exists in the database
                if (cursor.moveToFirst()) {
                    double latitude = cursor.getDouble(cursor.getColumnIndex("latitude"));
                    double longitude = cursor.getDouble(cursor.getColumnIndex("longitude"));
                    showToast("Latitude: " + latitude + "\nLongitude: " + longitude);
                } else {
                    showToast("Location not found.");
                }
                cursor.close();
            }
        });

        // Set a click listener for the update button
        updateButton.setOnClickListener(v -> {
            // Get input values
            String address = addressInput.getText().toString().trim();
            String latitudeStr = latitudeInput.getText().toString().trim();
            String longitudeStr = longitudeInput.getText().toString().trim();

            // Check if any field is empty
            if (address.isEmpty()) {
                showToast("Please enter an address.");
            } else if (latitudeStr.isEmpty()) {
                showToast("Please enter a latitude.");
            } else if (longitudeStr.isEmpty()) {
                showToast("Please enter a longitude.");
            } else {
                // Parse latitude and longitude to double
                double latitude = Double.parseDouble(latitudeStr);
                double longitude = Double.parseDouble(longitudeStr);

                // Update location in the database
                dbHelper.updateLocation(address, latitude, longitude);
                showToast("Location updated successfully.");
            }
        });

        // Set a click listener for the delete button
        deleteButton.setOnClickListener(v -> {
            // Get input value
            String address = addressInput.getText().toString().trim();

            // Check if the address field is empty
            if (address.isEmpty()) {
                showToast("Please enter an address to delete.");
            } else {
                // Delete location from the database
                dbHelper.deleteLocation(address);
                showToast("Location deleted successfully.");
            }
        });
    }

    // Method to show a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
