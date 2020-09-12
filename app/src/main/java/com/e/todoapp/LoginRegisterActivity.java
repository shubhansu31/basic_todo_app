package com.e.todoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginRegisterActivity extends AppCompatActivity {
    int AUTH_REQUEST_CODE = 1001;
    private static final String TAG = "MainActivity";
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        login = (Button)findViewById(R.id.login_register_button);

    }
    private void toMainActivity(){
        Intent intent = new Intent(LoginRegisterActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void loginRegister(View view) {

        List<AuthUI.IdpConfig> providers = Arrays.asList(
               new AuthUI.IdpConfig.EmailBuilder().build()
        );
        Intent intent = AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setAlwaysShowSignInMethodScreen(true)
                        .setLogo(R.drawable.noteslogo)
                        .build();
        startActivityForResult(intent,AUTH_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AUTH_REQUEST_CODE){
            if(resultCode == RESULT_OK ){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user.getMetadata().getCreationTimestamp() == user.getMetadata().getLastSignInTimestamp()){
                    Toast.makeText(this,"Welcome New User",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this,"Welcome User",Toast.LENGTH_LONG).show();
                }

                toMainActivity();
            }
            else{
                IdpResponse idpResponse = IdpResponse.fromResultIntent(data);
                if(idpResponse == null)
                    Log.d(TAG,"User Cancelled Sign In");
            }
        }
    }
}