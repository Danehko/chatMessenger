package danehko.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText mEditEmail;
    private EditText mEditPasswor;
    private Button mBtnEnter;
    private TextView mtxtAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);

        mEditEmail = findViewById(R.id.edit_Email);
        mEditPasswor = findViewById(R.id.edit_password);
        mBtnEnter = findViewById(R.id.btn_Enter);
        mtxtAccount = findViewById(R.id.txt_account);

        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEditEmail.getText().toString();
                String password = mEditPasswor.getText().toString();

                Log.i("Teste",email);
                Log.i("Teste",password);
            }
        });

        mtxtAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
