package models;

import play.db.ebean.Model;
import javax.persistence.*;

@Entity
public class Client extends Model{

    @Id
    public Long id;
    public String prenom;
    public String nom;

    public static Finder<Long, Client> find = 
            new Finder<Long, Client>(Long.class, Client.class);

}