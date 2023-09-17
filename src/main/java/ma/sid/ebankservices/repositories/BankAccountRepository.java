package ma.sid.ebankservices.repositories;

import ma.sid.ebankservices.entities.BankAccount;
import ma.sid.ebankservices.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource //dans le démmarage démmarer un web service rest full,qui permet de gérer les entités de type  BankAccount
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @RestResource(path = "/byType")
    List<BankAccount> findByType(@Param("t") AccountType type); //fourni par spring DATA
}
