package main.java.ru.unn.agile.tree.binary.model;

import  main.java.ru.unn.agile.tree.binary.model.node.BinaryNode;

public class BinarySearchTree<K extends Comparable<K>, V extends Comparable<V>> {

    private BinaryNode<K, V> root;

    public void insert(final K key, final V val) {
        root = insert(root, key, val);
    }

    private BinaryNode<K, V> insert(
            final BinaryNode<K, V> vertex,
            final K key,
            final V val) {

        if (vertex == null) {
            return new BinaryNode<K, V>(key, val);
        }

        int cmp = key.compareTo(vertex.getKey());

        if (cmp < 0) {
            vertex.setLeft(insert(vertex.getLeft(), key, val));
        } else if (cmp > 0) {
            vertex.setRight(insert(vertex.getRight(), key, val));
        } else if (cmp == 0) {
            vertex.setValue(val);
        }

        vertex.setCount(1 + size(vertex.getLeft()) + size(vertex.getRight()));

        return vertex;
    }

    public BinaryNode<K, V> find(final K key) {
        BinaryNode<K, V> vertex = root;
        while (vertex != null) {
            int cmp = key.compareTo(vertex.getKey());
            if (cmp < 0) {
                vertex = vertex.getLeft();
            } else if (cmp > 0) {
                vertex = vertex.getRight();
            } else if (cmp == 0) {
                return vertex;
            }
        }
        return null;
    }

    public int size() {
        return size(root);
    }

    private int size(final BinaryNode<K, V> vertex) {
        if (vertex == null) {
            return 0;
        }
        return vertex.getCount();
    }

    public BinaryNode<K, V> min() {
        return min(root);
    }

    private BinaryNode<K, V> min(final BinaryNode<K, V> vertex) {
        if (vertex != null) {
            if (vertex.getLeft() == null) {
                return vertex;
            }
            return min(vertex.getLeft());
        }
        return null;
    }

    public BinaryNode<K, V> max() {
        return max(root);
    }

    private BinaryNode<K, V> max(final BinaryNode<K, V> vertex) {
        if (vertex != null) {
            if (vertex.getRight() == null) {
                return vertex;
            }
            return max(vertex.getRight());
        }
        return null;
    }

    private BinaryNode<K, V> removeMin(final BinaryNode<K, V> vertex) {
        if (vertex != null) {
            if (vertex.getLeft() == null) {
                return vertex.getRight();
            }

            vertex.setLeft(removeMin(vertex.getLeft()));
            vertex.setCount(size(vertex.getLeft()) + size(vertex.getRight()) + 1);

            return vertex;
        }
        return null;
    }

    public void remove(final K key) {
        root = remove(root, key);
    }

    private BinaryNode<K, V> remove(final BinaryNode<K, V> vertex, final K key) {
        if (vertex == null) {
            return null;
        }

        BinaryNode<K, V> v = vertex;
        int cmp = key.compareTo(v.getKey());
        if (cmp < 0) {
            v.setLeft(remove(v.getLeft(), key));
        } else if (cmp > 0) {
            v.setRight(remove(v.getRight(), key));
        } else {
            if (v.getRight() == null) {
                return v.getLeft();
            }

            if (v.getLeft() == null) {
                return v.getRight();
            }

            BinaryNode<K, V> tmp = v;
            v = min(tmp.getRight());
            v.setRight(removeMin(tmp.getRight()));
            v.setLeft(tmp.getLeft());
        }

        v.setCount(size(v.getLeft()) + size(v.getRight()) + 1);
        return v;
    }

    public void print() {
        print(root, 0);
    }

    private void print(final BinaryNode<K, V> vertex, final int level) {
        if (vertex != null) {
            for (int i = 0; i < level; ++i) {
                System.out.print(".");
            }

            System.out.printf("L%d: ", level);
            System.out.println(vertex.toString());

            print(vertex.getLeft(), level + 1);
            print(vertex.getRight(), level + 1);
        }
    }
}
