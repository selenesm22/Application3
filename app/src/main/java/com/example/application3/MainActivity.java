package com.example.application3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView c1, c2;
    int maximo=0, medium=0;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relacionarVistas();
    }

    public void relacionarVistas(){
        c1=(TextView)findViewById(R.id.contador1);
        c2=(TextView)findViewById(R.id.contador2);
        b=(Button)findViewById(R.id.iniciar);
    }
    public void iniciarBoton(View V){
        //TareaAsincronaContadores objeto=new TareaAsincronaContadores();
        //objeto.execute();

        new TareaAsincronaContadores().execute();
    }
    class TareaAsincronaContadores extends AsyncTask{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            maximo=1000;
            medium=500;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            //se hacen al mismo tiempo
            for(int i=0; i<maximo; i++){
              publishProgress(i);
            }
            for(int j=0; j<medium; j++){
                publishProgress(j);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            //c1.setText(values[0], values[0], values[0]);//varios valores
            c1.setText(String.valueOf(values[0]));//consulta desde la primera posición del arreglo y lo muestra en textView1
            c2.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Object o) {
            Toast.makeText(MainActivity.this, "Acabó el contexto", Toast.LENGTH_SHORT).show();
          //  maximo=0;
        }
    }
}