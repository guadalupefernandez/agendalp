package mx.edu.tesoem.itics.guadalupe.agendalp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class mostrardatos extends AppCompatActivity {

    TextView lblnom, lblusu, lblcon, lblcor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrardatos);

        Bundle parametros = this.getIntent().getExtras();
        setContentView(R.layout.activity_mostrardatos);
        lblnom = (TextView) findViewById(R.id.lblnombre);
        lblusu = (TextView) findViewById(R.id.lblusuario);
        lblcon = (TextView) findViewById(R.id.lblcontra);
        lblcor = (TextView) findViewById(R.id.lblcorreo);


        lblnom.setText(parametros.getString("nombre").toString());
        lblusu.setText(parametros.getString("usuario").toString());
        lblcon.setText(parametros.getString("contra").toString());
        lblcor.setText(parametros.getString("correo").toString());
    }

    public void btnguardar(View v){
        guardar(lblnom.getText().toString() + "," + lblusu.getText().toString() + "," + lblcon.getText().toString() + "," + lblcor.getText().toString());
        cargaactividad();
    }

    public void guardar(String dato){
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("Datos.txt", Context.MODE_APPEND));
            archivo.write(dato + "\n");
            archivo.close();
            Toast.makeText(this, "Se grabo la informacion correctamente", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("Error","Error al escribir archivo");
        }
    }




    public void regresar(View v){

        cargaactividad();
    }

    private void cargaactividad(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }


}
