package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> pilaOriginal = new Stack<>();
        for (int i = 0; i < texto.length(); i++) {
            pilaOriginal.push(texto.charAt(i));
        }
        StringBuilder resultado = new StringBuilder();
        while (!pilaOriginal.isEmpty()) {
            resultado.append(pilaOriginal.pop());
        }
        return resultado.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Character top;
        Stack<Character> pilaSimbolos = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            Character c = expresion.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                pilaSimbolos.push(c);

            } else if (c == ')' || c == ']' || c == '}') {
                if (pilaSimbolos.isEmpty()) {
                    return false;
                }
                top = pilaSimbolos.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return pilaSimbolos.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> pilaAux = new Stack<>();

        while (!pila.isEmpty()) {
            int temp = pila.pop();
            while (!pilaAux.isEmpty() && temp < pilaAux.peek()) {
                pila.push(pilaAux.pop());
            }
            pilaAux.push(temp);
        }

        return new ArrayList<Integer>(pilaAux);
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {

        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();

        for (int i = 0; i < original.size(); i++) {
            int num = original.get(i);

            int division = num / 2;
            if (division * 2 == num) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }

        pares.addAll(impares);
        return pares;

    }
}
