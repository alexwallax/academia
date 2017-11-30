package academia.com.br.models;

import java.io.Serializable;

public class Cliente implements Serializable {

    private Integer id;
    private String nome;
    private String telefone;
    private String peso;
    private String altura;

    public Cliente() {}

    public Cliente(String nome, String telefone, String peso, String altura) {
        this.nome = nome;
        this.telefone = telefone;
        this.peso = peso;
        this.altura = altura;
    }

    public Integer getId() {return id; }

    public String getNome() {return nome; }

    public String getTelefone() {return telefone; }

    public String getPeso() {return peso; }

    public String getAltura() {return altura; }

    public void setId(Integer id) {this.id = id; }

    public void setNome(String nome) {this.nome = nome; }

    public void setTelefone(String telefone) {this.telefone = telefone; }

    public void setPeso(String peso) {this.peso = peso; }

    public void setAltura(String altura) {this.altura = altura; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return id != null ? id.equals(cliente.id) : cliente.id == null;
    }

    @Override
    public int hashCode() {return id != null ? id.hashCode() : 0; }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", peso='" + peso + '\'' +
                ", altura='" + altura + '\'' +
                '}';
    }
}
