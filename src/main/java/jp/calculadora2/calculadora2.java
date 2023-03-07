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
        //Contador
        int tmp = 0;

        //Se crean los textfields
        TextField text_nombre = new TextField();
        TextField text_edad = new TextField();


        //Se hace una función para adquirir los datos ingresados por los usuarios
        Persona[] arr;
        arr = new Persona[4];
        int[] arr2 = {0,0,0,0};
        int [] arr_p;
        arr_p = new int[4];
        //Acción del botón
        plus_Persona.setOnAction(actionEvent -> {
            //Se hace una función para almacenar los datos ingresados por el usuario
            for (int i = 0; i<4; i++){


                if (arr2[i] == 0) {


                        ///String persona = new String();
                        //String New_objeto = persona + Integer.toString(i);
                        if ((text_nombre.getText().length() == 0) || (text_edad.getText().length() == 0) || (list_provin.getValue() == null)) {
                            System.out.println("ERROR");
                        }
                        else {
                            Persona New_objeto = new Persona();
                            int edad = Integer.parseInt(text_edad.getText());
                            String nombre1 = text_nombre.getText();
                            Object Provincia = list_provin.getValue();
                            String PROVINCIA = Provincia.toString();
                            New_objeto.setProvincia(PROVINCIA);
                            New_objeto.setEdad(edad);
                            New_objeto.setNombre(nombre1);
                            if (temp>=1){
                                if(New_objeto.getNombre()==nombre1){
                                    New_objeto.setNombre(nombre1 +" #"+ temp+"");
                                }
                            }
                            else {
                                New_objeto.setNombre(nombre1);
                            }
                            arr2[i] = 1;
                            arr_p[i] = New_objeto.getEdad();
                            opcion_per1.getItems().add(New_objeto.getNombre());
                            opcion_per2.getItems().add(New_objeto.getNombre());
                            break;




                        }

                    }

            }
        });
        opcion_per1.setOnAction(actionEvent -> {

            String Persona = opcion_per1.getPromptText();
            for(int i = 0; i<4; i++){

                Object x = arr_p[i];
                if (Persona == x){


                }


            }

        });
        //Metodo donde se sumaran las edades de las personas selecionadas
        plus.setOnAction(actionEvent -> {
            int op1 = arr_p[opcion_per1.getItems().indexOf(opcion_per1.getValue())];
            int op2 = arr_p[opcion_per2.getItems().indexOf(opcion_per2.getValue())];

            // Creo una instancia del modelo
            Operaciones o = new Operaciones(op1, op2);

            // Realizo la suma
            int resultado = o.plus();

            text_result.setText(resultado + "");

        });
        //Metodo donde se restaran las edades de las personas selecionadas
        minus.setOnAction(actionEvent -> {
                    int op1 = arr_p[opcion_per1.getItems().indexOf(opcion_per1.getValue())];
                    int op2 = arr_p[opcion_per2.getItems().indexOf(opcion_per2.getValue())];

                    // Creo una instancia del modelo
                    Operaciones o = new Operaciones(op1, op2);

                    // Realizo la resta
                    int resultado = o.minus();

                    text_result.setText(resultado + "");

        });

        //Metodo donde se multipilicar las edades de las personas selecionadas
        multiply.setOnAction(actionEvent -> {
                    int op1 = arr_p[opcion_per1.getItems().indexOf(opcion_per1.getValue())];
                    int op2 = arr_p[opcion_per2.getItems().indexOf(opcion_per2.getValue())];

                    // Creo una instancia del modelo
                    Operaciones o = new Operaciones(op1, op2);

                    // Realizo la multiplicación
                    int resultado = o.mult();

                    text_result.setText(resultado + "");

        });
        //Metodo donde se dividiran las edades de las personas selecionadas
        divide.setOnAction(actionEvent -> {
                    int op1 = arr_p[opcion_per1.getItems().indexOf(opcion_per1.getValue())];
                    int op2 = arr_p[opcion_per2.getItems().indexOf(opcion_per2.getValue())];

                    // Creo una instancia del modelo
                    Operaciones o = new Operaciones(op1, op2);

                    // Realizo la división
                    double resultado = o.division();

                    text_result.setText(resultado + "");
        });




        //Posiciones de todos los labels y botones

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

        //Aumento de los tamaños de los labels y botones
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



        Scene scene = new Scene(root, 500, 450);


        primaria.setScene(scene);
        primaria.setTitle("Calculadora");

        primaria.show();









    }

    public static void main(String[] args) {
        launch();
    }

}

