package afifi.neveen.neveentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    //1.
    private TextInputEditText etEmail,etPassw,etConfPassword;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //2.
        etEmail=findViewById(R.id.etEmail);
        etPassw=findViewById(R.id.etPassw);
        etConfPassword=findViewById(R.id.etConfPassw);

        btnSave=findViewById(R.id.btnSignUpSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lkdfjglkjdsagjlkadsgj
                checkAndSave();
            }
        });


    }

    private void checkAndSave()
    {

        String email=etEmail.getText().toString();
        String passw=etPassw.getText().toString();
        String passwConf=etConfPassword.getText().toString();

        boolean isok=true;
        if(email.length()* passw.length()*passwConf.length()==0)
        {
            etEmail.setError("One of the files are is empty");
            isok=false;
        }
        if(passw.equals(passwConf)==false)
        {
            etConfPassword.setError("is not equal to password");
            isok=false;
        }

        if(isok)
        {
            //used for signing in, signing up and sign out
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(email,passw).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        /**
                         * event handler, when the mission is completed
                         * @param task information about the event
                         */
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //chek if creating  account passed successfully
                            if(task.isSuccessful())
                            {
                                Toast.makeText(SignUpActivity.this, "Creation Successfully", Toast.LENGTH_SHORT).show();
                                //close current activity
                                finish();
                            }
                            else
                                Toast.makeText(SignUpActivity.this, "Creation Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
        }

    }
}