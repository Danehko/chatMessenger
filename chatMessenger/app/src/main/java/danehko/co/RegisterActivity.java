package danehko.co;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText mEditUsername;
    private EditText mEditEmail;
    private EditText mEditPasswor;
    private Button mBtnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_register);

        mEditUsername = findViewById(R.id.edit_username);
        mEditEmail = findViewById(R.id.edit_Email);
        mEditPasswor = findViewById(R.id.edit_password);
        mBtnEnter = findViewById(R.id.btn_Enter);

        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
            //colocarnoprojeto
            private void createUser() {
                String email = mEditEmail.getText().toString();
                String senha = mEditPasswor.getText().toString();

                if(email == null || email.isEmpty() || senha == null || senha.isEmpty()){
                    Toast.makeText(getApplicationContext() , "Senha e Email devem ser preenchidos", Toast.LENGTH_LONG).show();
                    return;
                }
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                    Log.i("Tsste", task.getResult().getUser().getUid());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("Tsste", e.getMessage());
                            }
                        });
            }
        });

    }
}
