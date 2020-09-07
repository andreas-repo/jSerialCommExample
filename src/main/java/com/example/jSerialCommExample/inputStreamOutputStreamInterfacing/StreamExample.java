package com.example.jSerialCommExample.inputStreamOutputStreamInterfacing;

import com.fazecast.jSerialComm.SerialPort;

import java.io.InputStream;

public class StreamExample {
    public static void main(String[] args) {
        SerialPort comPort = SerialPort.getCommPorts()[0];
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        InputStream in = comPort.getInputStream();
        try
        {
            for (int j = 0; j < 1000; ++j)
                System.out.print((char)in.read());
            in.close();
        } catch (Exception e) { e.printStackTrace(); }
        comPort.closePort();
    }
}
