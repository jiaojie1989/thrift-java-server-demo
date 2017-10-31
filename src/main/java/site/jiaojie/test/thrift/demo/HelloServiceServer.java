/*
 * Copyright (C) 2017 Didi
 *  
 *  
 * 
 * This script is firstly created at 2017-10-31.
 * 
 * To see more infomation,
 *    visit our official website http://home.didichuxing.com/.
 */
package site.jiaojie.test.thrift.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.protocol.TJSONProtocol;

/**
 *
 * @author jiaojie <jiaojie@didichuxing.com thomasjiao@vip.qq.com>
 */
public class HelloServiceServer {

    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld TSimpleServer start ....");

            TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
//            TServer.Args tArgs = new TServer.Args(serverTransport);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
            tArgs.processor(tprocessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
//            TServer server = new TSimpleServer(tArgs);
            TServer server = new TThreadPoolServer(tArgs);
            server.serve();
        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HelloServiceServer server = new HelloServiceServer();
        server.startServer();
    }

}
