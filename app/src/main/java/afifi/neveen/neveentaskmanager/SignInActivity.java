package afifi.neveen.neveentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private Button btnSignUp,btnSignIn;
    TextInputEditText etEamil,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnSignUp=findViewById(R.id.btnSignUp);
        btnSignIn=findViewById(R.id.btnSignIn);
        etEamil=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                checkAndSave();
            }
        });


    }

    private void checkAndSave()
    {
        String email=etEamil.getText().toString();
        String passw=etPassword.getText().toString();
        boolean isOk=true;

        if(email.length()==0)
        {
            etEamil.setError("enter your email");
            isOk=false;
        }
        if(passw.length()==0)
        {
            etPassword.setError("enter your password");
            isOk=false;
        }
         if(email.indexOf('@')<=0)
         {
             etEamil.setError("wrong email syntax");
             isOk=false;
         }
         if(passw.length()<7)
         {
             etPassword.setError("password at least 7 character");
             isOk=false;
         }
         //*******
         if(isOk)
         {
             FirebaseAuth auth = FirebaseAuth.getInstance();
             auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task)
                 {
                     if(task.isSuccessful())
                     {
                         Toast.makeText(SignInActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                         Intent i=new Intent(SignInActivity.this,MainActivity.class);
                         startActivity(i);
                         finish();
                     }
                     else
                     {
                         Toast.makeText(SignInActivity.this,
                                 "Not Successful"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                     }

                 }
             });
         }

    }
}