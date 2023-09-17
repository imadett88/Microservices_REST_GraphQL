package ma.sid.ebankservices.entities;

import ma.sid.ebankservices.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

// c'est comme un filtrage de requete (afficher juste l'id & le type)

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
