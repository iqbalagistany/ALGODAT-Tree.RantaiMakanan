package UASsmt2;

import java.util.*;

public class ProjectUAS {

    Node root;

    class Node {

        int key;
        String nama;

        Node right;
        Node left;
        int data;

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

    private Node cariNode(int key) {
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
    

    private void cariKey(int key) {
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
                if (i > 3) {
                    break;
                }

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

    //Get minimum element in binary search tree
    private static Node minimumElement(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumElement(root.left);
        }
    }

    private static Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.data > value) {
            root.left = deleteNode(root.left, value);
        } else if (root.data < value) {
            root.right = deleteNode(root.right, value);

        } else {
            // if nodeToBeDeleted have both children
            if (root.left != null && root.right != null) {
                Node temp = root;
                // Finding minimum element from right
                Node minNodeForRight = minimumElement(temp.right);
                // Replacing current node with minimum node from right subtree
                root.data = minNodeForRight.data;
                // Deleting minimum node from right now
                root.right = deleteNode(root.right, minNodeForRight.data);

            } // if nodeToBeDeleted has only left child
            else if (root.left != null) {
                root = root.left;
            } // if nodeToBeDeleted has only right child
            else if (root.right != null) {
                root = root.right;
            } // if nodeToBeDeleted do not have child (Leaf node)
            else {
                root = null;
            }
        }
        postOrder(root);
        return root;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int pil, no;
        boolean flag = true;

        ProjectUAS Tree = new ProjectUAS();

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

                case 2:
                    do {
                        System.out.print("Masukkan nomor: ");
                        no = input.nextInt();
                        System.out.println(Tree.cariNode(no));

                        System.out.println("\n");
                        flag = false;
                    } while (flag == true);
                    break;

                case 3:
                    System.out.println("\n");
                    do {
                        System.out.print("Masukkan nomor: ");
                        no = input.nextInt();
                        Tree.cariKey(no);

                        System.out.println("\n");
                        flag = false;
                    } while (flag == true);

                    break;

                case 4:
                    System.out.print("Masukkan nomor: ");
                    no = input.nextInt();
                    Tree.deleteNode(Tree.root, no);
                        
                    System.out.println("\n");
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("\n");
                    System.out.println("Salah Inputan!");

                    break;
            }
            flag = false;
        } while (flag == false);

    }

}
