package jp.calculadora2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class calculadora2 extends Application {
    //Creamos una variable temp que nos servira como contador a la hora de guardar los nombres de las personas
    private int temp = 0;



    @Override
    public void start(Stage primaria) {
        //Se crean los labels
        Label text_result = new Label();
        Label agre_persona = new Label("Agregar Persona");
        Label operaciones = new Label("Operaciones");
        Label nombre = new Label("Nombre:");
        Label provincia = new Label("Provincia:");
        Label Edad = new Label("Edad:");
        Label persona_1 = new Label("Persona 1:");
        Label persona_2 = new Label("Persona 2:");
        Label resultadol = new Label("Resultado: " );
        //Se crean los botones
        Button plus = new Button("+");
        Button minus = new Button("-");
        Button multiply = new Button("*");
        Button divide= new Button("/");
        Button plus_Persona = new Button("+ Persona");
        //Se crean ComboBox para tener las provincias y guardar los datos de las personas
        ComboBox list_provin = new ComboBox();
        list_provin.getItems().addAll(
                "Alajuela",
                "Cartago",
                "Guanacaste",
                "Heredia",
                "Limon",
                "Puntarenas",
                "San Jose"

        );
        ComboBox opcion_per1 = new ComboBox();

        ComboBox opcion_per2 = new ComboBox();


        //Se crean los textfields
        TextField text_nombre = new TextField();
        TextField text_edad = new TextField();


        //Se hace un array que almacene los objetos personas ingresados por el usuario
        Persona[] arr;
        arr = new Persona[4];
        //Se crea un segundo Array donde vamos a ir contabilizando las personas ingresadas para que luego sean agregadas al Array arr
        int[] arr2 = {0,0,0,0};
        //En este  Array vamos a almacenar las edades de los objetos persona y así poder operar con ellos mas adelante
        int [] arr_p;
        arr_p = new int[4];
        //Acción del botón plus_Persona, donde se debe agregar el objeto persona al ser presionado
        plus_Persona.setOnAction(actionEvent -> {
            //Se hace una función para almacenar los datos ingresados por el usuario
            for (int i = 0; i<4; i++){


                if (arr2[i] == 0) {


                    //Se hace este if para revisar si se esta seleccionando los tres valores(nombre,provincia y edad
                    if ((text_nombre.getText().length() == 0) || (text_edad.getText().length() == 0) || (list_provin.getValue() == null)) {
                            System.out.println("ERROR");
                    }
                    else {
                        //Creamos un nuevo objeto persona con los atributos de la clase persona, sacados de lo escrito por el usuario
                        Persona New_objeto = new Persona();
                        int edad = Integer.parseInt(text_edad.getText());
                        String nombre1 = text_nombre.getText();
                        Object Provincia = list_provin.getValue();
                        //Convertimos el objeto provincia seleccionado en un String para que pueda ser almacenado, ya que al hacer el .set solo nos permite ingresar Strings
                        String PROVINCIA = Provincia.toString();
                        New_objeto.setProvincia(PROVINCIA);
                        New_objeto.setEdad(edad);
                        New_objeto.setNombre(nombre1);
                        //Utilizamos este if para poder verificar si aparecen nombres similares, si es el caso poder diferenciarlos con numeros, en el orden de entrada al Array
                        if (temp>=1){
                            if(New_objeto.getNombre()==nombre1){
                                    New_objeto.setNombre(nombre1 +" "+ temp+"");
                            }
                        }
                        else {
                            New_objeto.setNombre(nombre1);
                        }
                        //Aumentamos i
                        arr2[i] = 1;
                        //Asignamos en esa posición la edad del objeto persona ingresado en ese momento
                        arr_p[i] = New_objeto.getEdad();
                        //Agregamos a las comboBox de opciones los nombres de los objeto persona ingresados
                        opcion_per1.getItems().add(New_objeto.getNombre());
                        opcion_per2.getItems().add(New_objeto.getNombre());
                        //Se utiliza un break para que no almanece en todos los espacios el mismo objeto persona
                        break;

                        }

                    }

            }
        });

        //Acción del botón donde se sumaran las edades de las personas selecionadas
        plus.setOnAction(actionEvent -> {
            int op1 = arr_p[opcion_per1.getItems().indexOf(opcion_per1.getValue())];
            int op2 = arr_p[opcion_per2.getItems().indexOf(opcion_per2.getValue())];

            // Realizo la suma
            int resultado = op1 + op2;

            text_result.setText(resultado + "");

        });
        //Acción del botón donde se restaran las edades de las personas selecionadas
        minus.setOnAction(actionEvent -> {
                    int op1 = arr_p[opcion_per1.getItems().indexOf(opcion_per1.getValue())];
                    int op2 = arr_p[opcion_per2.getItems().indexOf(opcion_per2.getValue())];

                    // Realizo la resta
                    int resultado = op1 - op2;

                    text_result.setText(resultado + "");

        });

        //Acción del botón donde se multipilicar las edades de las personas selecionadas
        multiply.setOnAction(actionEvent -> {
                    int op1 = arr_p[opcion_per1.getItems().indexOf(opcion_per1.getValue())];
                    int op2 = arr_p[opcion_per2.getItems().indexOf(opcion_per2.getValue())];

                    // Realizo la multiplicación
                    int resultado = op1 * op2;

                    text_result.setText(resultado + "");

        });
        //Acción del botón donde se dividiran las edades de las personas selecionadas
        divide.setOnAction(actionEvent -> {
                    int op1 = arr_p[opcion_per1.getItems().indexOf(opcion_per1.getValue())];
                    int op2 = arr_p[opcion_per2.getItems().indexOf(opcion_per2.getValue())];

                    // Realizo la división
                    double resultado = op1/op2;

                    text_result.setText(resultado + "");
        });




        //Posiciones de todos los labels, botones, textFields y ComboBox

        resultadol.setLayoutX(170);
        resultadol.setLayoutY(20);

        text_result.setLayoutX(260);
        text_result.setLayoutY(25);

        agre_persona.setLayoutX(50);
        agre_persona.setLayoutY(60);

        nombre.setLayoutX(50);
        nombre.setLayoutY(90);

        text_nombre.setLayoutX(115);
        text_nombre.setLayoutY(90);

        provincia.setLayoutX(50);
        provincia.setLayoutY(120);

        list_provin.setLayoutX(130);
        list_provin.setLayoutY(120);

        Edad.setLayoutX(50);
        Edad.setLayoutY(150);

        text_edad.setLayoutX(95);
        text_edad.setLayoutY(150);

        plus_Persona.setLayoutX(80);
        plus_Persona.setLayoutY(180);

        operaciones.setLayoutX(270);
        operaciones.setLayoutY(60);

        persona_1.setLayoutX(280);
        persona_1.setLayoutY(90);

        opcion_per1.setLayoutX(280);
        opcion_per1.setLayoutY(120);

        persona_2.setLayoutX(280);
        persona_2.setLayoutY(150);

        opcion_per2.setLayoutX(280);
        opcion_per2.setLayoutY(175);

        plus.setLayoutX(270);
        plus.setLayoutY(240);

        minus.setLayoutX(305);
        minus.setLayoutY(240);

        multiply.setLayoutX(340);
        multiply.setLayoutY(240);

        divide.setLayoutX(375);
        divide.setLayoutY(240);

        //Aumento de los tamaños de los labels, botones, textField y comboBox
        text_result.setStyle("-fx-font-size: 1.3em; ");
        resultadol.setStyle("-fx-font-size: 1.5em; ");
        agre_persona.setStyle("-fx-font-size: 1.3em; ");
        nombre.setStyle("-fx-font-size: 1.3em; ");
        text_nombre.setStyle("-fx-font-size: 0.8em; ");
        provincia.setStyle("-fx-font-size: 1.3em; ");
        list_provin.setStyle("-fx-font-size: 0.8em; ");
        Edad.setStyle("-fx-font-size: 1.3em; ");
        text_edad.setStyle("-fx-font-size: 0.8em; ");
        plus_Persona.setStyle("-fx-font-size: 1.3em; ");
        operaciones.setStyle("-fx-font-size: 1.3em; ");
        persona_1.setStyle("-fx-font-size: 1.3em; ");
        opcion_per1.setStyle("-fx-font-size: 1.3em; ");
        persona_2.setStyle("-fx-font-size: 1.3em; ");
        opcion_per2.setStyle("-fx-font-size: 1.3em; ");
        plus.setStyle("-fx-font-size: 1.2em; ");
        minus.setStyle("-fx-font-size: 1.2em; ");
        multiply.setStyle("-fx-font-size: 1.2em; ");
        divide.setStyle("-fx-font-size: 1.2em; ");

        //Se llama al Layout Pane para hacer uso de Root
        Pane root = new Pane();


        //Se importa de collection el Observablelist para que se seleccione todos los elementos a mostrar en la ventana
        ObservableList list = root.getChildren();
        list.addAll(text_result, resultadol, agre_persona,nombre, provincia, Edad, plus_Persona, operaciones, persona_1, opcion_per1, opcion_per2, persona_2, plus, minus, multiply, divide, list_provin, text_nombre, text_edad);



        //Tamaño de la pantalla para la calculadora
        Scene scene = new Scene(root, 500, 450);


        primaria.setScene(scene);
        primaria.setTitle("Calculadora");

        primaria.show();









    }

    public static void main(String[] args) {
        launch();
    }

}

