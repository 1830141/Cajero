package com.practica.cajero;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    /////////////////////////////CLASES INSTANCIADAS
    CargarArchivos cargarArchivos = new CargarArchivos();
    App app = new App();
    /////////////////////////////////////////////////

    /////////////////////////ARRAYLIST UTILIZADOS
    ArrayList<Usuarios> usuarios = new ArrayList<>();
    ArrayList<Servicios> servicios = new ArrayList<>();
    /////////////////////////////////////////////////

    ////////////////////////////INICIO 1
    @FXML TextField nip,numeroTarjeta;
    /////////////////////////////////////////////////

    //////////////////////////MENU 2
    @FXML Button consultarSaldoCerrar,retiroCerrarMenu,volverCerrar,transferenciaCerrar;
    @FXML Label olaaaa;
    ////////////////////////////////////////////////

    ////////////////////////CONSULTAR SALDO 3
    @FXML TextField mostrarSaldoDisponible;
    @FXML Button retiroCerrarConsulta,menuCerrarConsultaSaldo;
    ////////////////////////////////////////////////

    ////////////////////CONSULTAR RETIRO 4
    @FXML TextField mostrarMonto;
    @FXML Label ocultarMontoRetiro;
    @FXML Button retiroCerrar,volverMenuRetiroCerrar;
    ///////////////////////////////////////////

    ////////////PROCESO RECHAZADO 5
    @FXML Button continuarCerrar;
    ///////////////////////////////////////

    //////////CAMBIO DE NIP 6
    @FXML Button cambioDeNipMenuCerrar,volverMenuNipCerrar,validarCerrar;
    @FXML TextField miNip,nuevoNip,confirmarNip;
    /////////////////////////////////

    /////////////PAGO DE SERVICIOS 7
    @FXML Button pagoDeServiciosMenuCerrar,volverMenuPagoDeServiciosCerrar,pagoDeServiciosCerrar;
    ////////////////////////////////

    ////////////PAGO DE SERVICIOS 8
    @FXML Button volverMenuPagarServicioCerrar,pagoCerrar;
    @FXML TextField codigoDeBarras;
    /////////////////////////

    /////////TRANSFERENCIA 9
    @FXML TextField transferenciaMonto;
    @FXML Button transferirCerrar;
    ///////////////////////////

    ///////TRANSFERENCIA NUMERO CUENTA 9
    @FXML Button volverMenuTransferenciaCerrar,continuarNumeroDeCuentaCerrar;
    @FXML TextField numeroDeCuenta;
    ////////////////

    //////////////////////VARIABLES
    static String cuenta="",cuentaTransferir="";
    static String tipoDeTarjeta="";
    ////////////////////////////////

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void nip(){
        try{
             if(nip.getText().length() == 4){
                usuarios = cargarArchivos.usuarios();
                 for(int i = 0; i < usuarios.size(); i ++){
                    try{
                        if(nip.getText().equals(usuarios.get(i).getNip()) && numeroTarjeta.getText().equals(usuarios.get(i).getNumeroTarjeta())&&usuarios.get(i).getTipoTarjeta().equals("Debito")) {
                            cuenta = usuarios.get(i).getNumeroTarjeta();
                            System.out.println("Cuenta: " + cuenta);
                            app.menu2();
                            Stage stage = (Stage) this.nip.getScene().getWindow();
                            stage.close();
                            tipoDeTarjeta = usuarios.get(i).getTipoTarjeta();
                        }else if(nip.getText().equals(usuarios.get(i).getNip()) && numeroTarjeta.getText().equals(usuarios.get(i).getNumeroTarjeta())&&usuarios.get(i).getTipoTarjeta().equals("Credito")){
                            cuenta = usuarios.get(i).getNumeroTarjeta();
                            System.out.println("Cuenta: " + cuenta);
                            app.menuCredito2();
                            Stage stage = (Stage) this.nip.getScene().getWindow();
                            stage.close();
                            tipoDeTarjeta = usuarios.get(i).getTipoTarjeta();
                        }
                     }catch (Exception e){
                        System.out.println("error");
                    }
                 }
             }
        }catch (Exception e){
        }
    }

    public void consultarSaldo() throws IOException {
        usuarios = cargarArchivos.usuarios();
        app.consultarSaldo3();
        Stage stage = (Stage)this.consultarSaldoCerrar.getScene().getWindow();
        stage.close();
    }

    public void mostrarSaldoTextField() throws IOException {
        usuarios = cargarArchivos.usuarios();
        try{
            for(int i = 0; i< usuarios.size();i++){
                if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())){
                    mostrarSaldoDisponible.setText(usuarios.get(i).getSaldo());
                }
            }
        }catch (Exception e){
        }
    }

    public void retiro(){
        app.retiro4();
        Stage stage = (Stage)this.retiroCerrarConsulta.getScene().getWindow();
        stage.close();
    }

    public void retiroMenu(){
        app.retiro4();
        Stage stage = (Stage)this.retiroCerrarMenu.getScene().getWindow();
        stage.close();
    }

    //Botones para mostrar los valores en el label de retiro
    public void mostrar100(){
        mostrarMonto.setText("100");
        ocultarMontoRetiro.setVisible(true);
    }
    public void mostrar200(){
        mostrarMonto.setText("200");
        ocultarMontoRetiro.setVisible(true);
    }
    public void mostrar300(){
        mostrarMonto.setText("300");
        ocultarMontoRetiro.setVisible(true);
    }
    public void mostrar400(){
        mostrarMonto.setText("400");
        ocultarMontoRetiro.setVisible(true);
    }
    public void mostrar500() {
        mostrarMonto.setText("500");
        ocultarMontoRetiro.setVisible(true);
    }
    public void mostrar1(){
        mostrarMonto.setText(mostrarMonto.getText()+"1");
    }
    public void mostrar2(){
        mostrarMonto.setText(mostrarMonto.getText()+"2");
    }
    public void mostrar3(){
        mostrarMonto.setText(mostrarMonto.getText()+"3");
    }
    public void mostrar4(){
        mostrarMonto.setText(mostrarMonto.getText()+"4");
    }
    public void mostrar5(){
        mostrarMonto.setText(mostrarMonto.getText()+"5");
    }
    public void mostrar6(){
        mostrarMonto.setText(mostrarMonto.getText()+"6");
    }
    public void mostrar7(){
        mostrarMonto.setText(mostrarMonto.getText()+"7");
    }
    public void mostrar8(){
        mostrarMonto.setText(mostrarMonto.getText()+"8");
    }
    public void mostrar9(){
        mostrarMonto.setText(mostrarMonto.getText()+"9");
    }
    public void mostrar0(){
        mostrarMonto.setText(mostrarMonto.getText()+"0");
    }
    public void mostrarPunto(){
        mostrarMonto.setText(mostrarMonto.getText()+".");
    }
    public void borrarDigito(){
        mostrarMonto.setText(mostrarMonto.getText().substring(0,mostrarMonto.getText().length()-1));
    }
    public void otroValorRetiro(){
        mostrarMonto.setText("");
        mostrarMonto.setDisable(false);
        mostrarMonto.setEditable(true);
    }

    //Boton para retirar lo que tenga el label
    public void retirar() throws IOException {
        double monto=0,nuevoMonto=0;
        usuarios = cargarArchivos.usuarios();
        try{
            monto = Double.parseDouble(mostrarMonto.getText());
            for(int i = 0; i < usuarios.size(); i ++){
                if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())){
                    if(monto < Double.parseDouble(usuarios.get(i).getSaldo())){
                        usuarios.get(i).setSaldo(String.valueOf(Double.parseDouble(usuarios.get(i).getSaldo())-monto));
                        escribir(usuarios);
                        app.procesoRealizado4();
                        Stage stage = (Stage)this.retiroCerrar.getScene().getWindow();
                        stage.close();
                     }else{
                        app.procesoRechazado5();
                        Stage stage = (Stage)this.retiroCerrar.getScene().getWindow();
                        stage.close();
                    }
                }
            }
        }catch (Exception e){
        }
    }

    public void cambioDeNip(){
        app.cambioDeNip6();
        Stage stage = (Stage)this.cambioDeNipMenuCerrar.getScene().getWindow();
        stage.close();
    }

    //Volver y condicionar para ver a que menu volver, si es de debito o credito
    public void volverMenu(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.menuCerrarConsultaSaldo.getScene().getWindow();
        stage.close();
    }

    public void volverMenuRetiro(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.volverMenuRetiroCerrar.getScene().getWindow();
        stage.close();
    }

    public void continuarCerrar(){
        app.retiro4();
        Stage stage = (Stage)this.continuarCerrar.getScene().getWindow();
        stage.close();
    }

    public void validar() throws IOException {
        usuarios = cargarArchivos.usuarios();
        for(int i = 0; i < usuarios.size(); i ++){
            if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())){
                if(miNip.getText().equals(usuarios.get(i).getNip())){
                    if(!miNip.getText().equals(nuevoNip.getText())){
                        if(nuevoNip.getText().equals(confirmarNip.getText())){
                            usuarios.get(i).setNip(nuevoNip.getText());
                            escribir(usuarios);
                            app.procesoRealizado4();
                            Stage stage = (Stage)this.validarCerrar.getScene().getWindow();
                            stage.close();
                        }else{
                            JOptionPane.showMessageDialog(null,"Error al modificar NIP","Modificar NIP",JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Error al modificar NIP","Modificar NIP",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Error al modificar NIP","Modificar NIP",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void volverMenuNip(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.volverMenuNipCerrar.getScene().getWindow();
        stage.close();
    }

    public void pagoDeServiciosMenu(){
        app.pagoDeServicios7();
        Stage stage = (Stage)this.pagoDeServiciosMenuCerrar.getScene().getWindow();
        stage.close();
    }

    public void volverMenuPagoDeServicios(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.volverMenuPagoDeServiciosCerrar.getScene().getWindow();
        stage.close();
    }

    public void volverMenuPagarServicio(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.volverMenuPagarServicioCerrar.getScene().getWindow();
        stage.close();
    }

    public void pagoDeServicios(){
        app.pagarServicio8();
        Stage stage = (Stage)this.pagoDeServiciosCerrar.getScene().getWindow();
        stage.close();
    }

    public void pago() throws IOException {
        usuarios = cargarArchivos.usuarios();
        servicios = cargarArchivos.servicios();
        for(int i = 0; i < usuarios.size(); i++){
            if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())){
                for(int j = 0; j < servicios.size(); j++){
                    if(servicios.get(j).getFolio().equals(codigoDeBarras.getText())){
                        if(Double.parseDouble(usuarios.get(i).getSaldo()) > Double.parseDouble(servicios.get(j).getMontoAPagar())){
                            usuarios.get(i).setSaldo(String.valueOf(Double.parseDouble(usuarios.get(i).getSaldo())-Double.parseDouble(servicios.get(j).getMontoAPagar())));
                            escribir(usuarios);
                            app.procesoRealizado4();
                            Stage stage = (Stage)this.pagoCerrar.getScene().getWindow();
                            stage.close();
                        }else{
                            JOptionPane.showMessageDialog(null,"Saldo insuficiente","Pago de servicios",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }

    public void transferencia(){
        app.transferenciaNumeroCuenta9();
        Stage stage = (Stage)this.transferenciaCerrar.getScene().getWindow();
        stage.close();
    }

    public void volverMenuTransferencia(){
        app.menu2();
        Stage stage = (Stage)this.volverMenuTransferenciaCerrar.getScene().getWindow();
        stage.close();
    }

    public void continuarNumeroDeCuenta() throws IOException {
        usuarios = cargarArchivos.usuarios();
        for(int i = 0; i < usuarios.size(); i++){
            if(!numeroDeCuenta.getText().equals(cuenta) && !usuarios.get(i).getTipoTarjeta().equals("Credito") && numeroDeCuenta.getText().equals(usuarios.get(i).getNumeroTarjeta())){
                cuentaTransferir=numeroDeCuenta.getText();
                app.transferencia9();
                Stage stage = (Stage)this.continuarNumeroDeCuentaCerrar.getScene().getWindow();
                stage.close();
            }
        }
    }

    public void transferir() throws IOException {
        usuarios = cargarArchivos.usuarios();
        boolean entro=false;
        for(int i = 0; i < usuarios.size(); i++){
            if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())) {
                if (Double.parseDouble(usuarios.get(i).getSaldo()) > Double.parseDouble(mostrarMonto.getText())) {
                    usuarios.get(i).setSaldo(String.valueOf(Double.parseDouble(usuarios.get(i).getSaldo()) - Double.parseDouble(mostrarMonto.getText())));
                    entro=true;
                }else{
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente","Transferencia",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        for(int i = 0; i < usuarios.size(); i++){
            if(cuentaTransferir.equals(usuarios.get(i).getNumeroTarjeta())){
                if(entro == true){
                    usuarios.get(i).setSaldo(String.valueOf(Double.parseDouble(usuarios.get(i).getSaldo())+Double.parseDouble(mostrarMonto.getText())));
                    app.procesoRealizado4();
                    Stage stage = (Stage)this.transferirCerrar.getScene().getWindow();
                    stage.close();
                    escribir(usuarios);
                }
            }
        }


    }

    public void volver(){
        app.inicio1();
        Stage stage = (Stage)this.volverCerrar.getScene().getWindow();
        stage.close();

    }
    //Metodo para escribir sobre el txt usuarios
    public void escribir(ArrayList<Usuarios> usuarios) throws IOException {
        for(int i = 0; i < usuarios.size();i++){
            System.out.println("LISTAS: "+usuarios.get(i).getTipoTarjeta());
        }
        BufferedWriter bf = new BufferedWriter(new FileWriter("C:\\Users\\Alan\\Desktop\\ProyectosSaid\\Cajero\\src\\main\\resources\\texto\\usuarios.txt\\"));
        for(int i = 0; i < usuarios.size();i++){
            bf.write(usuarios.get(i).getNumeroTarjeta()+"#"+usuarios.get(i).getNip()+"$"+usuarios.get(i).getSaldo()+"&"+usuarios.get(i).getTipoTarjeta()+"\n");
        }
        bf.close();
    }

}
