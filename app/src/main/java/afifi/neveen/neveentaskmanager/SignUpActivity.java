package afifi.neveen.neveentaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
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
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.crea
        }

    }
}