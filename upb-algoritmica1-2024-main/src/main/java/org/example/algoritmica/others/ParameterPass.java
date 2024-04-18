package org.example.algoritmica.others;

import java.util.Arrays;

/**
 * ParameterPass
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class ParameterPass {

    public static void passValuePrim(int nro) {
        nro++;
        System.out.println("passValuePrim: nro " + nro);
    }

    public static void passValueWrapp(Integer nro) {
        nro += 2;
        System.out.println("passValueWrapp: nro " + nro);
    }

    public static void passValueString(String s) {
        s = s + " nuevo";
        System.out.println("passValueString: " + s);
    }

    public static void passValueArrayInt(int[] values) {
        //values[0] = 150;
        values = new int[]{4, 5, 6};
        System.out.println("passValueArrayInt: " + Arrays.toString(values));
    }

    public static void passValueArrayBool(Boolean[] values) {
        System.out.println(values[0]);
        values[0] = true;

        Boolean[] values2 = new Boolean[3];
        values = values2;
        System.out.println("passValueArrayBool: " + Arrays.toString(values));
    }

    public static void passValueObject(User user) {
        user.setName("Marco Aurelio");
        user = new User("Nicolas", 18);
        System.out.println("passValueObject: " + user);
    }

    public static void main(String[] args) {
        int nro = 1;
        System.out.println(nro);
        passValuePrim(nro);
        System.out.println(nro);

        Integer nro2 = 100;
        System.out.println(nro2);
        passValueWrapp(nro2);
        System.out.println(nro2);

        String s = "Hola mundo!";
        System.out.println(s);
        passValueString(s);
        System.out.println(s);

        System.out.println();
        int[] numbers = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(numbers));
        passValueArrayInt(numbers);
        System.out.println(Arrays.toString(numbers));

        Boolean[] booleans = new Boolean[5];
        System.out.println(Arrays.toString(booleans));
        passValueArrayBool(booleans);
        System.out.println(Arrays.toString(booleans));

        User user = new User("Omar", 17);
        System.out.println(user);
        passValueObject(user);
        System.out.println(user);
    }
}
