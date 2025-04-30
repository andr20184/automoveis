package org.ltpo;

import org.ltpo.models.DAO.ModeloDAO;
import org.ltpo.models.Modelo;

import java.util.List;

public class Main {
    public static void main(String[] args){
        ModeloDAO modeloDAO = new ModeloDAO();

        //inserir novo usuário
        Modelo modelo = new Modelo(1, "Fox","Volkswagen");
        modeloDAO.salvar(modelo);
        System.out.println("Modelo inserido: "+modelo);

        //Buscar todos os usuários
        List<Modelo>modelos = modeloDAO.buscarTodos();
        System.out.println("\nTodos os Modelos:");
        for(Modelo m :modelos){
            System.out.println(m);
        }//Buscar um usuário por ID
        Modelo modeloBuscado = modeloDAO.buscarPorId(1);
        System.out.println("\nModelos com ID 1: " + modeloBuscado);

        //FecharEntityManger
        modeloDAO.fechar();

    }
}