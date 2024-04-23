package CalcService;
import java.util.List;

//import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import CalcEntity.Calculation;
import CalcEntity.Responce;

@Stateless
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalcService {

	@PersistenceContext(unitName = "Hello")
	private EntityManager em;

	@POST
	@Path("Calcc")
	public Responce Docalc(Calculation c1) {

		int n1 = c1.getNum1();
		int n2 = c1.getNum2();
		char op = c1.getOperation();

		Responce R = new Responce();
		double res = c1.calculate(n1,n2,op);
		R.setResponce(res);

		em.persist(c1);
		return R;
	}

	@GET
	@Path("calculations")
    public List<Calculation> getAllCalculations() {
		return em.createQuery("SELECT c FROM Calculation c", Calculation.class).getResultList();

	}
	
}

