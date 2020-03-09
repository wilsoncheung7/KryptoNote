package eecs1022.kryptonote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class KryptoNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kryptonote_layout);
        Button encrypt=findViewById(R.id.encrypt);
        Button decrypt=findViewById(R.id.decrypt);
        Button save=findViewById(R.id.save);
        Button load=findViewById(R.id.load);
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEncrypt(view);
            }
        });
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDecrypt(view);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSave(view);
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoad(view);
            }
        });
    }

    public void onEncrypt(View v){

        try{
            EditText keyView=findViewById(R.id.key);
            String key=keyView.getText().toString();
            Cipher cipher=new Cipher(key);
            ((TextView)findViewById(R.id.data)).setText(cipher.Encrypt(key));
        }

        catch (Exception e){
            System.out.println("Error");
        }
    }

    public void onDecrypt (View v){
        try{
            EditText keyView=findViewById(R.id.key);
            String key=keyView.getText().toString();
            Cipher cipher=new Cipher(key);
            ((TextView)findViewById(R.id.data)).setText(cipher.Decrypt(key));
        }

        catch (Exception e){
            System.out.println("Error");
        }
    }

    public void onSave(View v){
        try{
            String name=((EditText) findViewById(R.id.file)).getText().toString();
            File dir=this.getFilesDir();
            File file=new File(dir,name);
            FileWriter fw=new FileWriter(file);
            fw.write(((EditText)findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast.makeText(this,"Note Saved",Toast.LENGTH_LONG);
        }

        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG);
        }
    }

    public void onLoad(View v){
        try{
            String name=((EditText) findViewById(R.id.file)).getText().toString();
            File dir=this.getFilesDir();
            File file=new File(dir,name);
            FileReader fr=new FileReader(file);
            String show="";
            for (int c=fr.read();c!=-1;c=fr.read())
                show+=(char)c;
            fr.close();
            ((EditText)findViewById(R.id.data)).setText(show);
        }

        catch (Exception e){

        }
    }

}
