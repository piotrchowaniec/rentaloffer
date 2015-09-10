package com.microservices.rentaloffer;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class NeedPacket
{

	public final String NEED = "car_rental_offer";
	private final Map<String, Solution> solutions = new HashMap<>();
	private long id;

	public NeedPacket()
	{
	}

	public NeedPacket( long id )
	{
		this.id = id;
	}

	public String toJson()
	{
		Map<String, Object> message = new HashMap<>();
		message.put( "json_class", NeedPacket.class.getName() );
		message.put( "need_id", id );
		message.put( "need", NEED );
		message.put( "solutions", solutions );
		return new Gson().toJson( message );
	}

	public static NeedPacket fromJson( String message )
	{
		return new Gson().fromJson( message, NeedPacket.class );
	}

	public void proposeSolution( String providerId, Solution solution )
	{
		solutions.put( providerId, solution );
	}

	public boolean containsMySolultion( String providerId )
	{
		return solutions.containsKey( providerId );
	}

	public void setId( long id )
	{
		this.id = id;
	}
}
