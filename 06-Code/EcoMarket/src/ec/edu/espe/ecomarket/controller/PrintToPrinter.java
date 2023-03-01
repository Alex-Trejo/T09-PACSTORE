/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.ecomarket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author David Toapanta, Pacstore, DCCO-ESPE
 */

public class PrintToPrinter {

    private String printerIp;
    private int printerPort;
    private Socket socket;
    private PrintWriter printWriter;

    public PrintToPrinter(String printerIp, int printerPort) {
        this.printerIp = printerIp;
        this.printerPort = printerPort;
    }

    public void connect() throws IOException {
        socket = new Socket(printerIp, printerPort);
        printWriter = new PrintWriter(socket.getOutputStream(), true);
    }

    public void print(String text) {
        printWriter.println(text);
    }

    public void close() throws IOException {
        printWriter.close();
        socket.close();
    }
}
