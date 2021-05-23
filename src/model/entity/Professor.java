package model.entity;

public class Professor extends Pessoa {

    private double salario;
    private String titulacao;

    public Professor() {
    }

    public Professor(double salario, String titulacao) {
        this.salario = salario;
        this.titulacao = titulacao;
    }

    public Professor(double salario, String titulacao, int id, String nome, int idade) {
        super(id, nome, idade);
        this.salario = salario;
        this.titulacao = titulacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Idade: " + this.getIdade()
                + "\n Salario: " + this.getSalario()
                + "\n Titulação:" + this.getTitulacao()
                + "\n -----------";
    }
}