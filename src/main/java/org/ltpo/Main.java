package org.ltpo;

import org.ltpo.DAO.AutomoveisDAO;
import org.ltpo.DAO.ModeloDAO;
import org.ltpo.DAO.UsuariosDAO;
import org.ltpo.enuns.Tipo;
import org.ltpo.models.Automoveis;
import org.ltpo.models.Modelo;
import org.ltpo.models.Usuarios;

import java.util.List;

public class Main {
    public static void main(String[] args){
        ModeloDAO modeloDAO = new ModeloDAO();
        AutomoveisDAO automoveisDAO = new AutomoveisDAO();
        UsuariosDAO usuariosDAO = new UsuariosDAO();

        //inserir novo usuário
        Modelo modelo = new Modelo(1, "Fox","Volkswagen");
        modeloDAO.salvar(modelo);
        System.out.println("Modelo inserido: "+modelo);

        //Buscar todos os usuários
        List<Modelo>modelos = modeloDAO.buscarTodos();
        System.out.println("\nTodos os Modelos:");
        for(Modelo m :modelos){
            System.out.println(m);
        }
        //Buscar um usuário por ID
        Modelo modeloBuscado = modeloDAO.buscarPorId(1);
        System.out.println("\nModelos com ID 1: " + modeloBuscado);

        Automoveis automoveis = new Automoveis(1, "OVS-3301", 2025, "Prata", modelo );
        automoveisDAO.salvar(automoveis);
        System.out.println("Automovel inserido:"+automoveis);

        List<Automoveis > automoveis1 = automoveisDAO.buscarTodos();
        System.out.println("\n Todos os Automoveis:");
        for(Automoveis a :automoveis1){
            System.out.println(a);
        }
        Automoveis automovelBuscado = automoveisDAO.buscarPorId(1);
        System.out.println("Automoveis com ID 1:"+automovelBuscado);

        Usuarios usuarios = new Usuarios(1,"Andre","61981874615", Tipo.CLIENTE,automoveis1);
        usuariosDAO.salvar(usuarios);
        System.out.println("Usuario inserido: "+modelo);

        //Buscar todos os usuários
        List<Usuarios>usuarios1 = usuariosDAO.buscarTodos();
        System.out.println("\nTodos os Usuarios:");
        for(Usuarios u :usuarios1){
            System.out.println(u);
        }
        //Buscar um usuário por ID
        Usuarios usuarioBuscado = usuariosDAO.buscarPorId(1);
        System.out.println("\nUsuarios com ID 1: " + modeloBuscado);
        //FecharEntityManger
        modeloDAO.fechar();
        automoveisDAO.fechar();



    }
}