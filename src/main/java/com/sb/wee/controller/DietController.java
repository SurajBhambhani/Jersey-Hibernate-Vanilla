/**
 *
 */
package com.sb.wee.controller;

import com.sb.wee.model.DietDTO;
import com.sb.wee.service.DietService;
import com.sb.wee.service.IDietService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Suraj
 *
 */

@Path("/api")
public class DietController {

    IDietService dietService = new DietService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/diets/all")
    public List<DietDTO> getDiets() {
        return dietService.getAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(value = "/diet/add")
    public Response addUser(DietDTO dietDTO) {

        return Response.ok(dietService.create(dietDTO)).build();

    }

    @DELETE
    @Path(value = "/diet/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(DietDTO dietDTO) {

        dietService.remove(dietDTO);
        return Response.ok(201).build();

    }
}