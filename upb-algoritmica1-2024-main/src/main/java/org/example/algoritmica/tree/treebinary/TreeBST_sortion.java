package org.example.algoritmica.tree.treebinary;

import lombok.Getter;

import java.util.Arrays;

/**
 * TreeHeap
 *
 * @author Marcos Quispe
 * @since 1.0
 */
public class TreeBST_sortion implements TBPrint {

    private Node root;

    @Getter
    private int size;

    private boolean flag;

    private int[] values;

    public TreeBST_sortion() {
        root = null;
        size = 0;
        values = new int[10000]; // capacidad inicial
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node getNode(Node node, int valueToSearch) {
        if (node == null)
            return null;

        if (node.getValue() == valueToSearch)
            return node;

        Node izq = getNode(node.getLeft(), valueToSearch);
        if (izq != null) {
            return izq;
        } else {
            Node der = getNode(node.getRight(), valueToSearch);
            return der;
        }
    }

    //Inserción de elementos en un árbol binario de búsqueda

    public void addAll(int ...values) {
        for (int value : values) {
            add(value);
        }
    }
    public void add(int value) {
        if (isEmpty()) {
            root = new Node(value);
            size = 1;
            return;
        }
        // implement
        Node node = root;
        while (node != null) {
            if (value > node.getValue()) { // voy por la derecha
                if (node.getRight() == null) {
                    node.setRight(new Node(value));
                    size++;
                    return;
                }
                node = node.getRight();
            } else { // voy por la izq
                if (node.getLeft() == null) {
                    node.setLeft(new Node(value));
                    size++;
                    return;
                }
                node = node.getLeft();
            }
        }
    }
    /**
     * Elimina el nodo correspondiente al value del arbol bst
     * Considerar que hay 3 escenarios:
     *   1. si el nodo a eliminar es hoja
     *   2. si el nodo a eliminar tiene un solo hijo
     *   3. si el nodo a eliminar tiene dos hijos
     * @param value
     */
    public void delete(int value) {
        root = deleteMask(root, value);
    }

    private Node deleteMask(Node node, int value) {
        if (node == null)
            return node;

        if (value < node.getValue()) {
            node.setLeft(deleteMask(node.getLeft(), value));

        } else if (value > node.getValue()) {
            node.setRight(deleteMask(node.getRight(), value));

        } else {
            if (node.isLeaf()) {
                return null;
            }

            if (node.hasOneSon()) {
                return node.getLeft() != null ? node.getLeft() : node.getRight();
            }

            if (node.hasTwoSon()) { //Usar nextInOrden
                Node child = node.getRight();
                Node childPadre = node;


                while (child.getLeft() != null) {
                    childPadre = child;
                    child = child.getLeft();
                }

                //intercambiando
                if (childPadre != node) {
                    childPadre.setLeft(child.getRight());
                } else {
                    childPadre.setRight(child.getRight());
                }

                //reemplazando
                node.setValue(child.getValue());
            }
        }
        return node;
    }




    // funcion que permite intercambiar elementos de un array
    public void swap(int[] values, int i, int j) {
        int aux = values[i];
        values[i] = values[j];
        values[j] = aux;
    }

    public void print() {
        print(root);
    }
    private void print(Node node) { // metodo mascara
        if (node == null)
            return;
        System.out.println(node.getValue());
        print(node.getLeft());
        print(node.getRight());
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public int depth() {
        return depth(root);
    }

    /**
     * Retorna la longitud del camino mas largo
     * @param node
     * @return
     */
    public int depth(Node node) {
        if (node == null)
            return 0;
        if (node.isLeaf())
            return 1;

        int izq = depth(node.getLeft());
        int der = depth(node.getRight());
        return Math.max(izq, der) + 1;
    }

    /**
     * Retorna true si el arbol es perfecto
     * Un arbol es perfecto si todos sus niveles estan llenos
     * @return
     */
    public boolean isPerfect() {
       return Math.pow(2d, depth()) - 1 == size;
    }

    /**
     * Intercambia los valores de los nodos node1 y node2
     * @param node1
     * @param node2
     */
    private void swap(Node node1, Node node2) {
        int aux = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(aux);
    }


    public static void main(String[] args) {
        TreeBST_sortion tb = new TreeBST_sortion();
//        tb.putRoot(10);
//        tb.putLeft(10, 20);
//        tb.putRight(10, 30);
//
//        tb.putRight(20, 15);
////        tb.putLeft(30, 25);
////        tb.putLeft(30, 35);
//        tb.putLeft(20, 28);
        //tb.print();

        //TODO revisar

        //TBPrintUtil.print(tb);
        //System.out.println(tb.depth(tb.root));
        //System.out.println(tb.isFull(tb.root));

//        tb.deleteHeap();
//        tb.deleteHeap();
//        System.out.println();
//        TBPrintUtil.print(tb);
        //tb.postOrden(tb.root);
        //tb.bfs();
//        System.out.println(tb.getSize2(tb.root));
//        System.out.println(tb.areSiblings(tb.root, 30, 28));

        TBPrintUtil.print(tb);
        tb.add(21);
        tb.add(15);
        tb.add(18);
        tb.add(10);
        tb.add(32);
        tb.add(5);


        System.out.println("Arbol original");
        TBPrintUtil.print(tb);


        System.out.println("Cuando tiene un hijo - Eliminando el 10");
        tb.delete(10);
        TBPrintUtil.print(tb);
        //Caso 2 el eliminar tiene un solo hijo



        //Caso 3 eliminar cuando tiene dos hijos
        System.out.println("Elimina cuando tiene dos hijos - Eliminando el 15");
        tb.delete(15);
        TBPrintUtil.print(tb);


        //Caso 1 eliminar si es hoja
        System.out.println("Eliminar cuando es hoja - Eliminando el 5");
        tb.delete(5);
        TBPrintUtil.print(tb);

    }
}
