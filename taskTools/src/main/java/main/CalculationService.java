package main;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import db.Calculation;

/**
 * Session Bean implementation class CalculationService
 */
@Stateless
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CalculationService  {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em ;
	

	@POST
	@Path("/calc")
	@Consumes(MediaType.APPLICATION_JSON)
	public String performCalculation(Calculation calc )
	{
		
		String response = "Not supported operation";
		int res;
		
		if(calc.getOperation().equals("+"))
		{
			calc.setOperation("+");
			res = calc.getNumber1() + calc.getNumber2();
			response = "Result: " + res;
		}
		else if(calc.getOperation().equals("-"))
		{
			calc.setOperation("-");
			res = calc.getNumber1() - calc.getNumber2();
			response = "Result: " + res;
		}
		else if(calc.getOperation().equals("*"))
		{
			calc.setOperation("*");
			res = calc.getNumber1() * calc.getNumber2();
			response = "Result: " + res;
		}
		else if(calc.getOperation().equals("/"))
		{
			calc.setOperation("/");
			res = calc.getNumber1() / calc.getNumber2();
			response = "Result: " + res;
		}
		
		em.persist(calc);
		
		return response;
	}
	
	@GET
	@Path("/calculations")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Calculation> findAllCalculations() {
		TypedQuery<Calculation> query = em.createQuery("SELECT i FROM Calculation i" , Calculation.class);

		return query.getResultList();
	}
	

}
