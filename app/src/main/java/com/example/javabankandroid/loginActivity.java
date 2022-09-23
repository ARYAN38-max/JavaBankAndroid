package com.example.javabankandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class loginActivity extends AppCompatActivity {

    //Declaration of components which will be used in the application
    private EditText userName,userPhone,userPassword;
    private Button create_account;
    //Views
    RelativeLayout parent;
    CardView form;
    //FireBase DataBase
    FirebaseDatabase root_node;
    DatabaseReference child_node;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //finding view of the application by its ID to use in snackBar
        parent = findViewById(R.id.parent);
        form = findViewById(R.id.form);
        //addressing components by their ID
        userName = findViewById(R.id.userName);
        userPhone = findViewById(R.id.userPhone);
        userPassword = findViewById(R.id.userPhone);
        //addressing button by its id
        create_account = findViewById(R.id.create_account);

        //adding onClickListener to the button
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().equals(""))
                {
                    showIncompleteSnackBar();
                    userName.setText("");
                    userPhone.setText("");
                    userPassword.setText("");
                }
                else
                {
                        root_node = FirebaseDatabase.getInstance("https://javabankandroid-default-rtdb.firebaseio.com/");
                        child_node = root_node.getReference("Users");
                        userCredentials UserCredentials = new userCredentials(userName.getText().toString(), userPhone, userPassword.getText().toString());
                        child_node.setValue(UserCredentials);

                        child_node.child(userName.getText().toString()).setValue(UserCredentials);
                }
            }
        });

    }

    private void showIncompleteSnackBar()
    {
        Snackbar.make(form,"Retry Please", Snackbar.LENGTH_SHORT).show();
    }
}