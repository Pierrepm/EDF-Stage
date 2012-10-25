package controllers;

import models.*;
import play.data.*;
import play.mvc.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Clients extends Controller {

    /*
        Retourner une liste (au format JSON) de Clients
        cela correspond à un appel http de type GET
    */
    public static Result getAll() { // GET

        List<Client> list = Client.find.orderBy("nom").findList();
        return ok(toJson(list));
    }

    /*
        Retrouver un Client (au format JSON) par son id
        Cela correspond à un appel http de type GET
        Si il n'existe pas on génère une erreur
    */
    public static Result getById(Long id) { // GET

        Client modelToFind = Client.find.byId(id);

        if(modelToFind!=null) {
            return ok(toJson(modelToFind));
        } else {
            return badRequest("not found");
        }

    }

    /*
        Créer ou sauvegarder un Client, c'est une requête de type POST ou PUT.
        - On récupère les paramètres grâce à bindFromRequest
        - si l'id du modèle n'est pas null c'est une mise à jour (PUT)
        - sinon c'est une création (POST)
    */
    public static Result create() { //POST

        Form<Client> form = form(Client.class).bindFromRequest();
        Client model = form.get();
        model.save();
        return ok(toJson(model));
    }

    public static Result update(Long id) { //PUT

        Form<Client> form = form(Client.class).bindFromRequest();
        Client model = form.get();
        model.id = id;
        model.update();
        return ok(toJson(model));
    }       


    /*
        Retrouver un Client (au format JSON) par son id
        Puis le supprimer
        Cela correspond à un appel http de type DELETE
        Si il n'existe pas on génère une erreur
    */
    public static Result delete(Long id) { // DELETE

        Client modelToFind = Client.find.byId(id);
        if(modelToFind!=null) {
            modelToFind.delete();
            return ok(toJson(true));
        } else {
            return badRequest("not found");
        }

    }

    /*
        Requêtes de type GET pour ne ramener qu'un certain nombre d'enregistrements
    */
    public static Result query(String fieldName, String value) { // GET
        //humans/lastName/equals/morane
        List<Client> list = Client.find.where().eq(fieldName, value).findList();
        return ok(toJson(list));
    }      
}