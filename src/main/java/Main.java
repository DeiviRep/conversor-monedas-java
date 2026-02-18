import com.google.gson.Gson;

class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 30);

        Gson gson = new Gson();
        String json = gson.toJson(persona);

        System.out.println(json);
    }
}
