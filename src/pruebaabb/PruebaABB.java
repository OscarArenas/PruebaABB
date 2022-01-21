/*
 * Copyright (C) 2020 Oscar Arenas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pruebaabb;

import edu.oharenas.aleatorio.Aleatorio;
import modelo.ABB;

/**
 *
 * @author Oscar Arenas
 */
public class PruebaABB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ABB abb = new ABB();

//        abb.agregar(33);
//        abb.agregar(67);
//        abb.agregar(21);
//        abb.agregar(7);
//        abb.agregar(25);
        int n = 10;
        for (int i = 0; i < n; i++) {
            abb.agregar(Aleatorio.entero(1, 20));
        }

        System.out.println("Tamaño: " + abb.tamanio());

        abb.imprimir();

        // 1. Escriba un método que recorra todos los elementos del ABB
        //    pero sin utilizar recursividad.
        // 2. Escriba el método agregar pero utilizando recursividad. LLame 
        //    este método 'adicionar'.
        // 3. Escriba un método que retorne la cantidad de hojas del ABB.
    }
}
