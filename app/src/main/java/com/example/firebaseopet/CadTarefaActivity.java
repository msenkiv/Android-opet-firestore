package com.example.firebaseopet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CadTarefaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private FirebaseFirestore db;
    private EditText editTitulo, editCategoria;
    private Spinner spinnerPrioridade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_tarefa);

         spinnerPrioridade = findViewById(R.id.spinnerPrioridade);
         editTitulo = findViewById(R.id.editTitulo);
         editCategoria = findViewById(R.id.editCategoria);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.prioridade,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrioridade.setAdapter(adapter);
        spinnerPrioridade.setOnItemSelectedListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void registrardadostarefa(View view) {
        String titulo = editTitulo.getText().toString();
        String categoria = editCategoria.getText().toString();
        String prioridade = spinnerPrioridade.getSelectedItem().toString();


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String todate = dateFormat.format(currentdate());
        String  horario = todate.toString();

        Task task = new Task(horario,titulo,prioridade,categoria);

        db.collection("tarefas").add(task)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        String message = "Tarefa cadastrada";
                        Toast.makeText(CadTarefaActivity.this,message,Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String message = "Tarefa não cadastrada";
                        Toast.makeText(CadTarefaActivity.this,message,Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private Date currentdate() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        return cal.getTime();
    }
}
