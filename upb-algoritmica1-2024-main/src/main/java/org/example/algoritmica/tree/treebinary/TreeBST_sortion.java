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

    public void addAll(int ...values){ //Para enviar mas de un valor
        for (value:
             values) {
            add(value);

        }

    }
    public void add(int value) {
        //TreeBST_sortion tb = new TreeBST_sortion();


        Node node = new Node(value);
        if (isEmpty()) {
            root = new Node(value);
            size = 1;
            return;
        }


        System.out.println("Este es el valor que tengo ahorita: " + node.getValue());

        while(node != null){
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
                size++;
            } else {
                node.setRight(new Node(value));
                size++;
                return;
            }
        }



        //TBPrintUtil.print(tb);

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

        TBPrintUtil.print(tb);

    }
}
