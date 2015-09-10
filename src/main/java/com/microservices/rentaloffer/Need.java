package com.microservices.rentaloffer;

public class Need {

    public static void main(String[] args) {
        String host = args[0];
        String busName = args[1];

        Need.publish(host, busName);
    }

    public static void publish(String host, String busName) {
        long id = 0;
        while(true)
        {
            try (Connections connection = new Connections( host, busName ))
            {
                connection.publish( new NeedPacket( id++ ).toJson() );
                Thread.sleep( 10000 );
            }
            catch( Exception e )
            {
                throw new RuntimeException( "Could not publish message:", e );
            }
        }
    }
}
