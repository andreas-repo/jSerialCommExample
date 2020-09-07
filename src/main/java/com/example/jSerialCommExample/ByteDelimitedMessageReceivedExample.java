package com.example.jSerialCommExample;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortMessageListener;

public class ByteDelimitedMessageReceivedExample {
    private static final class MessageListener implements SerialPortMessageListener
    {
        @Override
        public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_RECEIVED; }

        @Override
        public byte[] getMessageDelimiter() { return new byte[] { (byte)0x0B, (byte)0x65 }; }

        @Override
        public boolean delimiterIndicatesEndOfMessage() { return true; }

        @Override
        public void serialEvent(SerialPortEvent event)
        {
            byte[] delimitedMessage = event.getReceivedData();
            System.out.println("Received the following delimited message: " + delimitedMessage);
        }
    }

    static public void main(String[] args)
    {
        SerialPort comPort = SerialPort.getCommPorts()[0];
        comPort.openPort();
        MessageListener listener = new MessageListener();
        comPort.addDataListener(listener);
        try { Thread.sleep(5000); } catch (Exception e) { e.printStackTrace(); }
        comPort.removeDataListener();
        comPort.closePort();
    }
}
