package com.example.validateprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText main_EDT_email, main_EDT_phone, main_EDT_name, main_EDT_age, main_EDT_password, main_EDT_date;
    private MaterialButton main_BTN_checkMail, main_BTN_checkPhone, main_BTN_checkName, main_BTN_checkAge, main_BTN_checkPassword, main_BTN_checkDate;
    private ValidViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(ValidViewModel.class);
        findViews();
        createListeners();
    }

    private void createListeners() {
        main_BTN_checkMail.setOnClickListener(v -> validate(main_EDT_email.getText().toString(), ValidEasyType.EMAIL));
        main_BTN_checkPhone.setOnClickListener(v -> validate(main_EDT_phone.getText().toString(), ValidEasyType.PHONE));
        main_BTN_checkName.setOnClickListener(v -> validate(main_EDT_name.getText().toString(), ValidEasyType.NAME));
        main_BTN_checkAge.setOnClickListener(v -> validate(main_EDT_age.getText().toString(), ValidEasyType.AGE));
        main_BTN_checkPassword.setOnClickListener(v -> validate(main_EDT_password.getText().toString(), ValidEasyType.PASSWORD));
        main_BTN_checkDate.setOnClickListener(v -> validate(main_EDT_date.getText().toString(), ValidEasyType.DATE));
    }

    private void validate(String input, ValidEasyType type) {
        String result = viewModel.validate(input, type);
        showToast(result);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void findViews() {
        main_EDT_email = findViewById(R.id.main_EDT_email);
        main_EDT_phone = findViewById(R.id.main_EDT_phone);
        main_EDT_name = findViewById(R.id.main_EDT_name);
        main_EDT_age = findViewById(R.id.main_EDT_age);
        main_EDT_password = findViewById(R.id.main_EDT_password);
        main_EDT_date = findViewById(R.id.main_EDT_date);

        main_BTN_checkMail = findViewById(R.id.main_BTN_checkMail);
        main_BTN_checkPhone = findViewById(R.id.main_BTN_checkPhone);
        main_BTN_checkName = findViewById(R.id.main_BTN_checkName);
        main_BTN_checkAge = findViewById(R.id.main_BTN_checkAge);
        main_BTN_checkPassword = findViewById(R.id.main_BTN_checkPassword);
        main_BTN_checkDate = findViewById(R.id.main_BTN_checkDate);
    }
}