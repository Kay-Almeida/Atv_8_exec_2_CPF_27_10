package kailaine.mobile.atv_8_exec_2_cpf_27_10;
/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kailaine.mobile.atv_8_exec_2_cpf_27_10.model.Pessoa;

public class SaidaActivity extends AppCompatActivity {

    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvSaida = findViewById(R.id.etSaida);
        tvSaida.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nome = bundle.getString("nome");
        String cpf = bundle.getString("cpf");
        String area = bundle.getString("area");

        pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);

        tvSaida.setText(pessoa.getNome()+"\n"+pessoa.getCpf()+"\n"+area);
        btnVoltar.setOnClickListener(op -> voltar());

    }

    private void voltar() {
        Intent i = new Intent (this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}