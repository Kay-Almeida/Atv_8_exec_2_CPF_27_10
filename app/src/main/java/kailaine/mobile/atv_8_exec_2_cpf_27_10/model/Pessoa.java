package kailaine.mobile.atv_8_exec_2_cpf_27_10.model;
/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */
public class Pessoa {
    private String cpf;
    private String nome;

 /* public Pessoa (String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }*/

    public Pessoa(){
        super();
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String valor){
        this.cpf = valor;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String valor){
        this.nome = valor;
    }
}
