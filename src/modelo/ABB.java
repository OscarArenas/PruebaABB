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
package modelo;

/**
 *
 * @author Oscar Arenas
 */
public class ABB {

    private NodoBinario raiz;
    private int n; // Cantidad de elementos

    public ABB() {
        raiz = null;
        n = 0;
    }

    public boolean agregar(int dato) {
        NodoBinario actual = raiz;
        NodoBinario padre = null;

        while (actual != null) {
            padre = actual;
            if (dato < actual.dato) {
                actual = actual.hijoIzquierdo;
            } else if (dato > actual.dato) {
                actual = actual.hijoDerecho;
            } else {
                return false;
            }
        }
        NodoBinario nuevoNodo = new NodoBinario(dato);

        if (padre == null) {
            raiz = nuevoNodo;
        } else if (dato < padre.dato) {
            padre.hijoIzquierdo = nuevoNodo;
        } else {
            padre.hijoDerecho = nuevoNodo;
        }
        n++;
        return true;
    }

    public boolean eliminar(int dato) {
        // En 'actual' almacenamos la referencia del nodo que se va a eliminar
        NodoBinario actual = raiz;
        NodoBinario padre = null;

        while (actual != null) {
            if (dato < actual.dato) {
                padre = actual;
                actual = actual.hijoIzquierdo;
            } else if (dato > actual.dato) {
                padre = actual;
                actual = actual.hijoDerecho;
            } else {
                break;
            }
        }
        if (actual == null) {
            return false;
        }

        //Caso 1: el actual no tiene hijoIzquierdo
        if (actual.hijoIzquierdo == null) {
            if (padre == null) {// Cuando se va a borrar la raiz
                raiz = raiz.hijoDerecho;
            } else {
                if (dato < padre.dato) {
                    padre.hijoIzquierdo = actual.hijoDerecho;
                } else {
                    padre.hijoDerecho = actual.hijoDerecho;
                }
            }
        } else {
            // Caso 2: El actual tiene hijo izquierdo
            NodoBinario padreMasALaDerecha = actual;
            NodoBinario masALaDerecha = actual.hijoIzquierdo;

            while (masALaDerecha.hijoDerecho != null) {
                padreMasALaDerecha = masALaDerecha;
                masALaDerecha = masALaDerecha.hijoDerecho;
            }
            actual.dato = masALaDerecha.dato;

            // Cuando el hijoIzquierdo del actual tiene hijoDerecho  
            if (padreMasALaDerecha.hijoDerecho == masALaDerecha) {
                padreMasALaDerecha.hijoDerecho = masALaDerecha.hijoIzquierdo;
            } else {
                // Cuando el hijoIzquierdo del actual no tiene hijoDerecho  
                padreMasALaDerecha.hijoIzquierdo = masALaDerecha.hijoIzquierdo;
            }
        }
        n--;
        return true;
    }

    public int tamanio() {
        return n;
    }

    public void imprimir() {
        imprimir(raiz, "");
    }

    private void imprimir(NodoBinario r, String espacios) {
        if (r != null) {
            imprimir(r.hijoDerecho, espacios + "   ");
            System.out.println(espacios + r.dato);
            imprimir(r.hijoIzquierdo, espacios + "   ");
        }
    }

    private class NodoBinario {

        int dato; // Campo clave
        NodoBinario hijoIzquierdo;
        NodoBinario hijoDerecho;

        public NodoBinario(int dato) {
            this.dato = dato;
            hijoIzquierdo = null;
            hijoDerecho = null;
        }

        public boolean esHoja() {
            return hijoIzquierdo == null && hijoDerecho == null;
        }
    }
}
