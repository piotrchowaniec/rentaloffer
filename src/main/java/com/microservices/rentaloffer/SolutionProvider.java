package com.microservices.rentaloffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class SolutionProvider implements MessageHandler
{

	private Random random = new Random();

	public SolutionProvider( Connections connection )
	{
		connections = connection;
	}

	public static void main( String[] args )
	{
		String host = args[0];
		String busName = args[1];

		Connections connection = new Connections( host, busName );
		connection.deliveryLoop( new SolutionProvider( connection ) );
	}

	@Override
	public void handle( String message )
	{
		logger.info( "message reveived: {}", message );
		NeedPacket needPacket = NeedPacket.fromJson( message );
		if( !needPacket.hasSolution() )
		{
			needPacket.proposeSolution( Math.abs( random.nextInt( 500 ) ) + 1 );
			connections.publish( needPacket.toJson() );
		}
	}

	private Connections connections;

	private Logger logger = LoggerFactory.getLogger( getClass() );

}
