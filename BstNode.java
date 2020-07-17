package UASsmt2;

import java.util.*;

public class BstNode {

    Node root;

    class Node {

        int key;
        String nama;

        Node right;
        Node left;

        Node(int key, String nama) {
            this.key = key;
            this.nama = nama;
        }

        @Override
        public String toString() {
            return "nomor " + key + " " + "adalah" + " " + nama;
        }
    }

    public void addNode(int key, String nama) {

        Node newNode = new Node(key, nama);

        if (root == null) {
            root = newNode;
        } else {
            Node Node = root;

            Node parent;
            while (true) {
                parent = Node;
                if (key < Node.key) {
                    Node = Node.left;
                    if (Node == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    Node = Node.right;
                    if (Node == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    private Node cariHewan(int key) {
        Node Node = root;

        while (Node.key != key) {
            if (key < Node.key) {
                Node = Node.left;
            } else {
                Node = Node.right;
            }
            if (Node == null) {
                return null;
            }
        }
        return Node;
    }

    private void cariTingkat(int key) {
        Node Node = root;
        int i = 0;
        while (Node.key != key) {
            if (key < Node.key) {
                i++;
                Node = Node.left;
            } else {
                i++;
                Node = Node.right;
            }
            if (Node == null) {
                System.out.println("Tidak ada dalam rantai makanan");
                return;
            }
        }
        if (i > 3) {
            System.out.println("Tidak ada dalam rantai makanan");
        } else if (i == 0) {
            System.out.println("Merupakan Produsen");
        } else if (i == 3) {
            System.out.println("Konsumen Puncak");
        } else {
            System.out.println("Konsumen ke: " + i);
        }
    }

    private static void postOrder(Node Node) {
        if (Node != null) {
            postOrder(Node.left);
            postOrder(Node.right);
            System.out.println(Node);
        }

    }

    private static void inOrder(Node Node) {
        if (Node != null) {
            inOrder(Node.left);
            System.out.println(Node);
            inOrder(Node.right);
        }

    }

    private static void preOrder(Node Node) {
        if (Node != null) {
            System.out.println(Node);
            preOrder(Node.left);
            preOrder(Node.right);

        }

    }

    private static Node deleteNode(Node root, int value) {
        Node tempNode = root;

        if (root.key == value) {
            return root = null;
        } else if (value < root.key) {
            try {
                if (root.left.key == value) {
                    deleteNode(tempNode.left, value);
                    return root.left = null;
                }
                return deleteNode(tempNode.left, value);
            } catch (Exception e) {
                System.out.println("Tidak ada dalam Rantai Makanan");
                return root;
            }
        } else {
            try {
                if (root.right.key == value) {
                    deleteNode(tempNode.right, value);
                    return root.right = null;
                }
                return deleteNode(tempNode.right, value);
            } catch (Exception e) {
                System.out.println("Tidak ada dalam Rantai Makanan");
                return root;
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int pil, no;
        boolean flag = true;

        BstNode Tree = new BstNode();

        Tree.addNode(50, "Padi");
        Tree.addNode(25, "Ayam");
        Tree.addNode(8, "Ular");
        Tree.addNode(3, "Serigala");
        Tree.addNode(10, "Harimau");
        Tree.addNode(30, "Musang");
        Tree.addNode(27, "Macan");
        Tree.addNode(35, "Singa");
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
            System.out.println("1) Melihat Keseluruhan Rantai Makanan");
            System.out.println("2) Mencari Hewan");
            System.out.println("3) Mencari Tingkatan Konsumen");
            System.out.println("4) Menghapus Hewan");
            System.out.println("5) Keluar");
            System.out.println("\n");

            System.out.print("Silahkan masukkan pilihan anda: ");
            pil = input.nextByte();

            switch (pil) {

                case 1:
                    /*                 
                    System.out.println("Berikut Nomor Hewan Dalam Rantai Makanan yang disajikan dalam bentuk Tree");
                    System.out.println("\n");
                    System.out.println("                       50                                                ");
                    System.out.println("                 /             \                                         ");
                    System.out.println(" ");
                    System.out.println("              25                 75                                      ");
                    System.out.println("             /  \               /  \                                     ");
                    System.out.println(" ");
                    System.out.println("         8         30       60        85                                 ");
                    //System.out.println("      / \       / \       / \       / \                                ");
                    System.out.println(" ");
                    System.out.println("       3   10   27   35   55   70   80   90                              "); 
                     */

                    System.out.println("\n");
                    System.out.println("Ada 3 Pilihan tampilan:");
                    System.out.println("1) Post Order");
                    System.out.println("2) In Order");
                    System.out.println("3) Pre Order");

                    System.out.print("Silahkan masukkan pilihan anda: ");
                    pil = input.nextByte();

                    switch (pil) {
                        case 1:

                            System.out.println("\n");
                            BstNode.postOrder(Tree.root);
                            System.out.println("\n");
                            break;

                        case 2:
                            System.out.println("\n");
                            BstNode.inOrder(Tree.root);
                            System.out.println("\n");
                            break;

                        case 3:
                            System.out.println("\n");
                            BstNode.preOrder(Tree.root);
                            System.out.println("\n");
                            break;

                        default:
                            System.out.println("Salah Inputan!!!");
                            System.out.println("\n");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan nomor: ");
                    no = input.nextInt();
                    if (Tree.cariHewan(no) == null) {
                        System.out.println("Tidak ada dalam rantai makanan");
                    } else {
                        System.out.println(Tree.cariHewan(no));
                    }
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.print("Masukkan nomor: ");
                    no = input.nextInt();
                    Tree.cariTingkat(no);
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.println("WARNING!!");
                    System.out.println("Menghapus hewan mengakibatkan predator alaminya ikut punah");
                    System.out.print("Masukkan nomor: ");
                    no = input.nextInt();
                    if (no == 50) {
                        System.out.println("DILARANG! karena produsen!");
                        System.out.println("SEMUA BISA PUNAH!");
                    } else {
                        BstNode.deleteNode(Tree.root, no);
                    }
                    System.out.println("\n");
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Salah Inputan!");
                    System.out.println("\n");
                    break;

            }
            flag = false;
        } while (flag == false);

    }

}
