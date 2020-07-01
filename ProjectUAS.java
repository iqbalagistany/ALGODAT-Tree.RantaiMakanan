package UASsmt2;

import java.util.Scanner;

public class ProjectUAS {

    Node root;

    public void addNode(int key, String nama) {

        Node newNode = new Node(key, nama);

        if (root == null) {
            root = newNode;
        } else {
            Node iniNode = root;

            Node parent;
            while (true) {
                parent = iniNode;
                if (key < iniNode.key) {
                    iniNode = iniNode.leftChild;
                    if (iniNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    iniNode = iniNode.rightChild;
                    if (iniNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }

        }
    }

    public Node cariNode(int key) {
        Node iniNode = root;

        while (iniNode.key != key) {
            if (key < iniNode.key) {
                iniNode = iniNode.leftChild;
            } else {
                iniNode = iniNode.rightChild;
            }
            if (iniNode == null) {
                return null;
            }
        }
        return iniNode;
    }

    public void postOrder(Node iniNode) {
        if (iniNode != null) {
            postOrder(iniNode.leftChild);
            postOrder(iniNode.rightChild);

            System.out.println(iniNode);
        }

    }

    public void inOrder(Node iniNode) {
        if (iniNode != null) {
            inOrder(iniNode.leftChild);
            System.out.println(iniNode);
            inOrder(iniNode.rightChild);

        }

    }

    public void preOrder(Node iniNode) {
        if (iniNode != null) {
            System.out.println(iniNode);
            preOrder(iniNode.leftChild);
            preOrder(iniNode.rightChild);

        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int pil, no;
        boolean flag = true;

        ProjectUAS Tree = new ProjectUAS();
        Tree.addNode(50, "Padi");
        Tree.addNode(25, "Ayam");
        Tree.addNode(10, "Ular");
        Tree.addNode(3, "Serigala");
        Tree.addNode(8, "Harimau");
        Tree.addNode(15, "Musang");
        Tree.addNode(12, "Macan");
        Tree.addNode(30, "Singa");
        Tree.addNode(75, "Belalang");
        Tree.addNode(60, "Katak");
        Tree.addNode(85, "Biawak");
        Tree.addNode(55, "Kucing");
        Tree.addNode(70, "Elang");
        Tree.addNode(80, "Rajawali");
        Tree.addNode(90, "Buaya");

        do {
            System.out.println("HELLO!!");
            System.out.println("Selamat Datang di Aplikasi Rantai Makanan");
            System.out.println("Kalian Bisa Memilih pilihan di bawah ini:");
            System.out.println("1) Mencari Hewan");
            System.out.println("2) Melihat Keseluruhan Rantai Makanan");
            System.out.println("3) Mencari Tingkatan Konsumen");
            System.out.println("4) Update Hewan");
            System.out.println("5) Menghapus Hewan");
            System.out.println("6) Keluar");
            System.out.println("\n");

            System.out.print("Silahkan masukkan pilihan anda: ");
            pil = input.nextByte();

            switch (pil) {

                case 1:
                    do {
                        System.out.print("Masukkan nomor: ");
                        no = input.nextInt();
                        System.out.println(Tree.cariNode(no));

                        System.out.println("\n");
                        flag = false;
                    } while (flag == true);
                    break;

                case 2:
                    do {
                        System.out.println("Ada 3 Pilihan tampilan:");
                        System.out.println("1) Post Order");
                        System.out.println("2) In Order");
                        System.out.println("3) Pre Order");
                        System.out.println("4) Keluar");
                        
                        System.out.print("Silahkan masukkan pilihan anda: ");
                        pil = input.nextByte();

                        switch (pil) {
                            case 1:

                                do {
                                    Tree.postOrder(Tree.root);
                                    System.out.println("\n");

                                    flag = false;
                                } while (flag == true);
                                break;

                            case 2:
                                do {
                                    Tree.inOrder(Tree.root);
                                    System.out.println("\n");

                                    flag = false;
                                } while (flag == true);
                                break;

                            case 3:
                                do {
                                    Tree.preOrder(Tree.root);
                                    System.out.println("\n");

                                    flag = false;
                                } while (flag == true);
                                break;

                                
                            case 4:
                                System.exit(0);
                                
                                
                            default:
                                System.out.println("\n");
                                System.out.println("Salah Inputan!");
                                break;

                        }
                        flag = false;
                    } while (flag == false);

                    break;

                case 3:
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.println("\n");
                    break;

                case 5:
                    System.out.println("\n");
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("\n");
                    System.out.println("Salah Inputan!");

                    break;
            }
            flag = false;
        } while (flag == false);

    }

    class Node {

        int key;
        String nama;

        Node rightChild;
        Node leftChild;

        Node(int key, String nama) {
            this.key = key;
            this.nama = nama;
        }

        @Override
        public String toString() {
            return "nomor " + key + " " + "adalah" + " " + nama;
        }
    }
}
