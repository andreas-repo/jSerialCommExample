package com.example.jSerialCommExample;

import com.fazecast.jSerialComm.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //get all Serial ports, save them in a SerialPort array and print everyone via forEach stream.
        SerialPort[] ports = SerialPort.getCommPorts();
        Arrays.stream(ports).forEach(port -> System.out.println(port));

        //get baud rate of every Serial Port
        for(int i = 0; i < ports.length; i++) {
            System.out.println("Port " +i +":" +ports[i].getBaudRate());
        }




    }
}
