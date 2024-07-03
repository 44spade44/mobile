package com.example.endsem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private EditText editTextValue1, editTextValue2, editTextValue3;
    private Button buttonSave, buttonNextPage;
    private DatabaseHelper1 databaseHelper;

    public SecondFragment() {
        // Required empty public constructor
    }

//    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        editTextValue1 = view.findViewById(R.id.editTextValue1);
        editTextValue2 = view.findViewById(R.id.editTextValue2);
        editTextValue3 = view.findViewById(R.id.editTextValue3);
        buttonSave = view.findViewById(R.id.buttonSave);
        buttonNextPage = view.findViewById(R.id.buttonNextPage);

        // Initialize your DatabaseHelper
        databaseHelper = new DatabaseHelper1(requireContext());

        // Button click listeners
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDatabase();
            }
        });

        buttonNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), SecondActivity.class);
                    intent.putExtra("value1", editTextValue1.getText().toString());
                    intent.putExtra("value2", editTextValue2.getText().toString());
                    intent.putExtra("value3", editTextValue3.getText().toString());
                    startActivity(intent);
            }
        });

        return view;
    }

    // Method to save data to database
    private void saveToDatabase() {
        String value1 = editTextValue1.getText().toString().trim();
        String value2 = editTextValue2.getText().toString().trim();
        String value3 = editTextValue3.getText().toString().trim();

        // Example: Saving values to database using your DatabaseHelper
        databaseHelper.insertData(value1, value2, value3);

        // Clear the editText fields after saving if needed
        editTextValue1.setText("");
        editTextValue2.setText("");
        editTextValue3.setText("");
    }
    }
