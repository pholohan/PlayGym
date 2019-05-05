package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Trainer extends Model
{
    @OneToMany(cascade = CascadeType.ALL)
    public List<Member> memberlist = new ArrayList<Member>();
    public String name;
    public String email;
    public String password;
    public String address;

    public Trainer(String name, String email, String password, String address)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public static Trainer findByEmail(String email)
    {
        return find("email", email).first();
    }

    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }
}
