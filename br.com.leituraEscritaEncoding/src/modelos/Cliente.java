package modelos;

import java.math.BigDecimal;

public class Cliente {

    private String tipoConta;
    private String agencia;
    private String numeroConta;
    private String nomeTitular;
    private Double saldo;

    public Cliente() { }

    public Cliente(String tipoConta, String agencia, String numeroConta, String nomeTitular, Double saldo) {
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tipo Conta='" + tipoConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", numero Conta='" + numeroConta + '\'' +
                ", nome Titular='" + nomeTitular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
