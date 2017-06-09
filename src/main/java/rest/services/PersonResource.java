package rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import model.Person;
import persistence.PersonRepository;

@Path("people")
public class PersonResource {

    final PersonRepository repository = new PersonRepository();

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response findAll(){
        return Response.ok(this.repository.findAll()).build();
    }

    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response update(final Person person){
        return Response.ok(this.repository.update(person)).build();
    }

    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response delete(final Person person){
        return Response.ok(this.repository.remove(person.getId())).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response add(final Person person){
        return Response.ok(this.repository.add(person)).build();
    }
}
