package company.office.entity;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.network.InetAddresses;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.transport.Transport;

import java.net.InetAddress;
import java.net.InetSocketAddress;

@Configuration
public class ServerModule {
/*
    @Bean
    public TransportClient rransportClient() {
        //启动settings
        Settings settings =  Settings.builder().put("cluster.name","biteniuniu").build();
        //使用settings获取ES客户端！
        TransportClient client = new PreBuiltTransportClient(settings);
        //添加客户端地址！
        client.addTransportAddress(new InetSocketTransportAddress(
                new InetSocketAddress(InetAddresses.forString("127.0.0.1"), 9300)));
        //返回一个客户端
        return  client;
    }*/


}
