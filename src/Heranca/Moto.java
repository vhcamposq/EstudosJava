package Heranca;

public class Moto extends Veiculo {
    private boolean temCarroLateral;

    public Moto(String marca, String modelo, int ano, boolean temCarroLateral) {
        super(marca, modelo, ano);
        this.temCarroLateral = temCarroLateral;
    }

    public boolean isTemCarroLateral() {
        return temCarroLateral;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano=" + getAno() +
                ", temCarroLateral=" + temCarroLateral +
                '}';
    }
}
