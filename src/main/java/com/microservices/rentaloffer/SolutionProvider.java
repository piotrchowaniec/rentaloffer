package com.microservices.rentaloffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolutionProvider implements MessageHandler {

    public SolutionProvider( Connections connection, String providerid ) {
        this.providerId = providerid;
        connections = connection;
    }

    public static void main( String[] args ) {
        String host = args[0];
        String busName = args[1];
        String providerid = args[2];

        Connections connection = new Connections( host, busName );
        connection.deliveryLoop( new SolutionProvider( connection, providerid ) );
    }

    @Override
    public void handle( String message ) {
        logger.info( "message reveived: {}", message );
        NeedPacket needPacket = NeedPacket.fromJson( message );
        if ( !needPacket.hasSolution() ) {
            needPacket.proposeSolution( new Solution( "advice by " + providerId ) );
            connections.publish( needPacket.toJson() );
        }
    }

    private String providerId;

    private Connections connections;

    private Logger logger = LoggerFactory.getLogger( getClass() );

}
