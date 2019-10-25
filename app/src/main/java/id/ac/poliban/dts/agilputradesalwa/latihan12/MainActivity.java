package id.ac.poliban.dts.agilputradesalwa.latihan12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etFirst = findViewById(R.id.etFirst);
        EditText etLast = findViewById(R.id.etLast);
        Button btLoad = findViewById(R.id.btLoad);
        Button btSave = findViewById(R.id.btSave);
        TextView tvResult = findViewById(R.id.tvResult);

        btSave.setOnClickListener(v -> {
            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();

            String iname,fname;
            iname = etFirst.getText().toString();
            fname = etLast.getText().toString();

            edit.putString("iname", iname);
            edit.putString("fname", fname);
            edit.apply();

            Toast.makeText(this, "data has been save it", Toast.LENGTH_SHORT).show();
        });

        btLoad.setOnClickListener(v -> {
            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            String iname = sp.getString("iname", "na");
            String fname = sp.getString("fname", "na");
            tvResult.setText(String.format("%s %s", fname, iname));
        });
    }
}
