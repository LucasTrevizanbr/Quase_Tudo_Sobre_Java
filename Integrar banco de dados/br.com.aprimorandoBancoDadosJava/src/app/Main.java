package app;

import view.CrudProdutoView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CrudProdutoView view = new CrudProdutoView();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
