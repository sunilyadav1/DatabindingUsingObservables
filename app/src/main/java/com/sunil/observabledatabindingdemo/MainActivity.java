package com.sunil.observabledatabindingdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sunil.observabledatabindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private UserDTO userDTO;
    private ClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        userDTO = new UserDTO();
        userDTO.setFirstName("Sunil");
        userDTO.setLastName("Yadav");

        activityMainBinding.setUser(userDTO);

        clickHandler = new ClickHandler(activityMainBinding.content.etFirstName, activityMainBinding.content.etLastName);
        activityMainBinding.content.setClickHandler(clickHandler);


    }

    public class ClickHandler {
        private EditText etFirstname, etLastName;

        public ClickHandler(EditText etFirstname, EditText etLastName) {
            this.etFirstname = etFirstname;
            this.etLastName = etLastName;
        }

        public void updateUser(View view) {
            userDTO.setFirstName(etFirstname.getText().toString());
            userDTO.setLastName(etLastName.getText().toString());
            etFirstname.setText("");
            etLastName.setText("");
        }
    }
}
