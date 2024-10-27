package kailaine.mobile.atv_8_exec_2_cpf_27_10;
/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kailaine.mobile.atv_8_exec_2_cpf_27_10.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText etNome, etCPF;
    private Button btnEmissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNome = findViewById(R.id.etNome);
        etCPF = findViewById(R.id.etCPF);
        btnEmissao = findViewById(R.id.btnEmissao);
        btnEmissao.setOnClickListener(op -> mostrarArea());
    }

    private void mostrarArea() {
        String nome = etNome.getText().toString();
        String cpf = etCPF.getText().toString();

        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(cpf);
        pessoa.setNome(nome);

        String[] vetor = new String[]{"Rio Grande do Sul", "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins", "Pará, Amazonas, Acre, Amapá, Rondônia e Roraima", "Ceará, Maranhão e Piauí", "Pernambuco, Rio Grande do Norte, Paraíba e Alagoas", "Bahia e Sergipe", "Minas Gerais", "Rio de Janeiro e Espírito Santo", "São Paulo", "Paraná e Santa Catarina"};
        String[] caracteres = cpf.split("");
        String nonoDigito = caracteres[8];
        String area = vetor[Integer.parseInt(nonoDigito)];

        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putString("cpf", cpf);
        bundle.putString("area", area);
        troca(bundle);


    }

    private void troca(Bundle bundle) {
        Intent i = new Intent(this, SaidaActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}