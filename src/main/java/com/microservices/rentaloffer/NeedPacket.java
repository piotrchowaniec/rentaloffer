package com.microservices.rentaloffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class NeedPacket
{

	public final String NEED = "car_rental_offer";
	private final List<Solution> solutions = new ArrayList<>();
	private Long id;

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
		message.put( "id", id );
		message.put( "need", NEED );
		message.put( "solutions", solutions );
		return new Gson().toJson( message );
	}

	public static NeedPacket fromJson( String message )
	{
		return new Gson().fromJson( message, NeedPacket.class );
	}

	public void proposeSolution( Solution solution )
	{
		solutions.add( solution );
	}

	public boolean hasSolution()
	{
		return !solutions.isEmpty();
	}

	public void setId( Long id )
	{
		this.id = id;
	}
}
