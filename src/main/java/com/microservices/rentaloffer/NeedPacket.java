package com.microservices.rentaloffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class NeedPacket
{

	public final String NEED = "car_rental_offer";
	private final List<Integer> solutions = new ArrayList<>();
	private Long needId;
	private Long userId;
	private String status;

	public NeedPacket()
	{
	}

	public NeedPacket( long needId )
	{
		this.needId = needId;
	}

	public String toJson()
	{
		Map<String, Object> message = new HashMap<>();
		message.put( "json_class", NeedPacket.class.getName() );
		message.put( "needId", needId );
		message.put( "userId", userId);
		message.put( "status", status);
		message.put( "need", NEED );
		message.put( "solutions", solutions );
		return new Gson().toJson( message );
	}

	public static NeedPacket fromJson( String message )
	{
		return new Gson().fromJson( message, NeedPacket.class );
	}

	public void proposeSolution( Integer solution )
	{
		solutions.add( solution );
	}

	public boolean hasSolution()
	{
		return !solutions.isEmpty();
	}

	public void setNeedId( Long needId )
	{
		this.needId = needId;
	}

	public void setUserId( Long userId )
	{

		this.userId = userId;
	}

	public void setStatus( String status )
	{
		this.status = status;
	}

	public List<Integer> getSolutions()
	{
		return solutions;
	}

	public Long getNeedId()
	{
		return needId;
	}

	public Long getUserId()
	{
		return userId;
	}

	public String getStatus()
	{
		return status;
	}
}
