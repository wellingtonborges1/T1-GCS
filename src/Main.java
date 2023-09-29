import app.Sistema;
import modelo.Empresa;

public class Main {
    public static void main(String[] args) {
        Empresa e = new Empresa();
        Sistema s = new Sistema(e);
        s.executa();
    }
    
}
