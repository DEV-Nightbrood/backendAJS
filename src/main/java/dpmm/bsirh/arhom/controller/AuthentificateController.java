package dpmm.bsirh.arhom.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dpmm.bsirh.arhom.ARHOMDao;
import dpmm.bsirh.arhom.security.BCrypt;
import dpmm.bsirh.buisness.entities.Credentials;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@RequestScoped
public class AuthentificateController implements Serializable {

    @Inject
    private ARHOMDao dao;


    private final String privateKEY = "mySecret";

    private JWTVerifier verifier;

    private  Algorithm algorithm ;

    @PostConstruct
    private void init()
    {
        try
        {
            algorithm = Algorithm.HMAC512(privateKEY);
            verifier = JWT.require(algorithm)
                    .withIssuer("BSIRH")
                    .build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public Boolean authentificate(Credentials cred) {

        AtomicBoolean retour = new AtomicBoolean(false);

        Optional.ofNullable(dao.getUserByIdentifiant(cred.getUsername()))
                .ifPresent(user -> retour.set(BCrypt.checkpw(cred.getPassword(), user.getPassword())));

        return retour.get();
    }

    public Optional<String> generateToken(Credentials cred)
    {
           return Optional.ofNullable(JWT.create()
                    .withIssuer("BSIRH")
                    .sign(algorithm));
    }

    public Boolean verifyToken(String token) {
        try {
            verifier.verify(token);//retour un decode utilisable
            return true;
        } catch (JWTVerificationException exception) {
            return false;

        }
    }
}
